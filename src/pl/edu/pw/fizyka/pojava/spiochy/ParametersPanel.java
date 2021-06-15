package pl.edu.pw.fizyka.pojava.spiochy;

import com.sun.tools.javac.Main;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ParametersPanel extends JPanel {
	public ParametersPanel(Parameters parameters) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel accelerationLabel = new JLabel("Przyspieszenie pojazdu");
		JTextField accelerationField = new JTextField(String.valueOf(parameters.getAcceleration()));
		accelerationLabel.setAlignmentX(CENTER_ALIGNMENT);
		accelerationField.setAlignmentX(CENTER_ALIGNMENT);
		this.add(accelerationLabel);
		this.add(accelerationField);

		JLabel reactionTimeLabel = new JLabel("Czas reakcji kierowcy");
		JTextField reactionTimeField = new JTextField(String.valueOf(parameters.getReactionTime()));
		reactionTimeLabel.setAlignmentX(CENTER_ALIGNMENT);
		reactionTimeField.setAlignmentX(CENTER_ALIGNMENT);
		this.add(reactionTimeLabel);
		this.add(reactionTimeField);

		JLabel carAmountLabel = new JLabel("Ilość pojazdów");
		JTextField carAmountField = new JTextField(String.valueOf(parameters.getCarAmount()));
		carAmountLabel.setAlignmentX(CENTER_ALIGNMENT);
		carAmountField.setAlignmentX(CENTER_ALIGNMENT);
		this.add(carAmountLabel);
		this.add(carAmountField);

		JButton updateBtn = new JButton("Aktualizuj parametry");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters.setAcceleration(Double.parseDouble(accelerationField.getText()));
				parameters.setReactionTime(Double.parseDouble(reactionTimeField.getText()));
				parameters.setCarAmount(Integer.parseInt(carAmountField.getText()));
			}
		});
		updateBtn.setAlignmentX(CENTER_ALIGNMENT);
		this.add(updateBtn);
	}
}
