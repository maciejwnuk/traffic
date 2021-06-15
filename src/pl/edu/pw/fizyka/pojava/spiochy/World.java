package pl.edu.pw.fizyka.pojava.spiochy;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class World {
    Integer carsLeft;

    ArrayList<Road> roadList;
    Intersection intersection;

    Parameters parameters;

    Random random;

    public World(Parameters parameters) {
        this.parameters = parameters;

        this.random = new Random();
    }

    public void addRoad(Road road) {
        roadList.add(road);
    }

    public void draw(Graphics2D g2d) {

    }

    public void step() {

    }
}
