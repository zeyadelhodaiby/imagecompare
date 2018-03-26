package scripts;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class CompareImage 
{

    static void processImage()
    {
        String file1 = "/Users/zeyadelhodaiby/Desktop/bmwpics/test28.jpg";
        String file2 = "/Users/zeyadelhodaiby/Desktop/bmwpics/test22 csopy.jpg";

        Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
        Image image2 = Toolkit.getDefaultToolkit().getImage(file2);

        try 
        {    
            PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
            PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);

            int[] data1 = null;

            if (grab1.grabPixels()) 
            {
                int width = grab1.getWidth();
                int height = grab1.getHeight();
                data1 = new int[width * height];
                data1 = (int[]) grab1.getPixels();
            }

            int[] data2 = null;

            if (grab2.grabPixels()) {
                int width = grab2.getWidth();
                int height = grab2.getHeight();
                data2 = new int[width * height];
                data2 = (int[]) grab2.getPixels();
            }
         String x=   Arrays.toString(data1);
       String y =      Arrays.toString(data2);
 
       
boolean ss = x.contains(y);
            
            System.out.println("Pixels equal: " + java.util.Arrays.equals(data1, data2));

        } catch (InterruptedException e1) {
            e1.printStackTrace();
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
    public static boolean CompareImages(File Img1 , File Img2) {
        //   processImage();
   
           
           
           if (Arrays.equals(returnPixelVal(Img1), returnPixelVal(Img2))) {
               return true;
           } else {
            return false;
           }
       }
    
    
    public static void main(String args[]) {
  
    	   File file1 = new File("/Users/zeyadelhodaiby/Desktop/bmwpics/test22.png");
    	   File file2 =new File("/Users/zeyadelhodaiby/Desktop/bmwpics/test28.png");
           boolean x = CompareImages(file1,file2);
    	
    	System.out.println(x);
    	
    }
}