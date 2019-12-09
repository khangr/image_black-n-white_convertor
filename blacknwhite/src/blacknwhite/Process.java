package blacknwhite;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Process {
	
	private static Color color;
	private static final int low = 0;
	private static final int high = 0xFFFFFFF;

	protected static BufferedImage black_n_white(BufferedImage buffered_image) {		
		
		for (int i = 0; i < buffered_image.getHeight(); i++) {
			for (int j = 0; j < buffered_image.getWidth(); j++) {
				color = new Color(buffered_image.getRGB(j, i));
					if(color.getBlue() > color.getGreen()) {
						if(color.getBlue() > color.getRed()) {
							if(color.getBlue() >= Global.opacity) {
								buffered_image.setRGB(j, i, high);
							} else {
								buffered_image.setRGB(j, i, low);
							}
						}
					}
					
					if(color.getGreen() > color.getBlue()) {
						if(color.getGreen() > color.getBlue()) {
							if(color.getGreen() >= Global.opacity) {
								buffered_image.setRGB(j, i, high);
							} else {
								buffered_image.setRGB(j, i, low);
							}
						}
					}
					
					if(color.getRed() > color.getBlue()) {
						if(color.getRed() > color.getGreen()) {
							if(color.getRed() >= Global.opacity) {
								buffered_image.setRGB(j, i, high);
							} else {
								buffered_image.setRGB(j, i, low);
							}
						}
					}
			}
		}
		
		return buffered_image;
	}
}
