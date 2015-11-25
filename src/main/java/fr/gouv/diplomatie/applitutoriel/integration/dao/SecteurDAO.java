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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;

import fr.gouv.diplomatie.applitutoriel.business.bo.Secteur;
import fr.gouv.diplomatie.applitutoriel.business.bo.Utilisateur;

/**
 * Classe DAO pour les entités Secteur
 *
 * @author MAEDI
 */
public class SecteurDAO extends SqlSessionDaoSupport {

    /**
     * Constructeur
     */
    public SecteurDAO() {

        super();
    }

    /**
     * retrieveDataList
     *
     * @return List < Secteur >
     */
    @Cacheable(cacheName = "secteurcache")
    public List<Secteur> retrieveDataList() {

        return this.getSqlSession().selectList("secteur.select");
    }

    /**
     * @param id
     *            Long
     * @return Secteur secteur
     */
    public Secteur selectById(final Long id) {

        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", id.toString());
        return (Secteur) this.getSqlSession().selectOne("secteur.selectById", params);
    }

    /**
     * @param id
     *            Long
     * @param auteur
     *            Utilisateur
     * @return Secteur secteur
     */
    public Secteur selectByIdAndAuteur(final Long id, final Utilisateur auteur) {

        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", id.toString());
        params.put("auteur", auteur.getLogin());
        return (Secteur) this.getSqlSession().selectOne("secteur.selectByIdAndAuteur", params);
    }

    /**
     * @param secteur
     *            Secteur
     * @return Secteur secteur
     */
    @TriggersRemove(cacheName = "secteurcache", removeAll = true)
    public Secteur ajouterSecteur(final Secteur secteur) {

        secteur.setId(new Long(this.getSqlSession().insert("secteur.insert", secteur)));
        return secteur;
    }

    /**
     * @param secteur
     *            Secteur
     * @return Secteur secteur
     */
    @TriggersRemove(cacheName = "secteurcache", removeAll = true)
    public Secteur modifierSecteur(final Secteur secteur) {

        this.getSqlSession().update("secteur.update", secteur);
        return secteur;
    }

    /**
     * Liste des secteurs avec le nom et la description. Exclue le secteur avec l'identifiant donné, si
     * défini.
     *
     * @param nom
     *            String
     * @param description
     *            String
     * @param id
     *            Long
     * @return List <Secteur>
     */
    public List<Secteur> selectByNomAndDesc(final String nom, final String description, final Long id) {

        final Map<String, String> params = new HashMap<String, String>();
        if (id != null) {
            params.put("id", id.toString());
        }
        params.put("nom", nom);
        params.put("desc", description);

        return this.getSqlSession().selectList("secteur.selectByNomAndDescExceptForId", params);
    }
}
