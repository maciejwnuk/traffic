package pl.edu.pw.fizyka.pojava.spiochy;

public class Parameters {
	
	double acceleration;
	double reactionTime;
	int numberOfCars;

	public Parameters(double acceleration, double reactionTime, int numberOfCars) {
		this.acceleration = acceleration;
		this.reactionTime = reactionTime;
		this.numberOfCars = numberOfCars;
	}

	
	public double getAcceleration() {
		return acceleration;
	}
	
	public double getReactionTime() {
		return reactionTime;
	}
	
	public int getNumberOfCars() {
		return numberOfCars;
	}
	
	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}
	
	public void setReactionTime(double reactionTime) {
		this.reactionTime = reactionTime;
	}
	
	public void setNumberOfCars(int numberOfCars) {
		this.numberOfCars = numberOfCars;
	}
	
	public void updateParameters(double acceleration, double reactionTime, int numberOfCars) {
		this.acceleration = acceleration;
		this.reactionTime = reactionTime;
		this.numberOfCars = numberOfCars;
	}
}
