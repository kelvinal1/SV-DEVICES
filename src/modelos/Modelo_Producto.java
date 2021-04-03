/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JOptionPane;
import modelos.clases_bases.producto;
import org.postgresql.util.Base64;

/**
 *
 * @author Kevin
 */
public class Modelo_Producto extends producto {

    private static ConexionPG conexion = new ConexionPG();

    public Modelo_Producto(int codigo, String nombre, int codigo_fab, String modelo, String descrip, Image foto) {
        super(codigo, nombre, codigo_fab, modelo, descrip, foto);
    }

    public Modelo_Producto() {
    }

    public boolean CREAR() {
        String foto64 = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            BufferedImage img = imgBinage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            foto64 = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        String sql = "INSERT INTO public.producto(nombre, cod_fab, modelo, descripcion, foto)\n"
                + "VALUES ('" + getNombre() + "'," + getCodigo_fab() + " , '" + getModelo() + "', '" + getDescrip() + "','" + foto64 + "');";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("--PRODUCTO CREADO"
                    + super.toString());

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ES POSIBLE QUE HAYAN DATOS CARACTERES EXCEDIDOS", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public boolean MODIFICAR() {
        String foto64 = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            BufferedImage img = imgBinage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            foto64 = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        String sql = "UPDATE public.producto\n"
                + "SET nombre='" + getNombre() + "', cod_fab=" + getCodigo_fab() + ", modelo='" + getModelo() + "', descripcion='" + getDescrip() + "', foto='" + foto64 + "'\n"
                + "WHERE cod_producto=" + getCodigo() + ";";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("--PRODUCTO MODIFICADO"
                    + super.toString());

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ES POSIBLE QUE HAYAN DATOS CARACTERES EXCEDIDOS", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public boolean ELIMINAR() {
        String sql = "DELETE FROM public.producto\n"
                + "WHERE cod_producto="+getCodigo()+";";
        if (conexion.NoQuery(sql) == null) {
            System.out.println("--PRODUCTO ELIMINADO: " + this.toString());

            return true;
        } else {
            return false;
        }

    }

    private static BufferedImage imgBinage(Image img) {

        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGR = bi.createGraphics();
        bGR.drawImage(img, 0, 0, null);
        bGR.dispose();
        return bi;
    }

    public static Image obtenImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) it.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0, param);
    }

}
