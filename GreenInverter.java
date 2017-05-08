
/**
 * Write a description of class GreenInverter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;

public class GreenInverter
{
        public ImageResource makeAvgGreen(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for (Pixel pixel: outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            
            pixel.setRed(0);
            pixel.setGreen((inPixel.getRed() + inPixel.getBlue()) / 2 );
            pixel.setBlue(0);
        }
        return outImage;
    }
    
    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource negativeImage = makeAvgGreen(inImage);
            String fileName = inImage.getFileName();
            String newFileName = "green-" + fileName;
            negativeImage.setFileName(newFileName);
            negativeImage.draw();
            negativeImage.save();
        }
    }
}
