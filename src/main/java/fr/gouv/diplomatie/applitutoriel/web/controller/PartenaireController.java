/**
 * Copyright ou © ou Copr. Ministère de l'Europe et des Affaires étrangères (2017)
 * <p/>
 * pole-architecture.dga-dsi-psi@diplomatie.gouv.fr
 * <p/>
 * Ce logiciel est un programme informatique servant à faciliter la création d'applications Web conformément
 * aux référentiels généraux français : RGI, RGS et RGAA
 * <p/>
 * Ce logiciel est régi par la licence CeCILL soumise au droit français et respectant les principes de
 * diffusion des logiciels libres. Vous pouvez utiliser, modifier et/ou redistribuer ce programme sous les
 * conditions de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA sur le site
 * "http://www.cecill.info".
 * <p/>
 * En contrepartie de l'accessibilité au code source et des droits de copie, de modification et de
 * redistribution accordés par cette licence, il n'est offert aux utilisateurs qu'une garantie limitée. Pour
 * les mêmes raisons, seule une responsabilité restreinte pèse sur l'auteur du programme, le titulaire des
 * droits patrimoniaux et les concédants successifs.
 * <p/>
 * A cet égard l'attention de l'utilisateur est attirée sur les risques associés au chargement, à
 * l'utilisation, à la modification et/ou au développement et à la reproduction du logiciel par l'utilisateur
 * étant donné sa spécificité de logiciel libre, qui peut le rendre complexe à manipuler et qui le réserve
 * donc à des développeurs et des professionnels avertis possédant des connaissances informatiques
 * approfondies. Les utilisateurs sont donc invités à charger et tester l'adéquation du logiciel à leurs
 * besoins dans des conditions permettant d'assurer la sécurité de leurs systèmes et ou de leurs données et,
 * plus généralement, à l'utiliser et l'exploiter dans les mêmes conditions de sécurité.
 * <p/>
 * Le fait que vous puissiez accéder à cet en-tête signifie que vous avez pris connaissance de la licence
 * CeCILL, et que vous en avez accepté les termes.
 * <p/>
 * <p/>
 * Copyright or © or Copr. Ministry for Europe and Foreign Affairs (2017)
 * <p/>
 * pole-architecture.dga-dsi-psi@diplomatie.gouv.fr
 * <p/>
 * This software is a computer program whose purpose is to facilitate creation of web application in
 * accordance with french general repositories : RGI, RGS and RGAA.
 * <p/>
 * This software is governed by the CeCILL license under French law and abiding by the rules of distribution
 * of free software. You can use, modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL "http://www.cecill.info".
 * <p/>
 * As a counterpart to the access to the source code and rights to copy, modify and redistribute granted by
 * the license, users are provided only with a limited warranty and the software's author, the holder of the
 * economic rights, and the successive licensors have only limited liability.
 * <p/>
 * In this respect, the user's attention is drawn to the risks associated with loading, using, modifying
 * and/or developing or reproducing the software by the user in light of its specific status of free software,
 * that may mean that it is complicated to manipulate, and that also therefore means that it is reserved for
 * developers and experienced professionals having in-depth computer knowledge. Users are therefore encouraged
 * to load and test the software's suitability as regards their requirements in conditions enabling the
 * security of their systems and/or data to be ensured and, more generally, to use and operate it in the same
 * conditions as regards security.
 * <p/>
 * The fact that you are presently reading this means that you have had knowledge of the CeCILL license and
 * that you accept its terms.
 *
 */
package fr.gouv.diplomatie.applitutoriel.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import fr.gouv.diplomatie.applitutoriel.business.service.partenaire.PartenaireService;
import fr.gouv.diplomatie.applitutoriel.integration.entity.Partenaire;
import fr.gouv.diplomatie.applitutoriel.integration.entity.Photo;
import fr.gouv.diplomatie.applitutoriel.integration.repository.partenaire.PartenaireSummaryDto;
import fr.gouv.diplomatie.applitutoriel.web.dto.partenaire.PartenaireRechercherDTOIn;
import fr.gouv.diplomatie.applitutoriel.web.dto.partenaire.TablePartenaire;

import hornet.framework.exception.BusinessException;
import hornet.framework.exception.BusinessListException;
import hornet.framework.exception.ObjectNotFoundException;
import hornet.framework.web.converter.HornetMediaType;
import hornet.framework.web.table.Pagination;

/**
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
@RestController
@RequestMapping(value = "/partenaires", produces = {
    MediaType.APPLICATION_JSON_VALUE})
public class PartenaireController {

    private static final int NB_ITEMS_PAR_PAGE = 10;

    private static final Logger LOG = LoggerFactory.getLogger(PartenaireController.class);

    @Resource
    private PartenaireService partenaireService;

    @RequestMapping(value = {
    "/{id}"}, method = RequestMethod.GET)
    public Partenaire lire(@PathVariable final Long id) {

        final Optional<Partenaire> partenaire = partenaireService.lirePartenaire(id);

        if (!partenaire.isPresent()) {
            throw new ObjectNotFoundException(new String[]{
                String.valueOf(id)});
        }

        return partenaire.get();
    }

    @RequestMapping(value = "/{idPartenaire}/photo", method = RequestMethod.GET)
    public Photo lirePhotoDuPartenaire(@PathVariable final Long idPartenaire) {

        final Optional<Partenaire> partenaire =
                    partenaireService.lirePartenaire(idPartenaire);

        if (partenaire.isPresent() && partenaire.get().getPhoto() != null) {
            return partenaire.get().getPhoto();
        } else {
            throw new ObjectNotFoundException(new String[]{
                String.valueOf(idPartenaire)});
        }
    }

    @RequestMapping(value = "/recherche", method = RequestMethod.POST, produces = {
        MediaType.APPLICATION_JSON_VALUE,
        HornetMediaType.APPLICATION_EXCEL_VALUE,
        HornetMediaType.TEXT_CSV_VALUE,
        HornetMediaType.APPLICATION_PDF_VALUE})
    public TablePartenaire rechercher(@RequestBody(required = false) final PartenaireRechercherDTOIn dtoIn) {

        LOG.debug("Demande de recherche");

        final TablePartenaire dtoOut = new TablePartenaire();
        dtoOut.setListeCriteres(dtoIn.getCriteres());

        List<PartenaireSummaryDto> liste = partenaireService.listerParCriteresAvecTri(
            dtoIn.getCriteres(), dtoIn.getSort() != null ? dtoIn.getSort()[0] : null);
        final int totalItems = liste.size();

        final Pagination pagination = dtoIn.getPagination();

        if (pagination != null) {

            if (pagination.getPageIndex() == 0) {
                pagination.setPageIndex(1);
            }

            final int itemsPerPage =
                        pagination.getItemsPerPage() == 0 ? NB_ITEMS_PAR_PAGE : pagination.getItemsPerPage();

            // Recuperation du nombre total de pages
            final int nombrePages = Math.max(1, (int) Math.ceil((double) totalItems / (double) itemsPerPage));

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

        return dtoOut;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Partenaire ajouter(@RequestBody final Partenaire partenaire) {

        final Partenaire ajout = partenaireService.ajouterPartenaire(partenaire);
        return ajout;
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifier(@PathVariable final Long id, @RequestBody final Partenaire partenaire) {
        partenaire.setId(id);
        partenaireService.modifierPartenaire(partenaire);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void supprimer(@PathVariable final Long id) {

        partenaireService.supprimerPartenaire(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/suppression", method = RequestMethod.POST)
    public List<Long> supprimerEnMasse(@RequestBody final List<Partenaire> listePartenaires) {

        final List<Long> ids = new ArrayList<>();
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
                exList.addBusinessException(new BusinessException("IN-PA-RPA-01", new String[]{
                    p.getPrenom(),
                    p.getNom(),
                    String.valueOf(p.getId())}));
            } catch (final BusinessException e) {
                final BusinessException be = new BusinessException("ER-PA-RPA-07", new String[]{
                    p.getPrenom(),
                    p.getNom()});
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
