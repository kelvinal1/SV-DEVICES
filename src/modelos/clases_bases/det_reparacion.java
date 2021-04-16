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
    private String problema;
    private String nombre;
    private String detalle;
    private int cod_producto;
    private double subtotal;
    private String producto;
    private double costo;
    public det_reparacion() {
    }

    public det_reparacion(String codigo_reparacion, int codigo_det_reparacion, int cod_producto, double subtotal) {
        this.codigo_reparacion = codigo_reparacion;
        this.codigo_det_reparacion = codigo_det_reparacion;
        this.cod_producto = cod_producto;
        this.subtotal = subtotal;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
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

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

   

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "\n\tdet_reparacion\n" + "codigo_reparacion=" + codigo_reparacion + ", codigo_det_reparacion=" + codigo_det_reparacion + ", cod_producto=" + cod_producto + ", subtotal=" + subtotal ;
    }

    
    
    
    
}
