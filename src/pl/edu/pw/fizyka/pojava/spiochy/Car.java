package pl.edu.pw.fizyka.pojava.spiochy;

import java.awt.*;

public class Car {
    int x;
    int y;

    double velocity;

    Color color;
    CarState state;
    TurnDirection turnDirection;
    DriveDirection driveDirection;

    public Car(int x, int y, Color color, DriveDirection driveDirection, TurnDirection turnDirection) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.driveDirection = driveDirection;
        this.turnDirection = turnDirection;

        this.velocity = 0.1;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public CarState getState() {
        return state;
    }

    public void setState(CarState state) {
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public TurnDirection getTurnDirection() {
        return turnDirection;
    }

    public void setTurnDirection(TurnDirection turnDirection) {
        this.turnDirection = turnDirection;
    }

    public DriveDirection getDriveDirection() {
        return driveDirection;
    }

    public void setDriveDirection(DriveDirection driveDirection) {
        this.driveDirection = driveDirection;
    }
}
