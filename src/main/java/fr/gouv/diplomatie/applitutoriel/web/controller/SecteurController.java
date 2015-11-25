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
import fr.gouv.diplomatie.applitutoriel.business.bo.Utilisateur;
import fr.gouv.diplomatie.applitutoriel.business.service.SecteurService;
import fr.gouv.diplomatie.applitutoriel.web.dto.secteur.SecteurAjouterDTOIn;
import fr.gouv.diplomatie.applitutoriel.web.dto.secteur.SecteurModifierDTOIn;
import fr.gouv.diplomatie.applitutoriel.web.dto.secteur.SecteurRechercherDTOIn;

/**
 * @author MAEDI
 * @since 1.0 - 4 févr. 2015
 */
@RestController
@RequestMapping(value = "/secteurs", produces = {MediaType.APPLICATION_JSON_VALUE})
public class SecteurController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SecteurController.class);

    // TODO gérer des sessions et récupérer l'utilisateur depuis la session
    private final Utilisateur utilMock = new Utilisateur(2L, "user");

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

    @RequestMapping(value = "/par_utilisateur", method = RequestMethod.GET)
    public List<Secteur> listerParUtilisateur() {

        final List<Secteur> secteurs = secteurService.getListeSecteurs(utilMock);
        return secteurs;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Secteur ajouterSecteur(@RequestBody final SecteurAjouterDTOIn dtoIn) {

        final Secteur secteur = secteurService.ajouterSecteur(dtoIn.getNom(), dtoIn.getDesc(), dtoIn.getUser());
        return secteur;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifierSecteur(@PathVariable final Long id, @RequestBody final SecteurModifierDTOIn secteur) {

    	Secteur sec = new Secteur();
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
