/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import modelos.Modelo_Det_Garantia;
import modelos.Modelo_Enc_Garantia;
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
    }

}
