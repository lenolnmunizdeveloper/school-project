package com.lenolnmuniz.peoples;

import java.util.ArrayList;

public class Responsible extends People {

    final int MONTHS = 12;

    private boolean[] payments = new boolean[MONTHS];

    public Responsible(String name) {
        super(name);
    }

    public boolean[] getPayments() {
        return payments;
    }

    public void setPayments(boolean[] payments) {
        this.payments = payments;
    }

    public boolean payMensality(int month, boolean situation) {
        payments[month] = situation;
        return situation;
    }

    @Override
    public String seeSituation(int month) {
        if(getPayments()[month]){
            return "O pagamento foi realizado no mês: " + month;
        }
        return "O pagamento não foi realizado no mês: " + month;
    }

    private StringBuilder convertListInString(ArrayList<Integer> list) {
        StringBuilder result = new StringBuilder();
        return result.append(list).append(", ");
    }

    private String monthsPaid() {
        ArrayList<Integer> monthsPaidList = new ArrayList<Integer>();

        for (int month = 1; month < payments.length ; month++) {
            if(payments[month]){
                monthsPaidList.add(month);
            }
        }
        return "Os meses pagos foram: " + convertListInString(monthsPaidList);
    }

    @Override
    public String report() {
        return "O responsável finaceiro " + getName() + " realizou o pagamento: " + monthsPaid();
    }

}
