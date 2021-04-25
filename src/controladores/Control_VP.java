/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.ConexionPG;
import modelos.Modelo_Admin;
import modelos.Modelo_Cliente;
import modelos.Modelo_Det_Factura;
import modelos.Modelo_Det_Garantia;
import modelos.Modelo_Det_Reparacion;
import modelos.Modelo_Enc_Factura;
import modelos.Modelo_Enc_Garantia;
import modelos.Modelo_Enc_Reparacion;
import modelos.Modelo_Fabricante;
import modelos.Modelo_Producto_A;
import modelos.Modelo_Producto_V;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.ventanas.Inicio_Sesion;
import vista.ventanas.Ventana_Admins;
import vista.ventanas.Ventana_Clientes;
import vista.ventanas.Ventana_Fabricantes;
import vista.ventanas.Ventana_Garantias;
import vista.ventanas.Ventana_Principal;
import vista.ventanas.Ventana_Productos_A;
import vista.ventanas.Ventana_Productos_V;
import vista.ventanas.Ventana_Reparaciones;
import vista.ventanas.Ventana_Ventas;

/**
 *
 * @author Kevin
 */
public class Control_VP {

    Ventana_Principal vista;

    public Control_VP() {
    }

    public Control_VP(Ventana_Principal vista) {
        this.vista = vista;
        vista.setVisible(true);
    }

    public void Iniciar_Control() {
        vista.getBtnSalir().addActionListener(l->CerrarSesion());
        vista.getSmMantCliente().addActionListener(l->VentanaClientes());
        vista.getBtnClientes().addActionListener(l->VentanaClientes());
        vista.getSmMantAdmin().addActionListener(l->VentanaAdmins());
        vista.getBtnAdmins().addActionListener(l->VentanaAdmins());
        vista.getBtnFabricantes().addActionListener(l->VentanaFabricante());
        vista.getSmFabricantes().addActionListener(l->VentanaFabricante());
        vista.getSmMantProV().addActionListener(l->VentanaProductoV());
        vista.getBtnProductos().addActionListener(l->VentanaProductoV());
        vista.getBtnProductosA().addActionListener(l->VentanaProductoA());
        vista.getSmMantProA().addActionListener(l->VentanaProductoA());
        vista.getBtnVentas().addActionListener(l->VentanaVentas());
        vista.getSmMantVentas().addActionListener(l->VentanaVentas());
        vista.getBtnReparaciones().addActionListener(l->VentanaReparaciones());
        vista.getSmMantRep().addActionListener(l->VentanaReparaciones());
        vista.getSmMantGarant().addActionListener(l->VentanaGarantias());
        vista.getBtnGarantias().addActionListener(l->VentanaGarantias());
        vista.getSmReporteVentas().addActionListener(l->Imprimir());
        vista.getSmReporteRep().addActionListener(l->Imprimir2());
        vista.getSmReporteGarantia().addActionListener(l->Imprimir3());
        vista.getSmReporteCliente().addActionListener(l->Imprimir4());
        vista.getSmReportesFabricantes().addActionListener(l->Imprimir5());
        vista.getSmReporteProA().addActionListener(l->Imprimir6());
        vista.getSmReporteProV().addActionListener(l->Imprimir7());
        vista.getSmReporteAdmin().addActionListener(l->Imprimir8());

    }

    public void CerrarSesion() {
        
        int op = JOptionPane.showConfirmDialog(null, "Seguro que desea finalizar sesion?");
        if (op == 0) {
            vista.setVisible(false);
            Inicio_Sesion vent = new Inicio_Sesion();
            Controlador_IS con = new Controlador_IS(vent);
            con.IniciarControl();
        }
    }
    
    public void VentanaClientes(){
        
        Ventana_Clientes v = new Ventana_Clientes();
        Modelo_Cliente m = new Modelo_Cliente();
        Controlador_Cliente c = new Controlador_Cliente(m, v);
        c.Iniciar_Control();
        this.vista.getDpVentana().add(v);
        
    }
    
    
    public void VentanaAdmins(){
        Ventana_Admins v = new Ventana_Admins();
        Modelo_Admin m = new Modelo_Admin();
        Control_Administrador c = new Control_Administrador(m, v);
        c.Iniciar_Control();
        this.vista.getDpVentana().add(v);
    }
    
    
    public void VentanaFabricante(){
        Ventana_Fabricantes v = new Ventana_Fabricantes();
        Modelo_Fabricante m = new Modelo_Fabricante();
        Controlador_Fabricantes c = new Controlador_Fabricantes(m, v);
        c.IniciarControl();
        this.vista.getDpVentana().add(v);
    }
    
    public void VentanaProductoV(){
        Ventana_Productos_V v = new Ventana_Productos_V();
        Modelo_Producto_V m = new Modelo_Producto_V();
        Controlador_Producto_V c = new Controlador_Producto_V(m, v);
        c.IniciarControl();
        this.vista.getDpVentana().add(v);
    }
    
    public void VentanaProductoA(){
        Ventana_Productos_A v = new Ventana_Productos_A();
        Modelo_Producto_A m = new Modelo_Producto_A();
        Controlador_Producto_A c = new Controlador_Producto_A(m, v);
        c.IniciarControl();
        this.vista.getDpVentana().add(v);
    }
    
    public void VentanaVentas(){
        Ventana_Ventas v = new Ventana_Ventas();
        Modelo_Enc_Factura e = new Modelo_Enc_Factura();
        Modelo_Det_Factura d = new Modelo_Det_Factura();
        Controlador_Factura c = new Controlador_Factura(e, d, v);
        c.IniciarControl(vista.getLblUsuario().getText());
        this.vista.getDpVentana().add(v);
    }
    
    public void VentanaReparaciones(){
        Ventana_Reparaciones v = new Ventana_Reparaciones();
        Modelo_Enc_Reparacion e = new Modelo_Enc_Reparacion();
        Modelo_Det_Reparacion d = new Modelo_Det_Reparacion();
        Controlador_Reparacion c = new Controlador_Reparacion(e, d, v);
        c.IniciarControl(vista.getLblUsuario().getText());
        this.vista.getDpVentana().add(v);
    }
    
    public void VentanaGarantias(){
        Ventana_Garantias v = new Ventana_Garantias();
        Modelo_Enc_Garantia e = new Modelo_Enc_Garantia();
        Modelo_Det_Garantia d = new Modelo_Det_Garantia();
        Controlador_Garantias c = new Controlador_Garantias(e, d, v);
        c.IniciarControl(vista.getLblUsuario().getText());
        this.vista.getDpVentana().add(v);
    }

    
    public void Imprimir() {
        ConexionPG con = new ConexionPG();

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/reportes/reporteG_Factura.jasper"));

         
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
            jv.show();

        } catch (JRException ex) {
            Logger.getLogger(Controlador_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void Imprimir2() {
        ConexionPG con = new ConexionPG();

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/reportes/reporteG_Reparacion.jasper"));

         
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
            jv.show();

        } catch (JRException ex) {
            Logger.getLogger(Controlador_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Imprimir3() {
        ConexionPG con = new ConexionPG();

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/reportes/reporteG_Garantia.jasper"));

         
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
            jv.show();

        } catch (JRException ex) {
            Logger.getLogger(Controlador_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Imprimir4(){
        ConexionPG con = new ConexionPG();
        
        try {
            JasperReport jr = (JasperReport)JRLoader.loadObject(getClass().getResource("/vista/reportes/Reportes_Clientes.jasper"));
            
            String aguja= "";
            Map<String,Object> parametros= new HashMap<String, Object>();
            parametros.put("aguja", "%"+aguja+"%");
            
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros,con.getCon());
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
            jv.show();
            
            
        } catch (JRException ex) {
            Logger.getLogger(Controlador_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Imprimir5() {
        ConexionPG con = new ConexionPG();

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/reportes/Reportes_Fabricantes.jasper"));

            String aguja = "";
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
    
    public void Imprimir6() {
        ConexionPG con = new ConexionPG();
        
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/reportes/Reportes_Producto_A.jasper"));
            
            String aguja ="";
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
    
    public void Imprimir7() {
        ConexionPG con = new ConexionPG();
        
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/reportes/Reportes_Producto_V.jasper"));
            
            String aguja = "";
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
    
    public void Imprimir8() {
        ConexionPG con = new ConexionPG();

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/reportes/Reportes_Admins.jasper"));

            String aguja ="";
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
