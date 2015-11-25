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
package fr.gouv.diplomatie.applitutoriel.web.tree;

import fr.gouv.diplomatie.applitutoriel.business.bo.Partenaire;
import fr.gouv.diplomatie.applitutoriel.business.bo.tree.TreeNodePartenaire;
import fr.gouv.diplomatie.applitutoriel.web.tree.vo.TreeVOPartenaire;
import hornet.framework.web.tree.AbstractTreeNodeBuilder;
import hornet.framework.web.tree.bo.ITreeNode;
import hornet.framework.web.tree.vo.ITreeVO;

/**
 * Projet AppliTutoriel.
 * 
 * @date 8 avr. 2013
 * @author MAEDI
 * 
 */
public class TreeNodePartenaireBuilder extends AbstractTreeNodeBuilder {

    /**
     * Arbre courant géneré par le builder
     */
    private TreeVOPartenaire treeItem;

    /**
     * Url utilisee pour generer les liens a associer aux elements de l'arborescence
     */
    private transient String urlFichePartenaire;

    /**
     * Parametre utilise pour generer les liens a associer aux elements de l'arborescence
     */
    private transient String paramIdPartenaire;

    /**
     * Constructeur
     * 
     * @param urlFichePartenaire
     *            String Chemin vers la page de consultation des partenaires
     * @param paramIdPartenaire
     *            String Nom du parametre pour envoyer l'identifiant vers la page de consultation des
     *            partenaires
     * 
     */
    public TreeNodePartenaireBuilder(
                final String urlFichePartenaire, final String paramIdPartenaire) {

        super(TreeNodePartenaire.class);

        this.urlFichePartenaire = urlFichePartenaire;
        this.paramIdPartenaire = paramIdPartenaire;
    }

    /**
     * Initialise l'element genere par le builder avec le partenaire a utiliser.
     * 
     * @param node
     *            Noeud courant
     */
    @Override
    protected void initTreeItem(final ITreeNode node) {

        final Partenaire partenaire = this.getPartenaire(node.getData());
        this.setTreeItem(new TreeVOPartenaire(partenaire, this.urlFichePartenaire, this.paramIdPartenaire));
    }

    /**
     * Aucun traitement necessaire (les donnees de l'element seront recuperees a partir de l'objet partenaire
     * associe).
     * 
     * @param node
     *            Noeud courant
     */
    @Override
    protected void buildTreeItem(final ITreeNode node) {

    }

    /**
     * Recupere l'objet partenaire courant si l'objet donne est compatible, ou initialise un nouveau
     * partenaire sinon.
     * 
     * @param data
     *            Object courant
     * @return Partenaire a utiliser
     */
    private Partenaire getPartenaire(final Object data) {

        Partenaire partenaire;
        if (data instanceof Partenaire) {

            partenaire = (Partenaire) data;
        } else {

            partenaire = new Partenaire();
        }

        return partenaire;
    }

    /**
     * Getter treeItem. {@inheritDoc}
     */
    @Override
    public ITreeVO getTreeItem() {

        return this.treeItem;
    }

    /**
     * Setter treeItem
     * 
     * @param treeItem
     *            Elément d'arborescence en cours de génération
     */
    public void setTreeItem(final TreeVOPartenaire treeItem) {

        this.treeItem = treeItem;
    }

}
