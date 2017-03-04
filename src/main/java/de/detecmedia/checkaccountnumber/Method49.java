package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.*;

/**
 * Kennzeichen 49.
 * <p>
 * <b>Variante 1</b></p><p>
 * Die Prüfzifferberechnung ist nach Kennzeichen 00 durchzuführen.</p><p>
 * Führt die Berechnung nach Variante 1 zu einem Prüfzifferfehler, so ist die
 * Berechnung nach Variante 2 vorzunehmen.</p>
 * <p>
 * <b>Variante 2</b></p><p>
 * Die Prüfzifferberechnung ist nach Kennzeichen 01 durchzuführen.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method00
 * @see Method01
 */
public class Method49 extends AbstractMethod {

    @Override
    public boolean test() {
        Method00 method00 = new Method00();
        method00.setAccountNumber(accountNumber);
        boolean check = method00.test();
        if (check) {
            return true;
        }
        Method01 method01 = new Method01();
        method01.setAccountNumber(accountNumber);
        return method01.test();
    }

}
