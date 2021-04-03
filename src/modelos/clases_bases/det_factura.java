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
public class det_factura {
    
    
    private String codigo_factura;
    private int cod_detalle_fact;
    private int cod_producto;
    private int cantidad;
    private double subtotal;

    public det_factura() {
    }

    public det_factura(String codigo_factura, int cod_detalle_fact, int cod_producto, int cantidad, double subtotal) {
        this.codigo_factura = codigo_factura;
        this.cod_detalle_fact = cod_detalle_fact;
        this.cod_producto = cod_producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public String getCodigo_factura() {
        return codigo_factura;
    }

    public void setCodigo_factura(String codigo_factura) {
        this.codigo_factura = codigo_factura;
    }

    public int getCod_detalle_fact() {
        return cod_detalle_fact;
    }

    public void setCod_detalle_fact(int cod_detalle_fact) {
        this.cod_detalle_fact = cod_detalle_fact;
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
        return "\n\tdet_factura\n" + "codigo_factura=" + codigo_factura + ", cod_detalle_fact=" + cod_detalle_fact + ", cod_producto=" + cod_producto + ", cantidad=" + cantidad + ", subtotal=" + subtotal ;
    }
    
    
    
}
