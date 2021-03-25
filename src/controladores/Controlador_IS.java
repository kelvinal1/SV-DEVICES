/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class Controlador_IS {

    private Inicio_Sesion vista;
    private Modelo_IS modelo;

    public Controlador_IS(Inicio_Sesion vista) {
        this.vista = vista;
        vista.setVisible(true);
    }

    public void IniciarControl() {
        KeyListener k1 = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                vista.getTxtUsuari().setText(vista.getTxtCorreo().getText());
            }
        };
        vista.getBtnNuevo().addActionListener(l -> RegistrarNuevo());
        vista.getBtnCancelar().addActionListener(l -> Cancelar());
        vista.getBtnIniciar().addActionListener(l -> IniciarSesion());
        vista.getBtnGuardar().addActionListener(l -> CrearAdmin());
        vista.getBtnBuscar().addActionListener(l -> AnadirImagen());
        vista.getTxtCorreo().addKeyListener(k1);

    }

    private void RegistrarNuevo() {
        vista.getDlgNuevo().setSize(680, 600);
        vista.getDlgNuevo().setVisible(true);
    }

    private void Cancelar() {
        vista.getDlgNuevo().setVisible(false);
    }

    private void IniciarSesion() {
        modelo = new Modelo_IS(vista.getTxtUsuario().getText(), vista.getTxtClave().getText());

        if (modelo.IniciarSesion()) {
            vista.setVisible(false);

            Ventana_Principal v1 = new Ventana_Principal();
            Control_VP c = new Control_VP(v1);
        } else {
            JOptionPane.showMessageDialog(null, "DATOS INCORRECTOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void CrearAdmin() {
        if (Validacion()) {
            String u = JOptionPane.showInputDialog("Ingrese usuario: ");
            String c = JOptionPane.showInputDialog("Ingrese clave: ");
            modelo = new Modelo_IS(u, c);
            if (modelo.IniciarSesion()) {
                String cedula = vista.getTxtCedula().getText();
                String nombres = vista.getTxtNombres().getText();
                String apellidos = vista.getTxtApellidos1().getText();

                Instant instante = vista.getDtcFecha().getDate().toInstant();
                ZoneId zi = ZoneId.of("America/Guayaquil");
                ZonedDateTime zdt = ZonedDateTime.ofInstant(instante, zi);
                java.sql.Date fechaN = java.sql.Date.valueOf(zdt.toLocalDate());

                String sexo = vista.getCmbSexo().getSelectedItem().toString();
                String telf = vista.getTxtTelf().getText();
                String correo = vista.getTxtCorreo().getText();
                String direc = vista.getTxtDirec().getText();
                ImageIcon ic = (ImageIcon) vista.getLblImagen().getIcon();

                Modelo_Persona p = new Modelo_Persona(cedula, nombres, apellidos, fechaN, sexo, telf, correo, direc, ic.getImage());
                if (p.CREAR()) {
                    String usuario = vista.getTxtUsuari().getText();
                    String clave = vista.getTxtContra().getText();
                    String c2 = vista.getTxtCedula().getText();
                    Modelo_Admin a = new Modelo_Admin(usuario, clave, c2);
                    if (a.CREAR()) {
                        JOptionPane.showMessageDialog(null, "CREADO");
                        limpiarCajas();
                        cedula = "";
                    } else {
                        System.out.println("no se creo admin");

                    }
                } else {
                    System.out.println("no se creo persona");
                }

            } else {
                JOptionPane.showMessageDialog(null, "NO SON DATOS CORRECTO PARA REGISRAR");
            }

        }

    }

    private void limpiarCajas() {
        vista.getTxtCedula().setText("");
        vista.getTxtNombres().setText("");
        vista.getTxtApellidos1().setText("");

        vista.getCmbSexo().setSelectedIndex(1);
        vista.getTxtTelf().setText("");
        vista.getTxtCorreo().setText("");
        vista.getTxtDirec().setText("");
        vista.getLblImagen().setIcon(null);
        vista.getDtcFecha().setDate(null);
        vista.getTxtUsuari().setText("");
        vista.getTxtContra().setText("");
        vista.getTxtContra2().setText("");
    }

    private void AnadirImagen() {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.JPG", "jpg", "png", "jpeg");
        jfc.setFileFilter(filtro);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
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

    public boolean Validacion() {
        boolean verificar = true;
        //////////////////////////////cedula
        if (vista.getTxtCedula().getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "NUMERO DE CARACTERES EN CEDULA EXCEDIDO", "Cedula Erronea", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtCedula().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "CEDULA VACIA", "Cedula Erronea", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ///////////////////////////////////////////////////////////////////nombres
        if (vista.getTxtNombres().getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "NUMERO DE CARACTERES EN NOMBRES EXCEDIDO", "Nombre Erroneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtNombres().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "NOMBRES VACIOS", "Nombre ErroneO", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        ////////////////////////////////////////////////////////////////////apellidos
        if (vista.getTxtNombres().getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "NUMERO DE CARACTERES EN APELLIDOS EXCEDIDO", "Apellido Erroneo", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        if (vista.getTxtNombres().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "APELLIDOS VACIOS", "Apellido ErroneO", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }

        return verificar;

    }

}
