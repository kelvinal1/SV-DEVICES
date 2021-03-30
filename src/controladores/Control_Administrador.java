/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
import com.sun.org.apache.bcel.internal.generic.IFEQ;
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
import modelos.Modelo_IS;
import modelos.Modelo_Persona;
import modelos.clases_bases.admin;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vista.ventanas.Ventana_Admins;

/**
 *
 * @author Kevin
 */
public class Control_Administrador {

    private Modelo_Admin modelo;
    private Ventana_Admins vista;

    public Control_Administrador() {
    }

    public Control_Administrador(Modelo_Admin modelo, Ventana_Admins vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        CargarLista("");
    }

    public void Iniciar_Control() {
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
        vista.getBtnEditarA().addActionListener(l -> CargarCamposTextos());
        vista.getTxtCorreo().addKeyListener(k1);
        vista.getBtnBuscar().addActionListener(l -> AnadirImagen());
        vista.getBtnActualizarA().addActionListener(l -> CargarLista(""));
        vista.getTxtBuscar().addKeyListener(k2);
        vista.getBtnModificar().addActionListener(l -> ModificarAdmin());
        vista.getBtnEliminarA().addActionListener(l -> EliminarAdmin());
        vista.getBtnGuardar1().addActionListener(l -> Crear_Admin_Cliente());

    }

    private void CargarLista(String aguja) {

        vista.getTblAdmin().setDefaultRenderer(Object.class, new ImagenTable());
        vista.getTblAdmin().setRowHeight(100);
        DefaultTableCellRenderer render = new DefaultTableCellHeaderRenderer();

        DefaultTableModel tablaA;

        tablaA = (DefaultTableModel) vista.getTblAdmin().getModel();
        tablaA.setNumRows(0);
        List<admin> lista = modelo.LISTAR(aguja);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(t -> {
            tablaA.addRow(new Object[ncols]);
            vista.getTblAdmin().setValueAt(t.getCedula(), i.value, 0);
            vista.getTblAdmin().setValueAt(t.getNombres(), i.value, 1);
            vista.getTblAdmin().setValueAt(t.getApellidos(), i.value, 2);
            vista.getTblAdmin().setValueAt(t.getFecha_n(), i.value, 3);
            vista.getTblAdmin().setValueAt(t.getSexo(), i.value, 4);
            vista.getTblAdmin().setValueAt(t.getTelef(), i.value, 5);
            vista.getTblAdmin().setValueAt(t.getCorreo(), i.value, 6);
            vista.getTblAdmin().setValueAt(t.getDirec(), i.value, 7);
            vista.getTblAdmin().setValueAt(t.getUsuario(), i.value, 8);

            Image img = t.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                render.setIcon(icon);
                vista.getTblAdmin().setValueAt(new JLabel(icon), i.value, 9);
            } else {
                vista.getTblAdmin().setValueAt(null, i.value, 9);
            }

            i.value++;

        });
        vista.getjLabel3().setText("" + vista.getTblAdmin().getRowCount());

    }

    private void Crear_Admin_Cliente() {

        Modelo_Cliente c = new Modelo_Cliente();
        c.setCedula(vista.getTxtCedula1().getText());

        if (c.BuscarCedula()) {
            Modelo_Admin a = new Modelo_Admin();
            a.setCedula(vista.getTxtCedula1().getText());
            a.setCedulafk(vista.getTxtCedula1().getText());
            a.setUsuario(a.Correo());
            a.setClave(vista.getTxtClave1().getText());

            if (validacion2()) {
                if (a.CREAR()) {
                    JOptionPane.showMessageDialog(vista, "EL ADMIN FUE CREADO SATISFACTORIAMENTE");
                    limpiarCajas();
                    CargarLista("");
                } else {
                    JOptionPane.showMessageDialog(vista, "ESTE ADMINISTRADOR YA HA SIDO REGISTRADO", "ADMINISTRADOR EXISTENTE", JOptionPane.ERROR_MESSAGE);

                }

            }

        } else {
            JOptionPane.showMessageDialog(vista, "La cedula ingresada no existe como cliente", "CEDULA NO EXISTENTE", JOptionPane.ERROR_MESSAGE);
        }

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
            ImageIcon ic = (ImageIcon) vista.getLblImagen().getIcon();

            Modelo_Persona p = new Modelo_Persona(cedula, nombres, apellidos, fechaN, sexo, telf, correo, direc, ic.getImage());
            String usuario = vista.getTxtUsuari().getText();
            String clave = vista.getTxtContra().getText();
            Modelo_Admin a = new Modelo_Admin();
            a.setCedula(cedula);
            a.setNombres(nombres);
            a.setApellidos(apellidos);
            a.setFecha_n(fechaN);
            a.setSexo(sexo);
            a.setTelef(telf);
            a.setCorreo(correo);
            a.setDirec(direc);
            a.setFoto(ic.getImage());
            a.setUsuario(usuario);
            a.setClave(clave);
            a.setCedulafk(cedula);

            if (modelo.CREAR_A(p, a)) {
                System.out.println(a.toString());
                JOptionPane.showMessageDialog(null, "EL ADMINISTRADOR FUE CREADO SATISFACTORIAMENTE");
                limpiarCajas();
                vista.getDlgAdmin().setVisible(false);
                CargarLista("");
            }

        }

    }

    private void ModificarAdmin() {
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
            String usuario = vista.getTxtUsuari().getText();
            String clave = vista.getTxtContra().getText();
            Modelo_Admin a = new Modelo_Admin();
            a.setCedula(cedula);
            a.setNombres(nombres);
            a.setApellidos(apellidos);
            a.setFecha_n(fechaN);
            a.setSexo(sexo);
            a.setTelef(telf);
            a.setCorreo(correo);
            a.setDirec(direc);
            a.setFoto(ic.getImage());
            a.setUsuario(usuario);
            a.setClave(clave);
            a.setCedulafk(cedula);

            if (modelo.MODIFICAR_A(p, a)) {
                System.out.println(a.toString());
                JOptionPane.showMessageDialog(null, "EL ADMINISTRADOR FUE MODIFICADO SATISFACTORIAMENTE");
                limpiarCajas();
                vista.getDlgAdmin().setVisible(false);
                CargarLista("");

            }

        }

    }

    private void EliminarAdmin() {
        try {
            int fila = vista.getTblAdmin().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblAdmin().getModel();
            int op = JOptionPane.showConfirmDialog(vista, "\tDesea eliminar este Administrador:\n"
                    + "Id: " + model.getValueAt(fila, 0).toString() + "\n"
                    + "Nombre: " + model.getValueAt(fila, 1).toString() + "\n"
                    + "Apellido: " + model.getValueAt(fila, 2).toString() + "\n"
                    + "Fecha Nac: " + model.getValueAt(fila, 3).toString());
            if (op == 0) {
                Modelo_Admin a1 = new Modelo_Admin();
                a1.setCedulafk(model.getValueAt(fila, 0).toString());
                Modelo_Persona p1 = new Modelo_Persona();
                p1.setCedula(model.getValueAt(fila, 0).toString());
                if (a1.ELIMINAR_A(p1, a1)) {
                    JOptionPane.showMessageDialog(vista, "ADMINISTRADOR ELIMINADO");
                    CargarLista("");
                } else {
                    JOptionPane.showMessageDialog(null, "\t Este Administrador era tambien un cliente"
                            + "\n\tsolo dejo de ser administrador");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No ha seleccionado ninguna fila para eliminarla");
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

    private void CargarCamposTextos() {
        try {
            int fila = vista.getTblAdmin().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblAdmin().getModel();
            vista.getTxtCedula().setText(model.getValueAt(fila, 0).toString());
            vista.getTxtNombres().setText(model.getValueAt(fila, 1).toString());
            vista.getTxtApellido().setText(model.getValueAt(fila, 2).toString());
            vista.getDtcFecha().setDate((java.util.Date) model.getValueAt(fila, 3));
            vista.getCmbSexo().setSelectedItem(model.getValueAt(fila, 4).toString());
            vista.getTxtTelf().setText(model.getValueAt(fila, 5).toString());
            vista.getTxtCorreo().setText(model.getValueAt(fila, 6).toString());
            vista.getTxtDirec().setText(model.getValueAt(fila, 7).toString());
            vista.getTxtUsuari().setText(model.getValueAt(fila, 8).toString());
            JLabel l1 = (JLabel) model.getValueAt(fila, 9);
            vista.getLblImagen().setIcon(l1.getIcon());
            Dialogo_A_C_M(2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "SELECCIONE UNA FILA POR FAVOR ");
        }

    }

    public void Dialogo_A_C_M(int tp) {

        vista.getDlgAdmin().setSize(720, 580);
        vista.getDlgAdmin2().setSize(740, 350);
        opciones();
        if (tp == 1) {
            String op = JOptionPane.showInputDialog(vista, "\tMenu"
                    + "\n1. Crear cliente apartir de admin"
                    + "\n2. Crear admin ");

            if (Integer.parseInt(op) == 1) {
                limpiarCajas();
                vista.getDlgAdmin2().setVisible(true);

            } else if (Integer.parseInt(op) == 2) {
                limpiarCajas();
                vista.getBtnGuardar().setVisible(true);
                vista.getDlgAdmin().setVisible(true);

            } else {
                JOptionPane.showMessageDialog(vista, "No ha ingresado una opcion de las que se brindo", "Opcion inexistente", JOptionPane.ERROR_MESSAGE);
            }

        } else if (tp == 2) {
            vista.getBtnModificar().setVisible(true);
            vista.getDlgAdmin().setVisible(true);
        } else if (tp == 3) {
            limpiarCajas();
            opciones();
            vista.getDlgAdmin().setVisible(false);
        }
    }

    private void opciones() {
        vista.getBtnGuardar().setVisible(false);
        vista.getBtnModificar().setVisible(false);

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
        vista.getTxtUsuari().setText("");
        vista.getTxtContra().setText("");
        vista.getTxtContra2().setText("");

    }

   

    public boolean validacion2() {
        boolean verificar = true;

        if (vista.getTxtClave1().getText().equals("") || vista.getTxtClave1().getText().equals("") || vista.getTxtCedula1().getText().equals("")) {
            verificar = false;
            JOptionPane.showMessageDialog(vista, "EXISTEN CAMPOS VACIOS", "CAMPOS", JOptionPane.ERROR_MESSAGE);
        }

        if (!vista.getTxtClave1().getText().equals(vista.getTxtClave2().getText())) {
            verificar = false;
            JOptionPane.showMessageDialog(vista, "CLAVE DIFERENTES", "CLAVES", JOptionPane.ERROR_MESSAGE);
        }

        return verificar;
    }

}
