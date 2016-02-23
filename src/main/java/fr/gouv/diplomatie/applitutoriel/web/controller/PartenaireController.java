/**
 * ﻿Copyright Ministère des Affaires étrangères et du Développement international , 22 avril 2015
 * https://adullact.net/projects/hornet/
 *
 *
 * Ce logiciel est un programme informatique servant à faciliter la création
 *  d'applications Web accessibles conforémement au RGAA et performantes.
 *
 * Ce logiciel est régi par la licence CeCILL v2.1 soumise au droit français et
 * respectant les principes de diffusion des logiciels libres. Vous pouvez
 * utiliser, modifier et/ou redistribuer ce programme sous les conditions
 * de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA
 * sur le site "http://www.cecill.info".
 *
 * En contrepartie de l'accessibilité au code source et des droits de copie,
 * de modification et de redistribution accordés par cette licence, il n'est
 * offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
 * seule une responsabilité restreinte pèse sur l'auteur du programme,  le
 * titulaire des droits patrimoniaux et les concédants successifs.
 *
 * A cet égard  l'attention de l'utilisateur est attirée sur les risques
 * associés au chargement,  à l'utilisation,  à la modification et/ou au
 * développement et à la reproduction du logiciel par l'utilisateur étant
 * donné sa spécificité de logiciel libre, qui peut le rendre complexe à
 * manipuler et qui le réserve donc à des développeurs et des professionnels
 * avertis possédant  des  connaissances  informatiques approfondies.  Les
 * utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
 * logiciel à leurs besoins dans des conditions permettant d'assurer la
 * sécurité de leurs systèmes et ou de leurs données et, plus généralement,
 * à l'utiliser et l'exploiter dans les mêmes conditions de sécurité.
 *
 * Le fait que vous puissiez accéder à cet en-tête signifie que vous avez
 * pris connaissance de la licence CeCILL, et que vous en avez accepté les
 * termes.
 */
package fr.gouv.diplomatie.applitutoriel.web.controller;

import hornet.framework.exception.BusinessException;
import hornet.framework.exception.BusinessListException;
import hornet.framework.web.converter.HornetMediaType;
import hornet.framework.web.exception.ObjectNotFoundException;
import hornet.framework.web.table.Pagination;
import hornet.framework.web.tree.bo.ITreeNode;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.gouv.diplomatie.applitutoriel.business.bo.Partenaire;
import fr.gouv.diplomatie.applitutoriel.business.bo.Photo;
import fr.gouv.diplomatie.applitutoriel.business.service.PartenaireService;
import fr.gouv.diplomatie.applitutoriel.business.service.PhotoService;
import fr.gouv.diplomatie.applitutoriel.web.dto.partenaire.PartenaireRechercherDTOIn;
import fr.gouv.diplomatie.applitutoriel.web.dto.partenaire.TablePartenaire;

/**
 * @author MAEDI
 * @since 1.0 - 3 févr. 2015
 */
@RestController
@RequestMapping(value = "/partenaires", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PartenaireController {

    private static final int NB_ITEMS_PAR_PAGE = 10;

    private static final Logger LOG = LoggerFactory.getLogger(PartenaireController.class);

    @Resource
    private PartenaireService partenaireService;

    @Resource
    private PhotoService photoService;

    @RequestMapping(value = {"/consulter/{id}","/editer/{id}"}, method = RequestMethod.GET)
    public Partenaire lire(@PathVariable final Long id) {

        final Partenaire partenaire = partenaireService.lirePartenaire(id);

        if (partenaire == null) {
            throw new ObjectNotFoundException();
        }

        return partenaire;
    }

    @RequestMapping(value = "/photo/{idPhoto}", method = RequestMethod.GET)
    public Photo lirePhotoDuPartenaire(@PathVariable final Long idPhoto) {

        final Photo photo = photoService.lirePhoto(idPhoto);
        return photo;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ITreeNode lister() {

        final ITreeNode tree = partenaireService.listerArborescenceOrganismePartenaire();
        return tree;
    }

    @RequestMapping(value = "/rechercher", method = RequestMethod.POST, produces = {
        MediaType.APPLICATION_JSON_VALUE,
        HornetMediaType.APPLICATION_EXCEL_VALUE,
        HornetMediaType.TEXT_CSV_VALUE,
        HornetMediaType.APPLICATION_PDF_VALUE})
    public TablePartenaire rechercher(@RequestBody final PartenaireRechercherDTOIn dtoIn) {

        LOG.debug("Demande de recherche");

        final TablePartenaire dtoOut = new TablePartenaire();
        dtoOut.setListeCriteres(dtoIn.getCriteres());

        List<Partenaire> liste =
                    partenaireService.listerParCriteresAvecTri(dtoIn.getCriteres(), dtoIn.getSort());
        final int totalItems = liste.size();

        final Pagination pagination = dtoIn.getPagination();

        if (pagination != null) {

            if (pagination.getPageIndex() == 0) {
                pagination.setPageIndex(1);
            }
            
            int itemsPerPage =
                        pagination.getItemsPerPage() == 0 ? NB_ITEMS_PAR_PAGE : pagination.getItemsPerPage();

            // Cas "Afficher tout"
            if (itemsPerPage == -1) {
                itemsPerPage = Integer.MAX_VALUE;
            }
            // Recuperation nombrePages
            int nombrePages = totalItems / itemsPerPage;
            if (totalItems % itemsPerPage > 0 || nombrePages == 0) {
                nombrePages++;
            }
            // Recalcul indexPage
            final int indexPagePartenaires = Math.min(pagination.getPageIndex(), nombrePages);
            pagination.setPageIndex(indexPagePartenaires);
            pagination.setItemsPerPage(itemsPerPage);

            // Pagination serveur
            final int minIndex = (pagination.getPageIndex() - 1) * itemsPerPage;
            final int maxIndex = Math.min(totalItems, minIndex + itemsPerPage);

            liste = liste.subList(minIndex, maxIndex);
        }

        dtoOut.setPagination(pagination);
        dtoOut.setListe(liste);
        dtoOut.setNbTotal(totalItems);

        LOG.debug("Out Demande de recherche : {}", dtoOut.toString());

        return dtoOut;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/sauvegarder", method = RequestMethod.POST)
    public Partenaire ajouter(@RequestBody final Partenaire partenaire) {

        final Partenaire ajout = partenaireService.ajouterPartenaire(partenaire);
        return ajout;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/sauvegarder/{id}", method = RequestMethod.PUT)
    public void modifier(@PathVariable final Long id, @RequestBody final Partenaire partenaire) {

        partenaire.setId(id);
        partenaireService.modifierPartenaire(partenaire);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/supprimer/{id}", method = RequestMethod.DELETE)
    public void supprimer(@PathVariable final Long id) {

        partenaireService.supprimerPartenaire(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/suppression", method = RequestMethod.POST)
    public List<Long> supprimerEnMasse(@RequestBody final List<Partenaire> listePartenaires) {

        final List<Long> ids = new ArrayList<Long>();
        LOG.debug("Demande de supression en masse");
        final BusinessListException exList = new BusinessListException();
        Boolean hasErrors = false;
        for (final Partenaire p : listePartenaires) {
            LOG.debug("Suppression du partenaire d'id {}", p.getId());
            try {
                supprimer(p.getId());
                // on retourne les ids correctements supprimés
                ids.add(p.getId());
                // on ajoute aussi les succès dans l'exception pour récapituler
                exList.addBusinessException(new BusinessException("200", new String[]{p.getId().toString()}));
            } catch (final BusinessException e) {
                final BusinessException be = new BusinessException(p.getId().toString());
                exList.addBusinessException(be);
                hasErrors = true;
            }
        }
        if (hasErrors) {
            throw exList;
        }
        return ids;
    }
}
