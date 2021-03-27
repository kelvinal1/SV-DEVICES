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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelos.Modelo_Admin;
import modelos.Modelo_Cliente;
import modelos.Modelo_Persona;
import modelos.clases_bases.admin;
import modelos.clases_bases.cliente;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vista.ventanas.Ventana_Clientes;

/**
 *
 * @author Kevin
 */
public class Controlador_Cliente {

    private Modelo_Cliente modelo;
    private Ventana_Clientes vista;

    public Controlador_Cliente() {
    }

    public Controlador_Cliente(Modelo_Cliente modelo, Ventana_Clientes vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    
    public void Iniciar_Control() {
        
        KeyListener k2 = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                CargarLista(vista.getTxtBuscar().getText());
            }
        };

        vista.getBtnGuardar().addActionListener(l -> CrearAdmin());
        vista.getBtnCancelar().addActionListener(l -> Dialogo_A_C_M(3));
        vista.getBtnNuevoC().addActionListener(l -> Dialogo_A_C_M(1));
        vista.getBtnEditarC().addActionListener(l -> CargarCamposTextos());
        vista.getBtnBuscar().addActionListener(l -> AnadirImagen());
        vista.getBtnActualizar().addActionListener(l -> CargarLista(""));
        vista.getTxtBuscar().addKeyListener(k2);
        vista.getBtnModificar().addActionListener(l->ModificarCliente());
        vista.getBtnEliminarC().addActionListener(l->EliminarCliente());

    }
    
    private void CargarLista(String aguja) {

        vista.getTblCliente().setDefaultRenderer(Object.class, new ImagenTable());
        vista.getTblCliente().setRowHeight(100);
        DefaultTableCellRenderer render = new DefaultTableCellHeaderRenderer();

        DefaultTableModel tablaA;

        tablaA = (DefaultTableModel) vista.getTblCliente().getModel();
        tablaA.setNumRows(0);
        List<cliente> lista = modelo.LISTAR(aguja);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(t -> {
            tablaA.addRow(new Object[ncols]);
            vista.getTblCliente().setValueAt(t.getCedula(), i.value, 0);
            vista.getTblCliente().setValueAt(t.getNombres(), i.value, 1);
            vista.getTblCliente().setValueAt(t.getApellidos(), i.value, 2);
            vista.getTblCliente().setValueAt(t.getFecha_n(), i.value, 3);
            vista.getTblCliente().setValueAt(t.getSexo(), i.value, 4);
            vista.getTblCliente().setValueAt(t.getTelef(), i.value, 5);
            vista.getTblCliente().setValueAt(t.getCorreo(), i.value, 6);
            vista.getTblCliente().setValueAt(t.getDirec(), i.value, 7);
            vista.getTblCliente().setValueAt(t.getDescuent(), i.value, 8);

            Image img = t.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                render.setIcon(icon);
                vista.getTblCliente().setValueAt(new JLabel(icon), i.value, 9);
            } else {
                vista.getTblCliente().setValueAt(null, i.value, 9);
            }

            i.value++;

        });
        vista.getjLabel3().setText("" + vista.getTblCliente().getRowCount());
    }

    private void CrearAdmin() {
        if (Validacion()) {

            String cedula = vista.getTxtCedula().getText();
            String nombres = vista.getTxtNombres().getText();
            String apellidos = vista.getTxtApellido().getText();

            Instant instante = vista.getDtcFecha().getDate().toInstant();
            ZoneId zi = ZoneId.of("America/Guayaquil");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instante, zi);
            java.sql.Date fechaN = java.sql.Date.valueOf(zdt.toLocalDate());

            String sexo = vista.getCmbSexo().getSelectedItem().toString();
            String telf = vista.getTxtTelf().getText();
            String correo = vista.getTxtCorreo().getText();
            String direc = vista.getTxtDirec().getText();
            int descuento = (int) vista.getSpnDescuento().getValue();
            ImageIcon ic = (ImageIcon) vista.getLblImagen().getIcon();

            Modelo_Persona p = new Modelo_Persona(cedula, nombres, apellidos, fechaN, sexo, telf, correo, direc, ic.getImage());
            Modelo_Cliente a = new Modelo_Cliente();
            a.setCedula(cedula);
            a.setNombres(nombres);
            a.setApellidos(apellidos);
            a.setFecha_n(fechaN);
            a.setSexo(sexo);
            a.setTelef(telf);
            a.setCorreo(correo);
            a.setDirec(direc);
            a.setFoto(ic.getImage());
            a.setDescuent(descuento);
            a.setCedulafk(cedula);

            if (modelo.CREAR_C(p, a)) {
                System.out.println(a.toString());
                JOptionPane.showMessageDialog(null, "EL CLIENTE FUE CREADO SATISFACTORIAMENTE");
                limpiarCajas();
                vista.getDlgCliente().setVisible(false);
                CargarLista("");
            }

        }

    }
    
    private void ModificarCliente() {
        if (Validacion()) {

            String cedula = vista.getTxtCedula().getText();
            String nombres = vista.getTxtNombres().getText();
            String apellidos = vista.getTxtApellido().getText();

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
            int descuento = (int) vista.getSpnDescuento().getValue();
          
            Modelo_Cliente a = new Modelo_Cliente();
            a.setCedula(cedula);
            a.setNombres(nombres);
            a.setApellidos(apellidos);
            a.setFecha_n(fechaN);
            a.setSexo(sexo);
            a.setTelef(telf);
            a.setCorreo(correo);
            a.setDirec(direc);
            a.setFoto(ic.getImage());
            a.setDescuent(descuento);
            a.setCedulafk(cedula);

            if (modelo.MODIFICAR_C(p, a)) {
                System.out.println(a.toString());
                JOptionPane.showMessageDialog(null, "EL CLIENTE FUE MODIFICADO SATISFACTORIAMENTE");
                vista.getDlgCliente().setVisible(false);
                limpiarCajas();
                
                CargarLista("");
                
                
            }

        }

    }
    
    private void EliminarCliente() {
        try {
            int fila = vista.getTblCliente().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblCliente().getModel();
            int op = JOptionPane.showConfirmDialog(vista, "\tDesea eliminar este Cliente:\n"
                    + "Id: " + model.getValueAt(fila, 0).toString() + "\n"
                    + "Nombre: " + model.getValueAt(fila, 1).toString() + "\n"
                    + "Apellido: " + model.getValueAt(fila, 2).toString() + "\n"
                    + "Fecha Nac: " + model.getValueAt(fila, 3).toString());
            if (op == 0) {
                Modelo_Cliente a1 = new Modelo_Cliente();
                a1.setCedulafk(model.getValueAt(fila, 0).toString());
                Modelo_Persona p1 = new Modelo_Persona();
                p1.setCedula(model.getValueAt(fila, 0).toString());
                if (a1.ELIMINAR_C(p1, a1)) {
                    JOptionPane.showMessageDialog(vista, "CLIENTE ELIMINADO");
                    CargarLista("");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No ha seleccionado ninguna fila para eliminarla");
        }

    }
    
    private void CargarCamposTextos() {
        try {
            int fila = vista.getTblCliente().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblCliente().getModel();
            vista.getTxtCedula().setText(model.getValueAt(fila, 0).toString());
            vista.getTxtNombres().setText(model.getValueAt(fila, 1).toString());
            vista.getTxtApellido().setText(model.getValueAt(fila, 2).toString());
            vista.getDtcFecha().setDate((java.util.Date) model.getValueAt(fila, 3));
            vista.getCmbSexo().setSelectedItem(model.getValueAt(fila, 4).toString());
            vista.getTxtTelf().setText(model.getValueAt(fila, 5).toString());
            vista.getTxtCorreo().setText(model.getValueAt(fila, 6).toString());
            vista.getTxtDirec().setText(model.getValueAt(fila, 7).toString());
            vista.getSpnDescuento().setValue(model.getValueAt(fila, 8));
            JLabel l1 = (JLabel) model.getValueAt(fila, 9);
            vista.getLblImagen().setIcon(l1.getIcon());
            Dialogo_A_C_M(2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "SELECCIONE UNA FILA POR FAVOR ");
        }

    }
    public void Dialogo_A_C_M(int tp) {
        vista.getDlgCliente().setSize(720, 580);
        opciones();
        if (tp == 1) {
            limpiarCajas();
            vista.getBtnGuardar().setVisible(true);
            vista.getDlgCliente().setVisible(true);
        } else if (tp == 2) {
            vista.getBtnModificar().setVisible(true);
            vista.getDlgCliente().setVisible(true);
        } else if (tp == 3) {
            limpiarCajas();
            opciones();
            vista.getDlgCliente().setVisible(false);
        }
    }
    private void opciones() {
        vista.getBtnGuardar().setVisible(false);
        vista.getBtnModificar().setVisible(false);

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
    private void limpiarCajas() {
        vista.getTxtCedula().setText("");
        vista.getTxtNombres().setText("");
        vista.getTxtApellido().setText("");

        vista.getCmbSexo().setSelectedIndex(0);
        vista.getTxtTelf().setText("");
        vista.getTxtCorreo().setText("");
        vista.getTxtDirec().setText("");
        vista.getLblImagen().setIcon(null);
        vista.getDtcFecha().setDate(null);
        vista.getSpnDescuento().setValue(0);

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
                vista.getLblImagen().setIcon(ic);
                vista.getLblImagen().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(Controlador_IS.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
