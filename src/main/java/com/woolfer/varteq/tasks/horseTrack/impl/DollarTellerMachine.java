package com.woolfer.varteq.tasks.horseTrack.impl;

import com.woolfer.varteq.tasks.horseTrack.commons.Denominations;
import com.woolfer.varteq.tasks.horseTrack.objectTypes.MoneyOT;
import com.woolfer.varteq.tasks.horseTrack.objectTypes.TellerMachine;

import java.util.*;

/**
 * Created by pavlenko on 3/15/2015.
 */
public class DollarTellerMachine implements TellerMachine {

    private MoneyOT money;
    private String currencyCode = "USD";
    private Currency currency = Currency.getInstance(currencyCode);

    public DollarTellerMachine() {
        money = new MoneyOT(currency);
        money.setCash(new TreeMap<Integer, Integer>());
        generateCashInventory(money.getCash());
    }

    @Override
    public MoneyOT getMoney() {
        return money;
    }

    @Override
    public void setMoney(MoneyOT money) {
        this.money = money;
    }

    @Override
    public void generateCashInventory(Map<Integer, Integer> cashInventory){

        cashInventory.put(Denominations.ONE.getDenomination(), 10);
        cashInventory.put(Denominations.FIVE.getDenomination(), 10);
        cashInventory.put(Denominations.TEN.getDenomination(), 10);
        cashInventory.put(Denominations.TWENTY.getDenomination(), 10);
        cashInventory.put(Denominations.ONE_HUNDRED.getDenomination(), 10);
    }

    @Override
    public void restockCashInventory(){
        Map cashInventory = money.getCash();
        if(cashInventory != null) {
            cashInventory.clear();
            generateCashInventory(cashInventory);
        }
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public Currency getCurrency() {
        return currency;
    }
}
