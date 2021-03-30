package pl.edu.pw.fizyka.pojava.spiochy;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RightPanel extends JPanel {
	
	JLabel stats = new JLabel("Statystyki:");
	
	JLabel labAvgPassingTime = new JLabel("Średni czas przejazdu: ");
	JLabel labMedian = new JLabel("Mediana: ");
	JLabel labVariance = new JLabel("Wariancja: ");
	
	JTextField textAvgPassingTime = new JTextField("###");
	JTextField textMedian = new JTextField("###");
	JTextField textVariance = new JTextField("###");
	
	JButton reset = new JButton("RESET");
	JButton onOff = new JButton("START/STOP");
	
	GridBagConstraints gbc = new GridBagConstraints();

	public RightPanel() {	
		setLayout(new GridBagLayout());
		
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(stats, gbc);
		
		gbc.insets = new Insets(10, 2, 2, 2);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(labAvgPassingTime, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(textAvgPassingTime, gbc);
		
		gbc.insets = new Insets(2, 2, 2, 2);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(labMedian, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(textMedian, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(labVariance, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(textVariance, gbc);
		
		gbc.insets = new Insets(500, 5, 5, 5);
		
		gbc.anchor = GridBagConstraints.CENTER; 
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(reset, gbc);
		
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(onOff, gbc);
	}

	public RightPanel(LayoutManager layout) {
		super(layout);
	}

	public RightPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public RightPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

}
