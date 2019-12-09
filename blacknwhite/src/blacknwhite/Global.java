package blacknwhite;

public class Global {

	public static void change(int x) {
		
		opacity_percent = x;
		opacity = opacity_percent * 255 / 100;
	}
	
	public static int opacity_percent = 50;
	public static int opacity = opacity_percent * 255 / 100;
	
}
