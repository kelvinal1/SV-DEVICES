/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.clases_bases.enc_factura;

/**
 *
 * @author Kevin
 */
public class Modelo_Enc_Factura extends enc_factura {

    private static ConexionPG conexion = new ConexionPG();

    public Modelo_Enc_Factura() {
    }

    public Modelo_Enc_Factura(String codigo_fact, int cod_cliente, int cod_administrador, Date fechaEmision, double descuento, Double subtotal, Double total_iva, Double total) {
        super(codigo_fact, cod_cliente, cod_administrador, fechaEmision, descuento, subtotal, total_iva, total);
    }

    public static List<enc_factura> LISTAR(String inicial) {
        try {
            String sql = "select * from facturascreadas "
                    + "\n where upper(cliente) like upper('%"+inicial+"%')"
                    + "\n or upper(vendedor) like upper('%"+inicial+"%')"
                    + "\n or upper(codigofact) like upper('%"+inicial+"%')";

            ResultSet rs = conexion.Query(sql);
            List<enc_factura> lista = new ArrayList<>();

            while (rs.next()) {
                enc_factura ef = new enc_factura(); 
                ef.setCodigo_fact(rs.getString(1));
                ef.setCliente(rs.getString(2));
                ef.setAdministrador(rs.getString(4));
                ef.setFechaEmision(rs.getDate(6));
                ef.setDescuento(rs.getDouble(7));
                ef.setSubtotal(rs.getDouble(8));
                ef.setTotal_iva(rs.getDouble(9));
                ef.setTotal(rs.getDouble(10));
                lista.add(ef);
            }

            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Enc_Factura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean CREAR() {
        String sql = "INSERT INTO public.enc_factura(cod_fact, cod_cliente, cod_admin, fecha_emision, subtotal, total_iva, total, descuento)\n"
                + "VALUES ('" + getCodigo_fact() + "'," + getCod_cliente() + " ," + getCod_administrador() + ",'" + getFechaEmision() + "'," + getSubtotal() + " ," + getTotal_iva() + "," + getTotal() + "," + getDescuento() + ");";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--ENCABEZADO FACTURA CREADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean MODIFICAR() {
        String sql = "UPDATE public.enc_factura\n"
                + "SET cod_cliente=" + getCod_cliente() + ", cod_admin=" + getCod_administrador() + ", fecha_emision='" + getFechaEmision() + "', subtotal=" + getSubtotal() + ", total_iva=" + getTotal_iva() + ", total=" + getTotal() + ", descuento=" + getDescuento() + "\n"
                + "WHERE cod_fact='" + getCodigo_fact() + "';";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--ENCABEZADO FACTURA MODIFICADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean ELIMINAR() {
        String sql = "DELETE FROM public.enc_factura\n"
                + "WHERE cod_fact='" + getCodigo_fact() + "';";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("--ENCABEZADO FACTURA ELIMINADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public String NuevoFact() {
        String codCompleto = "";
        try {

            String sql = "select cod_fact\n"
                    + "from enc_factura";
            String codigo = null;
            ResultSet rs = conexion.Query(sql);
            while (rs.next()) {
                codigo = rs.getString(1);
            }
            
            rs.close();
            codCompleto = "fact" + (Integer.parseInt(codigo.substring(4)) + 1);
            
                    
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Enc_Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(codCompleto);
        return codCompleto;
    }

    public int Cliente(String cedula) {

        try {
            int codigo = 0;
            String sql = "select cod_cliente\n"
                    + "from cliente\n"
                    + "where cedula='" + cedula + "'";

            ResultSet rs = conexion.Query(sql);
            while (rs.next()) {
                codigo = rs.getInt(1);
            }
            rs.close();
            return codigo;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Enc_Factura.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    public String ColocarAdmin(String usuario) {

        try {
            String adminAsignado = "";
            String sql = "select p.nombres||' '||p.apellidos \n"
                    + "from admin a, persona p\n"
                    + "where p.cedula=a.cedula\n"
                    + "and a.usuario='"+usuario+"';";

            ResultSet rs = conexion.Query(sql);
            while (rs.next()) {
                adminAsignado = rs.getString(1);
            }
            rs.close();
            return adminAsignado;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Enc_Factura.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

    }

    public int Admin(String usuario) {

        try {
            int codigo = 0;
            String sql = "select cod_admin\n"
                    + "from admin\n"
                    + "where usuario='" + usuario + "'";

            ResultSet rs = conexion.Query(sql);
            while (rs.next()) {
                codigo = rs.getInt(1);
            }
            rs.close();
            return codigo;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Enc_Factura.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

}
