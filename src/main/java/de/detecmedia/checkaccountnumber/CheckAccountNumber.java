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
     * 1st place of account number.
     */
    int ACCOUNT_NUMBER_PLACE_1_ST = 0;

    /**
     * 2nd place of account number.
     */
    int ACCOUNT_NUMBER_PLACE_2_ND = 1;

    /**
     * 3rd place of account number.
     */
    int ACCOUNT_NUMBER_PLACE_3_RD = 2;

    /**
     * 4th place of account number.
     */
    int ACCOUNT_NUMBER_PLACE_4_TH = 3;

    /**
     * 5th place of account number.
     */
    int ACCOUNT_NUMBER_PLACE_5_TH = 4;

    /**
     * 6th place of account number.
     */
    int ACCOUNT_NUMBER_PLACE_6_TH = 5;

    /**
     * 7th place of account number.
     */
    int ACCOUNT_NUMBER_PLACE_7_TH = 6;

    /**
     * 8th place of account number.
     */
    int ACCOUNT_NUMBER_PLACE_8_TH = 7;

    /**
     * 9th place of account number.
     */
    int ACCOUNT_NUMBER_PLACE_9_TH = 8;

    /**
     * 10th place of account number.
     */
    int ACCOUNT_NUMBER_PLACE_10_TH = 9;

    /**
     * weighting {2, 3, 4, 5, 6}
     */
    int[] WEIGHTING_2_3_4_5_6 = new int[]{2, 3, 4, 5, 6};

    /**
     * weighting {2, 3, 4, 5, 6,7}
     */
    int[] WEIGHTING_2_3_4_5_6_7 = new int[]{2, 3, 4, 5, 6, 7};

    /**
     * weighting {2, 3, 4, 5, 6, 7, 8}.
     */
    int[] WEIGHTING_2_3_4_5_6_7_8 = new int[]{2, 3, 4, 5, 6, 7, 8};

    /**
     * Factor starts at 1st.
     */
    int FACTOR_START_1ST = 1;

    /**
     * Factor starts at 2nd.
     */
    int FACTOR_START_2ND = 2;

    /**
     * Factor starts at 3.
     */
    int FACTOR_START_3RD = 3;

    /**
     * Factor starts at 4.
     */
    int FACTOR_START_4TH = 4;

    /**
     * Factor starts at 5.
     */
    int FACTOR_START_5TH = 5;

    /**
     * Factor starts at 6.
     */
    int FACTOR_START_6TH = 6;

    /**
     * Factor starts at 7.
     */
    int FACTOR_START_7TH = 7;

    /**
     * Factor end by 7.
     */
    int FACTOR_END_7TH = 7;

    /**
     * Factor end by 8.
     */
    int FACTOR_END_8TH = 8;

    /**
     * Factor end by 9.
     */
    int FACTOR_END_9TH = 9;

    /**
     * Factor end by 10.
     */
    int FACTOR_END_10TH = 10;

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
