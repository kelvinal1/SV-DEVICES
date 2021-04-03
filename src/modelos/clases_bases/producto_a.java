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
public class producto_a extends producto{
    
    
    private int cantidad;
    private String problema, detalle;
    private double costo;

    public producto_a() {
    }

    public producto_a(int codigo, String nombre, int codigo_fab, String modelo, String descrip, Image foto) {
        super(codigo, nombre, codigo_fab, modelo, descrip, foto);
    }

    public producto_a(int cantidad, String problema, String detalle, double costo) {
        this.cantidad = cantidad;
        this.problema = problema;
        this.detalle = detalle;
        this.costo = costo;
    }

    public producto_a(int cantidad, String problema, String detalle, double costo, int codigo, String nombre, int codigo_fab, String modelo, String descrip, Image foto) {
        super(codigo, nombre, codigo_fab, modelo, descrip, foto);
        this.cantidad = cantidad;
        this.problema = problema;
        this.detalle = detalle;
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "\n\tproducto_a\n" +super.toString()+ "cantidad=" + cantidad + ", problema=" + problema + ", detalle=" + detalle + ", costo=" + costo ;
    }
    
    
}
