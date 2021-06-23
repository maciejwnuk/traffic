package pl.edu.pw.fizyka.pojava.spiochy;

import pl.edu.pw.fizyka.pojava.spiochy.math.SpawnPoint2D;
import pl.edu.pw.fizyka.pojava.spiochy.math.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;

public class Car {
    static final double LENGTH = 40.;
    static final double WIDTH = Road.WIDTH / 3 * 2;

    Point2D position;
    Vector2D direction;
    double velocity;

    Point2D targetPoint;
    Iterator<Point2D> routeIter;

    boolean finished;
    double timeElapsed;

    Color color;

    public Car(SpawnPoint2D spawnPoint, ArrayList<Point2D> route, Color color) {
        this.position = spawnPoint.getPosition();
        this.direction = spawnPoint.getDirection();
        this.velocity = 0.;
        this.color = color;
        this.routeIter = route.iterator();
        // first point fix :/
        routeIter.next();
        this.targetPoint = routeIter.next();
        this.finished = false;
        this.timeElapsed = 0;
    }

    public void draw(Graphics2D g2d) {
        double theta = direction.getAngle();

        AffineTransform originalTransform = g2d.getTransform();

        g2d.setColor(color);
        g2d.translate(position.getX(), position.getY());
        g2d.rotate(theta);
        g2d.fillRect((int) -Car.LENGTH / 2,
                     (int) -Car.WIDTH / 2,
                     (int) Car.LENGTH,
                     (int) Car.WIDTH);

        g2d.setTransform(originalTransform);
    }

    public double getTimeElapsed() {
        return timeElapsed;
    }

    public void move() {
        timeElapsed += MainFrame.DELTA_TIME;
        double deltaLength = velocity * MainFrame.DELTA_TIME;

        direction = new Vector2D(targetPoint.getX() - position.getX(), targetPoint.getY() - position.getY());
        direction.normalize();

        direction.multiply(deltaLength);

        Point2D oldPosition = new Point2D.Double(position.getX(), position.getY());

        position.setLocation(position.getX() + direction.getX(), position.getY() + direction.getY());

        // Curve fever ..
        while (
            (targetPoint.getX() >= oldPosition.getX() && targetPoint.getX() <= position.getX() && targetPoint.getY() >= position.getY() && targetPoint.getY() <= oldPosition.getY())
            || (targetPoint.getX() >= position.getX() && targetPoint.getX() <= oldPosition.getX() && targetPoint.getY() >= position.getY() && targetPoint.getY() <= oldPosition.getY())
            || (targetPoint.getX() >= oldPosition.getX() && targetPoint.getX() <= position.getX() && targetPoint.getY() >= oldPosition.getY() && targetPoint.getY() <= position.getY())
            || (targetPoint.getX() >= position.getX() && targetPoint.getX() <= oldPosition.getX() && targetPoint.getY() >= oldPosition.getY() && targetPoint.getY() <= position.getY())
        ) {
            if (!routeIter.hasNext()) {
                finished = true;
                break;
            }

            targetPoint = routeIter.next();
        }
    }

    public boolean hasFinished() {
        return finished;
    }

    public double getVelocity() {
        return velocity;
    }

    public Point2D getPosition() {
        return position;
    }

    public void slowDown(double deceleration) {
        if (velocity - deceleration < 0)
            velocity = 0;
        else
            velocity -= deceleration;
    }

    public void speedUp(double acceleration) {
        if (velocity + acceleration < Road.SPEED_LIMIT)
            velocity += acceleration;
    }
}
