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
package fr.gouv.diplomatie.applitutoriel.arborescence;

import hornet.framework.web.tree.ITreeFactoryHelper;
import hornet.framework.web.tree.ITreeNodeBuilder;
import hornet.framework.web.tree.TreeFactory;
import hornet.framework.web.tree.TreeFactoryMapHelper;
import hornet.framework.web.tree.TreeNodeBooleanBuilder;
import hornet.framework.web.tree.TreeNodeDefaultBuilder;
import hornet.framework.web.tree.bo.ITreeNode;
import hornet.framework.web.tree.bo.TreeNodeDefault;
import hornet.framework.web.tree.vo.ITreeVO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.gouv.diplomatie.applitutoriel.business.bo.tree.TreeNodeOrganismeVip;
import fr.gouv.diplomatie.applitutoriel.business.service.PartenaireService;
import fr.gouv.diplomatie.applitutoriel.integration.dao.PartenaireDAO;
import fr.gouv.diplomatie.applitutoriel.web.tree.TreeNodePartenaireBuilder;

/**
 * Teste une implémentation de {@link PartenaireDAO}.
 *
 * @author MAEDI
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-appContext-test.xml"})
public class PartenaireArboTest {

    /**
     * Recuperation du logger
     */
    public static final Logger LOG = LoggerFactory.getLogger(PartenaireArboTest.class);

    /** <code>partenaireService</code> partenaireService */
    @Autowired
    private transient PartenaireService partenaireService;

    /**
     * Arborescence de partenaires
     */
    private transient ITreeNode treeNode;

    /**
     * Builder pour traiter un noeud Organisme de l'arborescence
     */
    private transient ITreeNodeBuilder builderOrganisme;

    /**
     * Builder pour traiter un noeud VIP de l'arborescence
     */
    private transient ITreeNodeBuilder builderVip;

    /**
     * Builder pour traiter un noeud Partenaire de l'arborescence
     */
    private transient ITreeNodeBuilder builderPartenaire;

    /**
     * @throws Exception
     *             Exception
     */
    @Before
    public void setUp() throws Exception {

        // Arborescence de noeuds organisme/vip/partenaire
        this.treeNode = this.partenaireService.listerArborescenceOrganismePartenaire();

        // Builders pour traiter les noeuds d'arborescence
        this.builderOrganisme = new TreeNodeDefaultBuilder(TreeNodeOrganismeVip.class);
        this.builderVip = new TreeNodeBooleanBuilder("VIP", "Non VIP");
        this.builderPartenaire = new TreeNodePartenaireBuilder("/dyn/partenaire.html", "idPartenaire");
    }

    /**
     * Test l'arborescence de Partenaire
     */
    @Test
    public void testArborescenceOrganismePartenaire() {

        Assert.assertNotNull(this.treeNode);
        Assert.assertFalse(this.treeNode.getChildren().isEmpty());
    }

    /**
     * Test de la construction d'une arborescence de Partenaires avec un helper gerant une liste chainee de
     * builders
     */
    @Test
    public void testChainTreeFactory() {

        // Helper pour gerer les builders
        final ITreeFactoryHelper helper = new TreeFactoryChainHelper();
        helper.addTreeNodeBuilder(this.builderOrganisme);
        helper.addTreeNodeBuilder(this.builderVip);
        helper.addTreeNodeBuilder(this.builderPartenaire);

        // Construction de l'arborescence finale
        final ITreeVO tree = new TreeFactory().buildCompleteTree(this.treeNode, helper);

        Assert.assertNotNull(tree);
        Assert.assertFalse(tree.getChildren().isEmpty());

        for (final ITreeVO treeItem : tree.getChildren()) {
            PartenaireArboTest.LOG.info(treeItem.toString());
        }
    }

    /**
     * Test de la construction d'une arborescence de Partenaire avec un helper gerant une map de builders
     */
    @Test
    public void testTreeFactory() {

        // Helper pour gerer les builders
        final ITreeFactoryHelper helper = new TreeFactoryMapHelper();
        helper.addTreeNodeBuilder(this.builderOrganisme);
        helper.addTreeNodeBuilder(this.builderVip);
        helper.addTreeNodeBuilder(this.builderPartenaire);

        // Construction de l'arborescence finale
        final ITreeVO tree = new TreeFactory().buildCompleteTree(this.treeNode, helper);

        Assert.assertNotNull(tree);
        Assert.assertFalse(tree.getChildren().isEmpty());

        for (final ITreeVO treeItem : tree.getChildren()) {
            PartenaireArboTest.LOG.info(treeItem.toString());
        }

    }
}

/**
 * Projet AppliTutoriel.
 *
 * @date 5 avr. 2013
 * @author MAEDI
 *
 */
interface ITreeNodeChainBuilder extends ITreeNodeBuilder {

    /**
     * Setter successor
     *
     * @param successor
     *            TreeItemChainBuilder
     */
    void setSuccessor(ITreeNodeChainBuilder successor);

    /**
     * Getter last successor
     *
     * @return TreeItemChainBuilder last successor of successor or itself
     */
    ITreeNodeChainBuilder getLastSuccessor();
}

/** Builder */
class TreeNodeChainBuilder implements ITreeNodeChainBuilder {

    /**
     * Recuperation du logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(TreeNodeChainBuilder.class);

    /**
     * Builder associe
     */
    private transient ITreeNodeBuilder builder;

    /**
     * Builder suivant
     */
    private transient ITreeNodeChainBuilder successor;

    /**
     * Constructeur
     *
     * @param builder
     *            Builder courant a associe
     */
    public TreeNodeChainBuilder(
                final ITreeNodeBuilder builder) {

        this.builder = builder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final ITreeVO convertNode(final ITreeNode node) {

        ITreeVO newTreeItem = null;

        if (this.isSupportedNode(node)) {

            TreeNodeChainBuilder.LOG.info("Using builder {} [nodeType={}] for node[class={}]", this.builder
                        .getClass().getSimpleName(), this.builder.getNodeType().getSimpleName(), node
                        .getClass().getSimpleName());

            newTreeItem = this.builder.convertNode(node);
        } else if (this.successor != null) {

            newTreeItem = this.successor.convertNode(node);
        } else {

            TreeNodeChainBuilder.LOG.info("No builder supporting node[class={}]", node.getClass()
                        .getSimpleName());
        }

        return newTreeItem;
    }

    /**
     * Verifie si le noeud courant est supporte par le builder
     *
     * @param node
     *            INode
     * @return true si le noeud courant n'est pas nul et si son type correspond a la classe supportee par le
     *         builder, false sinon.
     */
    public boolean isSupportedNode(final ITreeNode node) {

        return node != null && node.getClass() == this.getNodeType();
    }

    /**
     * {@inheritDoc}
     *
     */
    @Override
    public Class<? extends ITreeNode> getNodeType() {

        return this.builder.getNodeType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSuccessor(final ITreeNodeChainBuilder successor) {

        this.successor = successor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ITreeNodeChainBuilder getLastSuccessor() {

        ITreeNodeChainBuilder lastSuccessor = this;
        if (this.successor != null) {

            lastSuccessor = this.successor.getLastSuccessor();
        }
        return lastSuccessor;
    }

}

/**
 * Fabrique
 */
class TreeFactoryChainHelper implements ITreeFactoryHelper {

    /**
     * Chaine de builders
     */
    private transient ITreeNodeChainBuilder treeNodeChainBuilder;

    /**
     *
     */
    TreeFactoryChainHelper() {

        // builder Root
        this.addTreeNodeBuilder(new TreeNodeChainBuilder(new TreeNodeDefaultBuilder(TreeNodeDefault.class)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTreeNodeBuilder(final ITreeNodeBuilder builder) {

        if (builder != null) {

            this.addTreeNodeChainBuilder(new TreeNodeChainBuilder(builder));
        }
    }

    /**
     * Ajoute un builder supplementaire a la chaine.
     *
     * @param builder
     *            Builder a ajouter en fin de la chaine
     */
    public void addTreeNodeChainBuilder(final ITreeNodeChainBuilder builder) {

        if (this.treeNodeChainBuilder != null) {

            this.treeNodeChainBuilder.getLastSuccessor().setSuccessor(builder);
        } else {

            this.treeNodeChainBuilder = builder;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ITreeNodeChainBuilder selectBuilder(final ITreeNode node) {

        return this.treeNodeChainBuilder;
    }
}
