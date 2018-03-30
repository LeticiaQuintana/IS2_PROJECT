/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.postgres.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexis
 */
@Entity
@Table(name = "usuarios_userstories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosUserstories.findAll", query = "SELECT u FROM UsuariosUserstories u"),
    @NamedQuery(name = "UsuariosUserstories.findByIdUsuario", query = "SELECT u FROM UsuariosUserstories u WHERE u.usuariosUserstoriesPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuariosUserstories.findByIdUserStory", query = "SELECT u FROM UsuariosUserstories u WHERE u.usuariosUserstoriesPK.idUserStory = :idUserStory"),
    @NamedQuery(name = "UsuariosUserstories.findByDetalleCambio", query = "SELECT u FROM UsuariosUserstories u WHERE u.detalleCambio = :detalleCambio"),
    @NamedQuery(name = "UsuariosUserstories.findByFechaCambio", query = "SELECT u FROM UsuariosUserstories u WHERE u.fechaCambio = :fechaCambio"),
    @NamedQuery(name = "UsuariosUserstories.findByTiempoDeSesion", query = "SELECT u FROM UsuariosUserstories u WHERE u.tiempoDeSesion = :tiempoDeSesion")})
public class UsuariosUserstories implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariosUserstoriesPK usuariosUserstoriesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "detalle_cambio")
    private String detalleCambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cambio")
    @Temporal(TemporalType.DATE)
    private Date fechaCambio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tiempo_de_sesion")
    private String tiempoDeSesion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "id_user_story", referencedColumnName = "id_user_story", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Userstories userstories;

    public UsuariosUserstories() {
    }

    public UsuariosUserstories(UsuariosUserstoriesPK usuariosUserstoriesPK) {
        this.usuariosUserstoriesPK = usuariosUserstoriesPK;
    }

    public UsuariosUserstories(UsuariosUserstoriesPK usuariosUserstoriesPK, String detalleCambio, Date fechaCambio, String tiempoDeSesion) {
        this.usuariosUserstoriesPK = usuariosUserstoriesPK;
        this.detalleCambio = detalleCambio;
        this.fechaCambio = fechaCambio;
        this.tiempoDeSesion = tiempoDeSesion;
    }

    public UsuariosUserstories(int idUsuario, String idUserStory) {
        this.usuariosUserstoriesPK = new UsuariosUserstoriesPK(idUsuario, idUserStory);
    }

    public UsuariosUserstoriesPK getUsuariosUserstoriesPK() {
        return usuariosUserstoriesPK;
    }

    public void setUsuariosUserstoriesPK(UsuariosUserstoriesPK usuariosUserstoriesPK) {
        this.usuariosUserstoriesPK = usuariosUserstoriesPK;
    }

    public String getDetalleCambio() {
        return detalleCambio;
    }

    public void setDetalleCambio(String detalleCambio) {
        this.detalleCambio = detalleCambio;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public String getTiempoDeSesion() {
        return tiempoDeSesion;
    }

    public void setTiempoDeSesion(String tiempoDeSesion) {
        this.tiempoDeSesion = tiempoDeSesion;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Userstories getUserstories() {
        return userstories;
    }

    public void setUserstories(Userstories userstories) {
        this.userstories = userstories;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosUserstoriesPK != null ? usuariosUserstoriesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosUserstories)) {
            return false;
        }
        UsuariosUserstories other = (UsuariosUserstories) object;
        if ((this.usuariosUserstoriesPK == null && other.usuariosUserstoriesPK != null) || (this.usuariosUserstoriesPK != null && !this.usuariosUserstoriesPK.equals(other.usuariosUserstoriesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.postgres.entities.UsuariosUserstories[ usuariosUserstoriesPK=" + usuariosUserstoriesPK + " ]";
    }
    
}
