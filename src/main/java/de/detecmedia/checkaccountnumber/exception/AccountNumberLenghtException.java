/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.detecmedia.checkaccountnumber.exception;

/**
 * @author Markus Potthast
 */
public class AccountNumberLenghtException extends InvalidAcountNumberException {
    /**
     * Exception for account number to short.
     */
    public AccountNumberLenghtException() {
        super("AccountNumber to short");
    }


}
