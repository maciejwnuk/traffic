package pl.edu.pw.fizyka.pojava.spiochy;

import java.awt.geom.Point2D;

public class RowIntersection implements Intersection {
    Point2D.Double position;

    public void setPosition(Point2D.Double position) {
        this.position = position;
    }

    public Point2D getPosition() {
        return this.position;
    }

    public IntersectionType getType() {
        return IntersectionType.ROW;
    }
}
