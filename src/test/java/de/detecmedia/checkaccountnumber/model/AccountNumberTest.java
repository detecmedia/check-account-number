package de.detecmedia.checkaccountnumber.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static de.detecmedia.checkaccountnumber.model.AccountNumber.*;

/**
 * Created by potthast on 29.04.17.
 */
public class AccountNumberTest {
    private AccountNumber accountNumer;

    @Before
    public void setUp() throws Exception {
        accountNumer = accountNumber("123456 ");
    }

    @Test
    public void getAccountNumber() throws Exception {
    }

    @Test
    public void length() throws Exception {
        assertEquals(7,accountNumer.length());
    }

    @Test
    public void charAt() throws Exception {
        assertEquals('5',accountNumer.charAt(4));
    }

    @Test
    public void trim() throws Exception {
        assertEquals("123456",accountNumer.trim());
    }

    @Test
    public void get() throws Exception {
        assertEquals("123456",accountNumer.get());
    }

    @Test
    public void getIntArray() throws Exception {
        assertArrayEquals(new int[] {1,2,3,4,5,6}, accountNumer.getIntArray());
    }

}