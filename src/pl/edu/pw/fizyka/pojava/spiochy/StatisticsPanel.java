package pl.edu.pw.fizyka.pojava.spiochy;

import javax.swing.*;

public class StatisticsPanel extends JPanel {
    Statistics statistics;

    JLabel meanValueLabel;
    JLabel medianValueLabel;
    JLabel varianceValueLabel;

    public StatisticsPanel(Statistics statistics) {
        this.statistics = statistics;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel header = new JLabel("Statystyki przejazdu:");
        header.setAlignmentX(CENTER_ALIGNMENT);
        this.add(header);

        JLabel meanLabel = new JLabel("średni czas");
        meanValueLabel = new JLabel(String.valueOf(statistics.averageTime()));
        meanLabel.setAlignmentX(CENTER_ALIGNMENT);
        meanValueLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.add(meanLabel);
        this.add(meanValueLabel);

        JLabel medianLabel = new JLabel("mediana");
        medianValueLabel = new JLabel(String.valueOf(statistics.median()));
        medianLabel.setAlignmentX(CENTER_ALIGNMENT);
        medianValueLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.add(medianLabel);
        this.add(medianValueLabel);

        JLabel varianceLabel = new JLabel("wariancja");
        varianceValueLabel = new JLabel(String.valueOf(statistics.variance()));
        varianceLabel.setAlignmentX(CENTER_ALIGNMENT);
        varianceValueLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.add(varianceLabel);
        this.add(varianceValueLabel);
    }

    public void update() {
        meanValueLabel.setText(String.valueOf(statistics.averageTime()));
        medianValueLabel.setText(String.valueOf(statistics.median()));
        varianceValueLabel.setText(String.valueOf(statistics.variance()));
    }
}
