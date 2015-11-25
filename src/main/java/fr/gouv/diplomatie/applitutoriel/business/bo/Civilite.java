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

/**
 * Entité metier Civilite.
 *
 * @author MAEDI
 */
public class Civilite implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    private Long id;

    /** The libelle. */
    private String libelle;

    /**
     * Instantiates a new civilite.
     */
    public Civilite() {

        super();
    }

    /**
     * Instantiates a new civilite.
     *
     * @param id
     *            the id
     * @param libelle
     *            the libelle
     */
    public Civilite(
                final Long id, final String libelle) {

        super();
        this.id = id;
        this.libelle = libelle;
    }

    /**
     * Gets the id.
     *
     * @return Returns the id.
     */
    public Long getId() {

        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            The id to set.
     */
    public void setId(final Long id) {

        this.id = id;
    }

    /**
     * Gets the libelle.
     *
     * @return Returns the libelle.
     */
    public String getLibelle() {

        return this.libelle;
    }

    /**
     * Sets the libelle.
     *
     * @param libelle
     *            The libelle to set.
     */
    public void setLibelle(final String libelle) {

        this.libelle = libelle;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        final StringBuilder builder = new StringBuilder();
        builder.append("Civilite [id=").append(id).append(", libelle=").append(libelle).append("]");
        return builder.toString();
    }

}
