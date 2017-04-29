package de.detecmedia.checkaccountnumber.model;

/**
 * checkaccountnumber
 * <p>
 * Created on 06.03.17.
 *
 * @author markus potthast markus.potthast@detecmedia.de
 * @version 1.0.0
 */
public class AccountNumber {

    /**
     * account number.
     */
    private String accountNumber;
    private int[] accountNumberArray;

    private AccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static AccountNumber accountNumber(String accountNumber) {
        AccountNumber aClass = new AccountNumber(accountNumber);
        return aClass;
    }

    public Long getAccountNumber() {
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
     * return lenght of of account number.
     *
     * @return integer
     */
    public int length() {
        return accountNumber.length();
    }

    /**
     * Returns a char at index of string.
     *
     * @param index integer
     * @return char
     */
    public char charAt(int index) {
        return accountNumber.charAt(index);
    }

    /**
     * @return
     */
    public String trim() {
        return accountNumber.trim();
    }

    /**
     * get account number as string
     */
    public String get() {
        return trim();
    }

    /**
     * get account number as string
     */
    public int[] getIntArray() {
        return getAccountNumberArray();
    }

    private int[] getAccountNumberArray() {
        if (this.accountNumberArray == null) {
            accountNumber = accountNumber.trim();
            int lengthOfAccountNumber = accountNumber.length();
            int[] value = new int[lengthOfAccountNumber];
            for (int i = 0; i < value.length; i++) {
                value[i] = accountNumber.charAt(i) - '0';
            }
            this.accountNumberArray = value;
        }
        return this.accountNumberArray;
    }
}
