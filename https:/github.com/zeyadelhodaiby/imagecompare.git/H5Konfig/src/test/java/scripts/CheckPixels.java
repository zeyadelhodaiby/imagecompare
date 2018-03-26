package scripts;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class CheckPixels {
    public static void main(String args[]) throws IOException {

    	
        File pic1 = new File("/Users/zeyadelhodaiby/Desktop/bmwpics/test28.jpg");
        File pic2 = new File("/Users/zeyadelhodaiby/Desktop/bmwpics/test28.jpg");
        
        
        if (Arrays.equals(returnPixelVal(pic1), returnPixelVal(pic2))) {
            System.out.println("Match");
        } else {
            System.out.println("No match");
        }

    }

    public static byte[] returnPixelVal(File in) {

        BufferedImage img = null;
        File f = null;
        byte[] pixels = null;
        // read image
        try {
            f = in;
            img = ImageIO.read(f);
            pixels = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
        } catch (IOException e) {
            System.out.println(e);
        }

        return pixels;

    }
}