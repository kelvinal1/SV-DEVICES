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
public class enc_garantia {
    
    
    private String codigo_garantia;
    private int cod_cliente;
    private String cliente;
    private String vendedor;
    private int cod_admin;
    private Date fecha_emision;
    private Date fecha_retiro;
    private String estado;

    public enc_garantia() {
    }

    public enc_garantia(String codigo_garantia, int cod_cliente, String cliente, String vendedor, int cod_admin, Date fecha_emision, Date fecha_retiro, String estado) {
        this.codigo_garantia = codigo_garantia;
        this.cod_cliente = cod_cliente;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.cod_admin = cod_admin;
        this.fecha_emision = fecha_emision;
        this.fecha_retiro = fecha_retiro;
        this.estado = estado;
    }

    
    public String getCodigo_garantia() {
        return codigo_garantia;
    }

    public void setCodigo_garantia(String codigo_garantia) {
        this.codigo_garantia = codigo_garantia;
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

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
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

    @Override
    public String toString() {
        return "\n\ttenc_garantia\n" + "codigo_garantia=" + codigo_garantia + ", cod_cliente=" + cod_cliente + ", cod_admin=" + cod_admin + ", fecha_emision=" + fecha_emision + ", fecha_retiro=" + fecha_retiro + ", estado=" + estado ;
    }
    
    
    
    
    
    
}
