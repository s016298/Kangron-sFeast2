package sid.testrpg.tools;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loader {
	
	public BufferedImage loadResource (String path, String fileType){
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getClassLoader().getResource(path + "." + fileType));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}

}
