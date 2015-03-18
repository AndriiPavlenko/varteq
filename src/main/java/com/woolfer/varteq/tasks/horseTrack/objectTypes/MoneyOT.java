package com.woolfer.varteq.tasks.horseTrack.objectTypes;

import sun.invoke.empty.Empty;

import java.util.Currency;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by pavlenko on 3/14/2015.
 */
public class MoneyOT {

    protected Map<Integer, Integer> cash;
    protected Currency currency;

    public MoneyOT(Currency currency) {
        this.currency = currency;
    }

    public Map<Integer, Integer> getCash() {
        return cash;
    }

    public void setCash(Map<Integer, Integer> cash) {
        this.cash = cash;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Iterator iter = cash.entrySet().iterator();
        String symbol = currency.getSymbol();

        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            str.append(symbol);
            str.append(entry.getKey() + ", ");
            str.append(entry.getValue() + "\n");
        }
        return str.toString();
    }
}
