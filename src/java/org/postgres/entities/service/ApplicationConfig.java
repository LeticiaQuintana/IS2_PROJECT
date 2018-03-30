/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.postgres.entities.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author alexis
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.postgres.entities.service.KanbansFacadeREST.class);
        resources.add(org.postgres.entities.service.ProyectosFacadeREST.class);
        resources.add(org.postgres.entities.service.SprintsFacadeREST.class);
        resources.add(org.postgres.entities.service.UserstoriesFacadeREST.class);
        resources.add(org.postgres.entities.service.UsuariosFacadeREST.class);
        resources.add(org.postgres.entities.service.UsuariosProyectosFacadeREST.class);
        resources.add(org.postgres.entities.service.UsuariosUserstoriesFacadeREST.class);
    }
    
}
