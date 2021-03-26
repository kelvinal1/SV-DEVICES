/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.swing.JOptionPane;
import modelos.Modelo_Admin;
import vista.ventanas.Inicio_Sesion;
import vista.ventanas.Ventana_Admins;
import vista.ventanas.Ventana_Clientes;
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
        vista.getSmMantCliente().addActionListener(l->VentanaClientes());
        vista.getBtnClientes().addActionListener(l->VentanaClientes());
        vista.getSmMantAdmin().addActionListener(l->VentanaAdmins());
        vista.getBtnAdmins().addActionListener(l->VentanaAdmins());

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
    
    public void VentanaClientes(){
        
        Ventana_Clientes v = new Ventana_Clientes();
        v.setVisible(true);
        this.vista.getDpVentana().add(v);
        
    }
    
    
    public void VentanaAdmins(){
        Ventana_Admins v = new Ventana_Admins();
        Modelo_Admin m = new Modelo_Admin();
        Control_Administrador c = new Control_Administrador(m, v);
        c.Iniciar_Control();
        this.vista.getDpVentana().add(v);
    }

    
    
    
}
