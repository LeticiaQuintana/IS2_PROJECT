/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.postgres.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexis
 */
@Entity
@Table(name = "usuarios_proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosProyectos.findAll", query = "SELECT u FROM UsuariosProyectos u"),
    @NamedQuery(name = "UsuariosProyectos.findByIdUsuario", query = "SELECT u FROM UsuariosProyectos u WHERE u.usuariosProyectosPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuariosProyectos.findByIdProyecto", query = "SELECT u FROM UsuariosProyectos u WHERE u.usuariosProyectosPK.idProyecto = :idProyecto"),
    @NamedQuery(name = "UsuariosProyectos.findByRol", query = "SELECT u FROM UsuariosProyectos u WHERE u.rol = :rol")})
public class UsuariosProyectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariosProyectosPK usuariosProyectosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "rol")
    private String rol;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyectos proyectos;

    public UsuariosProyectos() {
    }

    public UsuariosProyectos(UsuariosProyectosPK usuariosProyectosPK) {
        this.usuariosProyectosPK = usuariosProyectosPK;
    }

    public UsuariosProyectos(UsuariosProyectosPK usuariosProyectosPK, String rol) {
        this.usuariosProyectosPK = usuariosProyectosPK;
        this.rol = rol;
    }

    public UsuariosProyectos(int idUsuario, String idProyecto) {
        this.usuariosProyectosPK = new UsuariosProyectosPK(idUsuario, idProyecto);
    }

    public UsuariosProyectosPK getUsuariosProyectosPK() {
        return usuariosProyectosPK;
    }

    public void setUsuariosProyectosPK(UsuariosProyectosPK usuariosProyectosPK) {
        this.usuariosProyectosPK = usuariosProyectosPK;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosProyectosPK != null ? usuariosProyectosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosProyectos)) {
            return false;
        }
        UsuariosProyectos other = (UsuariosProyectos) object;
        if ((this.usuariosProyectosPK == null && other.usuariosProyectosPK != null) || (this.usuariosProyectosPK != null && !this.usuariosProyectosPK.equals(other.usuariosProyectosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.postgres.entities.UsuariosProyectos[ usuariosProyectosPK=" + usuariosProyectosPK + " ]";
    }
    
}
