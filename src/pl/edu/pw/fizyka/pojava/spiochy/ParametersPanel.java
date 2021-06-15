package pl.edu.pw.fizyka.pojava.spiochy;

import com.sun.tools.javac.Main;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ParametersPanel extends JPanel {
	
	String[] crossingString = {
		"światła",
		"rownorzędne",
		"z pierwszeństwem przejazdu"
	};
	
	JLabel labAcceleration = new JLabel("Przyspieszenie pojazdów: ");
	JLabel labReactionTime = new JLabel("Czas reakcji kierowców: ");
	JLabel labNumberOfCars = new JLabel("Liczba pojazdów w symulacji: ");
	JTextField acceleration = new JTextField(); 
	JTextField reactionTime = new JTextField();
	JTextField numberOfCars = new JTextField();
	JComboBox crossingType = new JComboBox(crossingString);
	JButton updateParameters = new JButton("aktualizuj parametry");
	
	GridBagConstraints gbc = new GridBagConstraints();

	MainPanel mainPanel;
	
	Parameters parameters = new Parameters(0.0, 0.0, 10);

	public ParametersPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
		this.crossingType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = (String) crossingType.getSelectedItem();

				switch (item) {
					case "światła":
						mainPanel.setIntersectionType(0);
						break;

					case "rownorzędne":
						mainPanel.setIntersectionType(1);
						break;

					case "z pierwszeństwem przejazdu":
						mainPanel.setIntersectionType(2);
						break;
				}
			}
		});

		setLayout(new GridBagLayout());
		
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(labAcceleration, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		acceleration.setText("####");
		acceleration.setFont(new Font("font",Font.BOLD, acceleration.getFont().getSize()+1));
		this.add(acceleration, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(labReactionTime, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		reactionTime.setText("####");
		reactionTime.setFont(new Font("font",Font.BOLD, reactionTime.getFont().getSize()+1));
		this.add(reactionTime, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(labNumberOfCars, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		numberOfCars.setText("####");
		numberOfCars.setFont(new Font("font",Font.BOLD, reactionTime.getFont().getSize()+1));
		this.add(numberOfCars, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.add(crossingType, gbc);
		
		gbc.insets = new Insets(400, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 7;
		this.add(updateParameters, gbc);
		
		ActionListener updateListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateParameters();
			}
		};
		updateParameters.addActionListener(updateListener);
	}
	
	public void updateParameters() {
		String strAcceleration = acceleration.getText();
		String strReactionTime = reactionTime.getText();
		String strNumberOfCars = numberOfCars.getText();
		
		try {
			double dAcceleration = Double.parseDouble(strAcceleration);
			double dReactionTime = Double.parseDouble(strReactionTime);
			int iNumberOfCars = Integer.parseInt(strNumberOfCars);
			
			parameters.updateParameters(dAcceleration, dReactionTime, iNumberOfCars);
		} catch(Exception e) {
			System.out.println("Error during updating parameters.");
		}
	}

	public ParametersPanel(LayoutManager layout) {
		super(layout);
	}

	public ParametersPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public ParametersPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

}
