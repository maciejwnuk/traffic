package pl.edu.pw.fizyka.pojava.spiochy;

class Parameters {
    double acceleration;
    double brakingPower;
    int carAmount;
    IntersectionType intersectionType;

    public Parameters(double acceleration, double brakingPower, int carAmount, IntersectionType intersectionType) {
        this.acceleration = acceleration;
        this.brakingPower = brakingPower;
        this.carAmount = carAmount;
        this.intersectionType = intersectionType;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getBrakingPower() {
        return brakingPower;
    }

    public void setBrakingPower(double brakingPower) {
        this.brakingPower = brakingPower;
    }

    public int getCarAmount() {
        return carAmount;
    }

    public void setCarAmount(int carAmount) {
        this.carAmount = carAmount;
    }

    public IntersectionType getIntersectionType() {
        return intersectionType;
    }

//    public void setIntersectionType(IntersectionType intersectionType) {
//        this.intersectionType = intersectionType;
//    }
}
