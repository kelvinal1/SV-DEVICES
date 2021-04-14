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
import javax.swing.SpinnerModel;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelos.ConexionPG;
import modelos.Modelo_Cliente;
import modelos.Modelo_Det_Factura;
import modelos.Modelo_Enc_Factura;
import modelos.Modelo_Producto_V;
import modelos.clases_bases.cliente;
import modelos.clases_bases.det_factura;
import modelos.clases_bases.producto_v;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.ventanas.Ventana_Principal;
import vista.ventanas.Ventana_Ventas;

/**
 *
 * @author Kevin
 */
public class Controlador_Factura {

    private Modelo_Enc_Factura modeloEncabezado;
    private Modelo_Det_Factura modeloDetalle;
    private Ventana_Ventas vista;
    private List<Modelo_Det_Factura> detalles;

    public Controlador_Factura() {
    }

    public Controlador_Factura(Modelo_Enc_Factura modeloEncabezado, Modelo_Det_Factura modeloDetalle, Ventana_Ventas vista) {
        this.modeloEncabezado = modeloEncabezado;
        this.modeloDetalle = modeloDetalle;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void IniciarControl(String vendedor) {
        detalles = new ArrayList<>();
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

        vista.getBtnNuevoF().addActionListener(l -> Dialogo());
        vista.getBtnClientes().addActionListener(l -> CargarClientes(""));
        vista.getTxtCliente().addKeyListener(k1);
        vista.getBtnInsertCliente().addActionListener(l -> CargarClienteFact());
        vista.getBtnAnadirP().addActionListener(l -> CargarProductos(""));
        vista.getTxtBuscarProducto().addKeyListener(k2);
        vista.getBtnInsertarProducto().addActionListener(l -> CargarProCant());
        vista.getSpnCantidad().addChangeListener(l -> cargarSubtotalPro());
        vista.getBtnAnadirPro().addActionListener(l -> CargarProFact());
        vista.getBtnElminarP().addActionListener(l -> EliminarDetalle());
        vista.getTxtVendedor().setText(modeloEncabezado.ColocarAdmin(vendedor));
        modeloEncabezado.setCod_administrador(modeloEncabezado.Admin(vendedor));
        vista.getBtnGuardar().addActionListener(l->RegistrarFactura());

    }

    public void CargarClientes(String aguja) {
        vista.getDlgListaC().setVisible(true);
        vista.getDlgListaC().setSize(720, 320);
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
            vista.getTblProducto().setValueAt(t.getPrecio(), i.value, 2);
            vista.getTblProducto().setValueAt(t.getCant_stock(), i.value, 3);
            i.value++;
        });

    }

    public void Dialogo() {
        vista.getTxtNFact().setText(modeloEncabezado.NuevoFact());
        vista.getDlgFactura().setVisible(true);
        vista.getDlgFactura().setSize(1225, 705);
    }

    public void CargarClienteFact() {
        try {
            int fila = vista.getTblClientes().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblClientes().getModel();
            vista.getTxtNomApell().setText(String.valueOf(model.getValueAt(fila, 0)));
            vista.getTxtDireccion().setText(String.valueOf(model.getValueAt(fila, 1)));
            vista.getTxtCedula().setText(String.valueOf(model.getValueAt(fila, 2)));
            vista.getTxtTelefono().setText(String.valueOf(model.getValueAt(fila, 3)));
            vista.getTxtDescuento().setText(String.valueOf(model.getValueAt(fila, 4)));
            vista.getDlgListaC().setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO HA SELECCIONADO NINGUN CLIENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void CargarProCant() {
        try {

            int fila = vista.getTblProducto().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblProducto().getModel();
            vista.getLblNumCodigoP().setText(String.valueOf(model.getValueAt(fila, 0)));
            vista.getTxtProducto().setText(String.valueOf(model.getValueAt(fila, 1)));
            vista.getLblPrecioPU().setText(String.valueOf(model.getValueAt(fila, 2)));
            vista.getLblPrecioT().setText(String.valueOf(model.getValueAt(fila, 2)));

            vista.getDlgListaP().setVisible(false);
            vista.getDlgAnadirP().setVisible(true);
            vista.getDlgAnadirP().setSize(620, 320);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO HA SELECCIONADO NINGUN PRODUCTO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarSubtotalPro() {
        Integer cantidad = (Integer) vista.getSpnCantidad().getValue();
        double precio = Double.parseDouble(vista.getLblPrecioPU().getText()) * cantidad;
        DecimalFormat df = new DecimalFormat("#.00");
        vista.getLblPrecioT().setText("" + df.format(precio));
    }

    public void CargarProFact() {

        Modelo_Det_Factura d = new Modelo_Det_Factura();
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
        System.out.println("--DETATALLES CREADOS\n" + detalles.toString());
        detalles.stream().forEach(t -> {

            tablaA.addRow(new Object[ncols]);
            vista.getTblDetalle().setValueAt(t.getCod_producto(), i.value, 0);
            vista.getTblDetalle().setValueAt(t.getProducto(), i.value, 1);
            vista.getTblDetalle().setValueAt(t.getPrecioU(), i.value, 2);
            vista.getTblDetalle().setValueAt(t.getCantidad(), i.value, 3);
            vista.getTblDetalle().setValueAt(t.getSubtotal(), i.value, 4);

            i.value++;

        });
        vista.getDlgAnadirP().setVisible(false);

        CalcularTotales();

    }

    public void CalcularTotales() {
        String iva = "0." + vista.getSpnIVA().getValue().toString();

        DecimalFormat df = new DecimalFormat("#.00");
        double subtotal = 0;

        for (int i = 0; i < detalles.size(); i++) {
            subtotal = subtotal + detalles.get(i).getSubtotal();
        }

        vista.getTxtSubtotal().setText("" + df.format(subtotal));

        double ivaT = subtotal * Double.parseDouble(iva);
        vista.getTxtIVA().setText("" + df.format(ivaT));
        String dc = vista.getTxtDescuento().getText();

        if (dc.length() == 1) {
            dc = "0.0" + dc;
        } else if (dc.length() == 2) {
            dc = "0." + dc;
        }
        double TOTAL = (subtotal + ivaT);
        double TOTALdescuento = (subtotal + ivaT) - (TOTAL * Double.parseDouble(dc));

        vista.getTxtTotal().setText(df.format(TOTALdescuento));
        vista.getTxtTotalSN().setText(df.format(TOTAL));

    }

    public void EliminarDetalle() {

        try {
            int fila = vista.getTblDetalle().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) vista.getTblDetalle().getModel();
            Modelo_Det_Factura m1 = new Modelo_Det_Factura();

            m1.setCodigo_factura(vista.getTxtNFact().getText());
            m1.setCod_producto(Integer.parseInt(model.getValueAt(fila, 0).toString()));
            m1.setProducto(model.getValueAt(fila, 1).toString());
            m1.setPrecioU(Double.parseDouble(model.getValueAt(fila, 2).toString()));
            m1.setCantidad(Integer.parseInt(model.getValueAt(fila, 3).toString()));
            m1.setSubtotal(Double.parseDouble(model.getValueAt(fila, 4).toString()));
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
            vista.getTblDetalle().setValueAt(t.getPrecioU(), i.value, 2);
            vista.getTblDetalle().setValueAt(t.getCantidad(), i.value, 3);
            vista.getTblDetalle().setValueAt(t.getSubtotal(), i.value, 4);

            i.value++;

        });

        CalcularTotales();

    }

    public void RegistrarFactura() {

        Modelo_Enc_Factura encabezado = new Modelo_Enc_Factura();

        encabezado.setCodigo_fact(vista.getTxtNFact().getText());
        encabezado.setCod_cliente(encabezado.Cliente(vista.getTxtCedula().getText()));
        encabezado.setCod_administrador(modeloEncabezado.getCod_administrador());
        Instant instante = vista.getDtcFecha().getDate().toInstant();
        ZoneId zi = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instante, zi);
        java.sql.Date fechaN = java.sql.Date.valueOf(zdt.toLocalDate());
        encabezado.setFechaEmision(fechaN);
        encabezado.setDescuento(Double.parseDouble(vista.getTxtDescuento().getText()));
        encabezado.setSubtotal(Double.parseDouble(vista.getTxtSubtotal().getText()));
        encabezado.setTotal_iva(Double.parseDouble(vista.getTxtIVA().getText()));
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
                JOptionPane.showMessageDialog(null, "FACTURA CREADA");
                Imprimir(encabezado);
            }
        }else{
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR ENCABEZADO FACTURA","ERROR ENCABEZADO",JOptionPane.ERROR_MESSAGE);
        }
        
        

    }
    
    
    
    public void Imprimir(Modelo_Enc_Factura enc){
        ConexionPG con = new ConexionPG();
        
        try {
            JasperReport jr = (JasperReport)JRLoader.loadObject(getClass().getResource("/vista/reportes/ReporteFactura.jasper"));
           
            Map<String,Object> parametros= new HashMap<String, Object>();
            parametros.put("factura","%"+vista.getTxtNFact().getText()+"%");
            parametros.put("num_Fact",enc.getCodigo_fact());
            parametros.put("cedula",vista.getTxtCedula().getText());
            parametros.put("fecha",enc.getFechaEmision());
            parametros.put("cliente",vista.getTxtNomApell().getText());
            parametros.put("telefono",vista.getTxtTelefono().getText());
            parametros.put("vendedor",vista.getTxtVendedor().getText());
            parametros.put("direccion",vista.getTxtDireccion().getText());
            parametros.put("descuento",Double.parseDouble(vista.getTxtDescuento().getText()));
            parametros.put("iva",enc.getTotal_iva());
            parametros.put("total",enc.getTotal());
            parametros.put("subtotal",enc.getSubtotal());
            
            
            
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros,con.getCon());
            JasperViewer jv = new JasperViewer(jp);
            jv.setVisible(true);
            
            
        } catch (JRException ex) {
            Logger.getLogger(Controlador_Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
