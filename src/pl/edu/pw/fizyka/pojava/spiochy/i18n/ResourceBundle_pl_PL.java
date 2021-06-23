package pl.edu.pw.fizyka.pojava.spiochy.i18n;

import java.util.ListResourceBundle;

public class ResourceBundle_pl_PL extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"title", "Symulacja ruchu drogowego"},
			{"acceleration", "Przyspieszenie pojazdów"},
			{"reactionTime", "Czas reackji kierowcy"},
			{"carAmount", "Ilość pojazdów"},
			{"intersectionType", "Rodzaj skrzyżowania"},
			{"lights", "Światła"},
			{"peer", "Równorzędne"},
			{"row", "Z pierwszeństwem przejazdu"},
			{"updateParameters", "Aktualizuj parametry"},
			{"importParameters", "Wczytaj parametry z pliku"},
			{"BrakesPower", "Moc hamulców"},
			
			{"statistics", "Statystyki przejazdu"},
			{"mean", "Średni czas"},
			{"median", "Mediana"},
			{"variance", "Wariancja"},
			{"save", "Zapisz do pliku"},
			
			{"run", "Uruchom"},
			{"resume", "Wznów"},
			{"stop", "Zatrzymaj"},
			
			{"chooseFile", "Wybierz plik"},
			{"fileNotChosen", "Nie wybrano pliku"},
		};
	}

}
