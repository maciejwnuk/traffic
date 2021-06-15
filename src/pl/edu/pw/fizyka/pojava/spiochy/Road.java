package pl.edu.pw.fizyka.pojava.spiochy;

import java.awt.*;
import java.awt.geom.Line2D;

public class Road {
    double speedLimit;

    Line2D path;

    public Road(double speedLimit, Line2D path) {
        this.speedLimit = speedLimit;
        this.path = path;
    }

    public void draw(Graphics2D g2d) {
        g2d.draw(this.path.getBounds2D());
    }
}
