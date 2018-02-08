
package settingsCarsonAmanat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GearIcon extends JFrame{

	 public static void main(String args[]) throws IOException {
	        GearIcon ob = new GearIcon();
	        ob.setVisible(true);
	        
	    }

	private JPanel p;
	public  JButton b;
	 
	 GearIcon() {
	        p = new JPanel(new BorderLayout());
	        b = new JButton();
	        b.setBackground(Color.black);
	        ImageIcon img = new ImageIcon("resources/gear.png");
	        b.setIcon(img);

	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(100, 100);
	        p.add(b);
	        add(p);
	       validate();

	   }

}
