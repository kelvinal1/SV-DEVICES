/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.clases_bases;;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author Kevin
 */
public class admin  extends persona{
    private String usuario, clave, cedulafk;
    private int cod_admin;
    public admin() {
    }

    public admin(String cedula, String nombres, String apellidos, Date fecha_n, String sexo, String telef, String correo, String direc, Image foto) {
        super(cedula, nombres, apellidos, fecha_n, sexo, telef, correo, direc, foto);
    }

    public admin(String usuario, String clave, String cedulafk) {
        this.usuario = usuario;
        this.clave = clave;
        this.cedulafk = cedulafk;
    }

    public String getCedulafk() {
        return cedulafk;
    }

    public void setCedulafk(String cedulafk) {
        this.cedulafk = cedulafk;
    }

    public int getCod_admin() {
        return cod_admin;
    }

    public void setCod_admin(int cod_admin) {
        this.cod_admin = cod_admin;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "\n\tADMIN CREDAO \nDATOS\n"+super.toString() + "\nusuario=" + usuario + "\nclave=" + clave+"\ncedulafk="+cedulafk +"\ncod_admin="+cod_admin;
        
    }
    
    
    
}
