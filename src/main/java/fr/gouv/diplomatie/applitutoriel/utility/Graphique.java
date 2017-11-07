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
package fr.gouv.diplomatie.applitutoriel.utility;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.SortOrder;

/**
 * The Class Graphique.
 *
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 * @since 1.0 - 7 août 2014
 */
public final class Graphique {

    /**
     * Classe utilitaire => Constructeur privé.
     */
    private Graphique() {

        // not called
    }

    /** The list color. */
    private static List<Color> listColor = new ArrayList<Color>();
    static {
        listColor.add(0, new Color(102, 153, 102));
        listColor.add(1, new Color(51, 51, 102));
        listColor.add(2, new Color(51, 102, 204));
        listColor.add(3, new Color(204, 51, 51));
        listColor.add(4, new Color(0, 204, 204));
        listColor.add(5, new Color(51, 204, 153));
        listColor.add(6, new Color(255, 0, 153));
        listColor.add(7, new Color(204, 204, 0));
        listColor.add(8, Color.BLUE);
        listColor.add(9, Color.DARK_GRAY);
        listColor.add(10, Color.CYAN);
        listColor.add(11, Color.GREEN);
        listColor.add(12, Color.LIGHT_GRAY);
        listColor.add(13, Color.MAGENTA);
        listColor.add(14, Color.ORANGE);
        listColor.add(15, Color.PINK);
        listColor.add(16, Color.RED);
        listColor.add(17, Color.WHITE);
        listColor.add(18, Color.YELLOW);
    }

    /**
     * Creer camember3 d.
     *
     * @param title
     *            the title
     * @param dataset
     *            the dataset
     * @param legend
     *            the legend
     * @param tooltips
     *            the tooltips
     * @param urls
     *            the urls
     * @return the j free chart
     * @throws FontFormatException
     *             the font format exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public static JFreeChart creerCamember3D(final String title, final DefaultPieDataset dataset,
                final boolean legend, final boolean tooltips, final boolean urls) throws FontFormatException,
        IOException {

        dataset.sortByValues(SortOrder.DESCENDING);
        final JFreeChart jfreeChart = ChartFactory.createPieChart3D(title, dataset, legend, tooltips, urls);

        jfreeChart.setBackgroundPaint(Color.white);
        jfreeChart.setBorderVisible(true);
        jfreeChart.getLegend().setPosition(RectangleEdge.LEFT);
        final GraphicsEnvironment graph = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final InputStream inputStream =
                    Thread.currentThread().getContextClassLoader()
                                .getResourceAsStream("hornet/framework/font/LiberationSans-Bold.ttf");
        final Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        graph.registerFont(font);
        jfreeChart.getLegend().setItemFont(new Font("Liberation Sans", Font.BOLD, 11));
        jfreeChart.getLegend().setHeight(400);
        jfreeChart.getLegend().setBorder(0, 0, 0, 0);
        jfreeChart.setTitle(new TextTitle(title, new Font("Liberation Sans", Font.BOLD, 16)));
        final PiePlot piePlot = (PiePlot) jfreeChart.getPlot();

        final int nbData = dataset.getItemCount();
        int cptColor = 0;
        for (int x = 0; x < nbData; x++) {
            if (cptColor >= listColor.size()) {
                cptColor = 0;
            }
            piePlot.setSectionPaint(dataset.getKey(x), listColor.get(cptColor));

            cptColor++;

        }

        piePlot.setForegroundAlpha(0.5f);
        piePlot.setLabelFont(new Font("Liberation Sans", Font.BOLD, 12));
        piePlot.setLabelOutlineStroke(null);
        piePlot.setLabelLinkStroke(new BasicStroke(0.4f));
        piePlot.setLabelBackgroundPaint(Color.WHITE);
        piePlot.setLabelLinkStyle(PieLabelLinkStyle.STANDARD);
        piePlot.setBackgroundAlpha(0);
        piePlot.setOutlineVisible(false);
        piePlot.setForegroundAlpha(1); // transparence
        piePlot.setInteriorGap(0); // le camembert occupe plus de place
        piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{1}"));
        piePlot.setStartAngle(70);
        piePlot.setCircular(true); // force pour avoir un cercle et pas un oval
        piePlot.setMaximumLabelWidth(0.20);
        piePlot.setBaseSectionOutlinePaint(Color.BLACK); // bordure du camembert

        return jfreeChart;

    }

    /**
     * permet de soit compléter le libellé pour éviter d'avoir 2 légendes sur la même ligne, soit de découper
     * le libellé s'il ne loge pas en longueur sur une seule ligne.
     *
     * @param chaine
     *            the chaine
     * @param longueur
     *            the longueur
     * @return the string
     */
    public static String genererLibellePourLegende(final String chaine, final int longueur) {

        final StringBuffer retour = new StringBuffer();

        if (chaine.length() <= longueur) {

            retour.append(StringUtils.rightPad(chaine, longueur, ' '));
        } else {

            retour.append(chaine);
            final int index = StringUtils.lastIndexOf(" ", chaine.substring(0, longueur));

            if (index > 0) {
                retour.replace(index, index + 1, "\r\n");
            }

        }

        return retour.toString();
    }
}
