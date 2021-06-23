package pl.edu.pw.fizyka.pojava.spiochy;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {

    public ControlPanel(MainPanel mainPanel) {

        JButton stepBtn = new JButton("Step");
        stepBtn.setAlignmentX(CENTER_ALIGNMENT);
        stepBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.step();
            }
        });
        this.add(stepBtn);

        JButton switchBtn = new JButton("Uruchom");
        JButton restartBtn = new JButton("Restart");

        switchBtn.setAlignmentX(CENTER_ALIGNMENT);
        restartBtn.setAlignmentX(CENTER_ALIGNMENT);

        switchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mainPanel.isRunning()) {
                    mainPanel.pauseSimulation();
                    switchBtn.setText("Wznów");
                } else {
                    if (!mainPanel.isCompleted())
                        mainPanel.startSimulation();
                    else
                        mainPanel.resumeSimulation();

                    switchBtn.setText("Zatrzymaj");
                }
            }
        });
        restartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.restartSimulation();
                switchBtn.setText("Uruchom");
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(switchBtn);
        this.add(restartBtn);
    }
}
