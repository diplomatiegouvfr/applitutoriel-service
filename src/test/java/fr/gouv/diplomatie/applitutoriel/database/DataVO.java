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
package fr.gouv.diplomatie.applitutoriel.database;

import java.io.Serializable;
import java.util.Date;

/**
 * Projet AppliTutoriel.
 *
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 *
 */
public class DataVO implements Serializable {

    private static final String CURDATE = "CURDATE()";

    /**
     * <code>serialVersionUID</code> the serialVersionUID
     */
    private static final long serialVersionUID = -3179313738555309954L;

    /**
     * <code>idPays</code> the idPays
     */
    private int idPays;

    /**
     * <code>idVille</code> the idVille
     */
    private int idVille;

    /**
     * <code>idCiv</code> the idCiv
     */
    private int idCiv;

    /**
     * <code>isClient</code> the isClient
     */
    private String isClient;

    /**
     * <code>isVip</code> the isVip
     */
    private String isVip;

    /**
     * <code>nom</code> the nom
     */
    private String nom;

    /**
     * <code>prenom</code> the prenom
     */
    private String prenom;

    /**
     * <code>mail</code> the mail
     */
    private String mail;

    /**
     * <code>cp</code> the cp
     */
    private String cp;

    /**
     * <code>rue</code> the rue
     */
    private String rue;

    /**
     * <code>organisme</code> the organisme
     */
    private String organisme;

    /**
     * <code>dateCrea</code> the dateCrea
     */
    private Date dateCrea;

    /**
     * <code>dateModif</code> the dateModif
     */
    private Date dateModif;

    /**
     * Constructeur
     */
    public DataVO() {

        super();
    }

    /**
     * @param idPays
     *            int
     * @param idVille
     *            int
     * @param idCiv
     *            int
     * @param isClient
     *            String
     * @param isVip
     *            String
     * @param nom
     *            String
     * @param prenom
     *            String
     * @param mail
     *            String
     * @param cp
     *            String
     * @param rue
     *            String
     * @param organisme
     *            String
     * @param dateCrea
     *            Date
     * @param dateModif
     *            Date
     */
    public DataVO(
                final int idPays, final int idVille, final int idCiv, final String isClient,
                final String isVip, final String nom, final String prenom, final String mail,
                final String cp, final String rue, final String organisme, final Date dateCrea,
                final Date dateModif) {

        super();
        this.idPays = idPays;
        this.idVille = idVille;
        this.idCiv = idCiv;
        this.isClient = isClient;
        this.isVip = isVip;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.cp = cp;
        this.rue = rue;
        this.organisme = organisme;
        this.dateCrea = dateCrea;
        this.dateModif = dateModif;
    }

    /**
     * Getter of the idPays
     *
     * @return Returns the idPays.
     */
    public final int getIdPays() {

        return this.idPays;
    }

    /**
     * Setter of the idPays
     *
     * @param idPays
     *            The idPays to set.
     */
    public final void setIdPays(final int idPays) {

        this.idPays = idPays;
    }

    /**
     * Getter of the idVille
     *
     * @return Returns the idVille.
     */
    public final int getIdVille() {

        return this.idVille;
    }

    /**
     * Setter of the idVille
     *
     * @param idVille
     *            The idVille to set.
     */
    public final void setIdVille(final int idVille) {

        this.idVille = idVille;
    }

    /**
     * Getter of the idCiv
     *
     * @return Returns the idCiv.
     */
    public final int getIdCiv() {

        return this.idCiv;
    }

    /**
     * Setter of the idCiv
     *
     * @param idCiv
     *            The idCiv to set.
     */
    public final void setIdCiv(final int idCiv) {

        this.idCiv = idCiv;
    }

    /**
     * Getter of the isClient
     *
     * @return Returns the isClient.
     */
    public final String getIsClient() {

        return this.isClient;
    }

    /**
     * Setter of the isClient
     *
     * @param isClient
     *            The isClient to set.
     */
    public final void setIsClient(final String isClient) {

        this.isClient = isClient;
    }

    /**
     * Getter of the isVip
     *
     * @return Returns the isVip.
     */
    public final String getIsVip() {

        return this.isVip;
    }

    /**
     * Setter of the isVip
     *
     * @param isVip
     *            The isVip to set.
     */
    public final void setIsVip(final String isVip) {

        this.isVip = isVip;
    }

    /**
     * Getter of the nom
     *
     * @return Returns the nom.
     */
    public final String getNom() {

        return this.nom;
    }

    /**
     * Setter of the nom
     *
     * @param nom
     *            The nom to set.
     */
    public final void setNom(final String nom) {

        this.nom = nom;
    }

    /**
     * Getter of the prenom
     *
     * @return Returns the prenom.
     */
    public final String getPrenom() {

        return this.prenom;
    }

    /**
     * Setter of the prenom
     *
     * @param prenom
     *            The prenom to set.
     */
    public final void setPrenom(final String prenom) {

        this.prenom = prenom;
    }

    /**
     * Getter of the mail
     *
     * @return Returns the mail.
     */
    public final String getMail() {

        return this.mail;
    }

    /**
     * Setter of the mail
     *
     * @param mail
     *            The mail to set.
     */
    public final void setMail(final String mail) {

        this.mail = mail;
    }

    /**
     * Getter of the cp
     *
     * @return Returns the cp.
     */
    public final String getCp() {

        return this.cp;
    }

    /**
     * Setter of the cp
     *
     * @param cp
     *            The cp to set.
     */
    public final void setCp(final String cp) {

        this.cp = cp;
    }

    /**
     * Getter of the rue
     *
     * @return Returns the rue.
     */
    public final String getRue() {

        return this.rue;
    }

    /**
     * Setter of the rue
     *
     * @param rue
     *            The rue to set.
     */
    public final void setRue(final String rue) {

        this.rue = rue;
    }

    /**
     * Getter of the organisme
     *
     * @return Returns the organisme.
     */
    public final String getOrganisme() {

        return this.organisme;
    }

    /**
     * Setter of the organisme
     *
     * @param organisme
     *            The organisme to set.
     */
    public final void setOrganisme(final String organisme) {

        this.organisme = organisme;
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

    /** {@inheritDoc} */
    @Override
    public String toString() {

        final StringBuffer sb = new StringBuffer(20);
        final String sdateCrea = DateUtility.parseDateToString(this.dateCrea);
        final String sdateModif = DateUtility.parseDateToString(this.dateModif);
        final String separatorStringString = "', '";
        final String separatorOtherString = ", '";
        final String separatorStringOther = "', ";
        final String separator = ", ";
        sb.append(this.idPays);
        sb.append(separator);
        sb.append(this.idVille);
        sb.append(separator);
        sb.append(this.idCiv);
        sb.append(separator);
        sb.append(this.isClient);
        sb.append(separator);
        sb.append(this.isVip);
        sb.append(separatorOtherString);
        sb.append(this.nom);
        sb.append(separatorStringString);
        sb.append(this.prenom);
        sb.append(separatorStringString);
        sb.append(this.mail);
        sb.append(separatorStringString);
        sb.append(this.cp);
        sb.append(separatorStringString);
        sb.append(this.rue);
        sb.append(separatorStringString);
        sb.append(this.organisme);
        // Dates
        if (!sdateCrea.equals(CURDATE)) {
            sb.append(separatorStringString);
        } else {
            sb.append(separatorStringOther);
        }

        // date création
        sb.append(sdateCrea);
        if (!sdateCrea.equals(CURDATE)) {
            sb.append(" 00:00:00");
        }

        if (!sdateCrea.equals(CURDATE) && !sdateModif.equals(CURDATE)) {
            sb.append(separatorStringString);
        } else if (sdateCrea.equals(CURDATE) && sdateModif.equals(CURDATE)) {
            sb.append(separator);
        } else {
            sb.append(separatorStringOther);
        }

        // date modif
        sb.append(sdateModif);
        if (!sdateModif.equals(CURDATE)) {
            sb.append(" 00:00:00");
        }

        if (!sdateModif.equals(CURDATE)) {
            sb.append("'");
        }

        return sb.toString();
    }

    /**
     * @param o
     *            DataVO
     * @return boolean
     */
    @Override
    public boolean equals(final Object o) {

        final DataVO data = (DataVO) o;
        return this.getNom() != null && this.getNom().equals(data.getNom())
                    && this.getPrenom().equals(data.getPrenom());
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {

        return super.hashCode();
    }

    /**
     * @return String
     */
    public String debug() {

        return "nom : " + this.nom + ", prenom : " + this.prenom;
    }

    /**
     * fillDataVO
     */
    public void fillDataVO() {

        this.idPays = GenerateData.ID_PAYS; // ID_PAYS
        this.idVille = GenerateData.ID_VILLE; // ID_VILLE
        this.idCiv = GenerateData.ID_CIV; // ID_CIV

        this.isVip = GenerateData.genereBoolean(); // IS_VIP
        this.isClient = GenerateData.genereBoolean(); // IS_CLIENT

        this.nom = GenerateData.genereNom(); // NOM
        this.prenom = GenerateData.generePrenom(); // PRENOM
        this.mail = GenerateData.genereMail(this.prenom, this.nom); // MAIL

        this.cp = GenerateData.CP; // CP

        this.rue = GenerateData.genereRue(); // RUE

        this.organisme = GenerateData.genereOrganisme(); // ORGANISME

        this.genereDate(); // DATE_CREA et DATE_MODIF
    }

    /**
     * genereDate
     */
    public void genereDate() {

        // Deux dates : DATE_CREA et DATE_MODIF
        // -> DATE_CREA <= DATE_MODIF <= dateDuJour
        final Date dateJour = DateUtility.getDateJour();
        // 3 cas possibles
        final String choixCase = GenerateData.genereCase();
        switch (Integer.valueOf(choixCase)) {
            case 1:
                // Cas 1 : les deux dates sont a date du jour
                this.dateCrea = dateJour; // DATE_CREA
                this.dateModif = dateJour; // DATE_MODIF
                break;
            case 2:
                // Cas 2 : date crea avant, date modif date du jour
                this.dateCrea = DateUtility.getDateAvant(dateJour); // DATE_CREA
                this.dateModif = dateJour; // DATE_MODIF
                break;
            case 3:
                // Cas 3 : date crea avant, date modif avant date jour
                // DATE_MODIF
                this.dateModif = DateUtility.getDateAvant(dateJour);
                // DATE_CREA
                this.dateCrea = DateUtility.getDateAvant(this.dateModif);
                break;
            default:
                break;
        }
    }
}
