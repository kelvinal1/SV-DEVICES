/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv_devices;

import controladores.Controlador_IS;
import modelos.ConexionPG;
import modelos.Modelo_IS;
import vista.ventanas.Inicio_Sesion;

/**
 *
 * @author Kevin
 */
public class sv_devices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Inicio_Sesion vent= new Inicio_Sesion();
        Controlador_IS con = new Controlador_IS(vent);
        con.IniciarControl();
    }
    
}
