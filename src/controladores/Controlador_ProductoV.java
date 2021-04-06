/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modelos.Modelo_Producto_V;
import vista.ventanas.Ventana_Productos_V;

/**
 *
 * @author Kevin
 */
public class Controlador_ProductoV {
    
    private Modelo_Producto_V modelo;
    private Ventana_Productos_V vista;

    public Controlador_ProductoV() {
    }

    public Controlador_ProductoV(Modelo_Producto_V modelo, Ventana_Productos_V vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }
    
    
    public void IniciarControl(){
        
        KeyListener k= new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        
    }
    
    
}
