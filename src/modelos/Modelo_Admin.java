/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import modelos.clases_bases.admin;
import org.postgresql.util.Base64;

/**
 *
 * @author Kevin
 */
public class Modelo_Admin extends admin{
    
    private static ConexionPG conexion = new ConexionPG();

    public Modelo_Admin(String usuario, String clave) {
        super(usuario, clave);
    }
    
     

    
    
}
