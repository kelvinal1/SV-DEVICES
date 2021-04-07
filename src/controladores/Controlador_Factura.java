/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.Modelo_Det_Factura;
import modelos.Modelo_Enc_Factura;
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
    
    public void IniciarControl(){
        System.out.println(modeloEncabezado.NuevoFact());
    }
    
    
    
    
    
    
    
}
