/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.clases_bases.fabricante;

/**
 *
 * @author Kevin
 */
public class Modelo_Fabricante extends fabricante {

    private static ConexionPG conexion = new ConexionPG();

    public Modelo_Fabricante(int codigo, String nombre, String telefono, String direccion) {
        super(codigo, nombre, telefono, direccion);
    }

    public Modelo_Fabricante() {
    }

    public static List<fabricante> LISTAR(String inicial) {
        try {
            String sql = "select *"
                    + "\n from fabricante"
                    + "\n where upper(nombre) like upper('%" + inicial + "%')"
                    + "\n or where upper(telefono) like upper('%" + inicial + "%')"
                    + "\n or where upper(direccion) like upper('%" + inicial + "%');";
            ResultSet rs = conexion.Query(sql);

            List<fabricante> lista = new ArrayList<>();

            while (rs.next()) {
                fabricante f = new Modelo_Fabricante();
                f.setCodigo(rs.getInt(1));
                f.setNombre(rs.getString(2));
                f.setTelefono(rs.getString(3));
                f.setDireccion(rs.getString(4));
                lista.add(f);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Fabricante.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean CREAR() {
        String sql = "INSERT INTO public.fabricante(nombre, telefono, direccion)\n"
                + "VALUES ( '" + getNombre() + "', '" + getTelefono() + "', '" + getDireccion() + "');";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--FABRICANTE CREADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean MODIFICAR() {
        String sql = "UPDATE public.fabricante\n"
                + "SET  nombre='" + getNombre() + "', telefono='" + getTelefono() + "', direccion='" + getDireccion() + "'\n"
                + "WHERE cod_fabricante= " + getCodigo() + ";";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--FABRICANTE MODIFICADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean ELIMINAR() {
        String sql = "DELETE FROM public.fabricante\n"
                + "WHERE cod_fabricante="+getCodigo()+";";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--FABRICANTE ELIMINADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

}
