package com.folha.boot.service.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Component;

@Component
public class UtilidadesDistintas {

	//UTILIDADES DISTINTAS
    public static BufferedImage toBufferedImage(Image img){
    if (img instanceof BufferedImage)
    {
        return (BufferedImage) img;
    }

    // Create a buffered image with transparency
    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

    // Draw the image on to the buffered image
    Graphics2D bGr = bimage.createGraphics();
    bGr.drawImage(img, 0, 0, null);
    bGr.dispose();

    // Return the buffered image
    return bimage;
}
  
    public static byte[] getBytesFromInputStream(InputStream is)  {
    
    ByteArrayOutputStream os = new ByteArrayOutputStream();     
    
    try{    
    
        byte[] buffer = new byte[0xFFFF];
            for (int len = is.read(buffer); len != -1; len = is.read(buffer)) { 
            os.write(buffer, 0, len);
        }
    }catch(Exception e){JOptionPane.showMessageDialog(null, e.getMessage());}
    
    return os.toByteArray();
}
    
    
    public static BufferedImage resizeBufferedImage(BufferedImage img, int newW, int newH) { 
    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

    Graphics2D g2d = dimg.createGraphics();
    g2d.drawImage(tmp, 0, 0, null);
    g2d.dispose();

    return dimg;
}  
    
  
    
    public byte[] toByteArrayAutoClosable(BufferedImage image, String type) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try{
            ImageIO.write(image, type, out);
        
        }catch(Exception e){JOptionPane.showMessageDialog(null, e.getMessage());}
    
    return out.toByteArray();
    }
   

}
