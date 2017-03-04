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
     * @return
     */
    char[] getFlag();
}
