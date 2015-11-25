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
package fr.gouv.diplomatie.applitutoriel.business.service;

import hornet.framework.web.table.Sort;
import hornet.framework.web.tree.bo.ITreeNode;

import java.util.List;

import fr.gouv.diplomatie.applitutoriel.business.bo.Partenaire;
import fr.gouv.diplomatie.applitutoriel.web.action.forms.FormRecherchePartenaire;

/**
 * @author MAEDI
 */
public interface PartenaireService {

    /**
     * @param criteres
     *            FormRecherchePartenaire
     * @return boolean
     */
    boolean verifDate(FormRecherchePartenaire criteres);

    /**
     * Retourne une liste de partenaires en fonction des criteres
     *
     * @param criteres
     *            FormRecherchePartenaire
     * @return liste de partenaires
     */
    List<Partenaire> listerParCriteres(FormRecherchePartenaire criteres);

    /**
     * Retourne une liste de partenaires en fonction des criteres et triee en fonction du tri
     *
     * @param criteres
     *            FormRecherchePartenaire
     * @param sort
     *            Sort
     * @return liste de partenaires ordonnee
     */
    List<Partenaire> listerParCriteresAvecTri(FormRecherchePartenaire criteres, Sort sort);

    /**
     * Recupere un partenaire par son identifiant
     *
     * @param idPartenaire
     *            Long
     * @return le partenaire
     */
    Partenaire lirePartenaire(Long idPartenaire);

    /**
     * Creation du partenaire.
     *
     * @param partenaire
     *            Partenaire
     * @return le partenaire ajoute
     */
    Partenaire ajouterPartenaire(Partenaire partenaire);

    /**
     * Met a jour le partenaire
     *
     * @param partenaire
     *            Partenaire
     */
    void modifierPartenaire(Partenaire partenaire);

    /**
     * Supprime le partenaire
     *
     * @param idPartenaire
     *            Long
     */
    void supprimerPartenaire(Long idPartenaire);

    /**
     * @param partenaire
     *            List Partenaire
     * @param sort
     *            String
     */
    void sortData(List<Partenaire> partenaire, String sort);

    /**
     * Retourne une arborescence de noeuds partenaires, structurés sous la forme : Organisme/VIP/Nom+Prénom
     *
     * @return INode arborescence de noeuds partenaires
     */
    ITreeNode listerArborescenceOrganismePartenaire();

}
