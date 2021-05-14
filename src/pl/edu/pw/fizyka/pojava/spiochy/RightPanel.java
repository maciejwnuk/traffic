package pl.edu.pw.fizyka.pojava.spiochy;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RightPanel extends JPanel {
	
	JLabel labAvgPassingTime = new JLabel("Średni czas przejazdu: ");
	JLabel labMedian = new JLabel("Mediana: ");
	JLabel labVariance = new JLabel("Wariancja: ");
	
	JTextArea textAvgPassingTime = new JTextArea("###");
	JTextArea textMedian = new JTextArea("###");
	JTextArea textVariance = new JTextArea("###");
	
	JButton reset = new JButton("RESET");
	JButton onOff = new JButton("START/STOP");
	JButton refresh = new JButton("ODŚWIEŻ");
	JButton saveStats = new JButton("ZAPISZ");
	
	GridBagConstraints gbc = new GridBagConstraints();

	public RightPanel() {	
		setLayout(new GridBagLayout());
		
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(labAvgPassingTime, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		textAvgPassingTime.setFont(new Font("font",Font.BOLD, textAvgPassingTime.getFont().getSize()+1));
		this.add(textAvgPassingTime, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(labMedian, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		textMedian.setFont(new Font("font",Font.BOLD, textMedian.getFont().getSize()+1));
		this.add(textMedian, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(labVariance, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		textVariance.setFont(new Font("font",Font.BOLD, textVariance.getFont().getSize()+1));
		this.add(textVariance, gbc);
		
		gbc.insets = new Insets(50, 5, 5, 5);
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.add(refresh, gbc);
		
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		this.add(saveStats, gbc);
		
		gbc.insets = new Insets(350, 5, 5, 5);
		
		gbc.anchor = GridBagConstraints.CENTER; 
		gbc.gridx = 0;
		gbc.gridy = 8;
		this.add(reset, gbc);
		
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 9;
		this.add(onOff, gbc);
		
		Statistics sss = new Statistics();
		
		long cos = 1;
		long cos2 = 2;
		long cos3 = 3;
		
		sss.measuredTimes.add(cos);
		sss.measuredTimes.add(cos2);
		sss.measuredTimes.add(cos3);
		
		ActionListener refreshListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String strAvg = String.valueOf(sss.averageTime());
				String strMed = String.valueOf(sss.median());
				String strVar = String.valueOf(sss.variance());
				textAvgPassingTime.setText(strAvg);
				textMedian.setText(strMed);
				textVariance.setText(strVar);
				
				System.out.println(sss.averageTime());
				System.out.println(sss.median());
				System.out.println(sss.variance());
			}
		};
		refresh.addActionListener(refreshListener);
		
		ActionListener saveListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String strAvg = String.valueOf(sss.averageTime());
				String strMed = String.valueOf(sss.median());
				String strVar = String.valueOf(sss.variance());
				String str = strAvg + '\n' + strMed + '\n' + strVar + '\n';
				
				File outputfile = new File("statystyki.txt");
				
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile));
					writer.write(str);
					
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		saveStats.addActionListener(saveListener);
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
