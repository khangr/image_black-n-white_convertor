package blacknwhite;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.omg.CORBA.RepositoryIdHelper;

public class Window extends JFrame {
	
	private String path;
	private BufferedImage buffered_image;
	private Image image;
	private JPanel inner_panel;
	private JButton button;
	
	public Window() {
	
		add(new Panel());
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private class Panel extends JPanel {
		
		private final int width = 600;
		private final int height = 530;
		
		private Panel() {
			
			inner_panel = new InnerPanel();
			button = new ButtonExplorer();
			add(inner_panel);
			add(button);
			add(new SaveButton());
			setBackground(Color.LIGHT_GRAY);
			setPreferredSize(new Dimension(width, height));
		}
	}
	
	private class InnerPanel extends JPanel {
		
		private final int width = 600;
		private final int height = 500;
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawImage(g);
		}
		
		private void drawImage(Graphics g) {
			
			g.drawImage(image, 0, 0, width, height, null);
		}
		
		private InnerPanel() {
			
			add(new Slider());
			setFocusable(true);
			setBorder(BorderFactory.createLoweredBevelBorder());
			setPreferredSize(new Dimension(width, height));
			
		}
	}
	
	private class Slider extends JSlider implements ChangeListener {
		
		public Slider() {
			
			setMinimum(0);
			setMaximum(100);
			addChangeListener(this);
		}

		@Override
		public void stateChanged(ChangeEvent arg0) {
			
			Global.change(getValue());
			buffered_image = new LoadImage(path).getBuffered_image();
			image = Process.black_n_white(buffered_image);
			inner_panel.repaint();
		}
	}
	
	private class SaveButton extends JButton implements ActionListener {
		
		private final int width = 80;
		private final int height = 25;
		
		private SaveButton() {
			
			setText("Save");
			addActionListener(this);
			setPreferredSize(new Dimension(width, height));
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			new SaveImage(path, (BufferedImage) image);
		}
	}
	
	private class ButtonExplorer extends JButton implements ActionListener {
		
		private final int width = 80;
		private final int height = 25;
		
		private ButtonExplorer() {
		
			setText("Select");
			addActionListener(this);
			setPreferredSize(new Dimension(width, height));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			path = new Explorer().getFile_name();
			buffered_image = new LoadImage(path).getBuffered_image();
			image = Process.black_n_white(buffered_image);
			inner_panel.repaint();
		}
		
	}

}
