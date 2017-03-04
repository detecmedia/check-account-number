/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.InvalidAcountNumberException;
import de.detecmedia.checkaccountnumber.exception.InvalidBankCodeException;
import org.apache.log4j.Logger;

/**
 * @author Markus Potthast <mpt@detecmedia.de>
 */
public class ESERAltsystems {

    private final Logger log = Logger.getLogger(ESERAltsystems.class);

    private String accountNumber;
    private String bankCode;
    private int[] accountNumberArray;
    private int[] bankNumber;

    public static int ACHT = 6;
    public static int NEUN = 7;

    public void setAccountNumber(String accountNumber) {
        if (accountNumber.length() < 8) {
            throw new InvalidAcountNumberException();
        }
        this.accountNumber = String.valueOf(Long.valueOf(accountNumber));
        this.accountNumberArray = new int[accountNumber.length()];
        for (int i = 0; i < accountNumberArray.length; i++) {
            log.debug("Char at Pos " + i + " is " + accountNumber.charAt(i));
            accountNumberArray[i] = accountNumber.charAt(i) - '0';
        }
    }

    public void setBankCode(String bankCode) {
        if (bankCode.charAt(3) != '5') {
            throw new InvalidBankCodeException("This Bankcode is invalid " + bankCode + " " + bankCode.charAt(3));
        }
        this.bankCode = bankCode;
        this.bankNumber = new int[bankCode.length()];
        for (int i = 0; i < bankNumber.length; i++) {
            log.debug("Char at Pos " + i + " is " + bankCode.charAt(i));
            bankNumber[i] = bankCode.charAt(i) - '0';
        }
    }

    public String getESERAltsystems(int count) {
        String code;
        code = bankCode.substring(4);
        code = code.concat(accountNumber.substring(0, 2));
        log.debug(code);
        log.debug(String.valueOf(Long.valueOf(accountNumber.substring(accountNumber.length() - count))));
        code = code.concat(String.valueOf(Long.valueOf(accountNumber.substring(accountNumber.length() - count))));
        log.debug("code: " + code);
        return code;
    }

    public long generateEserAccountNumber() {
        long eserAccountNumber = 0l;
        if ((accountNumberArray[0] != 0) || (accountNumberArray[1] != 0)
                || (accountNumberArray[2] == 0)) {
            throw new InvalidBankCodeException(
                    "Account number for generating old ESER-System account number need to have 8 relevant digits. First two digits have to be 0, third digit has to be between 1 and 9.");
        } else {
            // First 4 digits are the last 4 digits of the bank number
            for (int i = 0; i < 4; i++) {
                eserAccountNumber *= 10;
                eserAccountNumber += bankNumber[(bankNumber.length) - (4 - i)];
            }

            // ESER account number at 4,5 = first two digits of the account
            // number
            // ESER account number is filled up with the rest of the account
            // number. Leading digits which are 0, are skipped.
            boolean foundDigitNotZero = false;
            for (int i = 2; i < accountNumberArray.length; i++) {
                if ((i == 2) || (i == 3)
                        || ((accountNumberArray[i] == 0) && (foundDigitNotZero))
                        || (accountNumberArray[i] != 0)) {
                    eserAccountNumber *= 10;
                    eserAccountNumber += accountNumberArray[i];
                    if ((i != 2) && (i != 3)) {
                        foundDigitNotZero = true;
                    }
                }
            }

        }
        log.debug("generateEserAccountNumber " + eserAccountNumber);
        return eserAccountNumber;
    }

    public long generateEserAccountNumber1() {
        long eserAccountNumber = 0l;
        if ((accountNumberArray[0] != 0) || (accountNumberArray[1] == 0)) {
            throw new InvalidBankCodeException(
                    "Account number for generating old ESER-System account number need to have 9 relevant digits. First digits has to be 0, second digit has to be between 1 and 9.");
        } else {
            // First 4 digits are the last 4 digits of the bank number with the
            // second digit of the account number at third place
            for (int i = 0; i < 4; i++) {
                if (i != 2) {
                    eserAccountNumber *= 10;
                    eserAccountNumber += bankNumber[(bankNumber.length)
                            - (4 - i)];
                } else {
                    eserAccountNumber *= 10;
                    eserAccountNumber += accountNumberArray[2];
                }
            }

            // ESER account number at 4,5 = first and third digit of the account
            // number
            // ESER account number is filled up with the rest of the account
            // number. Leading digits which are 0, are skipped.
            boolean foundDigitNotZero = false;
            for (int i = 1; i < accountNumberArray.length; i++) {
                if (i != 2) {
                    if ((i == 1) || (i == 3)
                            || ((accountNumberArray[i] == 0) && (foundDigitNotZero))
                            || (accountNumberArray[i] != 0)) {
                        eserAccountNumber *= 10;
                        eserAccountNumber += accountNumberArray[i];
                        if ((i != 2) && (i != 3)) {
                            foundDigitNotZero = true;
                        }
                    }
                }
            }

        }
        log.debug("generateEserAccountNumber " + eserAccountNumber);
        return eserAccountNumber;
    }

}
