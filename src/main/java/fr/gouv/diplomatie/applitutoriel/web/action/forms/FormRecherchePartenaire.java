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
package fr.gouv.diplomatie.applitutoriel.web.action.forms;

import java.util.Date;

import fr.gouv.diplomatie.applitutoriel.business.bo.Partenaire;

/**
 * The Class FormRecherchePartenaire.
 *
 * @author MAEDI
 */
public class FormRecherchePartenaire {

    /** The partenaire. */
    private Partenaire partenaire;

    /** The uti id. */
    private String utiId;

    /** The id secteur. */
    private Long idSecteur;

    /** The start date. */
    private Date startDate;

    /** The end date. */
    private Date endDate;

    /**
     * Instantiates a new form recherche partenaire.
     */
    public FormRecherchePartenaire() {

        this.partenaire = new Partenaire();
    }

    /**
     * Gets the partenaire.
     *
     * @return Returns the partenaire.
     */
    public Partenaire getPartenaire() {

        return this.partenaire;
    }

    /**
     * Sets the partenaire.
     *
     * @param partenaire
     *            The partenaire to set.
     */
    public void setPartenaire(final Partenaire partenaire) {

        this.partenaire = partenaire;
    }

    /**
     * Gets the id secteur.
     *
     * @return Returns the idSecteur.
     */
    public Long getIdSecteur() {

        return this.idSecteur;
    }

    /**
     * Sets the id secteur.
     *
     * @param idSecteur
     *            The idSecteur to set.
     */
    public void setIdSecteur(final Long idSecteur) {

        this.idSecteur = idSecteur;
    }

    /**
     * Gets the start date.
     *
     * @return Returns the startDate.
     */
    public Date getStartDate() {

        return this.startDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate
     *            The startDate to set.
     */
    public void setStartDate(final Date startDate) {

        Date date = null;
        if (startDate != null) {
            date = (Date) startDate.clone();
        }
        this.startDate = date;
    }

    /**
     * Gets the end date.
     *
     * @return Returns the endDate.
     */
    public Date getEndDate() {

        return this.endDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate
     *            The endDate to set.
     */
    public void setEndDate(final Date endDate) {

        Date date = null;
        if (endDate != null) {
            date = (Date) endDate.clone();
        }
        this.endDate = date;
    }

    /**
     * Gets the uti id.
     *
     * @return Returns the utiId.
     */
    public String getUtiId() {

        return this.utiId;
    }

    /**
     * Sets the uti id.
     *
     * @param utiId
     *            The utiId to set.
     */
    public void setUtiId(final String utiId) {

        this.utiId = utiId;
    }

    /**
     * Checks if is valid.
     *
     * @return boolean
     */
    public final boolean isValid() {

        return this.startDate != null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        final StringBuilder builder = new StringBuilder();
        builder.append("FormRecherchePartenaire [partenaire=").append(partenaire).append(", utiId=")
                    .append(utiId).append(", idSecteur=").append(idSecteur).append(", startDate=")
                    .append(startDate).append(", endDate=").append(endDate).append("]");
        return builder.toString();
    }

}
