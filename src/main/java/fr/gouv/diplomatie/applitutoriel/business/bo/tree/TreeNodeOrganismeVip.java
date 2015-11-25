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
/**
 *
 */
package fr.gouv.diplomatie.applitutoriel.business.bo.tree;

import hornet.framework.web.tree.bo.ITreeNode;
import hornet.framework.web.tree.bo.TreeNodeBoolean;
import hornet.framework.web.tree.bo.TreeNodeDefault;

/**
 * Projet AppliTutoriel.
 *
 * @date 8 avr. 2013
 * @author MAEDI
 *
 */
public class TreeNodeOrganismeVip extends TreeNodeDefault {

    /**
     * Noeud d'arborescence pour les VIP
     */
    private transient TreeNodeBoolean arborescenceNodeVip;

    /**
     * Noeud d'arborescence pour les non VIP
     */
    private transient TreeNodeBoolean arborescenceNodeNonVip;

    /**
     * Constructeur par defaut
     */
    public TreeNodeOrganismeVip() {

        super();
        this.arborescenceNodeVip = new TreeNodeBoolean(Boolean.TRUE);
        this.arborescenceNodeNonVip = new TreeNodeBoolean(Boolean.FALSE);

        this.getChildren().add(this.arborescenceNodeVip);
        this.getChildren().add(this.arborescenceNodeNonVip);
    }

    /**
     * Constructeur
     *
     * @param organisme
     *            String
     */
    public TreeNodeOrganismeVip(
                final String organisme) {

        this();
        this.setData(organisme);
    }

    /**
     * Methode pour ajouter un sous-noeud d'arborescence a un des deux noeuds d'arborescence geres
     *
     * @param isVip
     *            Boolean
     * @param childNode
     *            IArborescenceNode
     */
    public void addChild(final Boolean isVip, final ITreeNode childNode) {

        if (Boolean.TRUE.equals(isVip)) {
            this.arborescenceNodeVip.getChildren().add(childNode);
        } else {
            this.arborescenceNodeNonVip.getChildren().add(childNode);
        }
    }

}
