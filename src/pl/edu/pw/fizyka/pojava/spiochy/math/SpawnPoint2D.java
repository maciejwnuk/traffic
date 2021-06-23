package pl.edu.pw.fizyka.pojava.spiochy.math;

import java.awt.geom.Point2D;

public class SpawnPoint2D {
    Point2D position;
    Vector2D direction;

    public SpawnPoint2D(Point2D position, Vector2D direction) {
        this.position = position;
        this.direction = direction.getNormalized();
    }

    public Point2D getPosition() {
        return position;
    }

    public Vector2D getDirection() {
        return direction;
    }
}
