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

import fr.gouv.diplomatie.applitutoriel.business.bo.Secteur;
import fr.gouv.diplomatie.applitutoriel.business.service.SecteurService;
import fr.gouv.diplomatie.applitutoriel.web.dto.secteur.SecteurAjouterDTOIn;
import fr.gouv.diplomatie.applitutoriel.web.dto.secteur.SecteurModifierDTOIn;
import fr.gouv.diplomatie.applitutoriel.web.dto.secteur.SecteurRechercherDTOIn;

/**
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 * @since 1.0 - 4 févr. 2015
 */
@RestController
@RequestMapping(value = "/secteurs", produces = {
    MediaType.APPLICATION_JSON_VALUE})
public class SecteurController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SecteurController.class);

    @Resource
    private SecteurService secteurService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Secteur lire(@PathVariable final Long id) {

        final Secteur secteur = secteurService.lireSecteur(id);
        return secteur;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Secteur> listerActifs() {

        LOGGER.debug("methode listerActifs");

        final List<Secteur> secteurs = secteurService.getListeSecteursActifs();
        return secteurs;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Secteur ajouterSecteur(@RequestBody final SecteurAjouterDTOIn dtoIn) {

        final Secteur secteur =
                    secteurService.ajouterSecteur(dtoIn.getNom(), dtoIn.getDesc(), dtoIn.getUser());
        return secteur;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifierSecteur(@PathVariable final Long id,
                @RequestBody final SecteurModifierDTOIn secteur) {

        final Secteur sec = new Secteur();
        sec.setNom(secteur.getNom());
        sec.setDesc(secteur.getDesc());
        sec.setId(id);

        secteurService.modifierSecteur(sec, secteur.getUser());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void supprimerSecteur(@PathVariable final Long id) {

        secteurService.supprimerSecteur(id);
    }

    @RequestMapping(value = "/rechercher", method = RequestMethod.POST)
    public List<Secteur> rechercheSecteurs(@RequestBody final SecteurRechercherDTOIn dtoIn) {

        final List<Secteur> secteurs =
                    secteurService.rechercheSecteurs(dtoIn.getNom(), dtoIn.getDescription(), dtoIn.getId());
        return secteurs;
    }
}
