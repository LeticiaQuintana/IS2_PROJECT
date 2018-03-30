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
import org.postgres.entities.Kanbans;
import org.postgres.entities.KanbansPK;

/**
 *
 * @author alexis
 */
@Stateless
@Path("org.postgres.entities.kanbans")
public class KanbansFacadeREST extends AbstractFacade<Kanbans> {
    @PersistenceContext(unitName = "ScrumdbRestPU")
    private EntityManager em;

    private KanbansPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idKanban=idKanbanValue;idSprint=idSprintValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        org.postgres.entities.KanbansPK key = new org.postgres.entities.KanbansPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idKanban = map.get("idKanban");
        if (idKanban != null && !idKanban.isEmpty()) {
            key.setIdKanban(idKanban.get(0));
        }
        java.util.List<String> idSprint = map.get("idSprint");
        if (idSprint != null && !idSprint.isEmpty()) {
            key.setIdSprint(idSprint.get(0));
        }
        return key;
    }

    public KanbansFacadeREST() {
        super(Kanbans.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Kanbans entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, Kanbans entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        org.postgres.entities.KanbansPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Kanbans find(@PathParam("id") PathSegment id) {
        org.postgres.entities.KanbansPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Kanbans> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Kanbans> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
