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
package fr.gouv.diplomatie.applitutoriel.web.dto.contact;

/**
 * Entité metier Mail
 *
 * @author MAEDI
 */
public class ContactEnvoyerDTOIn {

    private String nom;

    private String prenom;

    private String mail;

    private String message;

    /**
     * @return nom
     */
    public String getNom() {

        return nom;
    }

    /**
     * @param nom
     *            nom
     */
    public void setNom(final String nom) {

        this.nom = nom;
    }

    /**
     * @return prenom
     */
    public String getPrenom() {

        return prenom;
    }

    /**
     * @param prenom
     *            prenom
     */
    public void setPrenom(final String prenom) {

        this.prenom = prenom;
    }

    /**
     * @return mail
     */
    public String getMail() {

        return mail;
    }

    /**
     * @param mail
     *            mail
     */
    public void setMail(final String mail) {

        this.mail = mail;
    }

    /**
     * @return message
     */
    public String getMessage() {

        return message;
    }

    /**
     * @param message
     *            message
     */
    public void setMessage(final String message) {

        this.message = message;
    }

}