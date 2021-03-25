/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.*;

import java.sql.*;

/**
 *
 * @author Kevin
 */
public class ConexionPG {

    private String url = "jdbc:postgresql://localhost:5433/SV-DEVICES";
    private String usuario = "postgres";
    private String clave = "1234";
    private Connection con;

    public ConexionPG() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con=DriverManager.getConnection(url, usuario, clave);
            System.out.println("BASE ENLAZADA");
                    
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet Query(String slq) {
        try {
            Statement st;
            st = con.createStatement();
            return st.executeQuery(slq);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    
    public SQLException NoQuery(String sql){
        
        try {
            Statement st;
            st=con.createStatement();
            st.execute(sql);
            return null;
        } catch (SQLException ex) {
            
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return ex;
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    
}

