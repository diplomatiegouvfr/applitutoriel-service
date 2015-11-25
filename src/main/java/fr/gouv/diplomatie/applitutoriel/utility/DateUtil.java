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
package fr.gouv.diplomatie.applitutoriel.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class DateUtil.
 *
 * @author MAEDI
 */
public final class DateUtil {

    /** <code>logger</code>: Definition du logger. */
    private static final Logger LOG = LoggerFactory.getLogger(DateUtil.class);

    /** Chaine de caractère correspondant au format de la date Française. */
    private static final String FORMAT_DATE = "dd/MM/yyyy";

    /** <code>DATE_BORNE_INF</code> the DATE_BORNE_INF. */
    private static final Date DATE_BORNE_INF = DateUtil.stringToDate("01/01/1753");

    /** <code>DATE_BORNE_SUP</code> the DATE_BORNE_SUP. */
    private static final Date DATE_BORNE_SUP = DateUtil.stringToDate("31/12/9999");

    /**
     * Instantiates a new date util.
     */
    private DateUtil() {

    }

    /**
     * Transforme une chaine dd/mm/aaaa en date dd/MM/yyyy.
     *
     * @param p_date
     *            .
     * @return java.util.Date .
     */
    public static Date stringToDate(final String p_date) {

        Date date = null;
        if (p_date != null) {
            try {
                final SimpleDateFormat format = new SimpleDateFormat(DateUtil.FORMAT_DATE, Locale.FRENCH);
                date = format.parse(p_date);
            } catch (final ParseException e) {
                return null;
            }
        }
        return date;
    }

    /**
     * Get Date du Jour.
     *
     * @return Date dateDuJour
     */
    public static Date getDateDuJour() {

        return new Date();
    }

    /**
     * Checks if is date valide.
     *
     * @param pDate
     *            Date
     * @return boolean isValid
     */
    public static boolean isDateValide(final Date pDate) {

        if (pDate.after(DateUtil.DATE_BORNE_INF) && pDate.before(DateUtil.DATE_BORNE_SUP)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if is date valide.
     *
     * @param pDate
     *            the date
     * @param pFormat
     *            the format
     * @return true, if is date valide
     */
    public static boolean isDateValide(final String pDate, final String pFormat) {

        try {
            final DateFormat df = new SimpleDateFormat(pFormat, Locale.FRENCH);
            df.setLenient(false);
            final Date laDate = df.parse(pDate);
            final String dateString = df.format(laDate);
            return pDate.equals(dateString);
        } catch (final ParseException e) {
            return false;
        }
    }

    /**
     * Checks if is date valide.
     *
     * @param pDate
     *            the date
     * @return true, if is date valide
     */
    public static boolean isDateValide(final String pDate) {

        return isDateValide(pDate, FORMAT_DATE);
    }
}
