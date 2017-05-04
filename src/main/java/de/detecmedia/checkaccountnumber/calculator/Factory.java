package de.detecmedia.checkaccountnumber.calculator;

import de.detecmedia.checkaccountnumber.constants.Factor;
import de.detecmedia.checkaccountnumber.converter.Weighting;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * checkaccountnumber
 * <p>
 * Created on 05.03.17.
 *
 * @author markus potthast markus.potthast@detecmedia.de
 * @version 1.0.0
 */
public final class  Factory {
    /**
     * define logger.
     */
    private static Logger log = Logger.getLogger(Factor.class);
    /**
     * account number array.
     */
    private int[] accountNumber;
    /**
     * weighting array.
     */
    private int[] weighting;
    /**
     * end pos.
     */
    private int end;
    /**
     * start pos.
     */
    private int start;
    /**
     * 1st start pos.
     */
    private static final int START_1ST = 0;

    /**
     * Factory.
     *
     * @param number    account number array
     * @param weighting weighting array
     * @param start     start pos
     * @param end       end pos
     * @return calculated account number
     */
    public static int[] factory(final int[] number,
                                final int[] weighting,
                                final int start,
                                final int end) {
        Factory factory = new Factory();
        factory.setAccountNumber(number);
        factory.setWeighting(weighting);
        factory.setStart(start, false);
        factory.setEnd(end);
        return factory.factory();
    }

    /**
     * Factory.
     *
     * @param number    account number array
     * @param weighting weighting array
     * @param start     start pos
     * @param end       end pos
     * @return calculated account number
     */
    public static int[] factory(final int[] number,
                                final Weighting weighting,
                                final int start,
                                final int end) {
        Factory factory = new Factory();
        factory.setAccountNumber(number);
        factory.setWeighting(weighting.getWeighting());
        factory.setStart(start, false);
        factory.setEnd(end);
        return factory.factory();
    }

    /**
     * Factory.
     *
     * @param number    account number array
     * @param weighting weighting array
     * @param start     start pos
     * @param end       end pos
     * @return calculated account number
     * @deprecated remove in version 1
     */
    public static int[] factoryOld(final int[] number,
                                   final int[] weighting,
                                   final int start,
                                   final int end) {
        Factory factory = new Factory();
        factory.setAccountNumber(number);
        factory.setWeighting(weighting);
        factory.setStart(start, true);
        factory.setEnd(end);
        return factory.factory();
    }

    /**
     * Factory.
     *
     * @param number    account number array
     * @param weighting weighting array
     * @return calculated account number
     */
    public static int[] factory(final int[] number, final int[] weighting) {
        Factory factory = new Factory();
        factory.setAccountNumber(number);
        factory.setWeighting(weighting);
        factory.setStart(Factory.START_1ST);
        factory.setEnd(number.length - 1);
        return factory.factory();
    }

    /**
     * Factory.
     *
     * @param number    account number array
     * @param weighting weighting array
     * @return calculated account number
     */
    public static int[] factory(final int[] number, final de.detecmedia.checkaccountnumber.converter.Weighting weighting) {
        Factory factory = new Factory();
        factory.setAccountNumber(number);
        factory.setWeighting(weighting.getWeighting());
        factory.setStart(Factory.START_1ST);
        factory.setEnd(number.length - 1);
        return factory.factory();
    }

    /**
     * private constructor.
     */
    private Factory() {

    }

    /**
     * Calculatet.
     *
     * @return calculatet account number.
     */
    private int[] factory() {
        int[] number = accountNumber;

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
     * set account number.
     *
     * @param setAccountNumber int array
     */

    private void setAccountNumber(final int[] setAccountNumber) {
        this.accountNumber = setAccountNumber;
    }

    /**
     * set weighting.
     *
     * @param setWeighting int array
     */
    private void setWeighting(final int[] setWeighting) {
        this.weighting = setWeighting;
    }

    /**
     * set end pos.
     *
     * @param setEnd int.
     */
    private void setEnd(final int setEnd) {
        this.end = setEnd;
    }

    /**
     * set start pos.
     *
     * @param setStart     start pos
     * @param setCountdown boolean
     */
    private void setStart(final int setStart, final boolean setCountdown) {

        this.start = setStart;
        if (setCountdown) {
            this.start--;
        }
    }

    /**
     * set strart pos.
     *
     * @param setStart int
     */
    private void setStart(final int setStart) {
        this.start = setStart;
    }
}
