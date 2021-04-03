/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.clases_bases;

import java.awt.Image;

/**
 *
 * @author Kevin
 */
public class producto_v extends producto{
    private int codigo_p_v;
    
    private double descuento,precio;
    private int cant_stock,n_mes_garantia;

    public producto_v() {
    }

    public producto_v(int codigo, String nombre, int codigo_fab, String modelo, String descrip, Image foto) {
        super(codigo, nombre, codigo_fab, modelo, descrip, foto);
    }

    public producto_v(double descuento, double precio, int cant_stock, int n_mes_garantia) {
        this.descuento = descuento;
        this.precio = precio;
        this.cant_stock = cant_stock;
        this.n_mes_garantia = n_mes_garantia;
    }

    public producto_v(double descuento, double precio, int cant_stock, int n_mes_garantia, int codigo, String nombre, int codigo_fab, String modelo, String descrip, Image foto) {
        super(codigo, nombre, codigo_fab, modelo, descrip, foto);
        this.descuento = descuento;
        this.precio = precio;
        this.cant_stock = cant_stock;
        this.n_mes_garantia = n_mes_garantia;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCant_stock() {
        return cant_stock;
    }

    public void setCant_stock(int cant_stock) {
        this.cant_stock = cant_stock;
    }

    public int getN_mes_garantia() {
        return n_mes_garantia;
    }

    public void setN_mes_garantia(int n_mes_garantia) {
        this.n_mes_garantia = n_mes_garantia;
    }

    public int getCodigo_p_v() {
        return codigo_p_v;
    }

    public void setCodigo_p_v(int codigo_p_v) {
        this.codigo_p_v = codigo_p_v;
    }

    @Override
    public String toString() {
        return "\n\tproducto_v\n" +super.toString()+ "descuento=" + descuento + ", precio=" + precio + ", cant_stock=" + cant_stock + ", n_mes_garantia=" + n_mes_garantia+", codigo_pv="+codigo_p_v ;
    }
    
    
    


    
    
    
    
}
