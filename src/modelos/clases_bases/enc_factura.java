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
public class enc_factura {
    
    private String codigo_fact;
    private int cod_cliente;
    private int cod_administrador;
    private Date fechaEmision;
    private double descuento;
    private Double subtotal;
    private Double total_iva;
    private Double total;

    public enc_factura() {
    }

    public enc_factura(String codigo_fact, int cod_cliente, int cod_administrador, Date fechaEmision, double descuento, Double subtotal, Double total_iva, Double total) {
        this.codigo_fact = codigo_fact;
        this.cod_cliente = cod_cliente;
        this.cod_administrador = cod_administrador;
        this.fechaEmision = fechaEmision;
        this.descuento = descuento;
        this.subtotal = subtotal;
        this.total_iva = total_iva;
        this.total = total;
    }

    public String getCodigo_fact() {
        return codigo_fact;
    }

    public void setCodigo_fact(String codigo_fact) {
        this.codigo_fact = codigo_fact;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_administrador() {
        return cod_administrador;
    }

    public void setCod_administrador(int cod_administrador) {
        this.cod_administrador = cod_administrador;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
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

    public Double getTotal_iva() {
        return total_iva;
    }

    public void setTotal_iva(Double total_iva) {
        this.total_iva = total_iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "\n\tenc_factura\t" + "codigo_fact=" + codigo_fact + ", cod_cliente=" + cod_cliente + ", cod_administrador=" + cod_administrador + ", fechaEmision=" + fechaEmision + ", descuento=" + descuento + ", subtotal=" + subtotal + ", total_iva=" + total_iva + ", total=" + total;
    }
    
    
    
 
    
}
