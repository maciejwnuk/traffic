package pl.edu.pw.fizyka.pojava.spiochy;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
	public RightPanel(MainPanel mainPanel) {
		this.setLayout(new BorderLayout());

		StatisticsPanel statsPanel = new StatisticsPanel();
		ControlPanel ctrlPanel = new ControlPanel(mainPanel);

		this.add(statsPanel, BorderLayout.PAGE_START);
		this.add(ctrlPanel, BorderLayout.PAGE_END);
	}
}
