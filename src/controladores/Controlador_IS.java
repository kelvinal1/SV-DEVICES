/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.swing.JOptionPane;
import modelos.Modelo_IS;
import vista.ventanas.Inicio_Sesion;
import vista.ventanas.Ventana_Principal;

/**
 *
 * @author Kevin
 */
public class Controlador_IS  {
    private Inicio_Sesion vista ;
    private Modelo_IS modelo;

    public Controlador_IS(Inicio_Sesion vista) {
        this.vista = vista;
        vista.setVisible(true);
    }

   
    
    public void IniciarControl(){   
        vista.getBtnNuevo().addActionListener(l->RegistrarNuevo());
        vista.getBtnCancelar().addActionListener(l->Cancelar());
        vista.getBtnIniciar().addActionListener(l->IniciarSesion());
        
    }
    
    
    private void RegistrarNuevo(){
        vista.getDlgNuevo().setSize(680,600);
        vista.getDlgNuevo().setVisible(true);
    }
    
    private void Cancelar(){
        vista.getDlgNuevo().setVisible(false);
    }
    
    private void IniciarSesion(){
        modelo = new Modelo_IS(vista.getTxtUsuario().getText(),vista.getTxtClave().getText());
        if (modelo.IniciarSesion()) {
            vista.setVisible(false);
            Ventana_Principal v1 = new Ventana_Principal();
            v1.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "DATOS INCORRECTOS");
        }
    }
    
   
    
    
    

    
    
    
    
    
}
