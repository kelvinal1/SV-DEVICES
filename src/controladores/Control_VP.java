/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import vista.ventanas.Ventana_Principal;

/**
 *
 * @author Kevin
 */
public class Control_VP {
    
    Ventana_Principal vista ;

    public Control_VP() {
    }

    public Control_VP(Ventana_Principal vista) {
        this.vista = vista;
        vista.setVisible(true);
    }
    
}
