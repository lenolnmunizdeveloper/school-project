package com.lenolnmuniz.peoples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

        responsible1.setCpf("111.111.111-11");
        responsible2.setCpf("222.222.222-22");
        responsible3.setCpf("333.333.333-33");

        responsible1.setEmail("arnaldo.sacomani@arnaldo.com");
        responsible2.setEmail("gisele.freitas@freitas.com");
        responsible3.setEmail("roberto.cabral@roberto.com");

        responsible1.setPhone("(11) 11111-1111");
        responsible2.setPhone("(22) 22222-2222");
        responsible3.setPhone("(33) 33333-3333");
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
        boolean[] payments1 = {true, false, true, false, true, false};
        responsible1.setPayments(payments1);
        for (int i = 0; i < payments1.length; i++) {
            assertEquals(responsible1.getPayments()[i], payments1[i]);
        }

        boolean[] payments2 = {false, true, true, false, false, true};
        responsible2.setPayments(payments2);
        for (int i = 0; i < payments2.length; i++) {
            assertEquals(responsible2.getPayments()[i], payments2[i]);
        }

        boolean[] payments3 = {true, false, false, true, false, true};
        responsible3.setPayments(payments3);
        for (int i = 0; i < payments3.length; i++) {
            assertEquals(responsible3.getPayments()[i], payments3[i]);
        }
    }

    @Test
    public void testPayMensality() {
        assertTrue(responsible1.payMensality(1, true));
        assertFalse(responsible1.payMensality(2, false));
        assertTrue(responsible2.payMensality(1, true));
        assertFalse(responsible2.payMensality(2, false));
        assertFalse(responsible3.payMensality(1, false));
        assertTrue(responsible3.payMensality(2, true));
    }

    @Test
    public void testSeeSituation() {
        assertFalse(responsible1.getPayments()[1]);
        responsible1.payMensality(1, true);
        assertTrue(responsible1.getPayments()[1]);
        responsible1.payMensality(2, true);
        responsible1.payMensality(3, true);
        for (int i = 0; i < 4; i++) {
            if(responsible1.getPayments()[i]){
                assertEquals(responsible1.seeSituation(i),"O pagamento foi realizado no mês: " + i);
            } else {
                assertEquals(responsible1.seeSituation(i),"O pagamento não foi realizado no mês: " + i);
            }
        }

        responsible2.payMensality(1, true);
        assertFalse(responsible2.getPayments()[2]);
        responsible2.payMensality(2, false);
        assertFalse(responsible2.getPayments()[2]);
        responsible2.payMensality(3, true);
        for (int i = 0; i < 4; i++) {
            if(responsible2.getPayments()[i]){
                assertEquals(responsible2.seeSituation(i),"O pagamento foi realizado no mês: " + i);
            } else {
                assertEquals(responsible2.seeSituation(i),"O pagamento não foi realizado no mês: " + i);
            }
        }
        responsible3.payMensality(1, true);
        responsible3.payMensality(2, false);
        responsible3.payMensality(3, false);
        for (int i = 0; i < 4; i++) {
            if(responsible3.getPayments()[i]){
                assertEquals(responsible3.seeSituation(i),"O pagamento foi realizado no mês: " + i);
            } else {
                assertEquals(responsible3.seeSituation(i),"O pagamento não foi realizado no mês: " + i);
            }
        }
    }

    @Test
    public void testReport() {
        assertNotNull(responsible1.report());
        assertNotNull(responsible2.report());
        assertNotNull(responsible3.report());
        responsible1.payMensality(1, true);
        responsible1.payMensality(2, true);
        responsible1.payMensality(3, false);
        assertEquals("O responsável finaceiro " + responsible1.getName() + " realizou o pagamento: Os meses pagos foram: [1, 2], ", responsible1.report());

        responsible2.payMensality(1, true);
        responsible2.payMensality(2, true);
        responsible2.payMensality(3, true);
        assertEquals("O responsável finaceiro " + responsible2.getName() + " realizou o pagamento: Os meses pagos foram: [1, 2, 3], ", responsible2.report());

        responsible3.payMensality(1, false);
        responsible3.payMensality(2, true);
        responsible3.payMensality(3, false);
        assertEquals("O responsável finaceiro " + responsible3.getName() + " realizou o pagamento: Os meses pagos foram: [2], ", responsible3.report());

    }

    @After
    public void tearDown() {
        responsible1 = null;
        responsible2 = null;
        responsible3 = null;
    }
}