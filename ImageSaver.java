
/**
 * Write a description of class ImageSaver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;

public class ImageSaver
{
    public void doSave(String filePrefix) {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource image = new ImageResource(f);
            String fname = image.getFileName();
            String newName = filePrefix + fname; 
            image.draw();
            image.save();
        }
    }
}
