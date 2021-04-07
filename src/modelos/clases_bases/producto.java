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
public class producto {
    private int codigo;
    private String nombre;
    private int codigo_fab;
    private String modelo;
    private String descrip;
    private Image foto;

    public producto() {
    }

    public producto(int codigo, String nombre, int codigo_fab, String modelo, String descrip, Image foto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigo_fab = codigo_fab;
        this.modelo = modelo;
        this.descrip = descrip;
        this.foto = foto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo_fab() {
        return codigo_fab;
    }

    public void setCodigo_fab(int codigo_fab) {
        this.codigo_fab = codigo_fab;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return  "\n\tPRODUCTO\n"+"codigo=" + codigo + ", nombre=" + nombre + ", codigo_fab=" + codigo_fab + ", modelo=" + modelo + ", descrip=" + descrip + ", foto=" + foto ;
    }
    
    
    
    
}
