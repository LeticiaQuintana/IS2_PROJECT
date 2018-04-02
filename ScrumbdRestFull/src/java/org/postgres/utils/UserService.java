/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.postgres.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgres.entities.Usuarios;

/**
 *
 * @author PC
 */
public class UserService {
    
    
	public static Connection getConnection() 
        {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/scrumbd","postgres", "ara");
			return con;
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
	}

        public Usuarios VerificarUsuario(String email) throws SQLException
        {
            Connection conexion = getConnection();
            Usuarios user = new Usuarios();
            Statement statement = conexion.createStatement();
            String consulta = "SELECT nombre, apellido, estado FROM Usuarios WHERE email ='"+email+"'";
            ResultSet result = statement.executeQuery(consulta);
            try
            {
                if (result.next()){
                    user.setNombre(result.getString(1));
                    user.setApellido(result.getString(2));
                    user.setEstado(result.getInt(3));
                }else{
                 return null;
                }
            } catch(Exception ex){

            }finally {
                try { result.close(); } catch (Exception e) { /* ignored */ }
                try { statement.close(); } catch (Exception e) { /* ignored */ }
                try { conexion.close(); } catch (Exception e) { /* ignored */ }
            }
            return user;
    }
}
