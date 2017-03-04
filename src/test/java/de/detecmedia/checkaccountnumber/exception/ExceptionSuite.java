/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.detecmedia.checkaccountnumber.exception;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Markus Potthast <mpt@detecmedia.de>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({de.detecmedia.checkaccountnumber.exception.InvalidAcountNumberExceptionTest.class, de.detecmedia.checkaccountnumber.exception.InvalidBankCodeExceptionTest.class, de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtExceptionTest.class, de.detecmedia.checkaccountnumber.exception.InvalidExceptionTest.class})
public class ExceptionSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
