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
import modelos.clases_bases.enc_garantia;

/**
 *
 * @author Kevin
 */
public class Modelo_Enc_Garantia extends enc_garantia {

    private static ConexionPG conexion = new ConexionPG();

    public Modelo_Enc_Garantia() {
    }

    public Modelo_Enc_Garantia(String codigo_garantia, int cod_cliente, String cliente, String vendedor, int cod_admin, Date fecha_emision, Date fecha_retiro, String estado) {
        super(codigo_garantia, cod_cliente, cliente, vendedor, cod_admin, fecha_emision, fecha_retiro, estado);
    }

   

    public static List<enc_garantia> LISTAR(String inicial) {
        try {
            String sql = "select * from garantias "
                    + "\n where upper(cliente) like upper('%"+inicial+"%')"
                    + "\n or upper(vendedor) like upper('%"+inicial+"%')"
                    + "\n or upper(codigo) like upper('%"+inicial+"%')";

            ResultSet rs = conexion.Query(sql);
            List<enc_garantia> lista = new ArrayList<>();

            while (rs.next()) {
                enc_garantia eg = new enc_garantia(); 
                eg.setCodigo_garantia(rs.getString(1));
                eg.setCliente(rs.getString(2));
                eg.setCod_cliente(rs.getInt(3));
                eg.setVendedor(rs.getString(4));
                eg.setCod_admin(rs.getInt(5));
                eg.setFecha_emision(rs.getDate(6));
                eg.setFecha_retiro(rs.getDate(7));
                eg.setEstado(rs.getString(8));
                
                lista.add(eg);
            }

            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Enc_Garantia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public boolean CREAR() {
        String sql = "INSERT INTO public.enc_garantia(cod_garantia, cod_admin, cod_cliente, \"fechaE\", \"fechaS\", estado)\n"
                + "VALUES ('" + getCodigo_garantia() + "', " + getCod_admin() + "," + getCod_cliente() + " , '" + getFecha_emision() + "', '" + getFecha_retiro() + "', '" + getEstado() + "');";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("--ENCABEZADO GARANTIA CREADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean MODIFICAR() {
        String sql = "UPDATE public.enc_garantia\n"
                + "SET estado='" + getEstado() + "'\n"
                + "WHERE cod_garantia='" + getCodigo_garantia() + "' ;";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--ENCABEZADO GARANTIA MODIFICADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean ELIMINAR() {
        String sql = "DELETE FROM public.enc_garantia\n"
                + "WHERE cod_garantia='"+getCodigo_garantia()+"';";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("--ENCABEZADO GARANTIA ELIMINADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }
    
    public String NuevaRprc() {
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
            if (codigo==null) {
                codCompleto = "rprc1";
            }else{
                 codCompleto = "rprc" + (Integer.parseInt(codigo.substring(4)) + 1);
            }
           
           
            
                    
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Enc_Garantia.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Modelo_Enc_Garantia.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Modelo_Enc_Garantia.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Modelo_Enc_Garantia.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }
}
