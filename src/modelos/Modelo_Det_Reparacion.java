/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import modelos.clases_bases.det_reparacion;

/**
 *
 * @author Kevin
 */
public class Modelo_Det_Reparacion extends det_reparacion {

    private static ConexionPG conexion = new ConexionPG();

    public Modelo_Det_Reparacion() {
    }

    public Modelo_Det_Reparacion(String codigo_reparacion, int codigo_det_reparacion, int cod_producto, double subtotal) {
        super(codigo_reparacion, codigo_det_reparacion, cod_producto, subtotal);
    }

    public boolean CREAR() {
        String sql = "INSERT INTO public.det_reparacion(cod_reparacion, cod_producto, subtotal)\n"
                + "VALUES ('" + getCodigo_reparacion() + "', " + getCod_producto() + ", " + getSubtotal() + ");";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("--DETALLE REPARACION CREADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean MODIFICAR() {
        String sql = "UPDATE public.det_reparacion\n"
                + "SET  cod_producto="+getCod_producto()+", subtotal="+getSubtotal()+" \n"
                + "WHERE cod_reparacion='"+getCodigo_reparacion()+"';";

        if (conexion.NoQuery(sql) == null) {
            System.out.println("--DETALLE REPARACION MODIFICADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }
    
    public boolean ELIMINAR(    ) {
        String sql = "DELETE FROM public.det_reparacion\n"
                + "WHERE cod_reparacion='"+getCodigo_reparacion()+"';";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("--DETALLE REPARACION ELIMINADO"
                    + super.toString());
            return true;
        } else {
            return false;
        }
    }

}
