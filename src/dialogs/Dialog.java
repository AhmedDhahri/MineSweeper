package dialogs;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Dialog extends JFrame {
	int w;
	int h;
	ImageIcon icon;
	JPanel ContentPane;
	public Dialog() {
		ContentPane = new JPanel();
		ContentPane.setLayout(new BorderLayout());
		
		icon = new ImageIcon("icon.png");
		w = 200;
		h = 400;
		setSize(w,h);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		w = (int) (0.5*(getToolkit().getScreenSize().getWidth()- w));
		h = (int) (0.5*(getToolkit().getScreenSize().getHeight()- h));
		setLocation(w,h);
		setIconImage(icon.getImage());
		setContentPane(ContentPane);
		setVisible(true);
	}

}
