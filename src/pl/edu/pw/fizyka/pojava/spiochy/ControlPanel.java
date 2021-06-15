package pl.edu.pw.fizyka.pojava.spiochy;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    boolean isRunning;

    public ControlPanel(MainPanel mainPanel) {
        this.isRunning = false;

        JButton switchBtn = new JButton("Uruchom");
        JButton restartBtn = new JButton("Restart");

        switchBtn.setAlignmentX(CENTER_ALIGNMENT);
        restartBtn.setAlignmentX(CENTER_ALIGNMENT);

        switchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isRunning) {
                    mainPanel.pauseSimulation();
                    switchBtn.setText("Wznów");

                    isRunning = false;
                } else {
                    mainPanel.startSimulation();
                    switchBtn.setText("Zatrzymaj");

                    isRunning = true;
                }
            }
        });
        restartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.restartSimulation();
                switchBtn.setText("Launch simulation");

                isRunning = false;
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(switchBtn);
        this.add(restartBtn);
    }
}
