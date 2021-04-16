/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelos.Modelo_Det_Reparacion;
import modelos.Modelo_Enc_Reparacion;
import modelos.clases_bases.enc_reparacion;
import vista.ventanas.Ventana_Reparaciones;


/**
 *
 * @author Kevin
 */
public class Controlador_Reparacion {
    
    private Modelo_Enc_Reparacion modeloER;
    private Modelo_Det_Reparacion modeloDR;
    private Ventana_Reparaciones vista;
    private List<Modelo_Det_Reparacion> detalles ;

    public Controlador_Reparacion() {
    }

    public Controlador_Reparacion(Modelo_Enc_Reparacion modeloER, Modelo_Det_Reparacion modeloDR, Ventana_Reparaciones vista) {
        this.modeloER = modeloER;
        this.modeloDR = modeloDR;
        this.vista = vista;
        vista.setVisible(true);
        CargarFacturas("");
    }

    
    
    
    public void IniciarControl(String vendedor){
        vista.getBtnNuevoR().addActionListener(l->Dialogo());
        vista.getTxtVendedor().setText(modeloER.ColocarAdmin(vendedor));
        modeloER.setCod_admin(modeloER.Admin(vendedor));
        
        
        
    }
    
    public void CargarFacturas(String aguja){
        
        List<enc_reparacion> lista = modeloER.LISTAR(aguja);
        DefaultTableModel tablaA = (DefaultTableModel) vista.getTblReparacion().getModel();
        tablaA.setNumRows(0);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(f->{
           tablaA.addRow(new Object[ncols]);
           vista.getTblReparacion().setValueAt(f.getCodigo_reparacion(), i.value,0);
           vista.getTblReparacion().setValueAt(f.getCliente(), i.value,1);
           vista.getTblReparacion().setValueAt(f.getVendedor(), i.value,2);
           vista.getTblReparacion().setValueAt(f.getDescuento(), i.value,3);
           vista.getTblReparacion().setValueAt(f.getFecha_Emision(), i.value,4);
           vista.getTblReparacion().setValueAt(f.getFecha_retiro(), i.value,5);
           vista.getTblReparacion().setValueAt(f.getEstado(), i.value,6);
           vista.getTblReparacion().setValueAt(f.getSubtotal(), i.value,7);
           vista.getTblReparacion().setValueAt(f.getTotal(), i.value,8);
           i.value++;
        });
        
        vista.getjLabel3().setText(""+vista.getTblReparacion().getRowCount());
    
        
    }
    
    public void Dialogo() {
        vista.getTxtNRep().setText(modeloER.NuevoMant());
        vista.getDlgReparacion().setVisible(true);
        vista.getDlgReparacion().setSize(1225, 705);
    }
    
    
    
}
