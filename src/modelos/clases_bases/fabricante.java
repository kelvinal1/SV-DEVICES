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
public class fabricante {
    
    private int codigo;
    private String nombre, telefono, direccion;

    public fabricante() {
    }

    public fabricante(int codigo, String nombre, String telefono, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "\n\tFABRICANTE\n" + "codigo=" + codigo + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion ;
    }
    
    
    
    
}
