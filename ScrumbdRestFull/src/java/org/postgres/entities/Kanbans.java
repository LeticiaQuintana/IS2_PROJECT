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
@Table(name = "kanbans")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kanbans.findAll", query = "SELECT k FROM Kanbans k"),
    @NamedQuery(name = "Kanbans.findByIdKanban", query = "SELECT k FROM Kanbans k WHERE k.kanbansPK.idKanban = :idKanban"),
    @NamedQuery(name = "Kanbans.findByIdSprint", query = "SELECT k FROM Kanbans k WHERE k.kanbansPK.idSprint = :idSprint"),
    @NamedQuery(name = "Kanbans.findByEstado", query = "SELECT k FROM Kanbans k WHERE k.estado = :estado"),
    @NamedQuery(name = "Kanbans.findByNombreFase", query = "SELECT k FROM Kanbans k WHERE k.nombreFase = :nombreFase")})
public class Kanbans implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KanbansPK kanbansPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_fase")
    private String nombreFase;
    @JoinColumn(name = "id_sprint", referencedColumnName = "id_sprint", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sprints sprints;

    public Kanbans() {
    }

    public Kanbans(KanbansPK kanbansPK) {
        this.kanbansPK = kanbansPK;
    }

    public Kanbans(KanbansPK kanbansPK, String estado, String nombreFase) {
        this.kanbansPK = kanbansPK;
        this.estado = estado;
        this.nombreFase = nombreFase;
    }

    public Kanbans(String idKanban, String idSprint) {
        this.kanbansPK = new KanbansPK(idKanban, idSprint);
    }

    public KanbansPK getKanbansPK() {
        return kanbansPK;
    }

    public void setKanbansPK(KanbansPK kanbansPK) {
        this.kanbansPK = kanbansPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreFase() {
        return nombreFase;
    }

    public void setNombreFase(String nombreFase) {
        this.nombreFase = nombreFase;
    }

    public Sprints getSprints() {
        return sprints;
    }

    public void setSprints(Sprints sprints) {
        this.sprints = sprints;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kanbansPK != null ? kanbansPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kanbans)) {
            return false;
        }
        Kanbans other = (Kanbans) object;
        if ((this.kanbansPK == null && other.kanbansPK != null) || (this.kanbansPK != null && !this.kanbansPK.equals(other.kanbansPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.postgres.entities.Kanbans[ kanbansPK=" + kanbansPK + " ]";
    }
    
}
