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
package fr.gouv.diplomatie.applitutoriel.business.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * Entité metier Secteur
 *
 * @author MAEDI
 */
public class Secteur implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long id;

    /**
     *
     */
    private Date dateCreat;

    /**
     *
     */
    private String auteurCreat;

    /**
     *
     */
    private Date dateMajEnreg;

    /**
     *
     */
    private String auteurMajEnreg;

    /**
     *
     */
    private Date dateSupprEnreg;

    /**
     *
     */
    private String auteurSupprEnreg;

    /**
     *
     */
    private String nom;

    /**
     *
     */
    private String desc;

    /**
     *
     */
    public Secteur() {

    }

    /**
     *
     * @param nom
     *            String
     * @param description
     *            String
     * @param auteur
     *            Utilisateur
     */
    public Secteur(
                final String nom, final String description, final Utilisateur auteur) {

        this.nom = nom;
        this.desc = description;
        this.auteurCreat = auteur.getLogin();
        this.dateCreat = new Date();
        this.auteurMajEnreg = auteur.getLogin();
        this.dateMajEnreg = (Date) this.dateCreat.clone();
    }

    /**
     *
     * @param leNom
     *            String
     * @param laDescription
     *            String
     * @param util
     *            Utilisateur
     */
    public void modifier(final String leNom, final String laDescription, final Utilisateur util) {

        this.nom = leNom;
        this.desc = laDescription;
        this.auteurMajEnreg = util.getLogin();
        this.dateMajEnreg = new Date();
    }

    /**
     * @return Returns the id.
     */
    public Long getId() {

        return this.id;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(final Long id) {

        this.id = id;
    }

    /**
     * @return Returns the dateCreatEnreg.
     */
    public Date getDateCreat() {

        Date result = null;
        if (null != this.dateCreat) {
            result = (Date) this.dateCreat.clone();
        }
        return result;
    }

    /**
     * @param dateCreat
     *            The dateCreatEnreg to set.
     */
    public void setDateCreat(final Date dateCreat) {

        if (null == dateCreat) {
            this.dateCreat = null;
        } else {
            this.dateCreat = (Date) dateCreat.clone();
        }
    }

    /**
     * @return Returns the auteurCreatEnreg.
     */
    public String getAuteurCreat() {

        return this.auteurCreat;
    }

    /**
     * @param auteurCreat
     *            The auteurCreatEnreg to set.
     */
    public void setAuteurCreat(final String auteurCreat) {

        this.auteurCreat = auteurCreat;
    }

    /**
     * @return Returns the dateMajEnreg.
     */
    public Date getDateMajEnreg() {

        Date result = null;
        if (null != this.dateMajEnreg) {
            result = (Date) this.dateMajEnreg.clone();
        }
        return result;
    }

    /**
     * @param dateMajEnreg
     *            The dateMajEnreg to set.
     */
    public void setDateMajEnreg(final Date dateMajEnreg) {

        if (null == dateMajEnreg) {
            this.dateMajEnreg = null;
        } else {
            this.dateMajEnreg = (Date) dateMajEnreg.clone();
        }
    }

    /**
     * @return Returns the auteurMajEnreg.
     */
    public String getAuteurMajEnreg() {

        return this.auteurMajEnreg;
    }

    /**
     * @param auteurMajEnreg
     *            The auteurMajEnreg to set.
     */
    public void setAuteurMajEnreg(final String auteurMajEnreg) {

        this.auteurMajEnreg = auteurMajEnreg;
    }

    /**
     * @return Returns the dateSupprEnreg.
     */
    public Date getDateSupprEnreg() {

        Date result = null;
        if (null != this.dateSupprEnreg) {
            result = (Date) this.dateSupprEnreg.clone();
        }
        return result;
    }

    /**
     * @param dateSupprEnreg
     *            The dateSupprEnreg to set.
     */
    public void setDateSupprEnreg(final Date dateSupprEnreg) {

        if (null == dateSupprEnreg) {
            this.dateSupprEnreg = null;
        } else {
            this.dateSupprEnreg = (Date) dateSupprEnreg.clone();
        }
    }

    /**
     * @return Returns the auteurSupprEnreg.
     */
    public String getAuteurSupprEnreg() {

        return this.auteurSupprEnreg;
    }

    /**
     * @param auteurSupprEnreg
     *            The auteurSupprEnreg to set.
     */
    public void setAuteurSupprEnreg(final String auteurSupprEnreg) {

        this.auteurSupprEnreg = auteurSupprEnreg;
    }

    /**
     * @return Returns the nom.
     */
    public String getNom() {

        return this.nom;
    }

    /**
     * @param nom
     *            The nom to set.
     */
    public void setNom(final String nom) {

        this.nom = nom;
    }

    /**
     * @return Returns the desc.
     */
    public String getDesc() {

        return this.desc;
    }

    /**
     * @param desc
     *            The desc to set.
     */
    public void setDesc(final String desc) {

        this.desc = desc;
    }

    /**
     *
     * @param auteur
     *            Utilisateur
     */
    public void desactiver(final Utilisateur auteur) {

        this.auteurSupprEnreg = auteur.getLogin();
        this.dateSupprEnreg = new Date();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        final StringBuilder builder = new StringBuilder();
        builder.append("Secteur [id=").append(id).append(", dateCreat=").append(dateCreat)
                    .append(", auteurCreat=").append(auteurCreat).append(", dateMajEnreg=")
                    .append(dateMajEnreg).append(", auteurMajEnreg=").append(auteurMajEnreg)
                    .append(", dateSupprEnreg=").append(dateSupprEnreg).append(", auteurSupprEnreg=")
                    .append(auteurSupprEnreg).append(", nom=").append(nom).append(", desc=").append(desc)
                    .append("]");
        return builder.toString();
    }

}
