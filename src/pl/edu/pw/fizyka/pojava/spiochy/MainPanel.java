package pl.edu.pw.fizyka.pojava.spiochy;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Timer;
import java.util.TimerTask;

public class MainPanel extends JPanel {
    World world;
    TimerTask simulationTask;

    public MainPanel(Parameters parameters) {
        this.setBackground(new Color(47, 138, 47)); // Green as grass

        this.world = new World(parameters);
    }

    public void rebuildWorld() {
        world.clearRoads();

        Line2D vLine = new Line2D.Double(0., this.getHeight() / 2., this.getWidth(), this.getHeight() / 2.);
        Road vRoad = new Road(MainFrame.SPEED_LIMIT, vLine);
        world.addRoad(vRoad);

        Line2D hLine = new Line2D.Double(this.getWidth() / 2., 0., this.getWidth() / 2., this.getHeight());
        Road hRoad = new Road(MainFrame.SPEED_LIMIT, hLine);
        world.addRoad(hRoad);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        this.world.draw(g2d);
    }

    public void startSimulation() {
        this.rebuildWorld();

        Timer simulationTimer = new Timer();

        this.simulationTask = new TimerTask() {
            public void run() {
                world.step();

                repaint();
                revalidate();
            }
        };

        simulationTimer.scheduleAtFixedRate(this.simulationTask, 0, (long) (MainFrame.DELTA_TIME * 1000.));
    }

    public void pauseSimulation() {
        simulationTask.cancel();
    }

    public void restartSimulation() {
        this.pauseSimulation();

        this.rebuildWorld();
    }
}
