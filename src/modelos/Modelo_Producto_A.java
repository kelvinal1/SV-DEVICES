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
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import modelos.clases_bases.producto_a;
import org.postgresql.util.Base64;

/**
 *
 * @author Kevin
 */
public class Modelo_Producto_A extends producto_a {

    private static ConexionPG conexion = new ConexionPG();

    public Modelo_Producto_A() {
    }

    public Modelo_Producto_A(int codigo, String nombre, int codigo_fab, String modelo, String descrip, Image foto) {
        super(codigo, nombre, codigo_fab, modelo, descrip, foto);
    }

    public Modelo_Producto_A(int cantidad, String problema, String detalle, double costo) {
        super(cantidad, problema, detalle, costo);
    }

    public Modelo_Producto_A(int cantidad, String problema, String detalle, double costo, int codigo, String nombre, int codigo_fab, String modelo, String descrip, Image foto) {
        super(cantidad, problema, detalle, costo, codigo, nombre, codigo_fab, modelo, descrip, foto);
    }

    public static List<producto_a> LISTAR(String inicial) {

        try {
            String sql = "select p.cod_producto,p.nombre,p.cod_fab,p.modelo,p.descripcion,p.foto, pa.cod_producto_a,pa.cantidad,pa.problema,pa.detalle,pa.costo\n"
                    + "from producto p, producto_a pa\n"
                    + "where p.cod_producto=pv.cod_producto and( "
                    + "\n p.cod_producto like '%" + inicial + "%'"
                    + "\n or upper(p.nombre) like upper('%" + inicial + "%')"
                    + "\n or upper(p.modelo) like upper('%" + inicial + "%')"
                    + "\n or upper(p.descripcion) like upper('%" + inicial + "%'))";
            ResultSet rs = conexion.Query(sql);
            List<producto_a> lista = new ArrayList<>();
            byte[] bf;
            while (rs.next()) {

                producto_a v1 = new producto_a();
                v1.setCodigo(rs.getInt(1));
                v1.setNombre(rs.getString(2));
                v1.setCodigo_fab(rs.getInt(3));
                v1.setModelo(rs.getString(4));
                v1.setDescrip(rs.getString(5));
                v1.setCod_prod_a(rs.getInt(7));
                v1.setCantidad(rs.getInt(8));
                v1.setProblema(rs.getString(9));
                v1.setDetalle(rs.getString(10));
                v1.setCosto(rs.getDouble(11));

                bf = rs.getBytes("foto");

                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        v1.setFoto(obtenImagen(bf));
                    } catch (IOException ex) {
                        v1.setFoto(null);
                        Logger.getLogger(Modelo_Admin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    v1.setFoto(null);
                }

                lista.add(v1);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Admin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean CREAR() {

        String sql = "INSERT INTO public.producto_a( cantidad, problema, detalle, costo, cod_producto)\n"
                + "VALUES (" + getCantidad() + ",'" + getProblema() + "','" + getDetalle() + "'," + getCosto() + "," + getCodigo() + " );";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--PRODUCTO A REPARAR CREADO" + this.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean CREAR_PA(Modelo_Producto p, Modelo_Producto_A a) {
        if (p.CREAR()) {
            if (a.CREAR()) {
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

    public boolean MODIFICAR() {

        String sql = "UPDATE public.producto_a\n"
                + "SET  cantidad=" + getCantidad() + ", problema='" + getProblema() + "', detalle='" + getDetalle() + "', costo=" + getCosto() + "\n"
                + "WHERE cod_producto=" + getCodigo() + ";";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--PRODUCTO A REPARAR MODIFICADO" + this.toString());
            return true;
        } else {
            return false;
        }
    }
    
    public boolean MODIFICAR_PA(Modelo_Producto p, Modelo_Producto_A a) {
        if (p.MODIFICAR()) {
            if (a.MODIFICAR()) {
                return true;
            } else {

                System.out.println("NO SE MODIFICO :" + p.toString());
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean ELIMINAR() {
        String sql = "DELETE FROM public.producto_a\n"
                + "WHERE cod_producto=" + getCodigo() + ";";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("--PRODUCTO ELIMINADO: " + this.toString());

            return true;
        } else {
            return false;
        }

    }
    
    public boolean ELIMINAR_PA(Modelo_Producto p, Modelo_Producto_A a){
        if (a.ELIMINAR()) {
            if (p.ELIMINAR()) {
                return true;
            }else{
                System.out.println("NO SE ELIMINO : "+p.ELIMINAR());
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
