/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import modelos.clases_bases.det_garantia;

/**
 *
 * @author Kevin
 */
public class Modelo_Det_Garantia extends det_garantia {

    private static ConexionPG conexion = new ConexionPG();

    public Modelo_Det_Garantia() {
    }

    public Modelo_Det_Garantia(String codigo_garantia, int cod_det_garantia, int cod_producto, String problema, String detalle) {
        super(codigo_garantia, cod_det_garantia, cod_producto, problema, detalle);
    }

    public boolean CREAR() {
        String sql = "INSERT INTO public.det_garantia(cod_garantia, cod_producto, problema, detalle)\n"
                + "VALUES ('" + getCodigo_garantia() + "', " + getCod_producto() + ", '" + getProblema() + "', '" + getDetalle() + "');";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("--DETALLE GARANTIA CREADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean MODIFICAR() {
        String sql = "UPDATE public.det_garantia\n"
                + "SET  problema='" + getProblema() + "', detalle='" + getDetalle() + "'\n"
                + "WHERE  cod_garantia='" + getCodigo_garantia() + "';";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--DETALLE GARANTIA MODIFICADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean ELIMINAR() {
        String sql = "DELETE FROM public.det_garantia\n"
                + "WHERE  cod_garantia='"+getCodigo_garantia()+"';";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("--DETALLE GARANTIA ELIMINADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

}
