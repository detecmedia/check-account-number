package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.InvalidAcountNumberException;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * @author Markus Potthast
 */
public abstract class AbstractMethod implements CheckAccountNumber {
    /**
     * account number array
     */
    private int[] accountNumberArray;
    /**
     * Logger for this classe
     */
    private final Logger log = Logger.getLogger(AbstractMethod.class);
    /**
     * weighting,
     */
    private int[] weighting;

    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * AccountNumber
     */
    private String accountNumber;

    /**
     * @param accountnumber AccountNumber
     */
    @Override
    public void setAccountNumber(final String accountnumber) {

        this.accountNumber = accountnumber;
    }

    /**
     * Return AccountNumber as int Array.
     *
     * @return int[] accountNumner
     */
    protected int[] getAccountNumberArray() {
        if (this.accountNumberArray == null) {
            int lengthOfAccountNumber = accountNumber.length();
            int[] value = new int[lengthOfAccountNumber];
            log.debug("length of accountNumber: " + lengthOfAccountNumber);
            for (int i = 0; i < value.length; i++) {
                log.debug("Char at Pos " + i + " is " + accountNumber.charAt(i));
                value[i] = accountNumber.charAt(i) - '0';
            }
            this.accountNumberArray = value;
        }
        return this.accountNumberArray;
    }

    /**
     * set account number from int[]
     *
     * @param accountnumberarray account number
     */
    public void setAccountNumberArray(final int[] accountnumberarray) {

        this.accountNumberArray = accountnumberarray;
    }

    /**
     * return AccountNumber as int.
     *
     * @return int AccountNumber
     * @throws NumberFormatException whenn can't convert AccountNumber String to
     *                               int.
     */
    public int getInt() throws NumberFormatException {
        log.debug("set Accountnumber is: " + accountNumber);
        return Integer.parseInt(accountNumber.trim());
    }

    /**
     * get account number as long
     *
     * @return long account number
     * @throws NumberFormatException
     */
    public long getLong() throws NumberFormatException {
        log.debug("set Accountnumber is: " + accountNumber);
        if (accountNumber == null) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < accountNumberArray.length; i++) {
                int b = accountNumberArray[i];
                str.append(b);
            }
            accountNumber = str.toString();
        }
        return Long.parseLong(accountNumber);
    }

    /**
     * TODO TESTEN.
     *
     * @param zahl int
     * @return int quersumme
     */
    public int quersumme(int zahl) {

        int quersumme = 0;
        do {
            quersumme = quersumme + zahl % 10;
            zahl = zahl / 10;
        } while (zahl > 0);

        zahl = quersumme;

        return zahl;
    }

    /**
     * @param zahl Zubrerechnende Zahl
     * @return Quersumme
     */
    public int iterierteQuersumme(int zahl) {

        while (zahl > 9) {

            int quersumme = 0;
            do {
                quersumme = quersumme + zahl % 10;
                zahl = zahl / 10;
            } while (zahl > 0);

            zahl = quersumme;
        }

        return zahl;
    }

    /**
     * Math method.
     *
     * @param number    int[] AccountNumber
     * @param weighting weighting
     * @return int
     */
    protected int[] factor(int[] number, int[] weighting) {
        log.debug("accountNumber: " + this.accountNumber);

        return this.factor(number, weighting, 1, number.length - 1);
        //return number;
    }

    /**
     * @param number
     * @param weighting
     * @param start     start calculate from account number position
     * @param end       end calculate by account number position
     * @return
     */
    protected int[] factor(int[] number, int[] weighting, int start, int end) {

        start--;
        log.debug("start: " + start);
        log.debug("end: " + end);
        log.debug("tmp array:" + (end - start));
        int[] tmp = new int[(end - start)];
        log.debug("tmp.lenght " + tmp.length);
        //end--;
        log.debug("number:" + Arrays.toString(number));
        log.debug("weighting:" + Arrays.toString(weighting));

        int tmpI = 0;
        for (int i = start; i < end; i++) {
            tmp[tmpI++] = number[i];

        }
        tmpI = 0;
        for (int i = tmp.length - 1; i != -1; i--) {
            int u = tmp[i];
            if (tmpI < weighting.length) {
                log.debug(u + " * " + weighting[tmpI]);
                tmp[i] *= weighting[tmpI++];
            }
        }
        log.debug("tmp: " + Arrays.toString(tmp));
        tmpI = 0;

        log.debug("tmp " + start + "-" + end + ": " + Arrays.toString(tmp));
        for (int i = start; i < end; i++) {
            number[i] = tmp[tmpI++];
        }
        log.debug("number: " + Arrays.toString(number));
        return number;
    }

    /**
     * Modulus 10.
     *
     * @param number int
     * @return int
     */
    protected int modulus10(int number) {
        number %= 10;
        int checkDigit;
        log.debug("pz: " + (checkDigit = 10 - number));
        if (checkDigit == 10) {
            checkDigit = 0;
        }
        return checkDigit;
    }

    /**
     * Modulus 11 returns check digit.
     *
     * @param number int
     * @return int check digit
     */
    protected int modulus11(int number) {
        int checkDigit;
        number %= 11;

        log.debug("%11: " + number);
        if (number == 0) {
            log.debug("pz 0: " + number);
            return 0;
        }
        if (number == 1) {
            log.debug("InvalidException");
            throw new InvalidAcountNumberException();
        }
        checkDigit = 11 - number;
        log.debug("pz all: " + checkDigit);
        return checkDigit;
    }

    /**
     * Check PZ with last number of AccountNumber.
     *
     * @param pz     int Prüfziffer
     * @param number int[] AccountNumber
     * @return returns true by correct AccountNumber otherwise false.
     */
    protected boolean checkPz(int pz, int[] number) {
        return this.checkPz(pz, number, number.length);
    }

    /**
     * check checkdigit in account number.
     *
     * @param pz     int checkdigit
     * @param number int[] account number
     * @param pos    int pos of account number
     * @return true|false after check
     */
    protected boolean checkPz(int pz, int[] number, int pos) {
        log.debug("Number: " + Arrays.toString(number));
        log.debug("pz to number " + pos + " = " + pz + " to " + number[pos - 1]);
        if (pz == number[--pos]) {
            return true;
        }
        return false;
    }

    protected int add(int[] number) {
        return add(number, 0, number.length - 1);
    }

    /**
     * Addition from numbers
     *
     * @param number account number array
     * @param start  start pos
     * @param end    end pos
     * @return
     */
    protected int add(int[] number, int start, int end) {
        log.debug(start + " to " + end);
        int pz = 0;
        for (int i = start--; i < end; i++) {

            int o = number[i];
            if (o > 9) {
                o = quersumme(o);
            }
            log.debug("+" + o);
            pz += o;
        }
        log.debug("after add: " + pz);
        return pz;
    }

    /**
     * Füllt Accountnumber linksbündig mit nullen auf.
     *
     * @param number
     * @return
     */
    protected int[] expand(final int[] number) {
        int[] tmp = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int numberI = 0;
        for (int i = tmp.length - number.length; i < tmp.length; i++) {
            tmp[i] = number[numberI++];
        }

        return tmp;
    }

    protected int[] move(int[] number, int pos) {
        if (pos < 0) {
            pos *= -1;
            int[] tmp = new int[number.length];
            int tmpI = 0;
            for (int i = pos; i < number.length; i++) {
                tmp[tmpI++] = number[i];
            }
            log.debug("move: " + Arrays.toString(tmp));
            number = tmp;
        } else {
            int[] tmp = new int[number.length];
            int tmpI = 0;
            for (int i = pos; i < tmp.length; i++) {
                tmp[i] = number[tmpI++];
            }
            log.debug("move: " + Arrays.toString(tmp));
            number = tmp;
        }
        return number;
    }

    @Override
    final public char[] getFlag() {
        String name = getClass().getName();
        log.debug(name);
        log.debug(name.substring(name.length() - 2, name.length()));
        return name.substring(name.length() - 2, name.length()).toCharArray();
    }

    /**
     * Modulus 7. Die Summe der Produkte ist jedoch durch 7 zu dividieren. Der
     * verbleibende Rest wird vom Divisor (7) subtrahiert. Das Ergebnis ist die
     * Prüfziffer. Verbleibt kein Rest, ist die Prüfziffer 0.
     *
     * @param number
     * @return
     */
    protected int modulus7(int number) {
        number = (number % 7);
        if (number == 0) {
            return 0;
        }
        return 7 - number;
    }

    public int[] getWeighting() {
        return weighting;
    }

    public void setWeighting(int[] weighting) {
        this.weighting = weighting;
    }
}
