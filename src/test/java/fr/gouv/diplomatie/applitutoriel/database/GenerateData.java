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
package fr.gouv.diplomatie.applitutoriel.database;

import java.util.Locale;

/**
 * RessourcesDatabase
 *
 * @author MAEDI
 */
public final class GenerateData {

    /**
     * <code>NB_MAX</code> the NB_MAX
     */
    public static final int NB_MAX = 100;

    /**
     * <code>DEBUT_REQ</code> the DEBUT_REQ
     */
    public static final String DEBUT_REQ = "INSERT INTO PARTENAIRE (" + "ID_PAYS, ID_VILLE, ID_CIVILITE, "
                + "PAR_IS_CLIENT, PAR_IS_VIP, " + "PAR_NOM, PAR_PRENOM, "
                + "PAR_PRO_COURRIEL, PAR_PRO_ADR_CP, PAR_PRO_ADR_RUE, PAR_ORGANISME, "
                + "PAR_DATE_CREATION, PAR_DATE_MODIFICATION) VALUES (";

    /**
     * <code>FIN_REQ</code> the FIN_REQ
     */
    public static final String FIN_REQ = ");";

    /**
     * <code>ID_PARTENAIRE</code> the ID_PARTENAIRE
     */
    public static final int ID_PARTENAIRE = 4;

    /**
     * <code>ID_PAYS</code> the ID_PAYS
     */
    public static final int ID_PAYS = 62; // FRANCE

    /**
     * <code>ID_VILLE</code> the ID_VILLE
     */
    public static final int ID_VILLE = 2664; // PARIS

    /**
     * <code>ID_CIV</code> the ID_CIV
     */
    public static final int ID_CIV = 2; // Mr

    /**
     * <code>TAB_CASE</code> the TAB_CASE
     */
    public static final String[] TAB_CASE = {
        "1",
        "2",
        "3"};

    /**
     * <code>TAB_BOOLEAN</code> the TAB_BOOLEAN
     */
    public static final String[] TAB_BOOLEAN = {
        "0",
        "1"};

    /**
     * <code>TAB_NOM</code> the TAB_NOM
     */
    public static final String[] TAB_NOM = {
        "DUPONT",
        "DUPOND",
        "DURAND",
        "PASCAL",
        "PAUL",
        "SILVA",
        "MARTIN",
        "JEAN",
        "SIMON",
        "JACQUES",
        "MAISTRE",
        "ALBERT",
        "DEVIL",
        "PRINCE",
        "JACK",
        "ROBERT",
        "ALFRED",
        "BAZIN",
        "DENO",
        "KIVEN",
        "SOLAU",
        "TADIO"};

    /**
     * <code>TAB_PRENOM</code> the TAB_PRENOM
     */
    public static final String[] TAB_PRENOM = {
        "Arnaud",
        "David",
        "Guillaume",
        "François",
        "Jean",
        "Jacques",
        "Pierre",
        "Paul",
        "Jean-Pierre",
        "Jean-Paul",
        "Matthieu",
        "Fred",
        "Max",
        "Vincent",
        "Bertrand",
        "Renaud",
        "Albert",
        "Bruce",
        "Sylvestre",
        "Marc",
        "Noa",
        "Jules",
        "James"};

    /**
     * <code>TAB_MAIL</code> the TAB_MAIL
     */
    public static final String[] TAB_MAIL = {
        "free.fr",
        "orange.net",
        "msn.com",
        "hotmail.com",
        "sfr.fr",
        "bouygues.net",
        "live.fr",
        "gmail.com",
        "yahoo.fr"};

    /**
     * <code>CP</code> the CP
     */
    public static final String CP = "75000";

    /**
     * <code>TAB_NUM_RUE</code> the TAB_NUM_RUE
     */
    public static final String[] TAB_NUM_RUE = GenerateData.generateTabStr(50);

    /**
     * <code>TAB_CPT_RUE</code> the TAB_CPT_RUE
     */
    public static final String[] TAB_CPT_RUE = {
        "",
        "bis ",
        "ter "};

    /**
     * <code>TAB_LIB_RUE</code> the TAB_LIB_RUE
     */
    public static final String[] TAB_LIB_RUE = {
        "rue",
        "avenue",
        "impasse",
        "boulevard"};

    /**
     * <code>TAB_FIN_RUE</code> the TAB_FIN_RUE
     */
    public static final String[] TAB_FIN_RUE = {
        "du chemin Vert",
        "Victor Hugo",
        "Besnière",
        "Général Leclerc",
        "Général Buat",
        "Général de Gaulle",
        "Adjudant Tifrice",
        "de la clairière",
        "du Lac",
        "des Hortensias",
        "du petit chemin",
        "du grand chemin",
        "du grand Lac",
        "de la forêt",
        "de l''auberge",
        "du moulin",
        "de Lyon",
        "de Vannes",
        "de Rennes",
        "Ivry",
        "Eiffel"};

    /**
     * <code>TAB_ORGANISME</code> the TAB_ORGANISME
     */
    public static final String[] TAB_ORGANISME = {
        "Organisme 1",
        "Organisme 2",
        "Organisme 3",
        "Organisme 4",
        "Organisme 5"};

    /**
     * Constructeur
     */
    private GenerateData() {

        super();
    }

    /**
     * @param max
     *            int
     * @return String[] tab
     */
    public static String[] generateTabStr(final int max) {

        final String[] result = new String[max];
        int index = 0;
        int nb = 1;
        for (int posTab = 0; posTab < max; posTab++) {
            result[index] = Integer.toString(nb);
            index++;
            nb++;
        }
        return result;
    }

    /**
     * @return String case
     */
    public static String genereCase() {

        return RandomUtility.rand(GenerateData.TAB_CASE);
    }

    /**
     * @return String boolean
     */
    public static String genereBoolean() {

        return RandomUtility.rand(GenerateData.TAB_BOOLEAN);
    }

    /**
     * @return String nom
     */
    public static String genereNom() {

        return RandomUtility.rand(GenerateData.TAB_NOM);
    }

    /**
     * @return String prenom
     */
    public static String generePrenom() {

        return RandomUtility.rand(GenerateData.TAB_PRENOM);
    }

    /**
     * @param prenom
     *            String
     * @param nom
     *            String
     * @return String mail
     */
    public static String genereMail(final String prenom, final String nom) {

        return prenom.toLowerCase(Locale.FRENCH) + "." + nom.toLowerCase(Locale.FRENCH) + "@"
                    + RandomUtility.rand(GenerateData.TAB_MAIL);
    }

    /**
     * @return String rue
     */
    public static String genereRue() {

        final String numRue = RandomUtility.rand(GenerateData.TAB_NUM_RUE);
        final String cptRue = RandomUtility.rand(GenerateData.TAB_CPT_RUE);
        final String libRue = RandomUtility.rand(GenerateData.TAB_LIB_RUE);
        final String finRue = RandomUtility.rand(GenerateData.TAB_FIN_RUE);
        return numRue + " " + cptRue + libRue + " " + finRue;
    }

    /**
     * @return String organisme
     */
    public static String genereOrganisme() {

        return RandomUtility.rand(GenerateData.TAB_ORGANISME);
    }
}
