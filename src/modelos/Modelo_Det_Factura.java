/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import modelos.clases_bases.det_factura;

/**
 *
 * @author Kevin
 */
public class Modelo_Det_Factura extends det_factura {

    private static ConexionPG conexion = new ConexionPG();

    public Modelo_Det_Factura() {
    }

    public Modelo_Det_Factura(String codigo_factura, int cod_detalle_fact, int cod_producto, int cantidad, double subtotal) {
        super(codigo_factura, cod_detalle_fact, cod_producto, cantidad, subtotal);
    }

    public boolean CREAR() {
        String sql = "INSERT INTO public.det_factura( cod_enc_fact, cod_producto, cantidad, subtotal)\n"
                + "VALUES ('" + getCodigo_factura() + "'," + getCod_producto() + " ," + getCantidad() + " ," + getSubtotal() + ");";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--DETALLE FACTURA CREADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean MODIFICAR() {
        String sql = "UPDATE public.det_factura\n"
                + "SET  cod_producto=" + getCod_producto() + ", cantidad=" + getCantidad() + ", subtotal=" + getSubtotal() + "\n"
                + "WHERE cod_enc_fact='" + getCodigo_factura() + "';";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--ENCABEZADO FACTURA MODIFICADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean ELIMINAR() {
        String sql = "DELETE FROM public.det_factura\n"
                + "WHERE cod_enc_fact='"+getCodigo_factura()+"';";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("--FABRICANTE ELIMINADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }
}
