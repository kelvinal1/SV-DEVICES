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
import static modelos.Modelo_Cliente.obtenImagen;
import modelos.clases_bases.cliente;
import modelos.clases_bases.producto_v;
import org.postgresql.util.Base64;

/**
 *
 * @author Kevin
 */
public class Modelo_Producto_V extends producto_v {

    private static ConexionPG conexion = new ConexionPG();

    public Modelo_Producto_V() {
    }

    public Modelo_Producto_V(int codigo, String nombre, int codigo_fab, String modelo, String descrip, Image foto) {
        super(codigo, nombre, codigo_fab, modelo, descrip, foto);
    }

    public Modelo_Producto_V(double descuento, double precio, int cant_stock, int n_mes_garantia) {
        super(descuento, precio, cant_stock, n_mes_garantia);
    }

    public Modelo_Producto_V(double descuento, double precio, int cant_stock, int n_mes_garantia, int codigo, String nombre, int codigo_fab, String modelo, String descrip, Image foto) {
        super(descuento, precio, cant_stock, n_mes_garantia, codigo, nombre, codigo_fab, modelo, descrip, foto);
    }

    public static List<producto_v> LISTAR(String inicial) {

        try {
            String sql = "select p.cod_producto,p.nombre,p.cod_fab,p.modelo,p.descripcion,p.foto, pv.cod_producto_v,pv.descuento,pv.precio,pv.cant_stock,pv.meses_garantia\n"
                    + "from producto p, producto_v pv\n"
                    + "where p.cod_producto=pv.cod_producto and( "
                    + "\n p.cod_producto like '%" + inicial + "%'"
                    + "\n or upper(p.nombre) like upper('%" + inicial + "%')"
                    + "\n or upper(p.modelo) like upper('%" + inicial + "%')"
                    + "\n or upper(p.descripcion) like upper('%" + inicial + "%'))";
            ResultSet rs = conexion.Query(sql);
            List<producto_v> lista = new ArrayList<>();
            byte[] bf;
            while (rs.next()) {

                producto_v v1 = new producto_v();
                v1.setCodigo(rs.getInt(1));
                v1.setNombre(rs.getString(2));
                v1.setCodigo_fab(rs.getInt(3));
                v1.setModelo(rs.getString(4));
                v1.setDescrip(rs.getString(5));
                v1.setCodigo_p_v(rs.getInt(7));
                v1.setDescuento(rs.getDouble(8));
                v1.setPrecio(rs.getDouble(9));
                v1.setCant_stock(rs.getInt(10));
                v1.setN_mes_garantia(rs.getInt(11));
                

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

    public boolean CREAR(){

        String sql = "INSERT INTO public.producto_v(cod_producto, descuento, precio, cant_stock, meses_garantia)\n"
                + "VALUES (" + getCodigo() + "," + getDescuento() + "," + getPrecio() + "," + getCant_stock() + "," + getN_mes_garantia() + ");";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--PRODUCTO A VENDER CREADO" + this.toString());
            return true;
        } else {
            return false;
        }
    }
    
    public boolean CREAR_PV(Modelo_Producto p, Modelo_Producto_V a) {
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

        String sql = "UPDATE public.producto_v\n"
                + "SET  descuento=" + getDescuento() + ", precio=" + getPrecio() + ", cant_stock=" + getCant_stock() + ", meses_garantia=" + getN_mes_garantia() + "\n"
                + "WHERE cod_producto=" + getCodigo() + ";";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--PRODUCTO A VENDER MODIFICADO" + this.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean MODIFICAR_PV(Modelo_Producto p, Modelo_Producto_V a) {
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
        String sql = "DELETE FROM public.producto_v\n"
                + "WHERE cod_producto=" + getCodigo() + ";";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("--PRODUCTO ELIMINADO: " + this.toString());

            return true;
        } else {
            return false;
        }

    }
    
    public boolean ELIMINAR_PV(Modelo_Producto p, Modelo_Producto_V a){
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
