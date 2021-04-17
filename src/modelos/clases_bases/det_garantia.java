/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.clases_bases;

/**
 *
 * @author Kevin
 */
public class det_garantia {
    
    private String codigo_garantia;
    private int cod_det_garantia;
    private int cod_producto;
    private String producto;
    private String problema;
    private String detalle;

    public det_garantia() {
    }

    public det_garantia(String codigo_garantia, int cod_det_garantia, int cod_producto, String problema, String detalle) {
        this.codigo_garantia = codigo_garantia;
        this.cod_det_garantia = cod_det_garantia;
        this.cod_producto = cod_producto;
        this.problema = problema;
        this.detalle = detalle;
    }

    public String getCodigo_garantia() {
        return codigo_garantia;
    }

    public void setCodigo_garantia(String codigo_garantia) {
        this.codigo_garantia = codigo_garantia;
    }

    public int getCod_det_garantia() {
        return cod_det_garantia;
    }

    public void setCod_det_garantia(int cod_det_garantia) {
        this.cod_det_garantia = cod_det_garantia;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "\n\tdet_garantia\n" + "codigo_garantia=" + codigo_garantia + ", cod_det_garantia=" + cod_det_garantia + ", cod_producto=" + cod_producto + ", problema=" + problema + ", detalle=" + detalle ;
    }

    
    
}
