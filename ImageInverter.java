
/**
 * Write a description of class ImageInverter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;
public class ImageInverter
{
    public ImageResource makeInversion(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for (Pixel pixel: outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getRed() + inPixel.getBlue()) / 2;
            
            pixel.setRed(0);
            pixel.setGreen(average);
            pixel.setBlue(0);
        }
        return outImage;
    }
    
    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource negativeImage = makeInversion(inImage);
            negativeImage.draw();
            negativeImage.save();
        }
    }
}
