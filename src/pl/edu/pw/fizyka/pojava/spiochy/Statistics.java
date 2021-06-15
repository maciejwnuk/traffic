package pl.edu.pw.fizyka.pojava.spiochy;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
	List<Long> measuredTimes = new ArrayList<Long>();

	long averageTime() {
		long sum = 0;
		for(int i=0; i<measuredTimes.size(); i++) {
			sum = sum + measuredTimes.get(i);
		}
		
		return (sum/measuredTimes.size());
	}
	
	long median() {
		measuredTimes.sort(null);

		if (measuredTimes.size() % 2 == 0) {
			return (measuredTimes.get((measuredTimes.size() - 1) / 2) + measuredTimes.get(measuredTimes.size() / 2)) / 2;
		} else {
			return measuredTimes.get(measuredTimes.size() / 2);
		}
	}
	
	long variance() {
		long sumavg = 0;
		long sumtot = 0;
		
		for(int i=0; i<measuredTimes.size(); i++) {
			sumavg = sumavg + measuredTimes.get(i);
		}
		
		for(int i=0; i<measuredTimes.size(); i++) {
			sumtot = sumtot + ( (measuredTimes.get(i) - (sumavg/measuredTimes.size()))*(measuredTimes.get(i) - (sumavg/measuredTimes.size())) );
		}
		
		return (sumtot/(measuredTimes.size()-1));
	}
}
