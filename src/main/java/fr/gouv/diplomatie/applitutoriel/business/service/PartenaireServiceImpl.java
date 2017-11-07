/**
 * Copyright ou © ou Copr. Ministère de l'Europe et des Affaires étrangères (2017)
 * <p/>
 * pole-architecture.dga-dsi-psi@diplomatie.gouv.fr
 * <p/>
 * Ce logiciel est un programme informatique servant à faciliter la création d'applications Web conformément
 * aux référentiels généraux français : RGI, RGS et RGAA
 * <p/>
 * Ce logiciel est régi par la licence CeCILL soumise au droit français et respectant les principes de
 * diffusion des logiciels libres. Vous pouvez utiliser, modifier et/ou redistribuer ce programme sous les
 * conditions de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA sur le site
 * "http://www.cecill.info".
 * <p/>
 * En contrepartie de l'accessibilité au code source et des droits de copie, de modification et de
 * redistribution accordés par cette licence, il n'est offert aux utilisateurs qu'une garantie limitée. Pour
 * les mêmes raisons, seule une responsabilité restreinte pèse sur l'auteur du programme, le titulaire des
 * droits patrimoniaux et les concédants successifs.
 * <p/>
 * A cet égard l'attention de l'utilisateur est attirée sur les risques associés au chargement, à
 * l'utilisation, à la modification et/ou au développement et à la reproduction du logiciel par l'utilisateur
 * étant donné sa spécificité de logiciel libre, qui peut le rendre complexe à manipuler et qui le réserve
 * donc à des développeurs et des professionnels avertis possédant des connaissances informatiques
 * approfondies. Les utilisateurs sont donc invités à charger et tester l'adéquation du logiciel à leurs
 * besoins dans des conditions permettant d'assurer la sécurité de leurs systèmes et ou de leurs données et,
 * plus généralement, à l'utiliser et l'exploiter dans les mêmes conditions de sécurité.
 * <p/>
 * Le fait que vous puissiez accéder à cet en-tête signifie que vous avez pris connaissance de la licence
 * CeCILL, et que vous en avez accepté les termes.
 * <p/>
 * <p/>
 * Copyright or © or Copr. Ministry for Europe and Foreign Affairs (2017)
 * <p/>
 * pole-architecture.dga-dsi-psi@diplomatie.gouv.fr
 * <p/>
 * This software is a computer program whose purpose is to facilitate creation of web application in
 * accordance with french general repositories : RGI, RGS and RGAA.
 * <p/>
 * This software is governed by the CeCILL license under French law and abiding by the rules of distribution
 * of free software. You can use, modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL "http://www.cecill.info".
 * <p/>
 * As a counterpart to the access to the source code and rights to copy, modify and redistribute granted by
 * the license, users are provided only with a limited warranty and the software's author, the holder of the
 * economic rights, and the successive licensors have only limited liability.
 * <p/>
 * In this respect, the user's attention is drawn to the risks associated with loading, using, modifying
 * and/or developing or reproducing the software by the user in light of its specific status of free software,
 * that may mean that it is complicated to manipulate, and that also therefore means that it is reserved for
 * developers and experienced professionals having in-depth computer knowledge. Users are therefore encouraged
 * to load and test the software's suitability as regards their requirements in conditions enabling the
 * security of their systems and/or data to be ensured and, more generally, to use and operate it in the same
 * conditions as regards security.
 * <p/>
 * The fact that you are presently reading this means that you have had knowledge of the CeCILL license and
 * that you accept its terms.
 *
 */
package fr.gouv.diplomatie.applitutoriel.business.service;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import fr.gouv.diplomatie.applitutoriel.business.bo.Partenaire;
import fr.gouv.diplomatie.applitutoriel.business.bo.Photo;
import fr.gouv.diplomatie.applitutoriel.business.bo.Ville;
import fr.gouv.diplomatie.applitutoriel.business.bo.tree.TreeNodeOrganismeVip;
import fr.gouv.diplomatie.applitutoriel.business.bo.tree.TreeNodePartenaire;
import fr.gouv.diplomatie.applitutoriel.integration.dao.PartenaireDAO;
import fr.gouv.diplomatie.applitutoriel.utility.DateUtil;
import fr.gouv.diplomatie.applitutoriel.web.action.forms.FormRecherchePartenaire;
import hornet.framework.exception.BusinessException;
import hornet.framework.web.table.Sort;
import hornet.framework.web.table.SortDirection;
import hornet.framework.web.tree.bo.ITreeNode;
import hornet.framework.web.tree.bo.TreeNodeDefault;

/**
 * PartenaireServiceImpl
 *
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
public class PartenaireServiceImpl implements PartenaireService {

    /**
     * <code>partenaireDAO</code> the partenaireDAO
     */
    private final transient PartenaireDAO partenaireDAO;

    /**
     * <code>villeService</code> the villeService
     */
    private final transient VilleService villeService;

    private final transient ProduitService produitService;

    private final transient PhotoService photoService;

    /**
     * Constructeur par défaut
     *
     */
    public PartenaireServiceImpl() {

        super();
        this.partenaireDAO = null;
        this.villeService = null;
        this.produitService = null;
        this.photoService = null;
    }

    /**
     * Constructeur
     *
     * @param partenaireDAO
     *            PartenaireDAO
     * @param villeService
     *            villeService
     */
    public PartenaireServiceImpl(
                final PartenaireDAO partenaireDAO, final VilleService villeService,
                final ProduitService produitService, final PhotoService photoService) {

        super();
        this.partenaireDAO = partenaireDAO;
        this.villeService = villeService;
        this.produitService = produitService;
        this.photoService = photoService;
    }

    /** {@inheritDoc} */
    @Override
    public boolean verifDate(final FormRecherchePartenaire criteres) {

        if (criteres.getEndDate() != null && !criteres.getEndDate().equals(criteres.getStartDate())
                    && criteres.getEndDate().before(criteres.getStartDate())) {
            return false;
        }
        return true;
    }

    /**
     * Verifie si la ville est bien rattachee au pays
     *
     * @param idVille
     *            l'identifiant de la ville a verifier
     * @param idPays
     *            l'identifiant du pays a comparer
     * @return false si la ville et le pays sont definis et qu'ils ne sont pas correspondants, true sinon.
     */
    private boolean checkVilleFromPays(final Long idVille, final Long idPays) {

        if (idVille != null && idPays != null) {
            final Ville ville = this.villeService.getVille(idVille);
            if (ville == null || ville.getPays().getId() == null || !ville.getPays().getId().equals(idPays)) {
                return false;
            }
        }
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public List<Partenaire> listerParCriteres(final FormRecherchePartenaire criteres) {

        return this.partenaireDAO.selectByCriteres(criteres);
    }

    /** {@inheritDoc} */
    @Override
    public List<Partenaire> listerParCriteresAvecTri(final FormRecherchePartenaire criteres, final Sort sort) {

        final List<Partenaire> partenaires = this.partenaireDAO.selectByCriteres(criteres);

        // Tri simple de colonne
        if (sort != null) {
            final String tri = sort.getKey();
            if (tri != null && !"".equals(tri)) {
                this.sortData(partenaires, tri);
                if (SortDirection.DESC == sort.getDir()) {
                    Collections.reverse(partenaires);
                }
            }
        }

        return partenaires;
    }

    /** {@inheritDoc} */
    @Override
    public Partenaire lirePartenaire(final Long idPartenaire) {

        final Partenaire partenaire = this.partenaireDAO.selectById(idPartenaire);
        return partenaire;
    }

    /** {@inheritDoc} */
    @Override
    public Partenaire ajouterPartenaire(final Partenaire partenaire) {

        if (!this.checkVilleFromPays(partenaire.getVille().getId(), partenaire.getVille().getPays().getId())) {
            throw new BusinessException("ER-PA-ED-01");
        }

        // création de la photo si nécessaire
        final Photo photo = partenaire.getPhoto();
        if (photo != null) {
            final Photo photoCreer = this.photoService.ajouterPhoto(photo);
            // mise à jour de la photo avec le nouvel identifiant
            partenaire.setPhoto(photoCreer);
        }

        partenaire.setDateCrea(DateUtil.getDateDuJour());
        partenaire.setDateModif(DateUtil.getDateDuJour());
        return this.partenaireDAO.insertPartenaire(partenaire);
    }

    /** {@inheritDoc} */
    @Override
    public void modifierPartenaire(final Partenaire partenaire) {

        if (!this.checkVilleFromPays(partenaire.getVille().getId(), partenaire.getVille().getPays().getId())) {
            throw new BusinessException("ER-PA-ED-01");
        }

        // création de la photo si nécessaire
        final Photo photo = partenaire.getPhoto();

        if (photo != null) {
            if (photo.getId() == null && photo.getData() != null) {

                final Photo photoCreer = this.photoService.ajouterPhoto(photo);
                // mise à jour de la photo avec le nouvel identifiant
                partenaire.setPhoto(photoCreer);
            }// pas de mise à jour pour un même ID photo

        }

        partenaire.setDateModif(DateUtil.getDateDuJour());
        this.partenaireDAO.modifierPartenaire(partenaire);

    }

    /** {@inheritDoc} */
    @Override
    public void supprimerPartenaire(final Long idPartenaire) {

        final Partenaire partenaire = new Partenaire();
        partenaire.setId(idPartenaire);
        this.produitService.supprimerProduitPartenaire(partenaire);
        this.partenaireDAO.deletePartenaire(partenaire);
    }

    /**
     * Comparateur de Partenaire, basé sur l'attribut nom.
     *
     * @author MEAE - Ministère de l'Europe et des Affaires étrangères
     * @since 1.0 - 18 déc. 2013
     */
    private static class PartenaireNomComparator implements Comparator<Partenaire>, Serializable {

        /**
         * Default UID.
         */
        private static final long serialVersionUID = 1L;

        /**
         * {@inheritDoc} java.util.Comparator#compare(java.lang.Object, java.lang.Object).
         */
        @Override
        public int compare(final Partenaire o1, final Partenaire o2) {

            return o1.getNom().compareToIgnoreCase(o2.getNom());
        }
    };

    /**
     * Comparateur de Partenaire, basé sur l'attribut Prenom.
     *
     * @author MEAE - Ministère de l'Europe et des Affaires étrangères
     * @since 1.0 - 18 déc. 2013
     */
    private static class PartenairePrenomComparator implements Comparator<Partenaire>, Serializable {

        /**
         * Default UID.
         */
        private static final long serialVersionUID = 1L;

        /**
         * {@inheritDoc} java.util.Comparator#compare(java.lang.Object, java.lang.Object).
         */
        @Override
        public int compare(final Partenaire o1, final Partenaire o2) {

            if (o1.getPrenom() == null && o2.getPrenom() == null) {
                return 0;
            }
            if (o1.getPrenom() == null) {
                return 1;
            }
            if (o2.getPrenom() == null) {
                return -1;
            }
            return o1.getPrenom().compareToIgnoreCase(o2.getPrenom());
        }

    };

    /**
     * Comparateur de Partenaire, basé sur l'attribut ProCourriel.
     *
     * @author MEAE - Ministère de l'Europe et des Affaires étrangères
     * @since 1.0 - 18 déc. 2013
     */
    private static class PartenaireProCourrielComparator implements Comparator<Partenaire>, Serializable {

        /**
         * Default UID.
         */
        private static final long serialVersionUID = 1L;

        /**
         * {@inheritDoc} java.util.Comparator#compare(java.lang.Object, java.lang.Object).
         */
        @Override
        public int compare(final Partenaire o1, final Partenaire o2) {

            if (o1.getProCourriel() == null && o2.getProCourriel() == null) {
                return 0;
            }
            if (o1.getProCourriel() == null) {
                return 1;
            }
            if (o2.getProCourriel() == null) {
                return -1;
            }

            return o1.getProCourriel().compareToIgnoreCase(o2.getProCourriel());
        }

    };

    /**
     * Comparateur de Partenaire, basé sur l'attribut Organisme.
     *
     * @author MEAE - Ministère de l'Europe et des Affaires étrangères
     * @since 1.0 - 18 déc. 2013
     */
    private static class PartenaireOrganismeComparator implements Comparator<Partenaire>, Serializable {

        /**
         * Default UID.
         */
        private static final long serialVersionUID = 1L;

        /**
         * {@inheritDoc} java.util.Comparator#compare(java.lang.Object, java.lang.Object).
         */
        @Override
        public int compare(final Partenaire o1, final Partenaire o2) {

            if (o1.getOrganisme() == null && o2.getOrganisme() == null) {
                return 0;
            }
            if (o1.getOrganisme() == null) {
                return 1;
            }
            if (o2.getOrganisme() == null) {
                return -1;
            }

            return o1.getOrganisme().compareToIgnoreCase(o2.getOrganisme());
        }

    };

    /**
     * Comparateur de Partenaire, basé sur l'attribut LabelIsVIP.
     *
     * @author MEAE - Ministère de l'Europe et des Affaires étrangères
     * @since 1.0 - 18 déc. 2013
     */
    private static class PartenaireLabelIsVIPComparator implements Comparator<Partenaire>, Serializable {

        /**
         * Default UID.
         */
        private static final long serialVersionUID = 1L;

        /**
         * {@inheritDoc} java.util.Comparator#compare(java.lang.Object, java.lang.Object).
         */
        @Override
        public int compare(final Partenaire o1, final Partenaire o2) {

            return o1.getLabelIsVIP().compareToIgnoreCase(o2.getLabelIsVIP());
        }

    };

    /**
     * Comparateur de Partenaire, basé sur l'attribut DateModif.
     *
     * @author MEAE - Ministère de l'Europe et des Affaires étrangères
     * @since 1.0 - 18 déc. 2013
     */
    private static class PartenaireDateModifComparator implements Comparator<Partenaire>, Serializable {

        /**
         * Default UID.
         */
        private static final long serialVersionUID = 1L;

        /**
         * {@inheritDoc} java.util.Comparator#compare(java.lang.Object, java.lang.Object).
         */
        @Override
        public int compare(final Partenaire o1, final Partenaire o2) {

            if (o1.getDateModif() == null) {
                return 1;
            }
            if (o2.getDateModif() == null) {
                return -1;
            }

            return o1.getDateModif().compareTo(o2.getDateModif());
        }
    };

    /** {@inheritDoc} */
    @Override
    public final void sortData(final List<Partenaire> partenaire, final String sort) {

        if ("NOM".equalsIgnoreCase(sort)) {
            Collections.sort(partenaire, new PartenaireNomComparator());
        }

        if ("PRENOM".equalsIgnoreCase(sort)) {
            Collections.sort(partenaire, new PartenairePrenomComparator());
        }

        if ("PROCOURRIEL".equalsIgnoreCase(sort)) {
            Collections.sort(partenaire, new PartenaireProCourrielComparator());
        }

        if ("ORGANISME".equalsIgnoreCase(sort)) {
            Collections.sort(partenaire, new PartenaireOrganismeComparator());
        }

        if ("ISVIP".equalsIgnoreCase(sort)) {
            Collections.sort(partenaire, new PartenaireLabelIsVIPComparator());
        }

        if ("DATEMODIF".equalsIgnoreCase(sort)) {
            Collections.sort(partenaire, new PartenaireDateModifComparator());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ITreeNode listerArborescenceOrganismePartenaire() {

        final List<Partenaire> partenaires = this.partenaireDAO.retrieveDataList();

        // Map ordonnee sur les clefs
        final Map<String, TreeNodeOrganismeVip> mapOrganismeNode =
                    new TreeMap<String, TreeNodeOrganismeVip>();

        // Noeud Organisme Vip par defaut
        final TreeNodeOrganismeVip defaultOrganismeNode = new TreeNodeOrganismeVip();

        final ITreeNode treeNodeRoot = new TreeNodeDefault();
        TreeNodeOrganismeVip treeNodeOrganismeVip;
        ITreeNode treeNodePartenaire;
        String organisme;
        for (final Partenaire p : partenaires) {

            // Noeud Organisme Vip
            organisme = p.getOrganisme();
            if (organisme == null || organisme.isEmpty()) {
                treeNodeOrganismeVip = defaultOrganismeNode;
            } else {
                treeNodeOrganismeVip = mapOrganismeNode.get(organisme);
                if (treeNodeOrganismeVip == null) {
                    treeNodeOrganismeVip = new TreeNodeOrganismeVip(organisme);
                    mapOrganismeNode.put(organisme, treeNodeOrganismeVip);
                }
            }

            // Noeud Partenaire
            treeNodePartenaire = new TreeNodePartenaire(p);
            treeNodeOrganismeVip.addChild(p.getIsVIP(), treeNodePartenaire);
        }

        // Reconstruit l'arbre finale avec les organismes ordonnes
        // suivis de l'organisme par defaut
        for (final Entry<String, TreeNodeOrganismeVip> entry : mapOrganismeNode.entrySet()) {
            treeNodeRoot.getChildren().add(entry.getValue());
        }
        treeNodeRoot.getChildren().add(defaultOrganismeNode);

        return treeNodeRoot;
    }
}
