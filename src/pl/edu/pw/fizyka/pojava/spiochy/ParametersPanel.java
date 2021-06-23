package pl.edu.pw.fizyka.pojava.spiochy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;

public class ParametersPanel extends JPanel {
	Lang lang;

	public ParametersPanel(Parameters parameters) {
		lang = new Lang();

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel accelerationLabel = new JLabel(lang.rb.getString("acceleration"));
		JTextField accelerationField = new JTextField(String.valueOf(parameters.getAcceleration()));
		accelerationLabel.setAlignmentX(CENTER_ALIGNMENT);
		accelerationField.setAlignmentX(CENTER_ALIGNMENT);
		this.add(accelerationLabel);
		this.add(accelerationField);

		JLabel brakingPowerLabel = new JLabel(lang.rb.getString("BrakesPower"));
		JTextField brakingPowerField = new JTextField(String.valueOf(parameters.getBrakingPower()));
		brakingPowerLabel.setAlignmentX(CENTER_ALIGNMENT);
		brakingPowerField.setAlignmentX(CENTER_ALIGNMENT);
		this.add(brakingPowerLabel);
		this.add(brakingPowerField);

		JLabel carAmountLabel = new JLabel(lang.rb.getString("carAmount"));
		JTextField carAmountField = new JTextField(String.valueOf(parameters.getCarAmount()));
		carAmountLabel.setAlignmentX(CENTER_ALIGNMENT);
		carAmountField.setAlignmentX(CENTER_ALIGNMENT);
		this.add(carAmountLabel);
		this.add(carAmountField);

//		JLabel intersectionLabel = new JLabel("Rodzaj skrzyżowania");
//
//		DefaultListModel<String> listModel = new DefaultListModel<>();
//		listModel.add(0, "światła");
//		listModel.add(1, "równorzędne");
//		listModel.add(2, "z pierwszeństwem przejazdu");
//
//		JList<String> intersectionList = new JList(listModel);
//		intersectionList.addListSelectionListener(new ListSelectionListener() {
//			public void valueChanged(ListSelectionEvent e) {
//				if (intersectionList.getSelectedValue().equals("światła")) {
//					parameters.setIntersectionType(IntersectionType.LIGHTS);
//				} else if (intersectionList.getSelectedValue().equals("równorzędne")) {
//					parameters.setIntersectionType(IntersectionType.PEER);
//				} else if (intersectionList.getSelectedValue().equals("z pierwszeństwem przejazdu")) {
//					parameters.setIntersectionType(IntersectionType.ROW);
//				}
//			}
//		});
//
//		this.add(intersectionLabel);
//		this.add(intersectionList);

		JButton updateBtn = new JButton(lang.rb.getString("updateParameters"));
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameters.setAcceleration(Double.parseDouble(accelerationField.getText()));
				parameters.setBrakingPower(Double.parseDouble(brakingPowerField.getText()));
				parameters.setCarAmount(Integer.parseInt(carAmountField.getText()));
			}
		});
		updateBtn.setAlignmentX(CENTER_ALIGNMENT);
		this.add(updateBtn);

		JFileChooser fc = new JFileChooser();
		JButton importBtn = new JButton(lang.rb.getString("importParameters"));
		importBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = fc.showDialog(null, lang.rb.getString("chooseFile"));

				if(JFileChooser.APPROVE_OPTION == result) {

				} else {
					JOptionPane.showMessageDialog(null, lang.rb.getString("fileNotChosen"), "Error", JOptionPane.INFORMATION_MESSAGE);
				}

				String read;
				StringBuffer str = new StringBuffer();
				FileReader fr;

				try {
					fr = new FileReader(fc.getSelectedFile());
					BufferedReader bfr = new BufferedReader(fr);

					while ((read = bfr.readLine()) != null) {
						str.append(read).append(" ");
					}

					String[] values = str.toString().split(" ", 0);

					accelerationField.setText(values[0]);
					brakingPowerField.setText(values[1]);
					carAmountField.setText(values[2]);

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		importBtn.setAlignmentX(CENTER_ALIGNMENT);
		this.add(importBtn);
	}
}
