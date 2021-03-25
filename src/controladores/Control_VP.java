/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.swing.JOptionPane;
import vista.ventanas.Inicio_Sesion;
import vista.ventanas.Ventana_Principal;

/**
 *
 * @author Kevin
 */
public class Control_VP {

    Ventana_Principal vista;

    public Control_VP() {
    }

    public Control_VP(Ventana_Principal vista) {
        this.vista = vista;
        vista.setVisible(true);
    }

    public void Iniciar_Control() {
        vista.getBtnSalir().addActionListener(l->CerrarSesion());

    }

    public void CerrarSesion() {
        
        int op = JOptionPane.showConfirmDialog(null, "Seguro que desea finalizar sesion?");
        if (op == 0) {
            vista.setVisible(false);
            Inicio_Sesion vent = new Inicio_Sesion();
            Controlador_IS con = new Controlador_IS(vent);
            con.IniciarControl();
        }
    }

}
