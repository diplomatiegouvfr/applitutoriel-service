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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DateUtility
 *
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
public final class DateUtility {

    /**
     * LOG
     */
    private static final Logger LOG = LoggerFactory.getLogger(DateUtility.class);

    /**
     * <code>FORMAT_DATE</code> the FORMAT_DATE
     */
    private static final String FORMAT_DATE = "yyyy-MM-dd";

    /**
     * <code>DATE_JOUR</code> the DATE_JOUR
     */
    private static final String DATE_JOUR = "CURDATE()";

    /**
     * Constructeur
     */
    private DateUtility() {

        super();
    }

    /**
     * @param stDate
     *            String
     * @return Date date
     */
    public static Date parseStringToDate(final String stDate) {

        Date dateReturn = null;
        try {
            dateReturn = new SimpleDateFormat(DateUtility.FORMAT_DATE, Locale.FRENCH).parse(stDate);
        } catch (final ParseException e) {
            DateUtility.LOG.info("Exception : {}", e.getMessage());
            dateReturn = new Date();
        }
        return dateReturn;
    }

    /**
     * @param date
     *            Date
     * @return String stDate
     */
    public static String parseDateToString(final Date date) {

        String stDate = "";
        if (DateUtility.isDateJour(date)) {
            stDate = DateUtility.DATE_JOUR;
        } else {
            stDate = new SimpleDateFormat(DateUtility.FORMAT_DATE, Locale.FRENCH).format(date);
        }
        return stDate;
    }

    /**
     * @return Date
     */
    public static Date getDateJour() {

        return new Date();
    }

    /**
     * @param date
     *            Date
     * @return boolean
     */
    public static boolean isDateJour(final Date date) {

        final String stDate = new SimpleDateFormat(DateUtility.FORMAT_DATE, Locale.FRENCH).format(date) + "'";
        final Date dateJour = new Date();
        final String stDateJour =
                    new SimpleDateFormat(DateUtility.FORMAT_DATE, Locale.FRENCH).format(dateJour) + "'";

        return stDate != null && stDateJour != null && stDate.equals(stDateJour);
    }

    /**
     * @param date
     *            Date
     * @return Date dateReturn
     */
    public static Date getDateAvant(final Date date) {

        Date dateReturn = null;
        // Variables
        final String[] tabJour = GenerateData.generateTabStr(29);
        final String[] tabMois = GenerateData.generateTabStr(12);
        final String[] tabAnnee = {
            "2001",
            "2002",
            "2003",
            "2004",
            "2005",
            "2006",
            "2007",
            "2008",
            "2009",
            "2010",
            "2011"};
        // Generation
        while (dateReturn == null) {
            String jour = RandomUtility.rand(tabJour);
            if (jour.length() == 1) {
                jour = "0" + jour;
            }
            String mois = RandomUtility.rand(tabMois);
            if (mois.length() == 1) {
                mois = "0" + mois;
            }
            final String annee = RandomUtility.rand(tabAnnee);
            // dateGen
            final Date dateGen = DateUtility.parseStringToDate(annee + "-" + mois + "-" + jour);
            if (dateGen.before(date)) {
                dateReturn = dateGen;
            }
        }
        // Return
        return dateReturn;
    }
}
