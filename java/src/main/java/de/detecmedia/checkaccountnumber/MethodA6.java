package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen A6.
 * <p>
 * <b>gültig seit 08.12.2003</b></p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Modulus 10, Gewichtung 3, 7, 1, 3, 7, 1, 3, 7, 1</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen. Die Stelle 10 ist die Prüfziffer.</p>
 * <p>
 * Sofern dann an der zweiten Stelle der Kontonummer eine 8 steht, erfolgen
 * Gewichtung und Berechnung wie beim Verfahren 00.</p>
 * <p>
 * Testkontonummern richtig: 800048548, 0855000014 <br>
 * Testkontonummern falsch: 860000817, 810033652</p>
 * <p>
 * Bei allen Kontonummern, die keine 8 an der zweiten Stelle haben, erfolgen
 * Gewichtung und Berechnung wie beim Verfahren 01.</p>
 * <p>
 * Testkontonummern (richtig): 17, 55300030, 150178033, 600003555, 900291823<br>
 * Testkontonummern (falsch): 305888, 200071280</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodA6
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (number[1] == 8) {
            return calculate1(number);
        } else {
            return calculate2(number);
        }
    }

    /**
     * <p>
     * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist
     * die Kontonummer für die Prüfzifferberechnung durch linksbündige
     * Auffüllung mit Nullen 10-stellig darzustellen. Die Stelle 10 ist die
     * Prüfziffer.</p>
     * <p>
     * Sofern dann an der zweiten Stelle der Kontonummer eine 8 steht, erfolgen
     * Gewichtung und Berechnung wie beim Verfahren 00.</p>
     *
     * @param number
     * @return
     */
    boolean calculate1(int[] number) {
        Method00 method00 = new Method00();
        method00.setAccountNumberArray(number);
        return method00.check(new int[]{ 2, 1, 2, 1, 2, 1, 2, 1, 2});
        
    }

    /**
     * <p>
     * Bei allen Kontonummern, die keine 8 an der zweiten Stelle haben, erfolgen
     * Gewichtung und Berechnung wie beim Verfahren 01.</p>
     * <p>
     * Testkontonummern (richtig): 17, 55300030, 150178033, 600003555,
     * 900291823<br>
     * Testkontonummern (falsch): 305888, 200071280</p>
     *
     * @param number
     * @return
     */
    boolean calculate2(int[] number) {
        Method01 method01 = new Method01();
        method01.setAccountNumberArray(number);
        return method01.check(new int[] {3, 7, 1, 3, 7, 1, 3, 7, 1});
    }

}
