/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.clases_bases;

/**
 *
 * @author Kevin
 */
public class det_reparacion {
    
    
    private String codigo_reparacion;
    private int codigo_det_reparacion;
    private int cod_producto;
    private int cantidad;
    private double subtotal;

    public det_reparacion() {
    }

    public det_reparacion(String codigo_reparacion, int codigo_det_reparacion, int cod_producto, int cantidad, double subtotal) {
        this.codigo_reparacion = codigo_reparacion;
        this.codigo_det_reparacion = codigo_det_reparacion;
        this.cod_producto = cod_producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public String getCodigo_reparacion() {
        return codigo_reparacion;
    }

    public void setCodigo_reparacion(String codigo_reparacion) {
        this.codigo_reparacion = codigo_reparacion;
    }

    public int getCodigo_det_reparacion() {
        return codigo_det_reparacion;
    }

    public void setCodigo_det_reparacion(int codigo_det_reparacion) {
        this.codigo_det_reparacion = codigo_det_reparacion;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "\n\tdet_reparacion\n" + "codigo_reparacion=" + codigo_reparacion + ", codigo_det_reparacion=" + codigo_det_reparacion + ", cod_producto=" + cod_producto + ", cantidad=" + cantidad + ", subtotal=" + subtotal ;
    }
    
    
    
}