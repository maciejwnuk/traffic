package pl.edu.pw.fizyka.pojava.spiochy;

import pl.edu.pw.fizyka.pojava.spiochy.math.SpawnPoint2D;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

public class World {
    ArrayList<Car> carList;
    Integer carsLeft;

    ArrayList<Road> roadList;
    Intersection intersection;

    Parameters parameters;
    Statistics statistics;

    Random random;

    public World(Parameters parameters, Statistics statistics) {
        this.parameters = parameters;
        this.statistics = statistics;

        this.clearRoads();

        this.random = new Random();
    }

    public void addRoad(Road road) {
        this.roadList.add(road);

        if (this.roadList.size() == 2) {
            switch (this.parameters.getIntersectionType()) {
                case LIGHTS -> this.intersection = new LightsIntersection();
                case PEER -> this.intersection = new PeerIntersection();
                case ROW -> this.intersection = new RowIntersection();
                default -> throw new IllegalStateException("Unexpected value: " + this.parameters.getIntersectionType());
            }

            double x1 = roadList.get(0).getPath().getX1();
            double x2 = roadList.get(0).getPath().getX2();

            double y1 = roadList.get(0).getPath().getY1();
            double y2 = roadList.get(0).getPath().getY2();

            double x3 = roadList.get(1).getPath().getX1();
            double x4 = roadList.get(1).getPath().getX2();

            double y3 = roadList.get(1).getPath().getY1();
            double y4 = roadList.get(1).getPath().getY2();

            double d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

            double x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / d;
            double y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / d;

            this.intersection.setPosition(new Point2D.Double(x, y));
        }
    }

    public void clearRoads() {
        this.carsLeft = parameters.getCarAmount();
        this.roadList = new ArrayList<>();
        this.carList = new ArrayList<>();
    }

    public void spawnCar(Road road) {
        SpawnPoint2D spawnPoint = road.getSpawnPoint(random.nextBoolean());
        Path2D path = this.makePath(road, spawnPoint, TurnDirection.values()[random.nextInt(3)]);
        PathIterator iter = path.getPathIterator(null, MainFrame.DELTA_TIME);
        ArrayList<Point2D> route = new ArrayList<>();

        while (!iter.isDone()) {
            double[] coords = new double[6];
            switch (iter.currentSegment(coords)) {
                case PathIterator.SEG_MOVETO:
                case PathIterator.SEG_LINETO:
                    route.add(new Point2D.Double(coords[0], coords[1]));
                    break;
            }
            iter.next();
        }

        carList.add(new Car(
                spawnPoint,
                route,
                new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256))
        ));
    }

    public Path2D makePath(Road road, SpawnPoint2D spawnPoint, TurnDirection dir) {
        Path2D route = new Path2D.Double();
        Point2D origin = spawnPoint.getPosition();

        route.moveTo(origin.getX(), origin.getY());

        Point2D iPos = this.intersection.getPosition();

        if (road.isHorizontal()) {
            // LEFT TO RIGHT
            if (origin.getX() < iPos.getX()) {
                route.lineTo(iPos.getX() - Car.LENGTH, origin.getY());

                switch (dir) {
                    case LEFT:
                        route.lineTo(iPos.getX(), origin.getY());
                        route.curveTo(
                                iPos.getX(),
                                origin.getY(),
                                iPos.getX() + Road.WIDTH / 2,
                                iPos.getY() + Road.WIDTH / 2,
                                iPos.getX() + Road.WIDTH / 2,
                                iPos.getY() - Car.LENGTH
                        );
                        route.lineTo(iPos.getX() + Road.WIDTH / 2, 0);
                        break;
                    case FORWARD:
                        route.lineTo(iPos.getX() * 2, origin.getY());
                        break;
                    case RIGHT:
                        route.curveTo(
                                iPos.getX() - Car.LENGTH,
                                origin.getY(),
                                iPos.getX(),
                                iPos.getY(),
                                iPos.getX() - Road.WIDTH / 2,
                                iPos.getY() + Car.LENGTH
                        );
                        route.lineTo(iPos.getX() - Road.WIDTH / 2, iPos.getY() * 2);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + dir);
                }
            // RIGHT TO LEFT
            } else {
                route.lineTo(iPos.getX() + Car.LENGTH, origin.getY());

                switch (dir) {
                    case LEFT:
                        route.lineTo(iPos.getX(), origin.getY());
                        route.curveTo(
                                iPos.getX(),
                                origin.getY(),
                                iPos.getX() - Road.WIDTH / 2,
                                iPos.getY() - Road.WIDTH / 2,
                                iPos.getX() - Road.WIDTH / 2,
                                iPos.getY() + Car.LENGTH
                        );
                        route.lineTo(iPos.getX() - Road.WIDTH / 2, iPos.getY() * 2);
                        break;
                    case FORWARD:
                        route.lineTo(0, origin.getY());
                        break;
                    case RIGHT:
                        route.curveTo(
                                iPos.getX() + Car.LENGTH,
                                origin.getY(),
                                iPos.getX(),
                                iPos.getY(),
                                iPos.getX() + Road.WIDTH / 2,
                                iPos.getY() - Car.LENGTH
                        );
                        route.lineTo(iPos.getX() + Road.WIDTH / 2, 0);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + dir);
                }
            }
        } else {
            // UP TO DOWN
            if (origin.getY() < iPos.getY()) {
                route.lineTo(origin.getX(), iPos.getY() - Car.LENGTH);

                switch (dir) {
                    case LEFT:
                        route.lineTo(origin.getX(), iPos.getY());
                        route.curveTo(
                                origin.getX(),
                                iPos.getY(),
                                iPos.getX() - Road.WIDTH / 2,
                                iPos.getY() + Road.WIDTH / 2,
                                iPos.getX() + Car.LENGTH,
                                iPos.getY() + Road.WIDTH / 2
                        );
                        route.lineTo(iPos.getX() * 2, iPos.getY() + Road.WIDTH / 2);
                        break;
                    case FORWARD:
                        route.lineTo(origin.getX(), iPos.getY() * 2);
                        break;
                    case RIGHT:
                        route.curveTo(
                                origin.getX(),
                                iPos.getY() - Car.LENGTH,
                                iPos.getX(),
                                iPos.getY(),
                                iPos.getX() - Car.LENGTH,
                                iPos.getY() - Road.WIDTH / 2
                        );
                        route.lineTo(0, iPos.getY() - Road.WIDTH / 2);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + dir);
                }
            // DOWN TO UP
            } else {
                route.lineTo(origin.getX(), iPos.getY() + Car.LENGTH);

                switch (dir) {
                    case LEFT:
                        route.lineTo(origin.getX(), iPos.getY());
                        route.curveTo(
                                origin.getX(),
                                iPos.getY(),
                                iPos.getX() + Road.WIDTH / 2,
                                iPos.getY() - Road.WIDTH / 2,
                                iPos.getX() - Car.LENGTH,
                                iPos.getY() - Road.WIDTH / 2
                        );
                        route.lineTo(0, iPos.getY() - Road.WIDTH / 2);
                        break;
                    case FORWARD:
                        route.lineTo(origin.getX(), 0);
                        break;
                    case RIGHT:
                        route.curveTo(
                                origin.getX(),
                                iPos.getY() + Car.LENGTH,
                                iPos.getX(),
                                iPos.getY(),
                                iPos.getX() + Car.LENGTH,
                                iPos.getY() + Road.WIDTH / 2
                        );
                        route.lineTo(iPos.getX() * 2, iPos.getY() + Road.WIDTH / 2);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + dir);
                }
            }
        }

        return route;
    }

    public void draw(Graphics2D g2d) {
        for (Road road: roadList) {
            road.draw(g2d);
        }

        Point2D iPos = this.intersection.getPosition();

        g2d.setColor(Road.COLOR);
        g2d.fillRect(
            (int) (iPos.getX() - Road.WIDTH),
            (int) (iPos.getY() - Road.WIDTH),
            (int) (2 * Road.WIDTH),
            (int) (2 * Road.WIDTH)
        );

        for (Car car: carList) {
            car.draw(g2d);
        }
    }

    public void step() {
        ArrayList<Car> carsToDrop = new ArrayList<>();
        Point2D iPos = this.intersection.getPosition();

        for (Car car: carList) {
            // Check if is near intersection && going too quick
            if (car.getPosition().getX() > iPos.getX() - Road.WIDTH * 2
                    && car.getPosition().getX() < iPos.getX() + Road.WIDTH * 2
                    && car.getPosition().getY() > iPos.getY() - Road.WIDTH * 2
                    && car.getPosition().getY() < iPos.getY() + Road.WIDTH * 2
                    && car.getVelocity() > Road.SPEED_LIMIT / 2) {
                car.slowDown(car.getVelocity() * parameters.getBrakingPower());
            } else {
                car.speedUp(parameters.getAcceleration()); // Accelerate to road limit
            }

            car.move();

            if (car.hasFinished()) {
                carsToDrop.add(car);
            }
        }

        for (Car car: carsToDrop) {
            statistics.addEntry(car.getTimeElapsed());

            carList.remove(car);
            carsLeft -= 1;

            if (!hasFinished())
                spawnCar(roadList.get(random.nextInt(2)));
        }
    }

    public boolean hasFinished() {
        return (carsLeft == 0);
    }
}
