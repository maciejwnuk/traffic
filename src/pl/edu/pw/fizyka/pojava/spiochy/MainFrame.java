package pl.edu.pw.fizyka.pojava.spiochy;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    static final int WIDTH = 1280;
    static final int HEIGHT = 720;

    MainPanel mainPanel;

    public MainFrame() throws HeadlessException {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);

        this.mainPanel = new MainPanel(IntersectionType.LIGHTS, 10);

        this.add(mainPanel, BorderLayout.CENTER);

        this.add(new ParametersPanel(mainPanel), BorderLayout.LINE_START);

        this.add(new RightPanel(), BorderLayout.LINE_END);

        this.setTitle("Symulacja ruchu drogowego");
        this.setVisible(true);

        this.mainPanel.updateDimension();
    }

    public void runSimulation() {
        this.mainPanel.runSimulation(200, 10, 2);
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();

        mainFrame.runSimulation();
    }
}
