package pl.edu.pw.fizyka.pojava.spiochy;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {

    Lang lang;

    public ControlPanel(MainPanel mainPanel) {
        lang = new Lang();

        JButton switchBtn = new JButton(lang.rb.getString("run"));
        JButton restartBtn = new JButton("Restart");

        switchBtn.setAlignmentX(CENTER_ALIGNMENT);
        restartBtn.setAlignmentX(CENTER_ALIGNMENT);

        switchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mainPanel.isRunning()) {
                    mainPanel.pauseSimulation();
                    switchBtn.setText(lang.rb.getString("resume"));
                } else {
                    if (!mainPanel.isCompleted())
                        mainPanel.startSimulation();
                    else
                        mainPanel.resumeSimulation();

                    switchBtn.setText(lang.rb.getString("stop"));
                }
            }
        });
        restartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.restartSimulation();
                switchBtn.setText(lang.rb.getString("run"));
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(switchBtn);
        this.add(restartBtn);
    }
}
