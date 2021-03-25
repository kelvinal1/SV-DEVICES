/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import modelos.clases_bases.Inicio_sesion;
import org.postgresql.util.Base64;

/**
 *
 * @author Kevin
 */
public class Modelo_IS extends Inicio_sesion{
    
    private static ConexionPG conexion = new ConexionPG();

    public Modelo_IS() {
    }

    public Modelo_IS(String usuario, String clave) {
        super(usuario, clave);
    }
    
    public boolean IniciarSesion(){
         boolean verificar = false;
        try {
           
            
            String sql="select usuario, clave "
                    + "from admin "
                    + " where usuario='"+getUsuario()+"' and clave='"+getClave()+"';";
            
            ResultSet rs= conexion.Query(sql);
            if(rs.next()) {
                System.out.println("USUARIO: ||"+getUsuario()+"||  inicio sesion ");
                verificar=true;
            }
            
            
            return  verificar;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_IS.class.getName()).log(Level.SEVERE, null, ex);
            return verificar;
        }
    }
    
    public boolean CREAR_A(Modelo_Persona p,Modelo_Admin a){
        boolean a1 = p.CREAR();
        boolean a2= a.CREAR();
        if (a1) {
            if (a2) {
                return true;
            }else{
                return false;           
            }
        }else{
            return false;
        }
    }
    
    
    
    
    
    
    
}
