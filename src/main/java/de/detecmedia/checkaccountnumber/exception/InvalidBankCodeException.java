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
public class InvalidBankCodeException extends InvalidException {

    private Logger logger = Logger.getLogger(InvalidBankCodeException.class);

    public InvalidBankCodeException() {
        this("This Bank Code is invalid");
    }

    public InvalidBankCodeException(String message) {
        super(message);
        logger.error(this.getMessage());
    }

}
