/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.postgres.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexis
 */
@Entity
@Table(name = "proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p"),
    @NamedQuery(name = "Proyectos.findByIdProyecto", query = "SELECT p FROM Proyectos p WHERE p.idProyecto = :idProyecto"),
    @NamedQuery(name = "Proyectos.findByNombreProyecto", query = "SELECT p FROM Proyectos p WHERE p.nombreProyecto = :nombreProyecto"),
    @NamedQuery(name = "Proyectos.findByEstado", query = "SELECT p FROM Proyectos p WHERE p.estado = :estado"),
    @NamedQuery(name = "Proyectos.findByCodigo", query = "SELECT p FROM Proyectos p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Proyectos.findByFechaInicio", query = "SELECT p FROM Proyectos p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Proyectos.findByFechaFinEstimada", query = "SELECT p FROM Proyectos p WHERE p.fechaFinEstimada = :fechaFinEstimada"),
    @NamedQuery(name = "Proyectos.findByAnho", query = "SELECT p FROM Proyectos p WHERE p.anho = :anho")})
public class Proyectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_proyecto")
    private String idProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_proyecto")
    private String nombreProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private BigInteger codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin_estimada")
    @Temporal(TemporalType.DATE)
    private Date fechaFinEstimada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anho")
    private BigInteger anho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private Collection<Sprints> sprintsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectos")
    private Collection<UsuariosProyectos> usuariosProyectosCollection;

    public Proyectos() {
    }

    public Proyectos(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Proyectos(String idProyecto, String nombreProyecto, String estado, BigInteger codigo, Date fechaInicio, Date fechaFinEstimada, BigInteger anho) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.estado = estado;
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFinEstimada = fechaFinEstimada;
        this.anho = anho;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigInteger getCodigo() {
        return codigo;
    }

    public void setCodigo(BigInteger codigo) {
        this.codigo = codigo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinEstimada() {
        return fechaFinEstimada;
    }

    public void setFechaFinEstimada(Date fechaFinEstimada) {
        this.fechaFinEstimada = fechaFinEstimada;
    }

    public BigInteger getAnho() {
        return anho;
    }

    public void setAnho(BigInteger anho) {
        this.anho = anho;
    }

    @XmlTransient
    public Collection<Sprints> getSprintsCollection() {
        return sprintsCollection;
    }

    public void setSprintsCollection(Collection<Sprints> sprintsCollection) {
        this.sprintsCollection = sprintsCollection;
    }

    @XmlTransient
    public Collection<UsuariosProyectos> getUsuariosProyectosCollection() {
        return usuariosProyectosCollection;
    }

    public void setUsuariosProyectosCollection(Collection<UsuariosProyectos> usuariosProyectosCollection) {
        this.usuariosProyectosCollection = usuariosProyectosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.postgres.entities.Proyectos[ idProyecto=" + idProyecto + " ]";
    }
    
}
