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

        Parameters parameters = new Parameters(1., 1., 10, IntersectionType.LIGHTS);

        MainPanel mainPanel = new MainPanel(parameters);

        this.add(mainPanel, BorderLayout.CENTER);

        this.add(new LeftPanel(parameters), BorderLayout.LINE_START);

        this.add(new RightPanel(mainPanel), BorderLayout.LINE_END);

        this.setTitle("Symulacja ruchu drogowego");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
    }
}
