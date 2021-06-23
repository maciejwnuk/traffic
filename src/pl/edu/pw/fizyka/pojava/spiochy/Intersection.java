package pl.edu.pw.fizyka.pojava.spiochy;

import java.awt.geom.Point2D;

public interface Intersection {
    void setPosition(Point2D.Double position);
    Point2D getPosition();

    IntersectionType getType();
}
