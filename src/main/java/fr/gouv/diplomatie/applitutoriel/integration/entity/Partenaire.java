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
package fr.gouv.diplomatie.applitutoriel.integration.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.gouv.diplomatie.applitutoriel.integration.entity.Civilite;
import fr.gouv.diplomatie.applitutoriel.integration.entity.Pays;
import fr.gouv.diplomatie.applitutoriel.integration.entity.Photo;
import fr.gouv.diplomatie.applitutoriel.integration.entity.Produit;
import fr.gouv.diplomatie.applitutoriel.integration.entity.Ville;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Entité metier Partenaire.
 *
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PARTENAIRE")
@Entity
@EqualsAndHashCode
public class Partenaire implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
//    public Partenaire(final Long id) {
//        this.id = id;
//    }

    /** The id. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_PARTENAIRE", updatable = false, nullable = false)
    protected Long id;
    
    @Column(name = "PAR_IS_CLIENT")
    protected boolean client;
    
    @Column(name = "PAR_IS_VIP")
	private boolean vip;

    @Column(name = "PAR_NOM", nullable = false)
    protected String nom;

    @Column(name = "PAR_PRENOM", nullable = false)
    protected String prenom;

    @Column(name = "PAR_NOM_LOCAL")
    protected String nomLocal;

    @Column(name = "PAR_PRENOM_LOCAL")
    protected String prenomLocal;
    
   	@Column(name = "PAR_DATE_NAISSANCE")
   	protected Date dateNaissance;
	
	@Column(name = "PAR_FONCTION")
	protected String fonction;
	
	@Column(name = "PAR_PRO_TEL_FIXE")
	protected String proTelFixe;
	
	@Column(name = "PAR_PRO_TEL_PORT")
	protected String proTelPort;
	
	@Column(name = "PAR_PRO_COURRIEL")
	protected String proCourriel;
	
	@Column(name = "PAR_PRO_FAX")
	protected String proFax;
	
	@Column(name = "PAR_PRO_ADR_CP")
	protected String proAdrCP;
	
	@Column(name = "PAR_PRO_ADR_RUE")
	protected String proAdrRue;
	
	@Column(name = "PAR_ASSIST_NOM")
	protected String assistNom;
	
	@Column(name = "PAR_ASSIST_PRENOM")
	protected String assistPrenom;
	
	@Column(name = "PAR_ASSIST_TEL")
	protected String assistTel;
	
	@Column(name = "PAR_ASSIST_COURRIEL")
	protected String assistCourriel;
	
	@Column(name = "PAR_COMMENTAIRE")
	protected String commentaire;
	
	@Column(name = "PAR_ORGANISME")
	protected String organisme;
	
	@Column(name = "PAR_DATE_CREATION")
	protected Date dateCrea;
	
	@Column(name = "PAR_DATE_MODIFICATION")
	protected Date dateModif;
	
	@Column(name = "PAR_SATISFACTION")
	protected String satisfaction;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_VILLE", nullable = false)
	protected Ville ville;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_CIVILITE", nullable = false)
	protected Civilite civilite;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_PAYS", nullable = false)
	protected Pays nationalite;
    
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ID_PHOTO", nullable = true)
	private Photo photo;
	
    @ManyToMany(cascade={CascadeType.REMOVE})
    @JsonIgnore
    @JoinTable(name="PRODUIT_PARTENAIRE", joinColumns=@JoinColumn(name="ID_PARTENAIRE", referencedColumnName="ID_PARTENAIRE"),
    		inverseJoinColumns=@JoinColumn(name="ID_PRODUIT", referencedColumnName="ID_PRODUIT"))
    private Set<Produit> produits;
    
//    public Long getId() {
//    	return this.partenaireId;
//    }
//    
//    public void setId(Long id) {
//    	this.partenaireId = id;
//    }

    /**
     * @return oui ou non
     */
    public String getLabelIsVIP() {

        if (vip) {
            return "oui";
        } else {
            return "non";
        }
    }
}
