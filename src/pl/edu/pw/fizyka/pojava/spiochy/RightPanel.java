package pl.edu.pw.fizyka.pojava.spiochy;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
	StatisticsPanel statsPanel;

	public RightPanel(MainPanel mainPanel, Statistics statistics) {
		this.setLayout(new BorderLayout());

		statsPanel = new StatisticsPanel(statistics);
		ControlPanel ctrlPanel = new ControlPanel(mainPanel);

		this.add(statsPanel, BorderLayout.PAGE_START);
		this.add(ctrlPanel, BorderLayout.PAGE_END);
	}

	public StatisticsPanel getStatsPanel() {
		return statsPanel;
	}
}
