package claculator;

import javax.swing.JFrame;
import java.awt.Dimension;

public class MainFrame {
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Calculator");
		f.setSize(new Dimension(450,600));
		f.setLocation(500,200);
//		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPanel myPanel = new MyPanel();
		f.add(myPanel);
	}
}
