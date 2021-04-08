/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelos.Modelo_Cliente;
import modelos.Modelo_Det_Factura;
import modelos.Modelo_Enc_Factura;
import modelos.clases_bases.cliente;
import vista.ventanas.Ventana_Ventas;

/**
 *
 * @author Kevin
 */
public class Controlador_Factura {

    private Modelo_Enc_Factura modeloEncabezado;
    private Modelo_Det_Factura modeloDetalle;
    private Ventana_Ventas vista;

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
        vista.getBtnNuevoF().addActionListener(l->Dialogo());
        vista.getBtnClientes().addActionListener(l->CargarClientes(""));
        vista.getTxtCliente().addKeyListener(k1);
        vista.getBtnInsertCliente().addActionListener(l->CargarClienteFact());

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
    
    

}
