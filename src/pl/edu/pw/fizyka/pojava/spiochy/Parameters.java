package pl.edu.pw.fizyka.pojava.spiochy;

class Parameters {
    double acceleration;
    double reactionTime;
    int carAmount;
    IntersectionType intersectionType;

    public Parameters(double acceleration, double reactionTime, int carAmount, IntersectionType intersectionType) {
        this.acceleration = acceleration;
        this.reactionTime = reactionTime;
        this.carAmount = carAmount;
        this.intersectionType = intersectionType;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getReactionTime() {
        return reactionTime;
    }

    public void setReactionTime(double reactionTime) {
        this.reactionTime = reactionTime;
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

    public void setIntersectionType(IntersectionType intersectionType) {
        this.intersectionType = intersectionType;
    }
}
