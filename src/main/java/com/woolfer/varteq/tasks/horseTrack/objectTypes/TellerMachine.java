package com.woolfer.varteq.tasks.horseTrack.objectTypes;

import java.util.Map;

/**
 * Created by pavlenko on 3/15/2015.
 */
public interface TellerMachine {
    public void setMoney(MoneyOT money);
    public MoneyOT getMoney();
    public void generateCashInventory(Map<Integer, Integer> cashInventory);
    public void restockCashInventory();
}
