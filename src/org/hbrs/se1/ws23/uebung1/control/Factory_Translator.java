package org.hbrs.se1.ws23.uebung1.control;

public class Factory_Translator {

    public static Translator create_GermanTranslator(){
        return new GermanTranslator();
    }
}
