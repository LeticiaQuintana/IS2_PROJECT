/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.postgres.entities.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;
import org.postgres.entities.UsuariosProyectos;
import org.postgres.entities.UsuariosProyectosPK;

/**
 *
 * @author alexis
 */
@Stateless
@Path("org.postgres.entities.usuariosproyectos")
public class UsuariosProyectosFacadeREST extends AbstractFacade<UsuariosProyectos> {
    @PersistenceContext(unitName = "ScrumdbRestPU")
    private EntityManager em;

    private UsuariosProyectosPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idUsuario=idUsuarioValue;idProyecto=idProyectoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        org.postgres.entities.UsuariosProyectosPK key = new org.postgres.entities.UsuariosProyectosPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idUsuario = map.get("idUsuario");
        if (idUsuario != null && !idUsuario.isEmpty()) {
            key.setIdUsuario(new java.lang.Integer(idUsuario.get(0)));
        }
        java.util.List<String> idProyecto = map.get("idProyecto");
        if (idProyecto != null && !idProyecto.isEmpty()) {
            key.setIdProyecto(idProyecto.get(0));
        }
        return key;
    }

    public UsuariosProyectosFacadeREST() {
        super(UsuariosProyectos.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(UsuariosProyectos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, UsuariosProyectos entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        org.postgres.entities.UsuariosProyectosPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public UsuariosProyectos find(@PathParam("id") PathSegment id) {
        org.postgres.entities.UsuariosProyectosPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<UsuariosProyectos> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<UsuariosProyectos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
