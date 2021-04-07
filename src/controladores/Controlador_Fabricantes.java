/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelos.Modelo_Fabricante;
import modelos.clases_bases.fabricante;
import vista.ventanas.Ventana_Fabricantes;

/**
 *
 * @author Kevin
 */
public class Controlador_Fabricantes {

    private Modelo_Fabricante modelo;
    private Ventana_Fabricantes vista;

    public Controlador_Fabricantes() {
    }

    public Controlador_Fabricantes(Modelo_Fabricante modelo, Ventana_Fabricantes vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        Listar("");
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
                Listar(vista.getTxtBuscar().getText());
            }
            
        };
        vista.getBtnNuevoF().addActionListener(l -> Dialogo(1));
        vista.getBtnGuardar().addActionListener(l -> Crear_Fabricante());
        vista.getBtnModificar().addActionListener(l->Modificar_Fabricante());
        vista.getBtnActualizar().addActionListener(l->Listar(""));
        vista.getBtnCancelar().addActionListener(l->Cancelar());
        vista.getBtnEditarF().addActionListener(l->CargarCampos());
        vista.getTxtBuscar().addKeyListener(k);
        vista.getBtnEliminarF().addActionListener(l->EliminarAdmin());
        
    }

    
    
    public void Listar(String aguja){
        List<fabricante> lista = modelo.LISTAR(aguja);
        DefaultTableModel tablaA = (DefaultTableModel) vista.getTblFabricante().getModel();
        tablaA.setNumRows(0);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(f->{
           tablaA.addRow(new Object[ncols]);
           vista.getTblFabricante().setValueAt(f.getCodigo(), i.value,0);
           vista.getTblFabricante().setValueAt(f.getNombre(), i.value,1);
           vista.getTblFabricante().setValueAt(f.getDireccion(), i.value,2);
           vista.getTblFabricante().setValueAt(f.getTelefono(), i.value,3);
           i.value++;
        });
        
        vista.getjLabel3().setText(""+vista.getTblFabricante().getRowCount());
        
        
    }
    
    public void Crear_Fabricante() {
        Modelo_Fabricante m = new Modelo_Fabricante();
        m.setNombre(vista.getTxtNombre().getText());
        m.setTelefono(vista.getTxtTelf().getText());
        m.setDireccion(vista.getTxtDirec().getText());

        if (m.CREAR()) {
            JOptionPane.showMessageDialog(vista, "Se ha creado satisfactoriamente el fabricante");
            Limpiar();
            vista.getDlgFabricante().setVisible(false);
            Listar("");
        } else {
            JOptionPane.showMessageDialog(vista, "Error al crear el fabricante", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void Modificar_Fabricante() {
        Modelo_Fabricante m = new Modelo_Fabricante();
        m.setCodigo(Integer.parseInt(vista.getLblCodigo().getText()));
        m.setNombre(vista.getTxtNombre().getText());
        m.setTelefono(vista.getTxtTelf().getText());
        m.setDireccion(vista.getTxtDirec().getText());

        if (m.MODIFICAR()) {
            JOptionPane.showMessageDialog(vista, "Se ha modificado satisfactoriamente el fabricante");
            vista.getDlgFabricante().setVisible(false);
            Limpiar();
            Listar("");
        } else {
            JOptionPane.showMessageDialog(vista, "Error al modificar el fabricante", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void EliminarAdmin() {
        try {
            int fila = vista.getTblFabricante().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblFabricante().getModel();
            int op = JOptionPane.showConfirmDialog(vista, "\tDesea eliminar este Fabricante:\n"
                    + "Id: " + model.getValueAt(fila, 0).toString() + "\n"
                    + "Nombre: " + model.getValueAt(fila, 1).toString() + "\n"
                    + "Direccion: " + model.getValueAt(fila, 2).toString() + "\n"
                    + "Telefono: " + model.getValueAt(fila, 3).toString());
            if (op == 0) {
                Modelo_Fabricante m = new Modelo_Fabricante();
                m.setCodigo(Integer.parseInt(model.getValueAt(fila, 0).toString()));
                m.setNombre(model.getValueAt(fila, 1).toString());
                m.setDireccion(model.getValueAt(fila, 2).toString());
                m.setTelefono(model.getValueAt(fila, 3).toString());
                if (m.ELIMINAR()) {
                    JOptionPane.showMessageDialog(vista, "SE ELIMINO EL FABRICANTE");
                    Listar("");
                } else {
                    JOptionPane.showMessageDialog(vista,"NO SE LOGRO ELIMINAR EL FABRICANTE","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No ha seleccionado ninguna fila para eliminarla");
        }

    }

    public void Dialogo(int op) {
        OcultarOpciones();
        if (op == 1) {
            vista.getDlgFabricante().setVisible(true);
            vista.getDlgFabricante().setSize(665, 318);
            vista.getBtnGuardar().setVisible(true);
            vista.getLblNCodigo().setVisible(false);
            vista.getLblCodigo().setVisible(false);
        } else if (op == 2) {
            vista.getDlgFabricante().setVisible(true);
            vista.getDlgFabricante().setSize(644, 318);
            vista.getBtnModificar().setVisible(true);
            vista.getLblNCodigo().setVisible(true);
            vista.getLblCodigo().setVisible(true);
        }

    }

    public void OcultarOpciones() {
        vista.getBtnGuardar().setVisible(false);
        vista.getBtnModificar().setVisible(false);
    }
    
    public void Cancelar(){
        Limpiar();
        vista.getDlgFabricante().setVisible(false);
        
    }
    
    public void Limpiar(){
        vista.getTxtNombre().setText("");
        vista.getTxtDirec().setText("");
        vista.getTxtTelf().setText("");
    }
    
    public void  CargarCampos(){
        try {
            int fila= vista.getTblFabricante().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblFabricante().getModel();
            vista.getLblCodigo().setText(String.valueOf(model.getValueAt(fila, 0)));
            vista.getTxtNombre().setText(String.valueOf(model.getValueAt(fila, 1)));
            vista.getTxtDirec().setText(String.valueOf(model.getValueAt(fila, 2)));
            vista.getTxtTelf().setText(String.valueOf(model.getValueAt(fila, 3)));
            Dialogo(2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "SELECCIONE UNA FILA POR FAVOR ");
           
        }
    }
    
    
    
    
    

}
