package pl.edu.pw.fizyka.pojava.spiochy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class World {
    Dimension dimension;

    Color streetColor;
    Color lineColor;

    int streetWidth;
    int lineWidth;

    IntersectionType iType;

    BufferedImage lightsImg;
    BufferedImage rightImg;
    BufferedImage rowImg;

    int carWidth;
    int carLength;

    List<Car> cars;

    Random random;

    public World(Color streetColor, Color lineColor, int streetWidth, int lineWidth, IntersectionType iType) {
        this.streetColor = streetColor;
        this.lineColor = lineColor;
        this.streetWidth = streetWidth;
        this.lineWidth = lineWidth;
        this.iType = iType;

        this.carWidth = streetWidth / 2 - lineWidth * 2;
        this.carLength = this.carWidth * 2;

        try {
            this.lightsImg = ImageIO.read(new File("./assets/Lights.png"));
            this.rightImg = ImageIO.read(new File("./assets/Right.png"));
            this.rowImg = ImageIO.read(new File("./assets/Row.png"));
        } catch (IOException e) {
            System.out.println("Error occurred during loading images.");
            System.exit(1);
        }

        this.random = new Random();
        this.cars = new ArrayList<Car>();
    }

    public void step(double dt) {
        for (Car car: this.cars) {
            if (car.getDriveDirection() == DriveDirection.RIGHT) {
                car.setX((int) (car.getX() + car.getVelocity() * dt));
            } else if (car.getDriveDirection() == DriveDirection.UP) {
                car.setY((int) (car.getY() - car.getVelocity() * dt));
            } else if (car.getDriveDirection() == DriveDirection.LEFT) {
                car.setX((int) (car.getX() - car.getVelocity() * dt));
            } else if (car.getDriveDirection() == DriveDirection.DOWN) {
                car.setY((int) (car.getY() + car.getVelocity() * dt));
            }
        }
    }

    public void spawnCars(int carAmount) {
        for (int i = 0; i < carAmount; i++) {
            TurnDirection tDir = TurnDirection.values()[Math.abs(this.random.nextInt()) % 3];

            int x, y;
            DriveDirection dDir = DriveDirection.values()[Math.abs(this.random.nextInt()) % 4];

            if (dDir == DriveDirection.RIGHT) {
                x = this.carLength / 2 + this.lineWidth;
                y = (int) (this.dimension.getHeight() / 2 + this.carWidth / 2) + this.lineWidth;
            } else if (dDir == DriveDirection.UP) {
                x = (int) (this.dimension.getWidth() / 2 + this.carWidth / 2) + this.lineWidth;
                y = (int) (this.dimension.getHeight() - this.carLength / 2) - this.lineWidth;
            } else if (dDir == DriveDirection.LEFT) {
                x = (int) (this.dimension.getWidth() - this.carLength / 2) - this.lineWidth;
                y = (int) (this.dimension.getHeight() / 2 - this.carWidth / 2) - this.lineWidth;
            } else {
              x = (int) (this.dimension.getWidth() / 2 - this.carWidth / 2) - this.lineWidth;
              y = this.carLength / 2 + this.lineWidth;
            }

            int r = Math.abs(this.random.nextInt()) % 255;
            int g = Math.abs(this.random.nextInt()) % 255;
            int b = Math.abs(this.random.nextInt()) % 255;

            this.cars.add(new Car(x, y, new Color(r, g, b), dDir, tDir));
        }
    }

    public void draw(Graphics2D g2d) {
        this.paintStreets(g2d);
        this.paintLines(g2d);
        this.paintCars(g2d);
        this.paintIntersectionIndicator(g2d);
    }

    private void paintCars(Graphics2D g2d) {
        for (Car car: this.cars) {
            g2d.setColor(car.getColor());

            if (car.getDriveDirection() == DriveDirection.DOWN || car.getDriveDirection() == DriveDirection.UP) {
                g2d.fillRect(
                        car.getX() - this.carWidth / 2,
                        car.getY() - this.carLength / 2,
                        this.carWidth,
                        this.carLength);
            } else {
                g2d.fillRect(
                        car.getX() - this.carLength / 2,
                        car.getY() - this.carWidth / 2,
                        this.carLength,
                        this.carWidth);
            }
        }
    }

    private void paintStreets(Graphics2D g2d) {
        g2d.setColor(this.streetColor);

        g2d.fillRect(0, (int) (this.dimension.getHeight() - this.streetWidth) / 2, (int) this.dimension.getWidth(), this.streetWidth);
        g2d.fillRect((int) (this.dimension.getWidth() - this.streetWidth) / 2, 0, this.streetWidth, (int) this.dimension.getHeight());
    }

    private void paintLines(Graphics2D g2d) {
        g2d.setColor(this.lineColor);

        g2d.fillRect(0, (int) (this.dimension.getHeight() - this.lineWidth) / 2, (int) this.dimension.getWidth(), this.lineWidth);
        g2d.fillRect((int) (this.dimension.getWidth() - this.lineWidth) / 2, 0, this.lineWidth, (int) this.dimension.getHeight());
    }

    private void paintIntersectionIndicator(Graphics2D g2d) {
        if (iType == IntersectionType.LIGHTS) {
            g2d.drawImage(this.lightsImg, null, (int) this.dimension.getWidth() / 2 + this.streetWidth, (int) this.dimension.getHeight() / 2 - lightsImg.getHeight() - this.streetWidth);
        } else if (iType == IntersectionType.PEER) {
            g2d.drawImage(this.rightImg, null, (int) this.dimension.getWidth() / 2 + this.streetWidth, (int) this.dimension.getHeight() / 2 - rightImg.getHeight() - this.streetWidth);
        } else if (iType == IntersectionType.ROW) {
            g2d.drawImage(this.rowImg, null, (int) this.dimension.getWidth() / 2 + this.streetWidth, (int) this.dimension.getHeight() / 2 - rowImg.getHeight() - this.streetWidth);
        }
    }

    public void setIntersectionType(IntersectionType iType) {
        this.iType = iType;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
}
