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
import java.util.Date;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import modelos.clases_bases.persona;
import org.postgresql.util.Base64;

/**
 *
 * @author Kevin
 */
public class Modelo_Persona extends persona{
    
    private static ConexionPG conexion = new ConexionPG();

    public Modelo_Persona() {
    }

    public Modelo_Persona(String cedula, String nombres, String apellidos, Date fecha_n, String sexo, String telef, String correo, String direc, Image foto) {
        super(cedula, nombres, apellidos, fecha_n, sexo, telef, correo, direc, foto);
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

        String sql = "INSERT INTO public.persona(cedula, nombres, apellidos, fecha_nac, sexo, telefono, correo, direc, foto)\n" +
        "VALUES ('"+getCedula()+"','"+getNombres()+"','"+getApellidos()+"','"+getFecha_n()+"','"+getSexo()+"','"+getTelef()+"','"+getCorreo()+"','"+getDirec()+"','"+foto64+"');";
        if (conexion.NoQuery(sql) == null) {
            return true;
        } else {
            return false;
        }

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
    
    
    
    
    public boolean ELIMINAR() {
        String sql = "DELETE FROM public.persona\n"
                + "WHERE cedula='" + getCedula()+ "';";
        if (conexion.NoQuery(sql) == null) {
            return true;
        } else {
            return false;
        }

    }
    
    
}
