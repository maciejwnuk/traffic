package pl.edu.pw.fizyka.pojava.spiochy;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Timer;
import java.util.TimerTask;

public class MainPanel extends JPanel {
    World world;
    TimerTask simulationTask;

    boolean running;
    boolean completed;
    boolean hasBeenBuilt;

    public MainPanel(Parameters parameters) {
        this.setBackground(new Color(47, 138, 47)); // Green as grass

        this.world = new World(parameters);
        this.running = false;
        this.completed = false;
        this.hasBeenBuilt = false;
    }

    public void rebuildWorld() {
        this.world.clearRoads();

        Line2D vLine = new Line2D.Double(0., this.getHeight() / 2., this.getWidth(), this.getHeight() / 2.);
        Road vRoad = new Road(vLine);
        this.world.addRoad(vRoad);

        Line2D hLine = new Line2D.Double(this.getWidth() / 2., 0., this.getWidth() / 2., this.getHeight());
        Road hRoad = new Road(hLine);
        this.world.addRoad(hRoad);

        this.world.spawnCar(vRoad);
        this.world.spawnCar(hRoad);

        this.hasBeenBuilt = true;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        if (hasBeenBuilt)
            this.world.draw(g2d);
    }

    public void startTimer() {
        Timer simulationTimer = new Timer();

        this.simulationTask = new TimerTask() {
            public void run() {
                world.step();

                repaint();
                revalidate();

                if (world.hasFinished()) {
                    this.cancel();
                    completed = true;
                }
            }
        };

        simulationTimer.scheduleAtFixedRate(this.simulationTask, 0, (long) (MainFrame.DELTA_TIME * 1000.));

        this.running = true;
        completed = false;
    }

    public void startSimulation() {
        this.rebuildWorld();

        this.startTimer();
    }

    public void resumeSimulation() {
        this.startTimer();
    }

    public void pauseSimulation() {
        simulationTask.cancel();

        this.running = false;
    }

    public void restartSimulation() {
        this.pauseSimulation();

        this.rebuildWorld();
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void step() {
        world.step();

        repaint();
        revalidate();
    }
}
