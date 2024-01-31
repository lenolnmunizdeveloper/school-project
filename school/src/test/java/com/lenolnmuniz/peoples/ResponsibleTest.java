package com.lenolnmuniz.peoples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ResponsibleTest {

    Responsible responsible1;
    Responsible responsible2;
    Responsible responsible3;

    @Before
    public void setUp() {
        responsible1 = new Responsible("Arnaldo Sacomani");
        responsible2 = new Responsible("Gisele Freitas");
        responsible3 = new Responsible("Roberto Cabral");
    }

    @Test
    public void testGetPayments() {
        assertNotNull(responsible1.getPayments());
        assertNotNull(responsible2.getPayments());
        assertNotNull(responsible3.getPayments());
        responsible1.payMensality(1, true);
        responsible1.payMensality(2, true);
        responsible1.payMensality(3, true);
        responsible2.payMensality(1, true);
        responsible2.payMensality(2, false);
        responsible2.payMensality(3, true);
        responsible3.payMensality(1, true);
        responsible3.payMensality(2, false);
        responsible3.payMensality(3, false);
        assertTrue(responsible1.getPayments()[1]);
        assertTrue(responsible1.getPayments()[2]);
        assertTrue(responsible1.getPayments()[3]);
        assertTrue(responsible2.getPayments()[1]);
        assertFalse(responsible2.getPayments()[2]);
        assertTrue(responsible2.getPayments()[3]);
        assertTrue(responsible3.getPayments()[1]);
        assertFalse(responsible3.getPayments()[2]);
        assertFalse(responsible3.getPayments()[3]);

        responsible1.payMensality(4, true);
        responsible1.payMensality(5, true);
        responsible1.payMensality(6, true);
        responsible2.payMensality(4, false);
        responsible2.payMensality(5, false);
        responsible2.payMensality(6, true);
        responsible3.payMensality(4, false);
        responsible3.payMensality(5, false);
        responsible3.payMensality(6, false);
        assertTrue(responsible1.getPayments()[4]);
        assertTrue(responsible1.getPayments()[5]);
        assertTrue(responsible1.getPayments()[6]);
        assertFalse(responsible2.getPayments()[4]);
        assertFalse(responsible2.getPayments()[5]);
        assertTrue(responsible2.getPayments()[6]);
        assertFalse(responsible3.getPayments()[4]);
        assertFalse(responsible3.getPayments()[5]);
        assertFalse(responsible3.getPayments()[6]);
    }

    @Test
    public void testSetPayments() {
    }

    @Test
    public void testPayMensality() {
        /*assertTrue(responsible1.payMensality(1, true));
        assertTrue(responsible1.payMensality(2, true));
        assertTrue(responsible2.payMensality(1, true));
        assertFalse(!responsible2.payMensality(2, false));
        assertFalse(!responsible3.payMensality(1, false));
        assertTrue(responsible3.payMensality(2, true));*/
    }

    @Test
    public void testSeeSituation() {
    }

    @Test
    public void testReport() {
        assertNotNull(responsible1.report());
        assertNotNull(responsible2.report());
        assertNotNull(responsible3.report());
    }

    @After
    public void tearDown() {
        responsible1 = null;
        responsible2 = null;
        responsible3 = null;
    }
}