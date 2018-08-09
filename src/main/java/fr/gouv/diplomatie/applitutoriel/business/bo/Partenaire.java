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
package fr.gouv.diplomatie.applitutoriel.business.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Entité metier Partenaire
 *
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
public class Partenaire implements Serializable {

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
    private ArrayList<Produit> listeProduit;

    /**
     *
     */
    private Ville ville;

    /**
     *
     */
    private Civilite civilite;

    /**
     *
     */
    private Pays nationalite;

    /**
     * Image du partenaire
     */
    private Photo photo;

    /**
     *
     */
    private Boolean client;

    /**
     *
     */
    private Boolean vip;

    /**
     *
     */
    private Boolean isVIPFiltre;

    /**
     *
     */
    private String nom;

    /**
     *
     */
    private String prenom;

    /**
     *
     */
    private String nomLocal;

    /**
     *
     */
    private String prenomLocal;

    /**
     *
     */
    private Date dateNaissance;

    /**
     *
     */
    private String fonction;

    /**
     *
     */
    private String proTelFixe;

    /**
     *
     */
    private String proTelPort;

    /**
     *
     */
    private String proCourriel;

    /**
     *
     */
    private String proFax;

    /**
     *
     */
    private String proAdrCP;

    /**
     *
     */
    private String proAdrRue;

    /**
     *
     */
    private String assistNom;

    /**
     *
     */
    private String assistPrenom;

    /**
     *
     */
    private String assistTel;

    /**
     *
     */
    private String assistCourriel;

    /**
     *
     */
    private String commentaire;

    /**
     *
     */
    private String organisme;

    /**
     *
     */
    private String satisfaction;

    /**
     * <code>dateCrea</code> the dateCrea
     */
    private Date dateCrea;

    /**
     * <code>dateModif</code> the dateModif
     */
    private Date dateModif;

    /**
     *
     */
    public Partenaire() {

        ville = new Ville();
        nationalite = new Pays();
        civilite = new Civilite();
    }

    /**
     * @param idPartenaire
     *            Long
     */
    public Partenaire(
                final Long idPartenaire) {

        id = idPartenaire;
        ville = new Ville();
        nationalite = new Pays();
        civilite = new Civilite();
    }

    /**
     * @return Returns the id.
     */
    public Long getId() {

        return id;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(final Long id) {

        this.id = id;
    }

    /**
     * @return photo
     */
    public Photo getPhoto() {

        return photo;
    }

    /**
     * @param photo
     *            photo
     */
    public void setPhoto(final Photo photo) {

        this.photo = photo;
    }

    public ArrayList<Produit> getListeProduit() {
        return listeProduit;
    }

    public void setListeProduit(final ArrayList<Produit> listeProduit) {
        this.listeProduit = listeProduit;
    }

    /**
     * @return Returns the ville.
     */
    public Ville getVille() {

        return ville;
    }

    /**
     * @param ville
     *            The ville to set.
     */
    public void setVille(final Ville ville) {

        this.ville = ville;
    }

    /**
     * @return Returns the civilite.
     */
    public Civilite getCivilite() {

        return civilite;
    }

    /**
     * @param civilite
     *            The civilite to set.
     */
    public void setCivilite(final Civilite civilite) {

        this.civilite = civilite;
    }

    /**
     * @return Returns the nationalite.
     */
    public Pays getNationalite() {

        return nationalite;
    }

    /**
     * @param nationalite
     *            The nationalite to set.
     */
    public void setNationalite(final Pays nationalite) {

        this.nationalite = nationalite;
    }

    /**
     * @return Returns the client.
     */
    public Boolean getClient() {

        return client;
    }

    /**
     * @param client
     *            The client to set.
     */
    public void setClient(final Boolean client) {

        this.client = client;
    }

    /**
     * @return Returns the vip.
     */
    public Boolean getVip() {

        return vip;
    }

    /**
     * @param vip
     *            The vip to set.
     */
    public void setVip(final Boolean vip) {

        this.vip = vip;
    }

    /**
     * @return Returns the isVIPFiltre.
     */
    public Boolean getIsVIPFiltre() {

        return isVIPFiltre;
    }

    /**
     * @param isVIPFiltre
     *            The isVIPFiltre to set.
     */
    public void setIsVIPFiltre(final Boolean isVIPFiltre) {

        this.isVIPFiltre = isVIPFiltre;
    }

    /**
     * @return oui ou non
     */
    public String getLabelIsVIP() {

        if (vip != null && vip) {
            return "oui";
        } else {
            return "non";
        }
    }

    /**
     * @return Returns the nom.
     */
    public String getNom() {

        return nom;
    }

    /**
     * @param nom
     *            The nom to set.
     */
    public void setNom(final String nom) {

        this.nom = nom;
    }

    /**
     * @return Returns the prenom.
     */
    public String getPrenom() {

        return prenom;
    }

    /**
     * @param prenom
     *            The prenom to set.
     */
    public void setPrenom(final String prenom) {

        this.prenom = prenom;
    }

    /**
     * @return Returns the nomLocal.
     */
    public String getNomLocal() {

        return nomLocal;
    }

    /**
     * @param nomLocal
     *            The nomLocal to set.
     */
    public void setNomLocal(final String nomLocal) {

        this.nomLocal = nomLocal;
    }

    /**
     * @return Returns the prenomLocal.
     */
    public String getPrenomLocal() {

        return prenomLocal;
    }

    /**
     * @param prenomLocal
     *            The prenomLocal to set.
     */
    public void setPrenomLocal(final String prenomLocal) {

        this.prenomLocal = prenomLocal;
    }

    public Date getDateNaissance() {

        return dateNaissance;
    }

    public void setDateNaissance(final Date dateNaissance) {

        this.dateNaissance = dateNaissance;
    }

    /**
     * @return Returns the fonction.
     */
    public String getFonction() {

        return fonction;
    }

    /**
     * @param fonction
     *            The fonction to set.
     */
    public void setFonction(final String fonction) {

        this.fonction = fonction;
    }

    /**
     * @return Returns the proTelFixe.
     */
    public String getProTelFixe() {

        return proTelFixe;
    }

    /**
     * @param proTelFixe
     *            The proTelFixe to set.
     */
    public void setProTelFixe(final String proTelFixe) {

        this.proTelFixe = proTelFixe;
    }

    /**
     * @return Returns the proTelPort.
     */
    public String getProTelPort() {

        return proTelPort;
    }

    /**
     * @param proTelPort
     *            The proTelPort to set.
     */
    public void setProTelPort(final String proTelPort) {

        this.proTelPort = proTelPort;
    }

    /**
     * @return Returns the proCourriel.
     */
    public String getProCourriel() {

        return proCourriel;
    }

    /**
     * @param proCourriel
     *            The proCourriel1 to set.
     */
    public void setProCourriel(final String proCourriel) {

        this.proCourriel = proCourriel;
    }

    /**
     * @return Returns the proFax.
     */
    public String getProFax() {

        return proFax;
    }

    /**
     * @param proFax
     *            The proFax to set.
     */
    public void setProFax(final String proFax) {

        this.proFax = proFax;
    }

    /**
     * @return Returns the proAdrCP.
     */
    public String getProAdrCP() {

        return proAdrCP;
    }

    /**
     * @param proAdrCP
     *            The proAdrCP to set.
     */
    public void setProAdrCP(final String proAdrCP) {

        this.proAdrCP = proAdrCP;
    }

    /**
     * @return Returns the proAdrRue.
     */
    public String getProAdrRue() {

        return proAdrRue;
    }

    /**
     * @param proAdrRue
     *            The proAdrRue to set.
     */
    public void setProAdrRue(final String proAdrRue) {

        this.proAdrRue = proAdrRue;
    }

    /**
     * @return Returns the assistNom.
     */
    public String getAssistNom() {

        return assistNom;
    }

    /**
     * @param assistNom
     *            The assistNom to set.
     */
    public void setAssistNom(final String assistNom) {

        this.assistNom = assistNom;
    }

    /**
     * @return Returns the assistPrenom.
     */
    public String getAssistPrenom() {

        return assistPrenom;
    }

    /**
     * @param assistPrenom
     *            The assistPrenom to set.
     */
    public void setAssistPrenom(final String assistPrenom) {

        this.assistPrenom = assistPrenom;
    }

    /**
     * @return Returns the assistTel.
     */
    public String getAssistTel() {

        return assistTel;
    }

    /**
     * @param assistTel
     *            The assistTel to set.
     */
    public void setAssistTel(final String assistTel) {

        this.assistTel = assistTel;
    }

    /**
     * @return Returns the assistCourriel.
     */
    public String getAssistCourriel() {

        return assistCourriel;
    }

    /**
     * @param assistCourriel
     *            The assistCourriel to set.
     */
    public void setAssistCourriel(final String assistCourriel) {

        this.assistCourriel = assistCourriel;
    }

    /**
     * @return Returns the commentaire.
     */
    public String getCommentaire() {

        return commentaire;
    }

    /**
     * @param commentaire
     *            The commentaire to set.
     */
    public void setCommentaire(final String commentaire) {

        this.commentaire = commentaire;
    }

    /**
     * @return Returns the organisme.
     */
    public String getOrganisme() {

        return organisme;
    }

    /**
     * @param organisme
     *            The organisme to set.
     */
    public void setOrganisme(final String organisme) {

        this.organisme = organisme;
    }

    /**
     * @return Returns the satisfaction.
     */
    public String getSatisfaction() {

        return satisfaction;
    }

    /**
     * @param satisfaction
     *            The satisfaction to set.
     */
    public void setSatisfaction(final String satisfaction) {

        this.satisfaction = satisfaction;
    }

    /**
     * Getter of the dateCrea
     *
     * @return Returns the dateCrea.
     */
    public final Date getDateCrea() {

        return dateCrea;
    }

    /**
     * Setter of the dateCrea
     *
     * @param dateCrea
     *            The dateCrea to set.
     */
    public final void setDateCrea(final Date dateCrea) {

        this.dateCrea = dateCrea;
    }

    /**
     * Getter of the dateModif
     *
     * @return Returns the dateModif.
     */
    public final Date getDateModif() {

        return dateModif;
    }

    /**
     * Setter of the dateModif
     *
     * @param dateModif
     *            The dateModif to set.
     */
    public final void setDateModif(final Date dateModif) {

        this.dateModif = dateModif;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        final StringBuilder builder = new StringBuilder();
        builder.append("Partenaire [id=").append(id).append(", ville=").append(ville).append(", civilite=")
        .append(civilite).append(", nationalite=").append(nationalite).append(", photo=")
        .append(photo).append(", client=").append(client).append(", vip=").append(vip)
        .append(", isVIPFiltre=").append(isVIPFiltre).append(", nom=").append(nom)
        .append(", prenom=").append(prenom).append(", nomLocal=").append(nomLocal)
        .append(", prenomLocal=").append(prenomLocal).append(", dateNaissance=")
        .append(dateNaissance).append(", fonction=").append(fonction)
        .append(", proTelFixe=").append(proTelFixe).append(", proTelPort=").append(proTelPort)
        .append(", proCourriel=").append(proCourriel).append(", proFax=").append(proFax)
        .append(", proAdrCP=").append(proAdrCP).append(", proAdrRue=").append(proAdrRue)
        .append(", assistNom=").append(assistNom).append(", assistPrenom=").append(assistPrenom)
        .append(", assistTel=").append(assistTel).append(", assistCourriel=")
        .append(assistCourriel).append(", commentaire=").append(commentaire)
        .append(", organisme=").append(organisme).append(", satisfaction=").append(satisfaction)
        .append(", dateCrea=").append(dateCrea).append(", dateModif=").append(dateModif)
        .append("]");
        return builder.toString();
    }


}
