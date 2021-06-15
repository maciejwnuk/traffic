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
        g2d.setColor(new Color(80, 80, 80));

        Polygon p = new Polygon();

        if (this.path.getX2() - this.path.getX1() > this.path.getY2() - this.path.getY1()) {
            p.addPoint((int) this.path.getX1(), (int) (this.path.getY1() - MainFrame.STREET_WIDTH));
            p.addPoint((int) this.path.getX2(), (int) (this.path.getY2() - MainFrame.STREET_WIDTH));
            p.addPoint((int) this.path.getX2(), (int) (this.path.getY2() + MainFrame.STREET_WIDTH));
            p.addPoint((int) this.path.getX1(), (int) (this.path.getY1() + MainFrame.STREET_WIDTH));
        } else {
            p.addPoint((int) (this.path.getX1() - MainFrame.STREET_WIDTH), (int) this.path.getY1());
            p.addPoint((int) (this.path.getX1() + MainFrame.STREET_WIDTH), (int) this.path.getY1());
            p.addPoint((int) (this.path.getX2() + MainFrame.STREET_WIDTH), (int) this.path.getY2());
            p.addPoint((int) (this.path.getX2() - MainFrame.STREET_WIDTH), (int) this.path.getY2());
        }

        g2d.fillPolygon(p);

        g2d.setColor(new Color(255, 255, 255));
        g2d.draw(this.path.getBounds2D());
    }
}
