package pl.edu.pw.fizyka.pojava.spiochy;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    World world;
    double deltaTime;

    public MainPanel(IntersectionType iType, double deltaTime) {
        this.setBackground(new Color(47, 138, 47)); // Green as grass

        this.deltaTime = deltaTime;

        this.world = new World(
                new Color(102,102,102),
                new Color(255,255,255),
                50,
                3,
                iType);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        this.world.draw(g2d);
    }

    public void updateDimension() {
        this.world.setDimension(this.getSize());

        this.repaint();
        this.revalidate();
    }

    public void setIntersectionType(int iType) {
        this.world.setIntersectionType(IntersectionType.LIGHTS);

        this.repaint();
        this.revalidate();
    }

    // DeltaStepCount -> Co ile stepów pojawiają się samochody
    // MaxSpawnCount -> Ile maksymalnie pojawień
    // CarAmount -> Ile samochodów podczas pojawienia
    // TODO: Poprawić nazewnictwo ;(
    // TODO: Stop symulacji
    public void runSimulation(int deltaStepCount, int maxSpawnCount, int carAmount) {
        double duration = System.currentTimeMillis();
        double lastFrame = 0;

        int stepCount = 0;
        int spawnCount = 0;

        while (true) {
            if (duration > this.deltaTime) {
                lastFrame = System.currentTimeMillis();

                this.world.step(this.deltaTime);
                stepCount += 1;

                if (stepCount % deltaStepCount == 0 && spawnCount < maxSpawnCount) {
                    this.world.spawnCars(carAmount);
                    spawnCount += 1;
                }

                this.repaint();
                this.revalidate();

                duration = 0;
            } else {
                duration = System.currentTimeMillis() - lastFrame;
            }
        }
    }
}
