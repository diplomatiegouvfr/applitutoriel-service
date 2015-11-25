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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FileUtility
 *
 * @author MAEDI
 */
public final class FileOutput {

    /**
     * LOG
     */
    private static final Logger LOG = LoggerFactory.getLogger(FileOutput.class);

    /**
     * <code>ressources</code> the ressources
     */
    private static final String RESSOURCES = "database";

    /**
     * <code>NOM_FICHIER</code> the NOM_FICHIER
     */
    private static final String NOM_FICHIER = "initDabase_fragment.txt";

    /**
     * <code>file</code> the file
     */
    private transient File file = null;

    /**
     * <code>writer</code> the writer
     */
    private transient FileWriter writer;

    /**
     * <code>buffer</code> the buffer
     */
    private transient BufferedWriter output;

    /**
     * Constructeur
     */
    public FileOutput() {

        super();
        this.initFichier();
    }

    /**
     * initFichier
     */
    public void initFichier() {

        final URL fichierBase = this.getClass().getClassLoader().getResource("");
        final String path = fichierBase.getPath().replaceAll("bin/classes/", "src/config");

        URL fichier = null;
        try {
            fichier = new URL("file:" + path + "/" + FileOutput.RESSOURCES + "/" + FileOutput.NOM_FICHIER);
        } catch (final MalformedURLException e) {
            FileOutput.LOG.info("Fichier non trouvé : ", e);
        }

        if (fichier != null) {
            try {
                this.file = new File(fichier.toURI());
            } catch (final URISyntaxException e) {
                FileOutput.LOG.info("Fichier en erreur : ", e);
            }
        }
    }

    /**
     * @return boolean
     */
    public boolean isReady() {

        if (this.file == null) {
            return false;
        }
        return true;
    }

    /**
     * ouvrirFichier
     */
    public void ouvrirFichier() {

        try {
            this.writer = new FileWriter(this.file, false);
            this.output = new BufferedWriter(this.writer);
        } catch (final IOException e) {
            FileOutput.LOG.info("Ouverture fichier impossible : ", e);
        }
    }

    /**
     * ecrireDansFichier
     *
     * @param ligne
     *            String
     */
    public void ecrireDansFichier(final String ligne) {

        try {
            this.output.append(ligne);
            this.output.append("\n");
            this.output.flush();
        } catch (final IOException e) {
            FileOutput.LOG.info("Ecriture dans fichier impossible : ", e);
        }
    }

    /**
     * fermerFichier
     */
    public void fermerFichier() {

        try {
            this.output.close();
        } catch (final IOException e) {
            FileOutput.LOG.info("Fermeture fichier impossible : ", e);
        }
    }
}
