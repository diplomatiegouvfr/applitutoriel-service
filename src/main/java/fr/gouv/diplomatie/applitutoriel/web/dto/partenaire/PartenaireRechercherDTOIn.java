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
package fr.gouv.diplomatie.applitutoriel.web.dto.partenaire;

import fr.gouv.diplomatie.applitutoriel.web.action.forms.FormRecherchePartenaire;
import hornet.framework.web.table.Pagination;
import hornet.framework.web.table.Sort;

/**
 * @author MAEDI
 * @since 1.0 - 4 févr. 2015
 */
public class PartenaireRechercherDTOIn {

    private Pagination pagination;

    private FormRecherchePartenaire criteres;

    private Sort sort;

    /**
     * @return criteres
     */
    public FormRecherchePartenaire getCriteres() {

        return criteres;
    }

    /**
     * @param criteres
     *            criteres
     */
    public void setCriteres(final FormRecherchePartenaire criteres) {

        this.criteres = criteres;
    }

    /**
     * @return sort
     */
    public Sort getSort() {

        return sort;
    }

    /**
     * @param sort
     *            sort
     */
    public void setSort(final Sort sort) {

        this.sort = sort;
    }

    /**
     * @return pagination
     */
    public Pagination getPagination() {

        return pagination;
    }

    /**
     * @param pagination
     *            pagination
     */
    public void setPagination(final Pagination pagination) {

        this.pagination = pagination;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        final StringBuilder builder = new StringBuilder();
        builder.append("PartenaireRechercherDTOIn [pagination=").append(pagination).append(", criteres=")
                    .append(criteres).append(", sort=").append(sort).append("]");
        return builder.toString();
    }

}
