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

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RandomUtility
 *
 * @author MAEDI
 */
public final class RandomUtility {

    /**
     * LOG
     */
    private static final Logger LOG = LoggerFactory.getLogger(RandomUtility.class);

    /**
     * Constructeur
     */
    private RandomUtility() {

        super();
    }

    /**
     * @param ref
     *            String[]
     * @return String
     */
    public static String rand(final String[] ref) {

        final int nbElem = ref.length;
        // Genere un nb aléatoire
        final Random random = new Random();
        // Retourne le nb dans la plage fournie
        final int nbRd = random.nextInt(nbElem);
        return ref[nbRd];
    }

    /**
     * testRdn
     */
    public static void testRdn() {

        final int nbElem = 2;
        final String[] ref = GenerateData.generateTabStr(nbElem);
        final int[] tabCpt = new int[nbElem + 1];
        for (int j = 0; j <= nbElem; j++) {
            tabCpt[j] = 0;
        }
        final int nbOcc = 1000;
        // Bouclage
        for (int i = 0; i <= nbOcc; i++) {
            final int res = Integer.valueOf(RandomUtility.rand(ref));
            tabCpt[res] = tabCpt[res] + 1;
        }
        // Fin
        // Parcours du nbOcc
        RandomUtility.LOG.info("Parcours : ");
        for (int k = 1; k < nbElem + 1; k++) {
            RandomUtility.LOG.info("k : {}, {}", k, tabCpt[k]);
        }
    }
}
