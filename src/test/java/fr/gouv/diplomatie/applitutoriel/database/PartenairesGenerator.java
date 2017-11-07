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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Générateur de partenaires pour tests de performances.
 */
public class PartenairesGenerator {

    /**
     * Complète le fichier initData.sql indiqué en dupliquant n fois une ligne de partenaire
     * @param args
     *  - args[0] chemin du fichier original initData.sql
     *  - args[1] chemin du fichier à écrire
     *  - args[2] (optionnel) nombre de lignes à générer
     */
    public static void main(final String[] args) {
        final String inFile;
        if(args.length > 0) {
            inFile = args[0];
        } else {
            inFile = "initData.sql";
        }
        System.out.println("Lecture du fichier " + inFile);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inFile));
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        final String outFile;
        if(args.length > 1) {
            outFile = args[1];
        } else {
            outFile = "initPerfData.sql";
        }
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(outFile));
        } catch (final IOException e) {
            e.printStackTrace();
            try {
                reader.close();
            } catch (final IOException e1) {
                e1.printStackTrace();
            }
            return;
        }

        int linesNb = 1000;
        if(args.length > 2) {
            linesNb = Integer.parseInt(args[2]);
        }

        try {
            String line = reader.readLine();
            /* Nom/Prénom de la ligne de partenaire à dupliquer */
            final String PATTERN = "'PASCAL', 'Arnaud'";
            while (line != null) {
                if (line.contains(PATTERN)) {
                    writer.write(line);
                    for (int i = 0; i < linesNb; i++) {
                        /* Les lignes sont générées en ajoutant un index aux noms/prénoms */
                        final String newLine = line.replace(PATTERN, "'PASCAL" + i +"', 'Arnaud" + i + "'");
                        writer.write(newLine);
                        writer.newLine();
                        if(i % 100 == 0) {
                            System.out.println(newLine);
                        }
                    }
                } else {
                    writer.write(line);
                    writer.newLine();
                    System.out.println(line);
                }
                line = reader.readLine();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }

            try {
                writer.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

    }

}
