/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.detecmedia.checkaccountnumber.exception;

import org.apache.log4j.Logger;

/**
 *
 * @author Markus Potthast
 */
public class InvalidException extends RuntimeException {

    private Logger logger = Logger.getLogger(InvalidException.class);

    public InvalidException(String message) {
        super(message);
        logger.error(this.getMessage());
    }

    

}
