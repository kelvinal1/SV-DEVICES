/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.Image;
import java.io.IOException;
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
import modelos.Modelo_Fabricante;
import modelos.Modelo_Producto;
import modelos.Modelo_Producto_A;
import modelos.clases_bases.fabricante;
import modelos.clases_bases.producto_a;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vista.ventanas.Ventana_Productos_A;

/**
 *
 * @author Kevin
 */
public class Controlador_Producto_A {

    private Modelo_Producto_A modelo;
    private Ventana_Productos_A vista;

    public Controlador_Producto_A() {
    }

    public Controlador_Producto_A(Modelo_Producto_A modelo, Ventana_Productos_A vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        CargarLista("");
    }

    public void IniciarControl() {
        vista.getBtnNuevoP().addActionListener(l -> Dialogo(1));
        vista.getBtnEditarP().addActionListener(l -> CargarCampos());
        vista.getBtnGuardar().addActionListener(l -> CrearProductoA());
        vista.getBtnBuscar().addActionListener(l -> AnadirImagen());
        vista.getBtnModificar().addActionListener(l->ModificarProductoA());
        vista.getBtnEliminarP().addActionListener(l->EliminarProductoA());

    }

    public void CargarLista(String aguja) {
        vista.getTblProducto().setDefaultRenderer(Object.class, new ImagenTable());
        vista.getTblProducto().setRowHeight(100);
        DefaultTableCellRenderer render = new DefaultTableCellHeaderRenderer();

        DefaultTableModel tablaA;

        tablaA = (DefaultTableModel) vista.getTblProducto().getModel();
        tablaA.setNumRows(0);

        List<producto_a> lista = modelo.LISTAR(aguja);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(pv -> {
            tablaA.addRow(new Object[ncols]);
            vista.getTblProducto().setValueAt(pv.getCodigo(), i.value, 0);
            vista.getTblProducto().setValueAt(pv.getNombre(), i.value, 1);
            vista.getTblProducto().setValueAt(pv.getCodigo_fab(), i.value, 2);
            vista.getTblProducto().setValueAt(pv.getModelo(), i.value, 3);
            vista.getTblProducto().setValueAt(pv.getDescrip(), i.value, 4);
            vista.getTblProducto().setValueAt(pv.getCantidad(), i.value, 5);
            vista.getTblProducto().setValueAt(pv.getProblema(), i.value, 6);
            vista.getTblProducto().setValueAt(pv.getDetalle(), i.value, 7);
            vista.getTblProducto().setValueAt(pv.getCosto(), i.value, 8);

            Image img = pv.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                render.setIcon(icon);
                vista.getTblProducto().setValueAt(new JLabel(icon), i.value, 9);
            } else {
                vista.getTblProducto().setValueAt(null, i.value, 9);
            }

            i.value++;

        });

        vista.getjLabel3().setText("" + vista.getTblProducto().getRowCount());

    }

    public void CrearProductoA() {
        String nombre = vista.getTxtNombre().getText();
        String codigoFab = vista.getCmbFabric().getSelectedItem().toString();
        String modelo = vista.getTxtModelo().getText();
        String descrip = vista.getTxtDescrip().getText();
        int cantidad = (int) vista.getSpnCantidad().getValue();
        String problema = vista.getTxtProblema().getText();
        String detalle = vista.getTxtDetalle().getText();
        Double costo = Double.parseDouble(vista.getTxtCosto().getText());

        ImageIcon ic = (ImageIcon) vista.getLblImagen().getIcon();
        Modelo_Producto p = new Modelo_Producto();
        p.setNombre(nombre);
        p.setCodigo_fab(Integer.parseInt(codigoFab.split(" ")[0]));
        p.setModelo(modelo);
        p.setDescrip(descrip);
        p.setFoto(ic.getImage());
        if (p.CREAR()) {
            Modelo_Producto_A v = new Modelo_Producto_A();
            v.setCodigo(p.ConseguirCodigo(descrip));
            v.setCantidad(cantidad);
            v.setProblema(problema);
            v.setDetalle(detalle);
            v.setCosto(costo);
            if (v.CREAR()) {
                JOptionPane.showMessageDialog(vista, "SE CREO SATISFACORIAMENTE EL PRODUCTO AJENO");
                limpiarCajas();
                vista.getDlgProductoA().setVisible(false);
                CargarLista("");
            } else {
                JOptionPane.showMessageDialog(vista, "ERROR AL CREAR PRODUCTO AJENO", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR AL CREAR PRODUCTO GENERAL", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void ModificarProductoA() {
        String nombre = vista.getTxtNombre().getText();
        String codigoFab = vista.getCmbFabric().getSelectedItem().toString();
        String modelo = vista.getTxtModelo().getText();
        String descrip = vista.getTxtDescrip().getText();
        int cantidad = (int) vista.getSpnCantidad().getValue();
        String problema = vista.getTxtProblema().getText();
        String detalle = vista.getTxtDetalle().getText();
        Double costo = Double.parseDouble(vista.getTxtCosto().getText());

        ImageIcon ic = (ImageIcon) vista.getLblImagen().getIcon();
        Modelo_Producto p = new Modelo_Producto();
        p.setNombre(nombre);
        p.setCodigo_fab(Integer.parseInt(codigoFab.split(" ")[0]));
        p.setModelo(modelo);
        p.setDescrip(descrip);
        p.setFoto(ic.getImage());
        if (p.MODIFICAR()) {
            Modelo_Producto_A v = new Modelo_Producto_A();
            v.setCodigo(p.ConseguirCodigo(descrip));
            v.setCantidad(cantidad);
            v.setProblema(problema);
            v.setDetalle(detalle);
            v.setCosto(costo);
            if (v.MODIFICAR()) {
                JOptionPane.showMessageDialog(vista, "SE MODIFICO SATISFACORIAMENTE EL PRODUCTO AJENO");
                limpiarCajas();
                vista.getDlgProductoA().setVisible(false);
                CargarLista("");
            } else {
                JOptionPane.showMessageDialog(vista, "ERROR AL MODIFICAR PRODUCTO AJENO", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR AL MODIFICAR PRODUCTO GENERAL", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Dialogo(int op) {

        vista.getBtnGuardar().setVisible(false);
        vista.getBtnModificar().setVisible(false);

        if (op == 1) {
            limpiarCajas();
            ListarFab();
            vista.getBtnGuardar().setVisible(true);
            vista.getDlgProductoA().setVisible(true);
            vista.getDlgProductoA().setSize(700, 700);

        } else if (op == 2) {
            vista.getLblCodigo().setVisible(true);
            vista.getLblNCodigo().setVisible(true);
            vista.getBtnModificar().setVisible(true);
            vista.getDlgProductoA().setVisible(true);
            vista.getDlgProductoA().setSize(700, 700);
        }

    }

    public void CargarCampos() {
        try {
            int fila = vista.getTblProducto().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblProducto().getModel();
            Modelo_Fabricante m = new Modelo_Fabricante();
            vista.getLblCodigo().setText(model.getValueAt(fila, 0).toString());
            ListarFab();
            vista.getTxtNombre().setText(model.getValueAt(fila, 1).toString());
            vista.getCmbFabric().setSelectedItem(m.CADENA(Integer.parseInt(model.getValueAt(fila, 2).toString())));
            vista.getTxtModelo().setText(model.getValueAt(fila, 3).toString());
            vista.getTxtDescrip().setText(model.getValueAt(fila, 4).toString());
            vista.getSpnCantidad().setValue(model.getValueAt(fila, 5));
            vista.getTxtProblema().setText(model.getValueAt(fila, 6).toString());
            vista.getTxtDetalle().setText(model.getValueAt(fila, 7).toString());
            vista.getTxtCosto().setText(model.getValueAt(fila, 8).toString());
            JLabel l1 = (JLabel) model.getValueAt(fila, 9);
            vista.getLblImagen().setIcon(l1.getIcon());
            Dialogo(2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No ha seleccionada una fila para editarla", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public void EliminarProductoA() {
        try {
            int fila = vista.getTblProducto().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblProducto().getModel();
            int op = JOptionPane.showConfirmDialog(vista, "\tDesea eliminar este Producto:\n"
                    + "Codigo: " + model.getValueAt(fila, 0).toString() + "\n"
                    + "Nombre: " + model.getValueAt(fila, 1).toString() + "\n"
                    + "Modelo: " + model.getValueAt(fila, 3).toString() + "\n"
                    + "Problema: " + model.getValueAt(fila, 6).toString());
            if (op == 0) {
                Modelo_Producto p = new Modelo_Producto();
                p.setCodigo(Integer.parseInt(model.getValueAt(fila, 0).toString()));

                Modelo_Producto_A pv = new Modelo_Producto_A();
                pv.setCodigo(Integer.parseInt(model.getValueAt(fila, 0).toString()));
                if (pv.ELIMINAR_PA(p, pv)) {
                    JOptionPane.showMessageDialog(vista, "PRODUCTO AJENO ELIMINADO");
                    CargarLista("");
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al borrar producto a la venta", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No ha seleccionado ninguna fila para eliminarla", "Error", JOptionPane.ERROR_MESSAGE);
        }

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

    public void ListarFab() {
        vista.getCmbFabric().removeAllItems();
        Modelo_Fabricante m = new Modelo_Fabricante();
        List<fabricante> lista = m.LISTAR("");
        lista.stream().forEach(t -> {
            vista.getCmbFabric().addItem(t.getCodigo() + " " + t.getNombre());

        });
    }

    public void limpiarCajas() {
        vista.getTxtNombre().setText("");
        vista.getCmbFabric().setSelectedIndex(0);
        vista.getTxtModelo().setText("");
        vista.getTxtDescrip().setText("");
        vista.getSpnCantidad().setValue(0);
        vista.getTxtProblema().setText("");
        vista.getTxtDetalle().setText("");
        vista.getTxtCosto().setText("");
        vista.getLblNCodigo().setVisible(false);
        vista.getLblCodigo().setVisible(false);
        vista.getLblImagen().setIcon(null);

    }

    public void Cancelar() {
        limpiarCajas();
        vista.getDlgProductoA().setVisible(false);

    }

}
