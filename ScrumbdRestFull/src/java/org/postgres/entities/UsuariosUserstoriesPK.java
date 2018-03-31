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
public class UsuariosUserstoriesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_user_story")
    private String idUserStory;

    public UsuariosUserstoriesPK() {
    }

    public UsuariosUserstoriesPK(int idUsuario, String idUserStory) {
        this.idUsuario = idUsuario;
        this.idUserStory = idUserStory;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdUserStory() {
        return idUserStory;
    }

    public void setIdUserStory(String idUserStory) {
        this.idUserStory = idUserStory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (idUserStory != null ? idUserStory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosUserstoriesPK)) {
            return false;
        }
        UsuariosUserstoriesPK other = (UsuariosUserstoriesPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if ((this.idUserStory == null && other.idUserStory != null) || (this.idUserStory != null && !this.idUserStory.equals(other.idUserStory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.postgres.entities.UsuariosUserstoriesPK[ idUsuario=" + idUsuario + ", idUserStory=" + idUserStory + " ]";
    }
    
}
