/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelos.ConexionPG;
import modelos.Modelo_Cliente;
import modelos.Modelo_Det_Garantia;
import modelos.Modelo_Enc_Garantia;
import modelos.Modelo_Producto_V;
import modelos.clases_bases.cliente;
import modelos.clases_bases.enc_garantia;
import modelos.clases_bases.producto_v;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
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

    public void IniciarControl(String vendedor) {
        KeyListener k1 = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                CargarGarantias(vista.getTxtBuscar().getText());
            }
        };
        detalles = new ArrayList<>();
        modeloE.setCod_admin(modeloE.Admin(vendedor));
        vista.getTxtVendedor().setText(modeloE.ColocarAdmin(vendedor));
        vista.getBtnActualizar().addActionListener(l -> CargarGarantias(""));
        vista.getBtnGuardar1().addActionListener(l -> CargarClientes(""));
        vista.getBtnAnadirP().addActionListener(l -> CargarProductos(""));
        vista.getBtnNuevoG().addActionListener(l -> Dialogo(1));
        vista.getBtnInsertCliente().addActionListener(l -> CargarClienteRepar());
        vista.getBtnGuardar3().addActionListener(l -> CargarProCant());
        vista.getBtnInsertarInfo().addActionListener(l -> CargarProGarant());
        vista.getBtnElminarP().addActionListener(l -> EliminarDetalle());
        vista.getBtnGuardar().addActionListener(l -> RegistrarGarantia());
        vista.getBtnCancelar().addActionListener(l->Dialogo(2));
        vista.getTxtBuscar().addKeyListener(k1);
        vista.getBtnImprimir().addActionListener(l->Imprimir2());
        vista.getBtnEliminarG().addActionListener(l->EliminarGarantia());
    }

    public void RegistrarGarantia() {

        if (validacion()) {

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
                    int op = JOptionPane.showConfirmDialog(null, "Desea imprimir esta garantia");
                    if (op == 0) {
                        Imprimir(encabezado);
                        BorrarDatosGarantia();
                    } else {
                        BorrarDatosGarantia();
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL CREAR ENCABEZADO GARANTIA", "ERROR ENCABEZADO", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public void CargarGarantias(String aguja) {
        DefaultTableModel tablaA;

        tablaA = (DefaultTableModel) vista.getTblReparacion().getModel();
        tablaA.setNumRows(0);
        List<enc_garantia> lista = modeloE.LISTAR(aguja);
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

    public void Dialogo(int op) {
        if (op == 1) {
            vista.getTxtNGarant().setText(modeloE.NuevaRprc());
            vista.getDlgGarantia().setVisible(true);
            vista.getDlgGarantia().setSize(1225, 705);

        } else if (op == 2) {
            BorrarDatosGarantia();
            vista.getDlgGarantia().setVisible(true);
        }

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

    public void BorrarDatosGarantia() {

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
    
    public void EliminarGarantia() {
        try {
            int fila = vista.getTblReparacion().getSelectedRow();
            int op = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar la reparacion:"
                    + "\nReparacion: " + vista.getTblReparacion().getValueAt(fila, 0));
            if (op == 0) {
                Modelo_Det_Garantia d = new Modelo_Det_Garantia();
                d.setCodigo_garantia(vista.getTblReparacion().getValueAt(fila, 0).toString());
                Modelo_Enc_Garantia e = new Modelo_Enc_Garantia();
                e.setCodigo_garantia(d.getCodigo_garantia());

                if (d.ELIMINAR()) {
                    if (e.ELIMINAR()) {
                        JOptionPane.showMessageDialog(null, "REPARACION ELIMINADA");
                        CargarGarantias("");
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


    public void Imprimir(Modelo_Enc_Garantia enc) {
        ConexionPG con = new ConexionPG();

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/reportes/ReporteGarantia.jasper"));

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("garantia", vista.getTxtNFact().getText());
            parametros.put("num_garant", enc.getCodigo_garantia());
            parametros.put("cedula", vista.getTxtCedula().getText());
            parametros.put("fechaE", enc.getFecha_emision());
            parametros.put("fechaS", enc.getFecha_retiro());
            parametros.put("cliente", vista.getTxtNombre().getText());
            parametros.put("telefono", vista.getTxtTelefono().getText());
            parametros.put("vendedor", vista.getTxtVendedor().getText());
            parametros.put("direccion", vista.getTxtDireccion().getText());
            parametros.put("descuento", Double.parseDouble(vista.getTxtDescuento().getText()));
            parametros.put("estado", enc.getEstado());

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
            jv.show();

        } catch (JRException ex) {
            Logger.getLogger(Controlador_Garantias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validacion() {
        boolean verificar = true;

        if (vista.getDtcFecha().getDate() == null) {
            verificar = false;
            JOptionPane.showMessageDialog(null, "NO HA INGRESADO FECHA EMISION", "FECHA", JOptionPane.ERROR_MESSAGE);
        }

        if (vista.getDtcFecha1().getDate() == null) {
            verificar = false;
            JOptionPane.showMessageDialog(null, "NO HA INGRESADO FECHA RETIRO", "FECHA", JOptionPane.ERROR_MESSAGE);
        }

        if (vista.getTxtNombre().getText().equals("")) {
            verificar = false;
            JOptionPane.showMessageDialog(null, "NO HA SELECCIONADO CLIENTE", "CLIENTE", JOptionPane.ERROR_MESSAGE);
        }

        if (vista.getTblDetalle().getRowCount() == 0) {
            verificar = false;
            JOptionPane.showMessageDialog(null, "NO HAY DETALLES INSERTADOS", "DETALLE", JOptionPane.ERROR_MESSAGE);
        }

        return verificar;
    }
    
    public void Imprimir2() {
        ConexionPG con = new ConexionPG();

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/reportes/reporte_Garantias.jasper"));

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
