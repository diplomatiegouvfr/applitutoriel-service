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
import java.util.Date;

/**
 * Entité metier Partenaire
 *
 * @author MAEDI
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
    private Boolean isClient;

    /**
     *
     */
    private Boolean isVIP;

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

        this.ville = new Ville();
        this.nationalite = new Pays();
        this.civilite = new Civilite();
    }

    /**
     * @param idPartenaire
     *            Long
     */
    public Partenaire(
                final Long idPartenaire) {

        this.id = idPartenaire;
        this.ville = new Ville();
        this.nationalite = new Pays();
        this.civilite = new Civilite();
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

    /**
     * @return Returns the ville.
     */
    public Ville getVille() {

        return this.ville;
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

        return this.civilite;
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

        return this.nationalite;
    }

    /**
     * @param nationalite
     *            The nationalite to set.
     */
    public void setNationalite(final Pays nationalite) {

        this.nationalite = nationalite;
    }

    /**
     * @return Returns the isClient.
     */
    public Boolean getIsClient() {

        return this.isClient;
    }

    /**
     * @param isClient
     *            The isClient to set.
     */
    public void setIsClient(final Boolean isClient) {

        this.isClient = isClient;
    }

    /**
     * @return Returns the isVIP.
     */
    public Boolean getIsVIP() {

        return this.isVIP;
    }

    /**
     * @param isVIP
     *            The isVIP to set.
     */
    public void setIsVIP(final Boolean isVIP) {

        this.isVIP = isVIP;
    }

    /**
     * @return Returns the isVIPFiltre.
     */
    public Boolean getIsVIPFiltre() {

        return this.isVIPFiltre;
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

        if (this.isVIP != null && this.isVIP) {
            return "oui";
        } else {
            return "non";
        }
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
     * @return Returns the prenom.
     */
    public String getPrenom() {

        return this.prenom;
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

        return this.nomLocal;
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

        return this.prenomLocal;
    }

    /**
     * @param prenomLocal
     *            The prenomLocal to set.
     */
    public void setPrenomLocal(final String prenomLocal) {

        this.prenomLocal = prenomLocal;
    }

    /**
     * @return Returns the fonction.
     */
    public String getFonction() {

        return this.fonction;
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

        return this.proTelFixe;
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

        return this.proTelPort;
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

        return this.proCourriel;
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

        return this.proFax;
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

        return this.proAdrCP;
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

        return this.proAdrRue;
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

        return this.assistNom;
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

        return this.assistPrenom;
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

        return this.assistTel;
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

        return this.assistCourriel;
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

        return this.commentaire;
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

        return this.organisme;
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

        return this.satisfaction;
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

        return this.dateCrea;
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

        return this.dateModif;
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
                    .append(photo).append(", isClient=").append(isClient).append(", isVIP=").append(isVIP)
                    .append(", isVIPFiltre=").append(isVIPFiltre).append(", nom=").append(nom)
                    .append(", prenom=").append(prenom).append(", nomLocal=").append(nomLocal)
                    .append(", prenomLocal=").append(prenomLocal).append(", fonction=").append(fonction)
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
