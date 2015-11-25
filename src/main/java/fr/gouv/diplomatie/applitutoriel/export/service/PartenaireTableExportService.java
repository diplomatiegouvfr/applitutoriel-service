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
package fr.gouv.diplomatie.applitutoriel.export.service;

import hornet.framework.export.vo.presentation.ColVO;
import hornet.framework.export.vo.presentation.RowVO;
import hornet.framework.export.vo.presentation.TableVO;
import hornet.framework.export.vo.utils.TableVOUtils;
import hornet.framework.web.service.export.AbstractTableExportService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import fr.gouv.diplomatie.applitutoriel.business.bo.Partenaire;
import fr.gouv.diplomatie.applitutoriel.web.dto.partenaire.TablePartenaire;

/**
 * @author Hornet
 * @since 1.0 - 3 mars 2015
 *
 *        Service d'export de {@link TablePartenaire} pour les formats XLS et CSV
 */
@Service
public class PartenaireTableExportService extends AbstractTableExportService<TablePartenaire> {

    private static final Logger LOG = LoggerFactory.getLogger(PartenaireTableExportService.class);

    /**
     * Indique que ce service gère les Table de <Partenaire> : <TablePartenaire>
     */
    @Override
    public Class<TablePartenaire> getSupportedClass() {

        return TablePartenaire.class;
    }

    /**
     * Construit un vo table pour l'export a partir d'une liste de partenaires
     *
     * Utilisé par l'export XLS et CSV
     *
     * @param listePartenaires
     *            Liste de partenaires
     * @return TableVO contenant les donnees de la liste de partenaires
     */
    @Override
    protected TableVO construireTableauExport(final TablePartenaire tablePartenaires) {

        final List<Partenaire> listePartenaires = tablePartenaires.getListe();

        final TableVO table = new TableVO();
        table.setNbColumns(6);

        table.setDate(new Date());
        final List<RowVO> lignes = new ArrayList<RowVO>();
        table.setRows(lignes);
        // Titre des colonnes
        final List<String> titles = new ArrayList<String>();
        titles.add("Nom");
        titles.add("Prénom");
        titles.add("Courriel");
        titles.add("Organisme");
        titles.add("VIP");
        titles.add("Date Modification");

        table.setColumnsTitles(titles);

        if (listePartenaires != null) {
            final Iterator<Partenaire> it = listePartenaires.iterator();

            RowVO row;
            List<ColVO> cols;
            while (it.hasNext()) {
                final Partenaire partenaire = it.next();

                row = new RowVO();
                cols = new ArrayList<ColVO>();

                final ColVO colNom = new ColVO();
                colNom.setValue(partenaire.getNom());
                final ColVO colPrenom = new ColVO();
                colPrenom.setValue(partenaire.getPrenom());
                final ColVO colCouriel = new ColVO();
                colCouriel.setValue(partenaire.getProCourriel());
                final ColVO colOrg = new ColVO();
                colOrg.setValue(partenaire.getOrganisme());
                final ColVO colVIP = new ColVO();
                colVIP.setFormat(TableVOUtils.FORMAT_BOOLEEN);
                colVIP.setValue(partenaire.getIsVIP());
                final ColVO colDateModif = new ColVO();
                colDateModif.setFormat(TableVOUtils.FORMAT_DATE);
                colDateModif.setValue(partenaire.getDateModif());

                cols.add(colNom);
                cols.add(colPrenom);
                cols.add(colCouriel);
                cols.add(colOrg);
                cols.add(colVIP);
                cols.add(colDateModif);
                row.setCols(cols);

                table.getRows().add(row);
            }
        }

        return table;
    }

}
