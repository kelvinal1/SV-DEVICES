/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.clases_bases;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author Kevin
 */
public class cliente extends persona{
    private int descuent,cod_cliente;
    private String cedulafk;
    

    public cliente() {
    }

    public cliente(String cedula, String nombres, String apellidos, Date fecha_n, String sexo, String telef, String correo, String direc, Image foto) {
        super(cedula, nombres, apellidos, fecha_n, sexo, telef, correo, direc, foto);
    }

    public cliente(int descuent,int cod_cliente) {
        this.descuent = descuent;
        this.cod_cliente=cod_cliente;
    }

    public int getDescuent() {
        return descuent;
    }

    public void setDescuent(int descuent) {
        this.descuent = descuent;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getCedulafk() {
        return cedulafk;
    }

    public void setCedulafk(String cedulafk) {
        this.cedulafk = cedulafk;
    }

    @Override
    public String toString() {
        return "\n\tCLIENTE  "+super.toString()+"\ncod_cliente="+cod_cliente+"\ndescuent=" + descuent+"\ncedulafk="+cedulafk ;
    }
    
}
