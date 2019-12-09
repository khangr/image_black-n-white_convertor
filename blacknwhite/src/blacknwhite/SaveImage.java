package blacknwhite;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SaveImage {

	private String absolute_path;
	private File write_file;
	
	public SaveImage(String path, BufferedImage image) {
		
		absolute_path = "";
		
		/*for (int i = 0; i < path.length() - 4; i++) {
			absolute_path += path.charAt(i); 
		}
		
		absolute_path += "_black.png";*/
		write_file = new File(path);
		try {
			ImageIO.write(image, "jpg", write_file);
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
}
