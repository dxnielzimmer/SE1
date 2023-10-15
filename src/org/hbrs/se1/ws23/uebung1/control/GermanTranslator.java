package org.hbrs.se1.ws23.uebung1.control;
import java.util.HashMap;

public class GermanTranslator implements Translator {

	public String date = "Okt/2023"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) {
		// [ihr Source Code aus Übung 1-2]

		HashMap<Integer,String> t_number = new HashMap<>();
		t_number.put(1,"eins");
		t_number.put(2,"zwei");
		t_number.put(3,"drei");
		t_number.put(4,"vier");
		t_number.put(5,"fünf");
		t_number.put(6,"sechs");
		t_number.put(7,"sieben");
		t_number.put(8,"acht");
		t_number.put(9,"neun");
		t_number.put(10,"zehn");

		String ouput = t_number.getOrDefault(number,"Übersetzung der Zahl [" + number + "] nicht\n" +
				"möglich ([" + Translator.version + "])");

		return ouput;
	}

	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: "Okt/2022"))
	 * Das Datum sollte system-intern durch eine Control-Klasse gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
