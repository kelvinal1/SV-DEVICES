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
            String sql = "SELECT f.cod_fact,f.cod_cliente, pc.nombres ||' '||pc.apellidos as \"cliente\", \n"
                    + "f.cod_admin,pa.nombres||' '||pa.apellidos as \"administrador\",\n"
                    + "f.fecha_emision, f.descuento, f.subtotal, f.total_iva, f.total\n"
                    + "FROM enc_factura f,  persona pc,  cliente c,  persona pa,  admin a \n"
                    + "where f.cod_cliente = c.cod_cliente and\n"
                    + "	c.cedula= pc.cedula and\n"
                    + "	f.cod_admin=a.cod_admin and\n"
                    + "	a.cedula=pa.cedula  and (\n"
                    + "		concat(upper(pc.nombres),upper(pc.apellidos)) like upper('%" + inicial + "%') and\n"
                    + "		concat(upper(pa.nombres),upper(pa.apellidos)) like upper('%" + inicial + "%') and\n"
                    + "		upper(f.cod_fact) like upper('%" + inicial + "%') );";

            ResultSet rs = conexion.Query(sql);
            List<enc_factura> lista = new ArrayList<>();

            while (rs.next()) {
                enc_factura ef = new enc_factura();
                ef.setCodigo_fact(rs.getString(1));
                ef.setCod_cliente(rs.getInt(2));
                ef.setCliente(rs.getString(3));
                ef.setCod_administrador(rs.getInt(4));
                ef.setAdministrador(rs.getString(5));
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
        String codCompleto="";
        try {
            
            String sql = "select cod_fact\n"
                    + "from enc_factura\n"
                    + "order by 1 asc";
            String codigo = null;
            ResultSet rs = conexion.Query(sql);
            while (rs.next()) {
                codigo=rs.getString(1);
            }
            
            codCompleto="fact"+(Integer.parseInt(codigo.substring(4))+1);
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Enc_Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return codCompleto;
    }
}
