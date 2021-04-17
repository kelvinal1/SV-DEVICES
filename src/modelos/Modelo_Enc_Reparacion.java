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
import modelos.clases_bases.enc_reparacion;

/**
 *
 * @author Kevin
 */
public class Modelo_Enc_Reparacion extends enc_reparacion {

    private static ConexionPG conexion = new ConexionPG();

    public Modelo_Enc_Reparacion() {
    }

    public Modelo_Enc_Reparacion(String codigo_reparacion, int cod_cliente, int cod_admin, Date fecha_Emision, Date fecha_retiro, String estado, double descuento, Double subtotal, Double total) {
        super(codigo_reparacion, cod_cliente, cod_admin, fecha_Emision, fecha_retiro, estado, descuento, subtotal, total);
    }
    
    
    public static List<enc_reparacion> LISTAR(String inicial) {
        try {
            String sql = "select * from reparacionescreadas;";

            ResultSet rs = conexion.Query(sql);
            List<enc_reparacion> lista = new ArrayList<>();

            while (rs.next()) {
                enc_reparacion er = new enc_reparacion();
                er.setCodigo_reparacion(rs.getString(1));
                er.setCliente(rs.getString(2));
                er.setCod_cliente(rs.getInt(3));
                er.setVendedor(rs.getString(4));
                er.setCod_admin(rs.getInt(5));
                er.setFecha_Emision(rs.getDate(6));
                er.setFecha_retiro(rs.getDate(7));
                er.setEstado(rs.getString(8));
                er.setDescuento(rs.getDouble(9));
                er.setSubtotal(rs.getDouble(10));
                er.setTotal(rs.getDouble(11));
                
                lista.add(er);
            }

            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Enc_Reparacion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean CREAR() {
        String sql = "INSERT INTO public.enc_reparacion(cod_reparacion, cod_cliente, cod_admin, estado, \"fechaE\", \"fechaS\", descuento, subtotal, total)\n"
                + "VALUES ('" + getCodigo_reparacion() + "'," + getCod_cliente() + " ," + getCod_admin() + " ,'" + getEstado() + "','" + getFecha_Emision() + "','" + getFecha_retiro() + "'," + getDescuento() + " ," + getSubtotal() + " , " + getTotal() + ");";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--ENCABEZADO REPARACION CREADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean MODIFICAR() {
        String sql = "UPDATE public.enc_reparacion\n"
                + "SET  cod_cliente=" + getCliente() + ", cod_admin=" + getCod_admin() + ", estado='" + getEstado() + "', \"fechaE\"='" + getFecha_Emision() + "', \"fechaS\"='" + getFecha_retiro() + "', descuento=" + getDescuento() + ", subtotal=" + getSubtotal() + ", total=" + getTotal() + "  \n"
                + "WHERE cod_reparacion='" + getCodigo_reparacion() + "';";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--ENCABEZADO REPARACION MODIFICADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean ELIMINAR() {
        String sql = "DELETE FROM public.enc_reparacion\n"
                + "WHERE cod_reparacion='"+getCodigo_reparacion()+"'";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("--ENCABEZADO FACTURA ELIMINADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public String NuevoMant() {
        String codCompleto = "";
        try {

            String sql = "select cod_reparacion\n"
                    + "from enc_reparacion";
            String codigo = null;
            ResultSet rs = conexion.Query(sql);
            while (rs.next()) {
                codigo = rs.getString(1);
            }

            rs.close();
            if (codigo==null) {
                codCompleto = "mant1";
            }else{
                codCompleto = "mant" + (Integer.parseInt(codigo.substring(4)) + 1);
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Enc_Reparacion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Modelo_Enc_Reparacion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Modelo_Enc_Reparacion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Modelo_Enc_Reparacion.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

}
