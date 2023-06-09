import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.lang.*;

public class LoadSave {
	
	public static final String LEVEL_ATLAS = "res/Terrain.png";
	
    public static BufferedImage GetPlayerAtlas(String fill)
    {
    	BufferedImage img = null;
    	InputStream is = LoadSave.class.getResourceAsStream(fill);
    	try{
    		img = ImageIO.read(is);
    	} catch (IOException e){
    		e.printStackTrace();
    	} finally {
    		try{
    			is.close();
    		} catch (IOException e){
    			e.printStackTrace();
    		}
    	}
    	return img;
    }
}