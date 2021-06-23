package pl.edu.pw.fizyka.pojava.spiochy;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    static final int WIDTH = 1280;
    static final int HEIGHT = 720;

    static final double DELTA_TIME = 1. / 60.;

    public MainFrame() throws HeadlessException {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);

        Parameters parameters = new Parameters(1., 0.1, 10, IntersectionType.LIGHTS);
        Statistics statistics = new Statistics();

        MainPanel mainPanel = new MainPanel(parameters, statistics);

        this.add(mainPanel, BorderLayout.CENTER);

        this.add(new LeftPanel(parameters), BorderLayout.LINE_START);

        RightPanel rightPanel = new RightPanel(mainPanel, statistics);

        this.add(rightPanel, BorderLayout.LINE_END);

        StatisticsPanel statisticsPanel = rightPanel.getStatsPanel();

        mainPanel.setStatsPanel(statisticsPanel);

        this.setTitle("Symulacja ruchu drogowego");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
    }
}
