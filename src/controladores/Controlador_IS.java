/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.Image;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelos.Modelo_Admin;
import modelos.Modelo_IS;
import modelos.Modelo_Persona;
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
        vista.getBtnGuardar().addActionListener(l->CrearAdmin());
        vista.getBtnBuscar().addActionListener(l->AnadirImagen());
        
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
            Control_VP c= new Control_VP(v1);
        }else{
            JOptionPane.showMessageDialog(null, "DATOS INCORRECTOS","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void CrearAdmin(){
        
        
        String cedula= vista.getTxtCedula().getText();
        String nombres= vista.getTxtNombres().getText();
        String apellidos= vista.getTxtApellidos1().getText();
        
        Instant instante = vista.getDtcFecha().getDate().toInstant();
        ZoneId zi = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instante, zi);
        java.sql.Date fechaN = java.sql.Date.valueOf(zdt.toLocalDate());
        
        String sexo= vista.getCmbSexo().getSelectedItem().toString();
        String telf= vista.getTxtTelf().getText();
        String correo= vista.getTxtCorreo().getText();
        String direc= vista.getTxtDirec().getText();
        ImageIcon ic = (ImageIcon)vista.getLblFoto().getIcon();
        
        
        
        String usuario= vista.getTxtUsuari().getText();
        String clave = vista.getTxtContra().getText();
        
                
        
        Modelo_Persona p = new Modelo_Persona(cedula, nombres, apellidos, fechaN, sexo, telf, correo, direc, ic.getImage());
        Modelo_Admin a = new Modelo_Admin(usuario, clave,cedula);
        
        
        if (modelo.CREAR_A(p, a)) {
            JOptionPane.showMessageDialog(null,"EL ADMIN SE CREO");
        }
               
    }
    
    
    private void AnadirImagen(){
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.JPG", "jpg","png","jpeg");
        jfc.setFileFilter(filtro);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado= jfc.showOpenDialog(null);
        if (estado==JFileChooser.APPROVE_OPTION) {
            try {
                Image icon = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(vista.getLblImagen().getWidth(),
                        vista.getLblImagen().getHeight(), Image.SCALE_SMOOTH);
                Icon ic = new ImageIcon(icon);
                vista.getLblFoto().setIcon(ic);
                vista.getLblFoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(Controlador_IS.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
        }
    }
   
    
    
    

    
    
    
    
    
}
