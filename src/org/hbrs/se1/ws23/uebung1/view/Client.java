package org.hbrs.se1.ws23.uebung1.view;

import org.hbrs.se1.ws23.uebung1.control.Factory_Translator;
import org.hbrs.se1.ws23.uebung1.control.Translator;

public class Client {

		/*
		 * Methode zur Ausgabe einer Zahl auf der Console
		 * (auch bezeichnet als CLI, Terminal)
		 *
		 */
		 void display( int aNumber ){
			// In dieser Methode soll die Methode translateNumber
			// mit dem übergegebenen Wert der Variable aNumber
			// aufgerufen werden.
			//
			// Strenge Implementierung gegen das Interface Translator gewuenscht!


			 Translator t1 = Factory_Translator.create_GermanTranslator();
			System.out.println("Das Ergebnis der Berechnung: " + "[" + t1.translateNumber(aNumber) + "]"  );

		 }
}





