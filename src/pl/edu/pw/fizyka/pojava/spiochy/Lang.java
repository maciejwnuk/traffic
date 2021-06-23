package pl.edu.pw.fizyka.pojava.spiochy;

import java.util.Locale;
import java.util.ResourceBundle;

public class Lang {
	
	Locale langPL = new Locale("pl", "PL");
	Locale langEN = new Locale("en", "US");
	Locale lang;
	ResourceBundle rb = ResourceBundle.getBundle("pl.edu.pw.fizyka.pojava.spiochy.i18n.ResourceBundle", langPL);
	
	Lang() {}
	
	void setRBEN() {
		lang = langEN;
		rb = ResourceBundle.getBundle("pl.edu.pw.fizyka.pojava.spiochy.i18n.ResourceBundle", lang);
	}
	
	void setRBPL() {
		lang = langPL;
		rb = ResourceBundle.getBundle("pl.edu.pw.fizyka.pojava.spiochy.i18n.ResourceBundle", lang);
	}
	
	ResourceBundle getRB() {
		return rb;
	}
	
}
