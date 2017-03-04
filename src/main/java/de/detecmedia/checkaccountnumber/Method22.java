package de.detecmedia.checkaccountnumber;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 22.
 * <p>
 * Modulus 10, Gewichtung 3, 1, 3, 1, 3, 1, 3, 1, 3</p><p>
 * Die einzelnen Stellen der Kontonummer sind von rechts nach links mit den
 * Ziffern 3, 1, 3, 1 usw. zu multiplizieren. Von den jeweiligen Produkten
 * bleiben die Zehnerstellen unberücksichtigt. Die verbleibenden Zahlen
 * (Einerstellen) werden addiert. Die Differenz bis zum nächsten Zehner ist die
 * Prüfziffer.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method22 extends AbstractMethod {

    private static Logger log = Logger.getLogger(Method22.class);

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{3, 1, 3, 1, 3, 1, 3, 1, 3};
        return calculate(weighting);
    }


    @Override
    protected int add(int[] number) {
        int pz = 0;
        log.debug("Number " + Arrays.toString(number));
        for (int i = 0; i < number.length - 1; i++) {
            int o = number[i];
            log.debug("" + o);
            if (o > 0) {
                log.debug("% 10 " + (o % 10));
                pz += (o % 10);
            }
        }

        return pz;
    }

    protected boolean calculate(int[] weighting) {
        int[] number = factor(this.getAccountNumberArray(), weighting);

        int pz = this.add(number);
        pz = 10 - (pz % 10);

        pz %= 10;

        return checkPz(pz, number);
    }

}
