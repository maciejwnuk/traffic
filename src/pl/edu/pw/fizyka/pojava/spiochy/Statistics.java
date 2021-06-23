package pl.edu.pw.fizyka.pojava.spiochy;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
	List<Double> measuredTimes;

	public Statistics() {
		this.measuredTimes = new ArrayList<>();
	}

	public void addEntry(double time) {
		measuredTimes.add(time);
	}

	public double averageTime() {
		if (measuredTimes.isEmpty())
			return 0;

		double sum = 0;

		for(int i=0; i<measuredTimes.size(); i++) {
			sum = sum + measuredTimes.get(i);
		}
		
		return (sum/measuredTimes.size());
	}

	public double median() {
		if (measuredTimes.isEmpty())
			return 0;

		measuredTimes.sort(null);

		if (measuredTimes.size() % 2 == 0) {
			return (measuredTimes.get((measuredTimes.size() - 1) / 2) + measuredTimes.get(measuredTimes.size() / 2)) / 2;
		} else {
			return measuredTimes.get(measuredTimes.size() / 2);
		}
	}

	public double variance() {
		if (measuredTimes.isEmpty())
			return 0;

		double sumavg = 0;
		double sumtot = 0;
		
		for(int i=0; i<measuredTimes.size(); i++) {
			sumavg = sumavg + measuredTimes.get(i);
		}
		
		for(int i=0; i<measuredTimes.size(); i++) {
			sumtot = sumtot + ( (measuredTimes.get(i) - (sumavg/measuredTimes.size()))*(measuredTimes.get(i) - (sumavg/measuredTimes.size())) );
		}
		
		return (sumtot/(measuredTimes.size()-1));
	}
}
