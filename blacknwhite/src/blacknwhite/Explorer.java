package blacknwhite;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Explorer {

	private JFileChooser file_chooser;
	private File file;
	private String file_name;
	private FileNameExtensionFilter file_name_ex;
	
	public Explorer() {
		
		file_name_ex = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
		file_chooser = new JFileChooser();
		file_chooser.setFileFilter(file_name_ex);
		file_chooser.showOpenDialog(null);
		file = file_chooser.getSelectedFile();
		file_name = file.getAbsolutePath();
	}
	
	public String getFile_name() {
		return file_name;
	}
}
