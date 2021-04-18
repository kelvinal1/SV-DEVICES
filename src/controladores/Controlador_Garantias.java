/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelos.Modelo_Cliente;
import modelos.Modelo_Det_Garantia;
import modelos.Modelo_Enc_Garantia;
import modelos.Modelo_Producto_V;
import modelos.clases_bases.cliente;
import modelos.clases_bases.enc_garantia;
import modelos.clases_bases.producto_v;
import sun.security.x509.AlgorithmId;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vista.ventanas.Ventana_Garantias;

/**
 *
 * @author Kevin
 */
public class Controlador_Garantias {

    private Modelo_Enc_Garantia modeloE;
    private Modelo_Det_Garantia modeloD;
    private Ventana_Garantias vista;
    private List<Modelo_Det_Garantia> detalles;

    public Controlador_Garantias(Modelo_Enc_Garantia modeloE, Modelo_Det_Garantia modeloD, Ventana_Garantias vista) {
        this.modeloE = modeloE;
        this.modeloD = modeloD;
        this.vista = vista;
        vista.setVisible(true);
        CargarGarantias("");
    }
    
    
    public void IniciarControl(String vendedor){
        detalles = new ArrayList<>();
        modeloE.setCod_admin(modeloE.Admin(vendedor));
        vista.getTxtVendedor().setText(modeloE.ColocarAdmin(vendedor));
        vista.getBtnActualizar().addActionListener(l->CargarGarantias(""));
        vista.getBtnGuardar1().addActionListener(l->CargarClientes(""));
        vista.getBtnAnadirP().addActionListener(l->CargarProductos(""));
        vista.getBtnNuevoG().addActionListener(l->Dialogo());
        vista.getBtnInsertCliente().addActionListener(l->CargarClienteRepar());
        vista.getBtnGuardar3().addActionListener(l->CargarProCant());
        vista.getBtnInsertarInfo().addActionListener(l->CargarProGarant());
        vista.getBtnElminarP().addActionListener(l->EliminarDetalle());
        vista.getBtnGuardar().addActionListener(l->RegistrarGarantia());
    }
    
    
    public void RegistrarGarantia() {

        Modelo_Enc_Garantia encabezado = new Modelo_Enc_Garantia();

        encabezado.setCodigo_garantia(vista.getTxtNFact().getText());
        encabezado.setCod_cliente(encabezado.Cliente(vista.getTxtCedula().getText()));
        encabezado.setCod_admin(modeloE.getCod_admin());
        Instant instante = vista.getDtcFecha().getDate().toInstant();
        Instant instante2 = vista.getDtcFecha1().getDate().toInstant();
        
        ZoneId zi = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instante, zi);
        ZonedDateTime zdt2 = ZonedDateTime.ofInstant(instante2, zi);
        java.sql.Date fechaN = java.sql.Date.valueOf(zdt.toLocalDate());
        java.sql.Date fecha2 = java.sql.Date.valueOf(zdt2.toLocalDate());
        encabezado.setFecha_emision(fechaN);
        encabezado.setFecha_retiro(fecha2);
        encabezado.setEstado(vista.getCmbEstado().getSelectedItem().toString());
        if (encabezado.CREAR()) {
            int rep = 0;
            for (int i = 0; i < detalles.size(); i++) {
                if (detalles.get(i).CREAR()) {
                    rep++;
                }

            }
            System.out.println("rep:" + rep);
            System.out.println("detalle: " + detalles.size());
            if (rep == detalles.size()) {
                JOptionPane.showMessageDialog(null, "GARANTIA CREADA");
                CargarGarantias("");
                BorrarDatosRepar();
                    

            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR ENCABEZADO GARANTIA", "ERROR ENCABEZADO", JOptionPane.ERROR_MESSAGE);
        }

    }
    public void CargarGarantias(String aguja) {
        DefaultTableModel tablaA;
        
        tablaA = (DefaultTableModel) vista.getTblReparacion().getModel();
        tablaA.setNumRows(0);
        List<enc_garantia> lista=modeloE.LISTAR(aguja);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(f -> {
            tablaA.addRow(new Object[ncols]);
            vista.getTblReparacion().setValueAt(f.getCodigo_garantia(), i.value, 0);
            vista.getTblReparacion().setValueAt(f.getCliente(), i.value, 1);
            vista.getTblReparacion().setValueAt(f.getVendedor(), i.value, 2);
            vista.getTblReparacion().setValueAt(f.getFecha_emision(), i.value, 3);
            vista.getTblReparacion().setValueAt(f.getFecha_retiro(), i.value, 4);
            vista.getTblReparacion().setValueAt(f.getEstado(), i.value, 5);
            
            
            i.value++;
        });
        

        vista.getjLabel3().setText("" + vista.getTblReparacion().getRowCount());

    }
    
    public void CargarClientes(String aguja) {
        vista.getDlgListaC().setVisible(true);
        vista.getDlgListaC().setSize(720, 320);
        Modelo_Cliente mc = new Modelo_Cliente();
        List<cliente> lista = mc.VistaClientes(aguja);
        DefaultTableModel tablaA = (DefaultTableModel) vista.getTblProducto1().getModel();
        tablaA.setNumRows(0);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(t -> {
            tablaA.addRow(new Object[ncols]);
            vista.getTblProducto1().setValueAt(t.getCliente(), i.value, 0);
            vista.getTblProducto1().setValueAt(t.getDirec(), i.value, 1);
            vista.getTblProducto1().setValueAt(t.getCedula(), i.value, 2);
            vista.getTblProducto1().setValueAt(t.getTelef(), i.value, 3);
            vista.getTblProducto1().setValueAt(t.getDescuent(), i.value, 4);
            i.value++;
        });

    }
    
    public void CargarClienteRepar() {
        try {
            int fila = vista.getTblProducto1().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblProducto1().getModel();
            vista.getTxtNombre().setText(String.valueOf(model.getValueAt(fila, 0)));
            vista.getTxtDireccion().setText(String.valueOf(model.getValueAt(fila, 1)));
            vista.getTxtCedula().setText(String.valueOf(model.getValueAt(fila, 2)));
            vista.getTxtTelefono().setText(String.valueOf(model.getValueAt(fila, 3)));
            vista.getTxtDescuento().setText(String.valueOf(model.getValueAt(fila, 4)));
            vista.getDlgListaC().setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO HA SELECCIONADO NINGUN CLIENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void CargarProductos(String aguja) {
        vista.getDlgListaP().setVisible(true);
        vista.getDlgListaP().setSize(720, 320);
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
            i.value++;
        });

    }
    
    public void CargarProCant() {
        try {
            int fila = vista.getTblProducto().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblProducto().getModel();
            vista.getLblCodigo().setText(String.valueOf(model.getValueAt(fila, 0)));
            vista.getTxtProducto1().setText(String.valueOf(model.getValueAt(fila, 1)));
            

            vista.getDlgListaP().setVisible(false);
            vista.getDlgInformacion().setVisible(true);
            vista.getDlgInformacion().setSize(720, 320);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO HA SELECCIONADO NINGUN PRODUCTO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void CargarProGarant() {

        Modelo_Det_Garantia d = new Modelo_Det_Garantia();
        d.setCodigo_garantia(vista.getTxtNFact().getText());
        d.setCod_producto(Integer.parseInt(vista.getLblCodigo().getText()));
        d.setProducto(vista.getTxtProducto1().getText());
        d.setProblema(vista.getTxtProblema().getText());
        d.setDetalle(vista.getTxtDetalle().getText());
        detalles.add(d);
        DefaultTableModel tablaA = (DefaultTableModel) vista.getTblDetalle().getModel();
        tablaA.setNumRows(0);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        System.out.println("--DETATALLES CREADOS\n" + detalles.toString());
        detalles.stream().forEach(t -> {

            tablaA.addRow(new Object[ncols]);
            vista.getTblDetalle().setValueAt(t.getCod_producto(), i.value, 0);
            vista.getTblDetalle().setValueAt(t.getProducto(), i.value, 1);
            vista.getTblDetalle().setValueAt(t.getProblema(), i.value, 2);
            vista.getTblDetalle().setValueAt(t.getDetalle(), i.value, 3);

            i.value++;

        });
        vista.getDlgInformacion().setVisible(false);



    }
    
    public void CargarClienteGarant() {
        try {
            int fila = vista.getTblProducto1().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblProducto().getModel();
            vista.getTxtNombre().setText(String.valueOf(model.getValueAt(fila, 0)));
            vista.getTxtDireccion().setText(String.valueOf(model.getValueAt(fila, 1)));
            vista.getTxtCedula().setText(String.valueOf(model.getValueAt(fila, 2)));
            vista.getTxtTelefono().setText(String.valueOf(model.getValueAt(fila, 3)));
            vista.getTxtDescuento().setText(String.valueOf(model.getValueAt(fila, 4)));
            vista.getDlgListaC().setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO HA SELECCIONADO NINGUN CLIENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Dialogo(){
        vista.getTxtNGarant().setText(modeloE.NuevaRprc());
        vista.getDlgGarantia().setVisible(true);
        vista.getDlgGarantia().setSize(1225, 705);
        
    }
    
    public void EliminarDetalle() {

        try {
            int fila = vista.getTblDetalle().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblDetalle().getModel();
            Modelo_Det_Garantia m1 = new Modelo_Det_Garantia();

            m1.setCodigo_garantia(vista.getTxtNFact().getText());
            m1.setCod_producto(Integer.parseInt(model.getValueAt(fila, 0).toString()));
            m1.setProducto(model.getValueAt(fila, 1).toString());
            m1.setProblema(model.getValueAt(fila, 2).toString());
            m1.setDetalle(model.getValueAt(fila, 3).toString());
            int op = JOptionPane.showConfirmDialog(null, "SEGURO QUE DESEA ELIMINAR EL PRODUCTO:"
                    + "\nProducto: " + model.getValueAt(fila, 0)
                    + "\nProblema: " + model.getValueAt(fila, 2));

            if (op == 0) {
                System.out.println("\n--DETALLE CREADO PARA COMPARAR\n" + m1.toString());

                for (int i = 0; i < detalles.size(); i++) {
                    if (detalles.get(i).getCod_producto() == m1.getCod_producto()) {
                        System.out.println("--DETALLE ELIMINADO\n" + detalles.get(i).toString());
                        detalles.remove(i);
                        RecargarDetalles();
                        break;
                    }
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR DETALLE", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        
        
    }
    
    
    public void RecargarDetalles() {

        DefaultTableModel tablaA = (DefaultTableModel) vista.getTblDetalle().getModel();
        tablaA.setNumRows(0);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        detalles.stream().forEach(t -> {

            tablaA.addRow(new Object[ncols]);
            vista.getTblDetalle().setValueAt(t.getCod_producto(), i.value, 0);
            vista.getTblDetalle().setValueAt(t.getProducto(), i.value, 1);
            vista.getTblDetalle().setValueAt(t.getProblema(), i.value, 2);
            vista.getTblDetalle().setValueAt(t.getDetalle(), i.value, 3);


            i.value++;

        });

        

    }

    public void BorrarDatosRepar() {

        vista.getTxtNombre().setText("");
        vista.getDtcFecha().setDate(null);
        vista.getDtcFecha1().setDate(null);
        vista.getTxtDireccion().setText("");
        vista.getTxtCedula().setText("");
        vista.getTxtTelefono().setText("");
        vista.getTxtDescuento().setText("");
  

        
        DefaultTableModel tablaA = (DefaultTableModel) vista.getTblDetalle().getModel();
        tablaA.setNumRows(0);
        detalles.clear();
        if (detalles.size() == 0) {
            System.out.println("--TODOS LOS DETALLES FUERON BORRADOS");
            vista.getTxtNGarant().setText(modeloE.NuevaRprc());

        }

    }
    
    
    
}