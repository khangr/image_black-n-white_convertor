package blacknwhite;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadImage {

	private BufferedImage buffered_image;
	
	public LoadImage(String path) {
		
		try {
			buffered_image = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Yol bulunamadý...");
		}
	}
	
	public BufferedImage getBuffered_image() {
		return buffered_image;
	}
	
}
