package pl.edu.pw.fizyka.pojava.spiochy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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

		JLabel intersectionLabel = new JLabel("Rodzaj skrzyżowania");

		DefaultListModel<String> listModel = new DefaultListModel<>();
		listModel.add(0, "światła");
		listModel.add(1, "równorzędne");
		listModel.add(2, "z pierwszeństwem przejazdu");

		JList<String> intersectionList = new JList(listModel);
		intersectionList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (intersectionList.getSelectedValue().equals("światła")) {
					parameters.setIntersectionType(IntersectionType.LIGHTS);
				} else if (intersectionList.getSelectedValue().equals("równorzędne")) {
					parameters.setIntersectionType(IntersectionType.PEER);
				} else if (intersectionList.getSelectedValue().equals("z pierwszeństwem przejazdu")) {
					parameters.setIntersectionType(IntersectionType.ROW);
				}
			}
		});

		this.add(intersectionLabel);
		this.add(intersectionList);

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
