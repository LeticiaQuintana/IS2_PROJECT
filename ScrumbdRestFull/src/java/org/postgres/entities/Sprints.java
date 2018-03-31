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
@Table(name = "sprints")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sprints.findAll", query = "SELECT s FROM Sprints s"),
    @NamedQuery(name = "Sprints.findByIdSprint", query = "SELECT s FROM Sprints s WHERE s.idSprint = :idSprint"),
    @NamedQuery(name = "Sprints.findByDuracion", query = "SELECT s FROM Sprints s WHERE s.duracion = :duracion"),
    @NamedQuery(name = "Sprints.findByEstado", query = "SELECT s FROM Sprints s WHERE s.estado = :estado"),
    @NamedQuery(name = "Sprints.findByTiempoTrabajado", query = "SELECT s FROM Sprints s WHERE s.tiempoTrabajado = :tiempoTrabajado")})
public class Sprints implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_sprint")
    private String idSprint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private BigInteger duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo_trabajado")
    private BigInteger tiempoTrabajado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprints")
    private Collection<Kanbans> kanbansCollection;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private Proyectos idProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSprint")
    private Collection<Userstories> userstoriesCollection;

    public Sprints() {
    }

    public Sprints(String idSprint) {
        this.idSprint = idSprint;
    }

    public Sprints(String idSprint, BigInteger duracion, String estado, BigInteger tiempoTrabajado) {
        this.idSprint = idSprint;
        this.duracion = duracion;
        this.estado = estado;
        this.tiempoTrabajado = tiempoTrabajado;
    }

    public String getIdSprint() {
        return idSprint;
    }

    public void setIdSprint(String idSprint) {
        this.idSprint = idSprint;
    }

    public BigInteger getDuracion() {
        return duracion;
    }

    public void setDuracion(BigInteger duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigInteger getTiempoTrabajado() {
        return tiempoTrabajado;
    }

    public void setTiempoTrabajado(BigInteger tiempoTrabajado) {
        this.tiempoTrabajado = tiempoTrabajado;
    }

    @XmlTransient
    public Collection<Kanbans> getKanbansCollection() {
        return kanbansCollection;
    }

    public void setKanbansCollection(Collection<Kanbans> kanbansCollection) {
        this.kanbansCollection = kanbansCollection;
    }

    public Proyectos getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyectos idProyecto) {
        this.idProyecto = idProyecto;
    }

    @XmlTransient
    public Collection<Userstories> getUserstoriesCollection() {
        return userstoriesCollection;
    }

    public void setUserstoriesCollection(Collection<Userstories> userstoriesCollection) {
        this.userstoriesCollection = userstoriesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSprint != null ? idSprint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sprints)) {
            return false;
        }
        Sprints other = (Sprints) object;
        if ((this.idSprint == null && other.idSprint != null) || (this.idSprint != null && !this.idSprint.equals(other.idSprint))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.postgres.entities.Sprints[ idSprint=" + idSprint + " ]";
    }
    
}
