/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.Image;
import java.io.ByteArrayInputStream;
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
import static modelos.Modelo_Admin.obtenImagen;
import modelos.clases_bases.admin;
import modelos.clases_bases.cliente;
import org.postgresql.util.Base64;

/**
 *
 * @author Kevin
 */
public class Modelo_Cliente extends cliente {

    private static ConexionPG conexion = new ConexionPG();

    public Modelo_Cliente() {
    }

    public Modelo_Cliente(String cedula, String nombres, String apellidos, Date fecha_n, String sexo, String telef, String correo, String direc, Image foto) {
        super(cedula, nombres, apellidos, fecha_n, sexo, telef, correo, direc, foto);
    }

    public Modelo_Cliente(int descuento, int cod_cliente) {
        super(descuento, cod_cliente);

    }

    public static List<cliente> LISTAR(String inicial) {

        try {
            String sql = "select "
                    + "\n p.cedula, p.nombres, p.apellidos, p.fecha_nac, p.sexo, p.telefono, p.correo , p.direc, p.foto, c.cod_cliente, c.descuento"
                    + "\n from cliente c, persona p"
                    + "\n where p.cedula=c.cedula and( "
                    + "\n p.cedula like '%" + inicial + "%'"
                    + "\n or upper(p.nombres) like upper('%" + inicial + "%')"
                    + "\n or upper(p.apellidos) like upper('%" + inicial + "%')"
                    + "\n or upper(p.telefono) like upper('%" + inicial + "%')"
                    + "\n or upper(p.correo) like upper('%" + inicial + "%'))";
            ResultSet rs = conexion.Query(sql);
            List<cliente> lista = new ArrayList<>();
            byte[] bf;
            while (rs.next()) {

                cliente a1 = new cliente();

                a1.setCedula(rs.getString(1));
                a1.setNombres(rs.getString(2));
                a1.setApellidos(rs.getString(3));
                a1.setFecha_n(rs.getDate(4));
                a1.setSexo(rs.getString(5));
                a1.setTelef(rs.getString(6));
                a1.setCorreo(rs.getString(7));
                a1.setDirec(rs.getString(8));
                a1.setCod_cliente(rs.getInt(10));
                a1.setDescuent(rs.getInt(11));

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
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Admin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean BuscarCedula() {
        boolean verifcar = false;
        String sql = "select cedula "
                + "\n from cliente "
                + "\n where cedula='" + getCedula() + "';";
        ResultSet rs = conexion.Query(sql);
        try {
            while (rs.next()) {
                verifcar = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return verifcar;

    }

    public boolean CREAR() {

        String sql = "INSERT INTO public.cliente(descuento, cedula)\n"
                + "VALUES (" + getDescuent() + ",'" + getCedulafk() + "');";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("\t Se creo cliente: " + this.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean MODIFICAR() {

        String sql = "UPDATE public.cliente\n"
                + "SET descuento=" + getDescuent() + "\n"
                + "WHERE cedula='" + getCedulafk() + "';";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("\t Se modifico cliente: " + this.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean CREAR_C(Modelo_Persona p, Modelo_Cliente a) {
        if (p.CREAR()) {
            if (a.CREAR()) {
                System.out.println("--SE CREO PERSONA"
                        + p.toString() + "\n"
                        + "--SE CREO CLIENTE"
                        + a.toString());
                return true;
            } else {
                p.ELIMINAR();
                System.out.println("Se elimino :" + p.toString());
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean MODIFICAR_C(Modelo_Persona p, Modelo_Cliente a) {
        if (p.MODIFICAR()) {
            if (a.MODIFICAR()) {
                System.out.println("--SE MODIFICO PERSONA"
                        + p.toString() + "\n"
                        + "--SE MODIFICO ADMIN"
                        + a.toString());
                return true;
            } else {

                System.out.println("NO SE MODIFICO :" + p.toString());
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean ELIMINAR_C(Modelo_Persona p, Modelo_Cliente a) {
        if (a.ELIMINAR()) {
            if (p.ELIMINAR()) {
                return true;
            } else {
                System.out.println("NO SE ELIMINO PERSONA: " + p.ELIMINAR());
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean ELIMINAR() {
        String sql = "DELETE FROM public.cliente\n"
                + "WHERE cedula='" + getCedulafk() + "';";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("\t Se elimino cliente: " + this.toString());
            return true;
        } else {
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

    public List<cliente> VistaClientes(String aguja) {

        try {
            String sql = "select * "
                    + "\n from Clientes"
                    + "\n where upper(cliente) like upper('%" + aguja + "%')"
                    + "\n or upper(cedula) like upper('%" + aguja + "%')"
                    + "\n or upper(telefono) like upper('%" + aguja + "%');";            
            
            ResultSet rs = conexion.Query(sql);
            List<cliente> lista = new ArrayList<>();
            while (rs.next()) {
                cliente c1 = new cliente();
                c1.setCliente(rs.getString(1));
                c1.setDirec(rs.getString(2));
                c1.setCedula(rs.getString(3));
                c1.setTelef(rs.getString(4));
                c1.setDescuent(rs.getInt(5));
                
                lista.add(c1);
                
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
