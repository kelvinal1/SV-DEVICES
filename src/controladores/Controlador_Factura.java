/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelos.Modelo_Cliente;
import modelos.Modelo_Det_Factura;
import modelos.Modelo_Enc_Factura;
import modelos.Modelo_Producto_V;
import modelos.clases_bases.cliente;
import modelos.clases_bases.det_factura;
import modelos.clases_bases.producto_v;
import vista.ventanas.Ventana_Ventas;

/**
 *
 * @author Kevin
 */
public class Controlador_Factura {

    private Modelo_Enc_Factura modeloEncabezado;
    private Modelo_Det_Factura modeloDetalle;
    private Ventana_Ventas vista;
    private List<det_factura> detalles= new ArrayList<>();

    public Controlador_Factura() {
    }

    public Controlador_Factura(Modelo_Enc_Factura modeloEncabezado, Modelo_Det_Factura modeloDetalle, Ventana_Ventas vista) {
        this.modeloEncabezado = modeloEncabezado;
        this.modeloDetalle = modeloDetalle;
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
                CargarClientes(vista.getTxtCliente().getText());
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
                CargarProductos(vista.getTxtBuscarProducto().getText());
            }
        };
        vista.getBtnNuevoF().addActionListener(l->Dialogo());
        vista.getBtnClientes().addActionListener(l->CargarClientes(""));
        vista.getTxtCliente().addKeyListener(k1);
        vista.getBtnInsertCliente().addActionListener(l->CargarClienteFact());
        vista.getBtnAnadirP().addActionListener(l->CargarProductos(""));
        vista.getTxtBuscarProducto().addKeyListener(k2);
        vista.getBtnInsertarProducto().addActionListener(l->CargarProCant());
        vista.getSpnCantidad().addChangeListener(l->cargarSubtotalPro());
        vista.getBtnAnadirPro().addActionListener(l->CargarProFact());
                

    }

    public void CargarClientes(String aguja) {
        vista.getDlgListaC().setVisible(true);
        vista.getDlgListaC().setSize(720,320);
        Modelo_Cliente mc = new Modelo_Cliente();
        List<cliente> lista = mc.VistaClientes(aguja);
        DefaultTableModel tablaA = (DefaultTableModel) vista.getTblClientes().getModel();
        tablaA.setNumRows(0);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(t -> {
            tablaA.addRow(new Object[ncols]);
            vista.getTblClientes().setValueAt(t.getCliente(), i.value, 0);
            vista.getTblClientes().setValueAt(t.getDirec(), i.value, 1);
            vista.getTblClientes().setValueAt(t.getCedula(), i.value, 2);
            vista.getTblClientes().setValueAt(t.getTelef(), i.value, 3);
            vista.getTblClientes().setValueAt(t.getDescuent(), i.value, 4);
            i.value++;
        });

    }
    
    public void CargarProductos(String aguja) {
        vista.getDlgListaP().setVisible(true);
        vista.getDlgListaP().setSize(720,320);
        Modelo_Producto_V mp = new Modelo_Producto_V();
        List<producto_v> lista = mp.VistaProductos(aguja);
        DefaultTableModel tablaA = (DefaultTableModel) vista.getTblProducto().getModel();
        tablaA.setNumRows(0);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(t -> {
            tablaA.addRow(new Object[ncols]);
            vista.getTblProducto().setValueAt(t.getCodigo(), i.value, 0);
            vista.getTblProducto().setValueAt(t.getNombre(), i.value, 1);
            vista.getTblProducto().setValueAt(t.getPrecio(), i.value, 2);
            vista.getTblProducto().setValueAt(t.getCant_stock(), i.value, 3);
            i.value++;
        });

    }
    
    public void Dialogo(){
        vista.getTxtNFact().setText(modeloEncabezado.NuevoFact());
        vista.getDlgFactura().setVisible(true);
        vista.getDlgFactura().setSize(1225,705);
    }
    
    public void CargarClienteFact(){
        try {
            int fila= vista.getTblClientes().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblClientes().getModel();
            vista.getTxtNomApell().setText(String.valueOf(model.getValueAt(fila, 0)));
            vista.getTxtDireccion().setText(String.valueOf(model.getValueAt(fila, 1)));
            vista.getTxtCedula().setText(String.valueOf(model.getValueAt(fila, 2)));
            vista.getTxtTelefono().setText(String.valueOf(model.getValueAt(fila, 3)));
            vista.getTxtDescuento().setText(String.valueOf(model.getValueAt(fila, 4)));
            vista.getDlgListaC().setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "NO HA SELECCIONADO NINGUN CLIENTE","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void CargarProCant(){
        try {
            
            int fila= vista.getTblProducto().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblProducto().getModel();
            vista.getLblNumCodigoP().setText(String.valueOf(model.getValueAt(fila, 0)));
            vista.getTxtProducto().setText(String.valueOf(model.getValueAt(fila, 1)));
            vista.getLblPrecioPU().setText(String.valueOf(model.getValueAt(fila, 2)));
            vista.getLblPrecioT().setText(String.valueOf(model.getValueAt(fila, 2)));
             
            vista.getDlgListaP().setVisible(false);
            vista.getDlgAnadirP().setVisible(true);
            vista.getDlgAnadirP().setSize(620,320);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "NO HA SELECCIONADO NINGUN PRODUCTO","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void cargarSubtotalPro(){
        Integer cantidad=(Integer) vista.getSpnCantidad().getValue();
        double precio = Double.parseDouble(vista.getLblPrecioPU().getText())*cantidad;
        DecimalFormat df = new DecimalFormat("#.00");
        vista.getLblPrecioT().setText(""+df.format(precio));
    }
    
    
    public void CargarProFact(){
       
        det_factura d = new det_factura();
        d.setCodigo_factura(vista.getTxtNFact().getText());
        d.setCod_producto(Integer.parseInt(vista.getLblNumCodigoP().getText()));
        d.setCantidad(Integer.parseInt(vista.getSpnCantidad().getValue().toString()));
        d.setSubtotal(Double.parseDouble(vista.getLblPrecioT().getText()));
        d.setPrecioU(Double.parseDouble(vista.getLblPrecioPU().getText()));
        d.setProducto(vista.getTxtProducto().getText());
        detalles.add(d);
        DefaultTableModel tablaA = (DefaultTableModel) vista.getTblDetalle().getModel();
        tablaA.setNumRows(0);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        
        detalles.stream().forEach(t->{
            
            tablaA.addRow(new Object[ncols]);
            vista.getTblDetalle().setValueAt(t.getCod_producto(), i.value, 0);
            vista.getTblDetalle().setValueAt(t.getProducto(), i.value, 1);
            vista.getTblDetalle().setValueAt(t.getPrecioU(), i.value, 2);
            vista.getTblDetalle().setValueAt(t.getCantidad(), i.value, 3);
            vista.getTblDetalle().setValueAt(t.getSubtotal(), i.value, 4);
            i.value++;
            
        });
        vista.getDlgAnadirP().setVisible(false);
        
        
    }
    
    
    
    

}
