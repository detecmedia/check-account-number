package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.calculator.Modulus;
import de.detecmedia.checkaccountnumber.converter.Weighting;


import java.util.Arrays;

import de.detecmedia.checkaccountnumber.model.AccountNumber;
import org.apache.log4j.Logger;

import static de.detecmedia.checkaccountnumber.calculator.Factory.factory;
import static de.detecmedia.checkaccountnumber.calculator.Factory.factoryOld;
import static de.detecmedia.checkaccountnumber.calculator.Modulus.Modulus11;
import static de.detecmedia.checkaccountnumber.model.AccountNumber.accountNumber;

/**
 * @author Markus Potthast
 */
public abstract class AbstractMethod implements CheckAccountNumber {
    /**
     * account number array.
     */
    private int[] accountNumberArray;

    /**
     * Logger for this class.
     */
    private final static Logger LOG = Logger.getLogger(AbstractMethod.class);

    /**
     * define weighting.
     */
    private int[] weighting;

    /**
     * AccountNumber
     */
    private AccountNumber accountNumber;

    /**
     * @param accountnumber AccountNumber
     */
    @Override
    public void setAccountNumber(final String accountnumber) {
        this.accountNumber = accountNumber(accountnumber);
    }

    public String getAccountNumber() {
        return accountNumber.get();
    }

    /**
     * Return AccountNumber as int Array.
     *
     * @return int[] accountNumner
     */
    protected int[] getAccountNumberArray() {
        return this.accountNumber.getIntArray();
    }

    /**
     * set account number from int[]
     *
     * @param accountnumberarray account number
     */
    public void setAccountNumberArray(final int[] accountnumberarray) {
        String tmp = "";
        for (int number : accountnumberarray) {
            tmp += number;
        }
        accountNumber = accountNumber(tmp);
        this.accountNumberArray = accountNumber.getIntArray();

    }

    /**
     * return AccountNumber as int.
     *
     * @return int AccountNumber
     * @throws NumberFormatException whenn can't convert AccountNumber String to
     *                               int.
     */
    public int getInt() throws NumberFormatException {
        LOG.debug("set Accountnumber is: " + accountNumber);
        return Integer.parseInt(accountNumber.trim());
    }

    /**
     * @return long
     */
    public long getLong() {
        LOG.debug("set Accountnumber is: " + accountNumber);
        return accountNumber.getAccountNumber();
    }

    /**
     * TODO TESTEN.
     *
     * @param zahl int
     * @return int quersumme
     */
    public int quersumme(final int zahl) {

        int quersumme = 0;
        int z = zahl;

        do {
            quersumme = quersumme + z % 10;
            z = z / 10;
        } while (z > 0);

        return quersumme;
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
        LOG.debug("accountNumber: " + this.accountNumber);

        return factory(number, weighting);
        //return number;
    }

    /**
     * @param number
     * @param weighting
     * @param start     start Factory from account number position
     * @param end       end Factory by account number position
     * @return
     */
    protected int[] factor(int[] number, int[] weighting, int start, int end) {
        return factoryOld(number, weighting, start, end);
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
        LOG.debug("pz: " + (checkDigit = 10 - number));
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
        return Modulus11(number);
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
        LOG.debug("Number: " + Arrays.toString(number));
        LOG.debug("pz to number " + pos + " = " + pz + " to " + number[pos - 1]);
        return pz == number[--pos];
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
        LOG.debug(start + " to " + end);
        int pz = 0;
        for (int i = start--; i < end; i++) {

            int o = number[i];
            if (o > 9) {
                o = quersumme(o);
            }
            LOG.debug("+" + o);
            pz += o;
        }
        LOG.debug("after add: " + pz);
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
            LOG.debug("move: " + Arrays.toString(tmp));
            number = tmp;
        } else {
            int[] tmp = new int[number.length];
            int tmpI = 0;
            for (int i = pos; i < tmp.length; i++) {
                tmp[i] = number[tmpI++];
            }
            LOG.debug("move: " + Arrays.toString(tmp));
            number = tmp;
        }
        return number;
    }

    @Override
    final public char[] getFlag() {
        String name = getClass().getName();
        LOG.debug(name);
        LOG.debug(name.substring(name.length() - 2, name.length()));
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
        return Modulus.Modulus7(number);
    }

    public int[] getWeighting() {
        return weighting;
    }

    public void setWeighting(int[] weighting) {
        this.weighting = weighting;
    }

    protected boolean check(int[] weighting) {
        return check(Weighting.Weighting(weighting));
    }

    protected boolean check(Weighting weighting) {
        return check(weighting.getWeighting());
    }
}
