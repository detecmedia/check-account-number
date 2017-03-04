/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.detecmedia.checkaccountnumber.exception;

import org.apache.log4j.Logger;

/**
 * @author Markus Potthast <mpt@detecmedia.de>
 */
public class InvalidAcountNumberException extends InvalidException {

    private final Logger logger = Logger.getLogger(InvalidAcountNumberException.class);

    public InvalidAcountNumberException() {
        this("This Check Digit is invalid");
    }

    public InvalidAcountNumberException(String message) {
        super(message);
        logger.error(this.getMessage());
    }


}
