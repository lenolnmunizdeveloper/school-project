package com.lenolnmuniz.peoples;

import java.lang.reflect.Array;

public class Responsible extends People {

    private boolean[] payments = new boolean[12];

    private Responsible(String name) {
        super(name);
    }

    public boolean[] getPayments() {
        return payments;
    }

    public void setPayments(boolean[] payments) {
        this.payments = payments;
    }

    public boolean payMensality(int mes, boolean situation) {
        //TODO implementar
        return false;
    }

    @Override
    public String seeSituation(int mes) {
        //TODO implementar
        return null;
    }

    @Override
    public String report() {
        //TODO implementar
        return null;
    }

}
