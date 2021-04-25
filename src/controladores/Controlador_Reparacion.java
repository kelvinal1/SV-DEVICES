/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelos.ConexionPG;
import modelos.Modelo_Cliente;
import modelos.Modelo_Det_Reparacion;
import modelos.Modelo_Enc_Reparacion;
import modelos.Modelo_Producto_A;
import modelos.clases_bases.cliente;
import modelos.clases_bases.enc_reparacion;
import modelos.clases_bases.producto_a;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
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
        CargarReparaciones("");
    }

    
    
    
    public void IniciarControl(String vendedor){
        detalles= new ArrayList<>();
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
                CargarProductos(vista.getTxtProducto().getText());
            }
        };
        
        
        KeyListener k3 = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                CargarReparaciones(vista.getTxtBuscar().getText());
            }
        };
        
        vista.getBtnNuevoR().addActionListener(l->Dialogo(1));
        vista.getTxtVendedor().setText(modeloER.ColocarAdmin(vendedor));
        modeloER.setCod_admin(modeloER.Admin(vendedor));
        vista.getBtnAnadirP().addActionListener(l->CargarProductos(""));
        vista.getBtnGuardar1().addActionListener(l->CargarClientes(""));
        vista.getTxtCliente().addKeyListener(k1);
        vista.getTxtProducto().addKeyListener(k2);
        vista.getBtnInsertCliente().addActionListener(l->CargarClienteFact());
        vista.getBtnGuardar3().addActionListener(l->InsertarProducto());
        vista.getBtnElminarP().addActionListener(l->EliminarDetalle());
        vista.getBtnGuardar().addActionListener(l->RegistrarReparacion());
        vista.getTxtBuscar().addKeyListener(k3);
        vista.getBtnImprimirR().addActionListener(l->Imprimir2());
        vista.getBtnEliminarR().addActionListener(l->EliminarReparacion());
    }
    
    public void CargarReparaciones(String aguja){
        
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
    
    public void RegistrarReparacion() {

        Modelo_Enc_Reparacion encabezado = new Modelo_Enc_Reparacion();

        encabezado.setCodigo_reparacion(vista.getTxtNRep().getText());
        encabezado.setCod_cliente(encabezado.Cliente(vista.getTxtCedula().getText()));
        encabezado.setCod_admin(modeloER.getCod_admin());
        Instant instante = vista.getDtcFecha().getDate().toInstant();
        ZoneId zi = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instante, zi);
        java.sql.Date fechaE = java.sql.Date.valueOf(zdt.toLocalDate());
        encabezado.setFecha_Emision(fechaE);
        
        Instant instante2 = vista.getDtcFecha1().getDate().toInstant();
        encabezado.setEstado(vista.getCmbEstado().getSelectedItem().toString());
        ZonedDateTime zdt2 = ZonedDateTime.ofInstant(instante2, zi);
        java.sql.Date fechaS = java.sql.Date.valueOf(zdt2.toLocalDate());
        
        encabezado.setFecha_retiro(fechaS);
        
        encabezado.setDescuento(Double.parseDouble(vista.getTxtDescuento().getText()));
        encabezado.setSubtotal(Double.parseDouble(vista.getTxtSubtotal().getText()));
        encabezado.setTotal(Double.parseDouble(vista.getTxtTotal().getText()));
        
        
        if (encabezado.CREAR()) {
            int rep=0;
            for (int i = 0; i < detalles.size(); i++) {
                if (detalles.get(i).CREAR()) {
                    rep++;
                }
                
            }
            System.out.println("rep:"+rep);
            System.out.println("detalle: "+detalles.size());
            if (rep==detalles.size()) {
                JOptionPane.showMessageDialog(null, "REPARACION CREADA");
                CargarReparaciones("");
                int op = JOptionPane.showConfirmDialog(null,"Desea imprimir la reparacion");
                if (op==0) {
                    Imprimir(encabezado);
                    BorrarDatosRepar();
                }else{
                    BorrarDatosRepar();
                }
                
               
            }
        }else{
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR ENCABEZADO FACTURA","ERROR ENCABEZADO",JOptionPane.ERROR_MESSAGE);
        }
        
        

    }
    
    public void Dialogo(int op) {
        BorrarDatosRepar();
        if (op==1) {
            
            vista.getDlgReparacion().setVisible(true);
            
            vista.getDlgReparacion().setSize(1225, 705);
        }else if(op==2){
            
        }
        
    }
    
    public void BorrarDatosRepar() {

        vista.getTxtNombre().setText("");
        vista.getDtcFecha().setDate(null);
        vista.getDtcFecha1().setDate(null);
        vista.getTxtDireccion().setText("");
        vista.getTxtCedula().setText("");
        vista.getTxtTelefono().setText("");
        vista.getTxtDescuento().setText("");
        vista.getTxtSubtotal().setText("");

        vista.getTxtTotal().setText("");
        DefaultTableModel tablaA = (DefaultTableModel) vista.getTblDetalle().getModel();
        tablaA.setNumRows(0);
        detalles.clear();
        if (detalles.size() == 0) {
            System.out.println("--TODOS LOS DETALLES FUERON BORRADOS");
            vista.getTxtNRep().setText(modeloER.NuevoMant());

        }

    }
    
    public void CargarClientes(String aguja) {
        vista.getDlgListaC().setVisible(true);
        vista.getDlgListaC().setSize(720, 320);
        Modelo_Cliente mc = new Modelo_Cliente();
        List<cliente> lista = mc.VistaClientes(aguja);
        DefaultTableModel tablaA = (DefaultTableModel) vista.getTblCliente().getModel();
        tablaA.setNumRows(0);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(t -> {
            tablaA.addRow(new Object[ncols]);
            vista.getTblCliente().setValueAt(t.getCliente(), i.value, 0);
            vista.getTblCliente().setValueAt(t.getDirec(), i.value, 1);
            vista.getTblCliente().setValueAt(t.getCedula(), i.value, 2);
            vista.getTblCliente().setValueAt(t.getTelef(), i.value, 3);
            vista.getTblCliente().setValueAt(t.getDescuent(), i.value, 4);
            i.value++;
        });
    }
    
    public void CargarClienteFact() {
        try {
            int fila = vista.getTblCliente().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblCliente().getModel();
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
        Modelo_Producto_A mp = new Modelo_Producto_A();
        List<producto_a> lista = mp.VistaProductos(aguja);
        DefaultTableModel tablaA = (DefaultTableModel) vista.getTblProducto().getModel();
        tablaA.setNumRows(0);
        int ncols = tablaA.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(t -> {
            tablaA.addRow(new Object[ncols]);
            vista.getTblProducto().setValueAt(t.getCod_prod_a(), i.value, 0);
            vista.getTblProducto().setValueAt(t.getNombre(), i.value, 1);
            vista.getTblProducto().setValueAt(t.getCantidad(), i.value, 2);
            vista.getTblProducto().setValueAt(t.getCosto(), i.value, 3);
            vista.getTblProducto().setValueAt(t.getProblema(), i.value,4);
            vista.getTblProducto().setValueAt(t.getDetalle(), i.value, 5);
            i.value++;
        });

    }
    
    public void InsertarProducto() {
        try {
            DecimalFormat format = new DecimalFormat("#.00");
            int fila = vista.getTblProducto().getSelectedRow();
            double subtotal= Double.parseDouble(vista.getTblProducto().getValueAt(fila, 3).toString())*Double.parseDouble(vista.getTblProducto().getValueAt(fila, 2).toString());
            Modelo_Det_Reparacion m = new Modelo_Det_Reparacion();
            
            m.setCodigo_reparacion(vista.getTxtNRep().getText());
            m.setCod_producto(Integer.parseInt(vista.getTblProducto().getValueAt(fila, 0).toString()));
            m.setProducto(vista.getTblProducto().getValueAt(fila, 1).toString());
            m.setCosto(Double.parseDouble(vista.getTblProducto().getValueAt(fila, 3).toString()));;
            m.setProblema(vista.getTblProducto().getValueAt(fila, 4).toString());
            m.setDetalle(vista.getTblProducto().getValueAt(fila, 5).toString());
            m.setSubtotal(subtotal);
            DefaultTableModel model = (DefaultTableModel) vista.getTblDetalle().getModel();
            
            model.addRow(new Object[]{
                m.getCod_producto(),
                m.getProducto(),
                m.getCosto(),
                m.getProblema(),
                m.getDetalle(),
                m.getSubtotal()
            });
            
            
            
          
            System.out.println("--DETALLE CREADO "+m.toString());
                    

            detalles.add(m);
            vista.getDlgListaP().setVisible(false);
            CalcularTotales();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO HA ELEGIDO NINGUN PRODUCTO","ERROR",JOptionPane.ERROR_MESSAGE);
        
        }
    }
    
    public void CalcularTotales() {

        DecimalFormat df = new DecimalFormat("#.00");
        double subtotal = 0;

        for (int i = 0; i < detalles.size(); i++) {
            subtotal = subtotal + detalles.get(i).getSubtotal();
        }

        vista.getTxtSubtotal().setText("" + df.format(subtotal));

      

        String dc = vista.getTxtDescuento().getText();

        if (dc.length() == 1) {
            dc = "0.0" + dc;
        } else if (dc.length() == 2) {
            dc = "0." + dc;
        }
        
        double totalSN = subtotal;
        
        double total= subtotal-(subtotal*Double.parseDouble(dc));
        vista.getTxtTotal().setText(""+total);

    }
    
    public void EliminarReparacion() {
        try {
            int fila = vista.getTblReparacion().getSelectedRow();
            int op = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar la factura:"
                    + "\nReparacion: " + vista.getTblReparacion().getValueAt(fila, 0)
                    + "\nSubtotal: " + vista.getTblReparacion().getValueAt(fila, 7)
                    + "\nTotal: " + vista.getTblReparacion().getValueAt(fila, 8));
            if (op == 0) {
                Modelo_Det_Reparacion d = new Modelo_Det_Reparacion();
                d.setCodigo_reparacion(vista.getTblReparacion().getValueAt(fila, 0).toString());
                Modelo_Enc_Reparacion e = new Modelo_Enc_Reparacion();
                e.setCodigo_reparacion(d.getCodigo_reparacion());

                if (d.ELIMINAR()) {
                    if (e.ELIMINAR()) {
                        JOptionPane.showMessageDialog(null, "REPARACION ELIMINADA");
                        CargarReparaciones("");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR AL BORRAR ENCABEZADO DE REPARACION", "ERROR", JOptionPane.ERROR_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR AL BORRAR DETALLE DE REPARACION", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO HA SELECCIONADO NINGUNA FILA ", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public void Imprimir(Modelo_Enc_Reparacion enc) {
        ConexionPG con = new ConexionPG();

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/reportes/ReporteMant.jasper"));

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("reparacion", vista.getTxtNRep().getText());
            parametros.put("num_repr", enc.getCodigo_reparacion());
            parametros.put("cedula", vista.getTxtCedula().getText());
            parametros.put("fecha_e", enc.getFecha_Emision());
            parametros.put("fecha_r", enc.getFecha_retiro());
            parametros.put("cliente", vista.getTxtNombre().getText());
            parametros.put("telefono", vista.getTxtTelefono().getText());
            parametros.put("vendedor", vista.getTxtVendedor().getText());
            parametros.put("direccion", vista.getTxtDireccion().getText());
            parametros.put("descuento", Double.parseDouble(vista.getTxtDescuento().getText()));
            parametros.put("estado", enc.getEstado());
            parametros.put("total", enc.getTotal());
            parametros.put("subtotal", enc.getSubtotal());

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
            jv.show();

        } catch (JRException ex) {
            Logger.getLogger(Controlador_Reparacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void EliminarDetalle() {

        try {
            int fila = vista.getTblDetalle().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblDetalle().getModel();
            Modelo_Det_Reparacion m1 = new Modelo_Det_Reparacion();

            m1.setCodigo_reparacion(vista.getTxtNRep().getText());
            m1.setCod_producto(Integer.parseInt(model.getValueAt(fila, 0).toString()));
            m1.setProducto(model.getValueAt(fila, 1).toString());
            m1.setSubtotal(Double.parseDouble(model.getValueAt(fila, 5).toString()));
           
            int op = JOptionPane.showConfirmDialog(null, "SEGURO QUE DESEA ELIMINAR EL PRODUCTO:"
                    + "\nCodigo: " + model.getValueAt(fila, 0)
                    + "\nProducto: " + model.getValueAt(fila, 1));

            if (op == 0) {
                System.out.println("\n--DETALLE CREADO PARA COMPARAR\n" + m1.toString());

                for (int i = 0; i < detalles.size(); i++) {
                    if (detalles.get(i).getCod_producto() == m1.getCod_producto() && detalles.get(i).getSubtotal() == m1.getSubtotal()) {
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
            vista.getTblDetalle().setValueAt(t.getCosto(), i.value, 2);
            vista.getTblDetalle().setValueAt(t.getProblema(), i.value, 3);
            vista.getTblDetalle().setValueAt(t.getDetalle(), i.value, 4);
            vista.getTblDetalle().setValueAt(t.getSubtotal(), i.value, 5);
            

            i.value++;

        });

        CalcularTotales();

    }
    
    public void Imprimir2() {
        ConexionPG con = new ConexionPG();

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/reportes/reporte_Reparaciones.jasper"));

            String aguja = vista.getTxtBuscar().getText();
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("aguja", "%" + aguja + "%");

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
            jv.show();

        } catch (JRException ex) {
            Logger.getLogger(Controlador_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
