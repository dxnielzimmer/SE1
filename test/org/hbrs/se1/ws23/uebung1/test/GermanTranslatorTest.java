package org.hbrs.se1.ws23.uebung1.test;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws23.uebung1.control.Translator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class GermanTranslatorTest {
    private GermanTranslator translator = new GermanTranslator();

    @Test
    void gt_Test() {
        String pos_ak1 = translator.translateNumber(1);
        assertEquals(pos_ak1, "eins");

        String pos_ak3 = translator.translateNumber(100);
        assertEquals(pos_ak3, "Übersetzung der Zahl [" + 100 + "] nicht\n" +
                "möglich ([" + Translator.version + "])");

        String neg_ak2 = translator.translateNumber(-1);
        assertEquals(neg_ak2,"Übersetzung der Zahl [" + -1 + "] nicht\n" +
                "möglich ([" + Translator.version + "])");
    }
}