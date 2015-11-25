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
package fr.gouv.diplomatie.applitutoriel.web.conf;

import hornet.framework.web.conf.HornetWebConfig;
import hornet.framework.web.converter.CsvHttpMessageConverter;
import hornet.framework.web.converter.HornetMediaType;
import hornet.framework.web.converter.PdfHttpMessageConverter;
import hornet.framework.web.converter.XlsHttpMessageConverter;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Hornet
 * @since 1.0 - 2 mars 2015
 */
@Configuration
@EnableWebMvc
public class WebConfig extends HornetWebConfig {

    @Resource
    private XlsHttpMessageConverter<?> xlsConverter;

    @Resource
    private CsvHttpMessageConverter<?> csvConverter;

    @Resource
    private PdfHttpMessageConverter<?> pdfConverter;

    @Override
    public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {

        super.configureContentNegotiation(configurer);

        // Ajouter ici les mimeTypes des contenus gérés par l'appli
        configurer.mediaType("pdf", HornetMediaType.APPLICATION_PDF)
                    .mediaType("xls", HornetMediaType.APPLICATION_EXCEL)
                    .mediaType("csv", HornetMediaType.TEXT_CSV);

    }

    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {

        super.configureMessageConverters(converters);

        // Ajouter ici les converter permettant de gérer les différents types de contenus
        converters.add(xlsConverter);
        converters.add(csvConverter);
        converters.add(pdfConverter);

    }

}
