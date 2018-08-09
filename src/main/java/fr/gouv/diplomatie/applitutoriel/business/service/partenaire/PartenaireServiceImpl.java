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
package fr.gouv.diplomatie.applitutoriel.business.service.partenaire;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gouv.diplomatie.applitutoriel.integration.entity.Partenaire;
import fr.gouv.diplomatie.applitutoriel.integration.repository.partenaire.PartenaireProjection;
import fr.gouv.diplomatie.applitutoriel.integration.repository.partenaire.PartenaireRepository;
import fr.gouv.diplomatie.applitutoriel.integration.repository.partenaire.PartenaireSpecification;
import fr.gouv.diplomatie.applitutoriel.integration.entity.Ville;
import fr.gouv.diplomatie.applitutoriel.business.service.ville.VilleService;
import fr.gouv.diplomatie.applitutoriel.web.action.forms.FormRecherchePartenaire;
import hornet.framework.exception.BusinessException;
import hornet.framework.web.table.Sort;
import hornet.framework.web.table.SortDirection;
/**
 * PartenaireServiceImpl
 *
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
@Service
public class PartenaireServiceImpl implements PartenaireService {
	
    private final static Logger LOGGER = LoggerFactory.getLogger(PartenaireServiceImpl.class);

    @Autowired
    private PartenaireRepository repository;
    
    /**
     * <code>villeService</code> the villeService
     */
    @Autowired
    private final transient VilleService villeService;


    /**
     * Constructeur par défaut
     *
     */
    public PartenaireServiceImpl() {

        super();
        villeService = null;
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
                final VilleService villeService) {

        super();
        this.villeService = villeService;
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
            final Ville ville = villeService.getVille(idVille);
            if (ville == null || ville.getPays().getId() == null || !ville.getPays().getId().equals(idPays)) {
                return false;
            }
        }
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public List<PartenaireProjection.Summary> listerParCriteres(final FormRecherchePartenaire criteres) {

        return repository.findAll(PartenaireSpecification.criteresRecherche(criteres));//base
    }

    /** {@inheritDoc} */
    @Override
    public List<PartenaireProjection.Summary> listerParCriteresAvecTri(final FormRecherchePartenaire criteres, final Sort sort) {

    	
    	return repository.findAll(PartenaireSpecification.criteresRecherche(criteres), this.getSortData(sort));//base

    }

    /** {@inheritDoc} */
    @Override
    @Transactional(readOnly = true)
    public Optional<Partenaire> lirePartenaire(final Long idPartenaire) {
    	
//    	Optional<fr.gouv.diplomatie.applitutoriel.integration.partenaire.PartenaireProjection.Partenaire> p = repository.findById(idPartenaire);
//    	fr.gouv.diplomatie.applitutoriel.integration.partenaire.PartenaireProjection.Partenaire p = repository.findById(idPartenaire);
    	Partenaire par = (Partenaire) repository.findById(idPartenaire);
    	Partenaire pp = repository.getOne(idPartenaire);
    	
    	List<fr.gouv.diplomatie.applitutoriel.integration.repository.partenaire.PartenaireProjection.Partenaire> l = repository.findAllById(idPartenaire);
//    	if(pp != null) {
//    		pp.getPhoto();
//    		pp.getProduits();
//    	}

        return Optional.ofNullable(par);//repository.findById(idPartenaire);
    }

    /** {@inheritDoc} */
    @Override
    public Partenaire ajouterPartenaire(final Partenaire partenaire) {

        if (!checkVilleFromPays(partenaire.getVille().getId(), partenaire.getVille().getPays().getId())) {
            throw new BusinessException("ER-PA-ED-01");
        }

        partenaire.setDateCrea(Date.valueOf(LocalDate.now()));
        partenaire.setDateModif(Date.valueOf(LocalDate.now()));
        return repository.save(partenaire);
    }

    /** {@inheritDoc} */
    @Override
    public void modifierPartenaire(final Partenaire partenaire) {

        if (!checkVilleFromPays(partenaire.getVille().getId(), partenaire.getVille().getPays().getId())) {
            throw new BusinessException("ER-PA-ED-01");
        }

        partenaire.setDateModif(Date.valueOf(LocalDate.now()));
        repository.save(partenaire);

    }

    /** {@inheritDoc} */
    @Override
    public void supprimerPartenaire(final Long idPartenaire) {

        final Partenaire partenaire = new Partenaire();
        partenaire.setId(idPartenaire);
        repository.delete(partenaire);
    }
    
    /** {@inheritDoc} 
     * @return */
    public final org.springframework.data.domain.Sort getSortData(final Sort sort) {

    	if (sort != null) {

            final org.springframework.data.domain.Sort.Direction dir = sort.getDir() == SortDirection.ASC
                ? org.springframework.data.domain.Sort.Direction.ASC
                : org.springframework.data.domain.Sort.Direction.DESC;

            switch (sort.getKey()) {
                case "nom":
                    return org.springframework.data.domain.Sort.by(dir, "nom");
                case "prenom":
                    return org.springframework.data.domain.Sort.by(dir, "prenom");
                case "proCourriel":
                    return org.springframework.data.domain.Sort.by(dir, "proCourriel");
                case "organisme":
                    return org.springframework.data.domain.Sort.by(dir, "organisme");
                case "vip":
                    return org.springframework.data.domain.Sort.by(dir, "vip");
                case "dateModification":
                    return org.springframework.data.domain.Sort.by(dir, "dateModification");
                default:
                    return org.springframework.data.domain.Sort
                                .by(org.springframework.data.domain.Sort.Direction.ASC, "nom");
            }
        } else {
            return org.springframework.data.domain.Sort.by(org.springframework.data.domain.Sort.Direction.ASC,
                "nom");
        }
    }
}
