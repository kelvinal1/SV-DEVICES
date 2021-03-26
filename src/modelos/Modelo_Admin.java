/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
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

    public Modelo_Admin(String usuario, String clave, String cedulafk) {
        super(usuario, clave, cedulafk);
    }

    public static List<admin> LISTAR(String inicial) {

        try {
            String sql = "select "
                    + "\n p.cedula, p.nombres, p.apellidos, p.fecha_nac, p.sexo, p.telefono, p.correo , p.direc, p.foto, a.cod_admin, a.usuario, a.clave"
                    + "\n from admin a, persona p"
                    + "\n where p.cedula=a.cedula and( "
                    + "\n p.cedula like '%" + inicial + "%'"
                    + "\n or upper(p.nombres) like upper('%" + inicial + "%')"
                    + "\n or upper(p.apellidos) like upper('%" + inicial + "%')"
                    + "\n or upper(p.telefono) like upper('%" + inicial + "%')"
                    + "\n or upper(p.correo) like upper('%" + inicial + "%'))";
            ResultSet rs = conexion.Query(sql);
            List<admin> lista = new ArrayList<>();
            byte[] bf;
            while (rs.next()) {

                admin a1 = new admin();
                
                a1.setCedula(rs.getString(1));
                a1.setNombres(rs.getString(2));
                a1.setApellidos(rs.getString(3));
                a1.setFecha_n(rs.getDate(4));
                a1.setSexo(rs.getString(5));
                a1.setTelef(rs.getString(6));
                a1.setCorreo(rs.getString(7));
                a1.setDirec(rs.getString(8));
                a1.setCod_admin(rs.getInt(10));
                a1.setUsuario(rs.getString(11));
                a1.setClave(rs.getString(12));
                
                bf = rs.getBytes("foto");

                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        a1.setFoto(obtenImagen(bf));
                    } catch (IOException ex) {
                        a1.setFoto(null);
                        Logger.getLogger(Modelo_Admin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    a1.setFoto(null);
                }

                lista.add(a1);
            }
            rs.close();
            System.out.println(lista.toString());
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Admin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }



    public boolean CREAR() {
        
        String sql = "INSERT INTO public.admin(usuario, clave, cedula)\n"
                + "VALUES ('"+getUsuario()+"','"+getClave()+"','"+getCedulafk()+"');";

        if (conexion.NoQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean CREAR_A(Modelo_Persona p,Modelo_Admin a){
        if (p.CREAR()) {
            if (a.CREAR()) {
                return true;
            }else{
                p.ELIMINAR();
                System.out.println("Se elimino :"+p.toString());
                return false;           
            }
        }else{
            return false;
        }
    }
    
    public static Image obtenImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) it.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0, param);
    }

}
