/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import modelos.clases_bases.admin;
import org.postgresql.util.Base64;

/**
 *
 * @author Kevin
 */
public class Modelo_Admin extends admin {

    private static ConexionPG conexion = new ConexionPG();
 

    public Modelo_Admin() {
    }

    public Modelo_Admin(String cedula, String nombres, String apellidos, Date fecha_n, String sexo, String telef, String correo, String direc, Image foto) {
        super(cedula, nombres, apellidos, fecha_n, sexo, telef, correo, direc, foto);
    }





    public boolean CREAR() {
        
        String sql = "INSERT INTO public.admin(usuario, clave, cedula)\n"
                + "VALUES ('"+getUsuario()+"','"+getClave()+"','"+getCedula()+"');";

        if (conexion.NoQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

}
