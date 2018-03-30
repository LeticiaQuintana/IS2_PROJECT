/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.postgres.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexis
 */
@Entity
@Table(name = "userstories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userstories.findAll", query = "SELECT u FROM Userstories u"),
    @NamedQuery(name = "Userstories.findByIdUserStory", query = "SELECT u FROM Userstories u WHERE u.idUserStory = :idUserStory"),
    @NamedQuery(name = "Userstories.findByDuracion", query = "SELECT u FROM Userstories u WHERE u.duracion = :duracion"),
    @NamedQuery(name = "Userstories.findByNombreCorto", query = "SELECT u FROM Userstories u WHERE u.nombreCorto = :nombreCorto"),
    @NamedQuery(name = "Userstories.findByNombreLargo", query = "SELECT u FROM Userstories u WHERE u.nombreLargo = :nombreLargo"),
    @NamedQuery(name = "Userstories.findByValorDelNegocio", query = "SELECT u FROM Userstories u WHERE u.valorDelNegocio = :valorDelNegocio"),
    @NamedQuery(name = "Userstories.findByValorTecnico", query = "SELECT u FROM Userstories u WHERE u.valorTecnico = :valorTecnico"),
    @NamedQuery(name = "Userstories.findByDescripcion", query = "SELECT u FROM Userstories u WHERE u.descripcion = :descripcion"),
    @NamedQuery(name = "Userstories.findByTiempoDeTrabajo", query = "SELECT u FROM Userstories u WHERE u.tiempoDeTrabajo = :tiempoDeTrabajo"),
    @NamedQuery(name = "Userstories.findByEstado", query = "SELECT u FROM Userstories u WHERE u.estado = :estado"),
    @NamedQuery(name = "Userstories.findByPrioridad", query = "SELECT u FROM Userstories u WHERE u.prioridad = :prioridad")})
public class Userstories implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_user_story")
    private String idUserStory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private BigInteger duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_corto")
    private String nombreCorto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_largo")
    private String nombreLargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_del_negocio")
    private BigInteger valorDelNegocio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_tecnico")
    private BigInteger valorTecnico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo_de_trabajo")
    private BigInteger tiempoDeTrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "prioridad")
    private String prioridad;
    @JoinColumn(name = "id_sprint", referencedColumnName = "id_sprint")
    @ManyToOne(optional = false)
    private Sprints idSprint;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userstories")
    private Collection<UsuariosUserstories> usuariosUserstoriesCollection;

    public Userstories() {
    }

    public Userstories(String idUserStory) {
        this.idUserStory = idUserStory;
    }

    public Userstories(String idUserStory, BigInteger duracion, String nombreCorto, String nombreLargo, BigInteger valorDelNegocio, BigInteger valorTecnico, String descripcion, BigInteger tiempoDeTrabajo, String estado, String prioridad) {
        this.idUserStory = idUserStory;
        this.duracion = duracion;
        this.nombreCorto = nombreCorto;
        this.nombreLargo = nombreLargo;
        this.valorDelNegocio = valorDelNegocio;
        this.valorTecnico = valorTecnico;
        this.descripcion = descripcion;
        this.tiempoDeTrabajo = tiempoDeTrabajo;
        this.estado = estado;
        this.prioridad = prioridad;
    }

    public String getIdUserStory() {
        return idUserStory;
    }

    public void setIdUserStory(String idUserStory) {
        this.idUserStory = idUserStory;
    }

    public BigInteger getDuracion() {
        return duracion;
    }

    public void setDuracion(BigInteger duracion) {
        this.duracion = duracion;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getNombreLargo() {
        return nombreLargo;
    }

    public void setNombreLargo(String nombreLargo) {
        this.nombreLargo = nombreLargo;
    }

    public BigInteger getValorDelNegocio() {
        return valorDelNegocio;
    }

    public void setValorDelNegocio(BigInteger valorDelNegocio) {
        this.valorDelNegocio = valorDelNegocio;
    }

    public BigInteger getValorTecnico() {
        return valorTecnico;
    }

    public void setValorTecnico(BigInteger valorTecnico) {
        this.valorTecnico = valorTecnico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getTiempoDeTrabajo() {
        return tiempoDeTrabajo;
    }

    public void setTiempoDeTrabajo(BigInteger tiempoDeTrabajo) {
        this.tiempoDeTrabajo = tiempoDeTrabajo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Sprints getIdSprint() {
        return idSprint;
    }

    public void setIdSprint(Sprints idSprint) {
        this.idSprint = idSprint;
    }

    @XmlTransient
    public Collection<UsuariosUserstories> getUsuariosUserstoriesCollection() {
        return usuariosUserstoriesCollection;
    }

    public void setUsuariosUserstoriesCollection(Collection<UsuariosUserstories> usuariosUserstoriesCollection) {
        this.usuariosUserstoriesCollection = usuariosUserstoriesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserStory != null ? idUserStory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userstories)) {
            return false;
        }
        Userstories other = (Userstories) object;
        if ((this.idUserStory == null && other.idUserStory != null) || (this.idUserStory != null && !this.idUserStory.equals(other.idUserStory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.postgres.entities.Userstories[ idUserStory=" + idUserStory + " ]";
    }
    
}
