/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.postgres.entities.service;

import java.sql.SQLException;
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
import javax.ws.rs.QueryParam;
import org.postgres.utils.UserService;
import org.postgres.entities.Usuarios;
import org.postgres.utils.CustomResponse;

/**
 *
 * @author alexis
 */
@Stateless
@Path("org.postgres.entities.usuarios")
public class UsuariosFacadeREST extends AbstractFacade<Usuarios> {
    @PersistenceContext(unitName = "ScrumdbRestPU")
    private EntityManager em;
    UserService serviceUser = new UserService();

    public UsuariosFacadeREST() {
        super(Usuarios.class);
    }
    
    /*@POST
    @Path("/login")
    @Consumes({"application/xml", "application/json"})
    public Usuarios login(Usuarios entity) {
        Usuarios user = new Usuarios();
      
        return null;
  
    }*/
    
    /*@POST
    @Path("/verificar-usuario")
    public Response login(@QueryParam("email") String email) throws SQLException{
        CustomResponse respuesta = new CustomResponse();
        
        respuesta.setRespuesta(serviceUser.VerificarUsuario(email));
        return Response.ok(respuesta).build();
        
    }*/
    @GET
    @Path("/verificar-usuario")
    @Produces({"application/json"})
    public Usuarios login(@QueryParam("email") String email) throws SQLException{
    
           Usuarios usuario = new Usuarios();
           usuario = serviceUser.VerificarUsuario(email);
           return usuario;

    }
    
    /*
    
    @POST
    @Path("/verificar-usuario")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Usuarios login(Usuarios user) throws SQLException{
        CustomResponse respuesta = new CustomResponse();
        
        Usuarios usuario = new Usuarios();
        usuario = serviceUser.VerificarUsuario(user.getEmail());
        return usuario;
    }
    */

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Usuarios entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Usuarios entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Usuarios find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Usuarios> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Usuarios> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
