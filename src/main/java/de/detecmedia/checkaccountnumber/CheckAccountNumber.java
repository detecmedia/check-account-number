/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.detecmedia.checkaccountnumber;

/**
 * @author Markus Potthast
 */
public interface CheckAccountNumber {

    /**
     * Added from 1st
     */
    int ADD_START_1ST = 0;

    /**
     * Added from 2nd
     */
    int ADD_START_2ND = 1;

    /**
     * Added from 3rd
     */
    int ADD_START_3RD = 2;

    /**
     * Added from 4th
     */
    int ADD_START_4TH = 3;

    /**
     * Added from 5th
     */
    int ADD_START_5TH = 4;


    /**
     * Added from 9th
     */
    int ADD_END_9TH = 8;

    /**
     * Added from 10th
     */
    int ADD_END_10TH = 9;


    /**
     * is Account number 7.
     */
    int ACCOUNT_NUMBER_IS_7 = 7;

    /**
     * is Account number 8.
     */
    int ACCOUNT_NUMBER_IS_8 = 8;

    /**
     * is Account number 9.
     */
    int ACCOUNT_NUMBER_IS_9 = 9;

    /**
     * acount number leght 10.
     */
    int ACCOUNT_NUMBER_LEGHT_10 = 10;

    /**
     * Minuent of check digit.
     */
    int MINUEND_CHECK_DIGIT = 11;

    /**
     * is result 10.
     */
    int RESULT_IS_10 = 10;

    /**
     * modulus 10.
     */
    int MODULUS_10 = 10;
    /**
     * modulus 11.
     */
    int MODULUS_11 = 11;

    /**
     * set acount number.
     *
     * @param accountNumber account number as string
     */
    void setAccountNumber(String accountNumber);

    /**
     * test accountnumber. if the account number is correct, it returns true.
     * otherwise false.
     *
     * @return boolean true /false
     */
    boolean test();

    /**
     * Specifies the characteristics of the method.
     *
     * @return char[]
     */
    char[] getFlag();
}
