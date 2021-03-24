/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.clases_bases;;

/**
 *
 * @author Kevin
 */
public class admin  extends persona{
    private String usuario, clave;

    public admin() {
        
    }

    public admin(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
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
        return "\tADMIN CREDAO \nDATOS\n"+super.toString() + "\nusuario=" + usuario + "\nclave=" + clave + '\n';
    }
    
    
    
}
