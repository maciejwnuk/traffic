package pl.edu.pw.fizyka.pojava.spiochy.i18n;

import java.util.ListResourceBundle;

public class ResourceBundle_en_US extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"title", "Road traffic simulator"},
			{"acceleration", "Acceleration"},
			{"reactionTime", "Driver's reaction time"},
			{"carAmount", "Number of cars"},
			{"intersectionType", "Intersection type"},
			{"lights", "Lights"},
			{"peer", "Peer"},
			{"row", "Row"},
			{"updateParameters", "Update parameters"},
			{"importParameters", "Import parameters from file"},
			{"BrakesPower", "Brakes power"},
			
			{"statistics", "Statistics"},
			{"mean", "Average time"},
			{"median", "Median"},
			{"variance", "Variance"},
			{"save", "Save as .txt"},
			
			{"run", "Run"},
			{"resume", "Resume"},
			{"stop", "Stop"},
			
			{"chooseFile", "Choose file"},
			{"fileNotChosen", "File is not chosen"},
		};
	}

}
