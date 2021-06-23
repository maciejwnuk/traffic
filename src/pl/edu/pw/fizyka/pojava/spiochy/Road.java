package pl.edu.pw.fizyka.pojava.spiochy;

import pl.edu.pw.fizyka.pojava.spiochy.math.SpawnPoint2D;
import pl.edu.pw.fizyka.pojava.spiochy.math.Vector2D;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Road {
    static final Color COLOR = new Color(80, 80, 80);
    static final double SPEED_LIMIT = 50.;
    static final double WIDTH = 25.;

    Line2D path;

    public Road(Line2D path) {
        this.path = path;
    }

    public Line2D getPath() {
        return path;
    }

    public boolean isHorizontal() {
        return (this.path.getX2() - this.path.getX1() > this.path.getY2() - this.path.getY1());
    }

    public SpawnPoint2D getSpawnPoint(boolean isReflected) {
        Point2D pos = new Point2D.Double();
        Vector2D dir = new Vector2D();

        if (this.isHorizontal()) {
            if (!isReflected) {
                pos.setLocation(this.path.getX1() + Car.LENGTH, this.path.getY1() + Road.WIDTH / 2);
                dir.set(1., 0.);
            } else {
                pos.setLocation(this.path.getX2() - Car.LENGTH, this.path.getY2() - Road.WIDTH / 2);
                dir.set(-1., 0.);
            }
        } else {
            if (!isReflected) {
                pos.setLocation(this.path.getX1() - Road.WIDTH / 2, this.path.getY1() + Car.LENGTH);
                dir.set(0., 1.);
            } else {
                pos.setLocation(this.path.getX2() + Road.WIDTH / 2, this.path.getY2() - Car.LENGTH);
                dir.set(0., -1.);
            }
        }

        SpawnPoint2D spawnPoint = new SpawnPoint2D(pos, dir);

        return spawnPoint;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(this.COLOR);

        Polygon p = new Polygon();

        if (this.isHorizontal()) {
            p.addPoint((int) this.path.getX1(), (int) (this.path.getY1() - Road.WIDTH));
            p.addPoint((int) this.path.getX2(), (int) (this.path.getY2() - Road.WIDTH));
            p.addPoint((int) this.path.getX2(), (int) (this.path.getY2() + Road.WIDTH));
            p.addPoint((int) this.path.getX1(), (int) (this.path.getY1() + Road.WIDTH));
        } else {
            p.addPoint((int) (this.path.getX1() - Road.WIDTH), (int) this.path.getY1());
            p.addPoint((int) (this.path.getX1() + Road.WIDTH), (int) this.path.getY1());
            p.addPoint((int) (this.path.getX2() + Road.WIDTH), (int) this.path.getY2());
            p.addPoint((int) (this.path.getX2() - Road.WIDTH), (int) this.path.getY2());
        }

        g2d.fillPolygon(p);

        g2d.setColor(new Color(255, 255, 255));
        g2d.draw(this.path.getBounds2D());
    }
}
