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
package fr.gouv.diplomatie.applitutoriel.ws.conf;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLSocketFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import fr.gouv.diplomatie.applitutoriel.ws.factory.WebServiceFactory;
import fr.gouv.diplomatie.applitutoriel.ws.hello.HelloService;
import fr.gouv.diplomatie.applitutoriel.ws.hello.IHelloService;

import hornet.framework.webservice.SSLSocketSpringFactory;
import hornet.framework.webservice.WsCallerHelper;

/**
 * Implementation pour l'envoi d'un mail de contact.
 *
 * @author MEAE - Ministère de l'Europe et des Affaires étrangères
 */
@Configuration
@PropertySource("classpath:webservices.properties")
public class WsConf {

    @Autowired
    private HelloService helloService;

    @Value("${applitutoriel.HelloService.endpoint}")
    private String endpoint;

    // parametres pour le KeyStore
    @Value("${applitutoriel.keyStore}")
    private File keyStore;

    @Value("${applitutoriel.keyStorePassword}")
    private String keyStorePassword;

    @Value("${applitutoriel.aliasCertificat}")
    private String certAlias;

    @Value("${applitutoriel.algoKeyStore}")
    private String algoKeyStore;

    @Value("${applitutoriel.typeKeyStore}")
    private String typeKeyStore;

    // parametres pour le trustStore
    @Value("${applitutoriel.trustStore}")
    private File trustStore;

    @Value("${applitutoriel.trustStorePassword}")
    private String trustStorePassword;

    @Value("${applitutoriel.typeTrustStore}")
    private String typeTrustStore;

    @Value("${applitutoriel.algoTrustStore}")
    private String algoTrustStore;

    @Bean
    @Scope("prototype")
    public IHelloService wsHelloService() {
        return helloService.getHelloServicePort();
    }

    @Bean
    public WsCallerHelper wsCallerHelper() {

        return new hornet.framework.webservice.WsCallerHelper();
    }

    @Bean
    public WebServiceFactory wsFactory() {

        return new fr.gouv.diplomatie.applitutoriel.ws.factory.WebServiceFactory(wsCallerHelper());
    }

    // Gestion Multipart pour uploader des fichiers
    // class="org.springframework.web.multipart.commons.CommonsMultipartResolver"
    @Bean
    public StandardServletMultipartResolver multipartResolver() {

        return new org.springframework.web.multipart.support.StandardServletMultipartResolver();
    }

    @Bean
    public SSLSocketSpringFactory sslSocketSpringFactory() {

        return new hornet.framework.webservice.SSLSocketSpringFactoryWithTrustStore(keyStore,
            keyStorePassword, certAlias, algoKeyStore, typeKeyStore, trustStore, trustStorePassword,
            typeTrustStore, algoTrustStore);
    }

    @Bean
    @Lazy
    public SSLSocketFactory sslSocketFactory() throws GeneralSecurityException, IOException {

        return sslSocketSpringFactory().getObject();
    }

    @SuppressWarnings("restriction")
    @Bean
    public Map<String, Object> wsHelloServiceContextMap() throws GeneralSecurityException, IOException {

        final Map<String, Object> m = new HashMap<>();
        m.put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
        m.put("com.sun.xml.internal.ws.transport.https.client.SSLSocketFactory", sslSocketFactory());

        return m;
    }
}
