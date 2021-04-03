/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.clases_bases;

import java.util.Date;

/**
 *
 * @author Kevin
 */
public class enc_reparacion {
    
    
    private String codigo_reparacion;
    private int cod_cliente;
    private int cod_admin;
    private Date fecha_Emision;
    private Date fecha_retiro;
    private String estado;
    private double descuento;
    private Double subtotal;
    private Double total;

    public enc_reparacion() {
    }

    public enc_reparacion(String codigo_reparacion, int cod_cliente, int cod_admin, Date fecha_Emision, Date fecha_retiro, String estado, double descuento, Double subtotal, Double total) {
        this.codigo_reparacion = codigo_reparacion;
        this.cod_cliente = cod_cliente;
        this.cod_admin = cod_admin;
        this.fecha_Emision = fecha_Emision;
        this.fecha_retiro = fecha_retiro;
        this.estado = estado;
        this.descuento = descuento;
        this.subtotal = subtotal;
        this.total = total;
    }

    public String getCodigo_reparacion() {
        return codigo_reparacion;
    }

    public void setCodigo_reparacion(String codigo_reparacion) {
        this.codigo_reparacion = codigo_reparacion;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_admin() {
        return cod_admin;
    }

    public void setCod_admin(int cod_admin) {
        this.cod_admin = cod_admin;
    }

    public Date getFecha_Emision() {
        return fecha_Emision;
    }

    public void setFecha_Emision(Date fecha_Emision) {
        this.fecha_Emision = fecha_Emision;
    }

    public Date getFecha_retiro() {
        return fecha_retiro;
    }

    public void setFecha_retiro(Date fecha_retiro) {
        this.fecha_retiro = fecha_retiro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "\n\tenc_reparacion\n" + "codigo_reparacion=" + codigo_reparacion + ", cod_cliente=" + cod_cliente + ", cod_admin=" + cod_admin + ", fecha_Emision=" + fecha_Emision + ", fecha_retiro=" + fecha_retiro + ", estado=" + estado + ", descuento=" + descuento + ", subtotal=" + subtotal + ", total=" + total ;
    }
    
    
    
}
