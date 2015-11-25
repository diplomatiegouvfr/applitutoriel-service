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
 * Entité metier Produit
 *
 * @author MAEDI
 */
public class Produit implements Serializable {

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
    private String nom;

    /**
     *
     */
    private String desc;

    /**
     *
     */
    private Secteur secteur;

    /**
     *
     */
    public Produit() {

        this.secteur = new Secteur();
    }

    /**
     * @param idProduit
     *            Long
     */
    public Produit(
                final Long idProduit) {

        this.id = idProduit;
        this.secteur = new Secteur();
    }

    /**
     *
     * @param nom
     *            String
     * @param description
     *            String
     */
    public Produit(
                final String nom, final String description) {

        this.nom = nom;
        this.desc = description;
        this.secteur = new Secteur();
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
     * @return Returns the secteur.
     */
    public Secteur getSecteur() {

        return this.secteur;
    }

    /**
     * @param secteur
     *            The secteur to set.
     */
    public void setSecteur(final Secteur secteur) {

        this.secteur = secteur;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        final StringBuilder builder = new StringBuilder();
        builder.append("Produit [id=").append(id).append(", nom=").append(nom).append(", desc=").append(desc)
                    .append(", secteur=").append(secteur).append("]");
        return builder.toString();
    }

}
