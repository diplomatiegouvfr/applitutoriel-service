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
package fr.gouv.diplomatie.applitutoriel.business.bo;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Hornet
 * @since 1.0 - 7 avr. 2015
 */
public class Photo implements Serializable {

    /**
    *
    */
    private static final long serialVersionUID = 1L;

    /**
    *
    */
    private Long id;

    /**
     * Nom du fichier
     */
    private String nom;

    /**
     * Type mime
     */
    private String mimeType;

    /**
     * Encoding
     */
    private String encoding;

    /**
     * Taille du fichier
     */
    private Long size;

    /**
     * Contenu du fichier
     */
    @JsonSerialize(using = fr.gouv.diplomatie.applitutoriel.web.conf.ByteArraySerializer.class)
    private byte[] buffer;

    /**
     * Instantiates a new photo.
     */
    public Photo() {

        super();
    }

    /**
     * @return id
     */
    public Long getId() {

        return id;
    }

    /**
     * @param id
     *            id
     */
    public void setId(final Long id) {

        this.id = id;
    }

    /**
     * @return nom
     */
    public String getNom() {

        return nom;
    }

    /**
     * @param nom
     *            nom
     */
    public void setNom(final String nom) {

        this.nom = nom;
    }

    /**
     * @return mimeType
     */
    public String getMimeType() {

        return mimeType;
    }

    /**
     * @param mimeType
     *            mimeType
     */
    public void setMimeType(final String mimeType) {

        this.mimeType = mimeType;
    }

    /**
     * @return encoding
     */
    public String getEncoding() {

        return encoding;
    }

    /**
     * @param encoding
     *            encoding
     */
    public void setEncoding(final String encoding) {

        this.encoding = encoding;
    }

    /**
     * @return size
     */
    public Long getSize() {

        return size;
    }

    /**
     * @param size
     *            size
     */
    public void setSize(final Long size) {

        this.size = size;
    }

    /**
     * @return buffer
     */
    public byte[] getBuffer() {

        return buffer;
    }

    /**
     * @param buffer
     *            buffer
     */
    public void setBuffer(final byte[] buffer) {

        this.buffer = buffer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        final StringBuilder builder = new StringBuilder();
        builder.append("Photo [id=").append(id).append(", nom=").append(nom).append(", mimeType=")
                    .append(mimeType).append(", encoding=").append(encoding).append(", size=").append(size)
                    .append("]");
        return builder.toString();
    }

}
