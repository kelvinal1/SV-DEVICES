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
import modelos.Modelo_Producto_V;
import modelos.clases_bases.admin;
import modelos.clases_bases.fabricante;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vista.ventanas.Ventana_Productos_V;
import modelos.clases_bases.producto_v;

/**
 *
 * @author Kevin
 */
public class Controlador_Producto_V {

    private Modelo_Producto_V modelo;
    private Ventana_Productos_V vista;

    public Controlador_Producto_V() {
    }

    public Controlador_Producto_V(Modelo_Producto_V modelo, Ventana_Productos_V vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        CargarLista("");

    }

    public void IniciarControl() {
        KeyListener k = new KeyListener() {
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
        vista.getBtnGuardar().addActionListener(l -> CrearProductoV());
        vista.getBtnNuevoP().addActionListener(l -> Dialogo(1));
        vista.getBtnEditarP().addActionListener(l -> CargarCampos());
        vista.getBtnBuscar().addActionListener(l -> AnadirImagen());
        vista.getTxtBuscar().addKeyListener(k);
        vista.getBtnModificar().addActionListener(l -> ModificarProductoV());
        vista.getBtnActualizarA().addActionListener(l -> CargarLista(""));
        vista.getBtnEliminarP().addActionListener(l -> EliminarProductoV());
        vista.getBtnCancelar().addActionListener(l->Cancelar());

    }

    public void CargarLista(String aguja) {
        vista.getTblProducto().setDefaultRenderer(Object.class, new ImagenTable());
        vista.getTblProducto().setRowHeight(100);
        DefaultTableCellRenderer render = new DefaultTableCellHeaderRenderer();

        DefaultTableModel tablaA;

        tablaA = (DefaultTableModel) vista.getTblProducto().getModel();
        tablaA.setNumRows(0);

        List<producto_v> lista = modelo.LISTAR(aguja);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(pv -> {
            tablaA.addRow(new Object[ncols]);
            vista.getTblProducto().setValueAt(pv.getCodigo(), i.value, 0);
            vista.getTblProducto().setValueAt(pv.getNombre(), i.value, 1);
            vista.getTblProducto().setValueAt(pv.getCodigo_fab(), i.value, 2);
            vista.getTblProducto().setValueAt(pv.getModelo(), i.value, 3);
            vista.getTblProducto().setValueAt(pv.getDescrip(), i.value, 4);
            vista.getTblProducto().setValueAt(pv.getCant_stock(), i.value, 5);
            vista.getTblProducto().setValueAt(pv.getPrecio(), i.value, 6);
            vista.getTblProducto().setValueAt(pv.getDescuento(), i.value, 7);
            vista.getTblProducto().setValueAt(pv.getN_mes_garantia(), i.value, 8);

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

    public void CrearProductoV() {
        String nombre = vista.getTxtNombre().getText();
        String codigoFab = vista.getCmbFabric().getSelectedItem().toString();
        String modelo = vista.getTxtModelo().getText();
        String descrip = vista.getTxtDescrip().getText();
        int Cant_Stock = (int) vista.getSpnCantidad().getValue();
        Double Precio = Double.parseDouble(vista.getTxtPrecio().getText());
        Double Descuento = Double.parseDouble(vista.getSpnDescuento().getValue().toString());
        int Garantia = (int) vista.getSpnGarantia().getValue();

        ImageIcon ic = (ImageIcon) vista.getLblImagen().getIcon();
        Modelo_Producto p = new Modelo_Producto();
        p.setNombre(nombre);
        p.setCodigo_fab(Integer.parseInt(codigoFab.split(" ")[0]));
        p.setModelo(modelo);
        p.setDescrip(descrip);
        p.setFoto(ic.getImage());
        if (p.CREAR()) {
            Modelo_Producto_V v = new Modelo_Producto_V();
            v.setCodigo(p.ConseguirCodigo(descrip));
            v.setDescuento(Descuento);
            v.setPrecio(Precio);
            v.setCant_stock(Cant_Stock);
            v.setN_mes_garantia(Garantia);
            if (v.CREAR()) {
                JOptionPane.showMessageDialog(vista, "SE CREO SATISFACORIAMENTE EL PRODUCTO");
                limpiarCajas();
                vista.getDlgProductoV().setVisible(false);
                CargarLista("");
            } else {
                JOptionPane.showMessageDialog(vista, "ERROR AL CREAR PRODUCTO PARA LA VENTA", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR AL CREAR PRODUCTO GENERAL", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ModificarProductoV() {
        String nombre = vista.getTxtNombre().getText();
        String codigoFab = vista.getCmbFabric().getSelectedItem().toString();
        String modelo = vista.getTxtModelo().getText();
        String descrip = vista.getTxtDescrip().getText();
        int Cant_Stock = (int) vista.getSpnCantidad().getValue();
        Double Precio = Double.parseDouble(vista.getTxtPrecio().getText());
        Double Descuento = Double.parseDouble(vista.getSpnDescuento().getValue().toString());
        int Garantia = (int) vista.getSpnGarantia().getValue();

        ImageIcon ic = (ImageIcon) vista.getLblImagen().getIcon();
        Modelo_Producto p = new Modelo_Producto();
        p.setCodigo(Integer.parseInt(vista.getLblCodigo().getText()));
        p.setNombre(nombre);
        p.setCodigo_fab(Integer.parseInt(codigoFab.split(" ")[0]));
        p.setModelo(modelo);
        p.setDescrip(descrip);
        p.setFoto(ic.getImage());
        if (p.MODIFICAR()) {
            Modelo_Producto_V v = new Modelo_Producto_V();
            v.setCodigo(p.ConseguirCodigo(descrip));
            v.setDescuento(Descuento);
            v.setPrecio(Precio);
            v.setCant_stock(Cant_Stock);
            v.setN_mes_garantia(Garantia);
            if (v.MODIFICAR()) {
                JOptionPane.showMessageDialog(vista, "SE MODIFICO SATISFACORIAMENTE EL PRODUCTO");
                limpiarCajas();
                vista.getDlgProductoV().setVisible(false);
                CargarLista("");
            } else {
                JOptionPane.showMessageDialog(vista, "ERROR AL MODIFICAR PRODUCTO PARA LA VENTA", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR AL PRODUCTO PRODUCTO GENERAL", "ERROR", JOptionPane.ERROR_MESSAGE);
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

    public void EliminarProductoV() {
        try {
            int fila = vista.getTblProducto().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblProducto().getModel();
            int op = JOptionPane.showConfirmDialog(vista, "\tDesea eliminar este Producto:\n"
                    + "Codigo: " + model.getValueAt(fila, 0).toString() + "\n"
                    + "Nombre: " + model.getValueAt(fila, 1).toString() + "\n"
                    + "Modelo: " + model.getValueAt(fila, 3).toString() + "\n"
                    + "Descripcion: " + model.getValueAt(fila, 4).toString());
            if (op == 0) {
                Modelo_Producto p = new Modelo_Producto();
                p.setCodigo(Integer.parseInt(model.getValueAt(fila, 0).toString()));

                Modelo_Producto_V pv = new Modelo_Producto_V();
                pv.setCodigo(Integer.parseInt(model.getValueAt(fila, 0).toString()));
                if (pv.ELIMINAR_PV(p, pv)) {
                    JOptionPane.showMessageDialog(vista, "PRODUCTO A LA VENTA ELIMINADO");
                    CargarLista("");
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al borrar producto a la venta", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No ha seleccionado ninguna fila para eliminarla", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void Dialogo(int op) {

        vista.getBtnGuardar().setVisible(false);
        vista.getBtnModificar().setVisible(false);

        if (op == 1) {
            limpiarCajas();
            ListarFab();
            vista.getBtnGuardar().setVisible(true);
            vista.getDlgProductoV().setVisible(true);
            vista.getDlgProductoV().setSize(700, 700);

        } else if (op == 2) {
            vista.getLblCodigo().setVisible(true);
            vista.getLblNCodigo().setVisible(true);
            vista.getBtnModificar().setVisible(true);
            vista.getDlgProductoV().setVisible(true);
            vista.getDlgProductoV().setSize(700, 700);
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
            vista.getTxtPrecio().setText(model.getValueAt(fila, 6).toString());
            vista.getSpnDescuento().setValue(model.getValueAt(fila, 7));
            vista.getSpnGarantia().setValue(model.getValueAt(fila, 8));
            JLabel l1 = (JLabel) model.getValueAt(fila, 9);
            vista.getLblImagen().setIcon(l1.getIcon());
            Dialogo(2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No ha seleccionada una fila para editarla", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiarCajas() {
        vista.getTxtNombre().setText("");
        vista.getCmbFabric().setSelectedIndex(0);
        vista.getTxtModelo().setText("");
        vista.getTxtDescrip().setText("");
        vista.getSpnCantidad().setValue(0);
        vista.getTxtPrecio().setText("");
        vista.getSpnDescuento().setValue(0);
        vista.getSpnGarantia().setValue(1);
        vista.getLblNCodigo().setVisible(false);
        vista.getLblCodigo().setVisible(false);
        vista.getLblImagen().setIcon(null);

    }
    
    public void Cancelar(){
        limpiarCajas();
        vista.getDlgProductoV().setVisible(false);
        
    }
}
