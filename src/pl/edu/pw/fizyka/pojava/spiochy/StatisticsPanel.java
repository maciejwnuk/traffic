package pl.edu.pw.fizyka.pojava.spiochy;

import javax.swing.*;

public class StatisticsPanel extends JPanel {
    public StatisticsPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel header = new JLabel("Statystyki przejazdu:");
        header.setAlignmentX(CENTER_ALIGNMENT);
        this.add(header);

        JLabel meanLabel = new JLabel("średni czas");
        JLabel meanValueLabel = new JLabel("Nan");
        meanLabel.setAlignmentX(CENTER_ALIGNMENT);
        meanValueLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.add(meanLabel);
        this.add(meanValueLabel);

        JLabel medianLabel = new JLabel("mediana");
        JLabel medianValueLabel = new JLabel("Nan");
        medianLabel.setAlignmentX(CENTER_ALIGNMENT);
        medianValueLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.add(medianLabel);
        this.add(medianValueLabel);

        JLabel varianceLabel = new JLabel("wariancja");
        JLabel varianceValueLabel = new JLabel("Nan");
        varianceLabel.setAlignmentX(CENTER_ALIGNMENT);
        varianceValueLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.add(varianceLabel);
        this.add(varianceValueLabel);
    }
}
