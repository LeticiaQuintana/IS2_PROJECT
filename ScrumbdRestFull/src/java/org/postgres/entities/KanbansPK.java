/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.postgres.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alexis
 */
@Embeddable
public class KanbansPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_kanban")
    private String idKanban;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_sprint")
    private String idSprint;

    public KanbansPK() {
    }

    public KanbansPK(String idKanban, String idSprint) {
        this.idKanban = idKanban;
        this.idSprint = idSprint;
    }

    public String getIdKanban() {
        return idKanban;
    }

    public void setIdKanban(String idKanban) {
        this.idKanban = idKanban;
    }

    public String getIdSprint() {
        return idSprint;
    }

    public void setIdSprint(String idSprint) {
        this.idSprint = idSprint;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKanban != null ? idKanban.hashCode() : 0);
        hash += (idSprint != null ? idSprint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KanbansPK)) {
            return false;
        }
        KanbansPK other = (KanbansPK) object;
        if ((this.idKanban == null && other.idKanban != null) || (this.idKanban != null && !this.idKanban.equals(other.idKanban))) {
            return false;
        }
        if ((this.idSprint == null && other.idSprint != null) || (this.idSprint != null && !this.idSprint.equals(other.idSprint))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.postgres.entities.KanbansPK[ idKanban=" + idKanban + ", idSprint=" + idSprint + " ]";
    }
    
}
