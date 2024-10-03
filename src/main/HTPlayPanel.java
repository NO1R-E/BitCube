package main;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HTPlayPanel extends JPanel{
	
	public HTPlayPanel() {
		
		initComponents();
		
	}
	
	private void initComponents() {
		setLayout(new FlowLayout());
		JLabel htp = new JLabel("How to play!");
		add(htp);
	
	}
}
