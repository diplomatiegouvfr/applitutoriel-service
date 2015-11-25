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
package fr.gouv.diplomatie.applitutoriel.integration.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.gouv.diplomatie.applitutoriel.business.bo.Utilisateur;

/**
 * Teste une implémentation de {@link UtilisateurDAO}.
 *
 * @author MAEDI
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-appContext-test.xml"})
public class UtilisateurDAOTest {

    /** <code>utilisateurDao</code> utilisateurDao */
    @Autowired
    private transient UtilisateurDAO utilisateurDao;

    /**
     * Test de la requete selectByLoginPassword de UtilisateurDao
     */
    @Test
    public void testSelectByLoginPasswordOK() {

        final Utilisateur utilisateur =
                    this.utilisateurDao.selectByLoginPassword("admin",
                        "d033e22ae348aeb5660fc2140aec35850c4da997");

        Assert.assertEquals(utilisateur.getLogin(), "admin");
    }

    /**
     * Test de la requete selectByLoginPassword de UtilisateurDao
     */
    @Test
    public void testSelectByLoginPasswordKO() {

        final Utilisateur utilisateur =
                    this.utilisateurDao.selectByLoginPassword("xxx",
                        "d033e22ae348aeb5660fc2140aec35850c4da997");

        Assert.assertNull(utilisateur);
    }

    /**
     * Test de la requete selectByLogin de UtilisateurDao
     */
    @Test
    public void testSelectByLogin() {

        final Utilisateur utilisateur = this.utilisateurDao.selectByLogin("admin");

        Assert.assertEquals(utilisateur.getLogin(), "admin");
    }

    /**
     * Test de la requete selectById de UtilisateurDao
     */
    @Test
    public void testSelectById() {

        final Utilisateur utilisateur = this.utilisateurDao.selectById(2L);

        Assert.assertEquals(utilisateur.getLogin(), "user");
    }
}
