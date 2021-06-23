package pl.edu.pw.fizyka.pojava.spiochy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;

public class StatisticsPanel extends JPanel {
    Statistics statistics;

    Lang lang;

    JLabel meanValueLabel;
    JLabel medianValueLabel;
    JLabel varianceValueLabel;

    public StatisticsPanel(Statistics statistics) {
        this.statistics = statistics;

        lang = new Lang();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel header = new JLabel(lang.rb.getString("statistics"));
        header.setAlignmentX(CENTER_ALIGNMENT);
        this.add(header);

        JLabel meanLabel = new JLabel(lang.rb.getString("mean"));
        meanValueLabel = new JLabel(String.valueOf(statistics.averageTime()));
        meanLabel.setAlignmentX(CENTER_ALIGNMENT);
        meanValueLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.add(meanLabel);
        this.add(meanValueLabel);

        JLabel medianLabel = new JLabel(lang.rb.getString("median"));
        medianValueLabel = new JLabel(String.valueOf(statistics.median()));
        medianLabel.setAlignmentX(CENTER_ALIGNMENT);
        medianValueLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.add(medianLabel);
        this.add(medianValueLabel);

        JLabel varianceLabel = new JLabel(lang.rb.getString("variance"));
        varianceValueLabel = new JLabel(String.valueOf(statistics.variance()));
        varianceLabel.setAlignmentX(CENTER_ALIGNMENT);
        varianceValueLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.add(varianceLabel);
        this.add(varianceValueLabel);

        JButton saveBtn = new JButton(lang.rb.getString("save"));
        saveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PrintWriter pw;

                try {
                    pw = new PrintWriter("statistics.txt");

                    pw.println("Średni czas przejazdu: " + meanValueLabel.getText());

                    pw.println("Mediana: " + medianValueLabel.getText());

                    pw.println("Wariancja: " + varianceValueLabel.getText());

                    pw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        saveBtn.setAlignmentX(CENTER_ALIGNMENT);
        saveBtn.setAlignmentY(CENTER_ALIGNMENT);
        this.add(saveBtn);
    }

    public void update() {
        meanValueLabel.setText(String.valueOf(statistics.averageTime()));
        medianValueLabel.setText(String.valueOf(statistics.median()));
        varianceValueLabel.setText(String.valueOf(statistics.variance()));
    }
}
