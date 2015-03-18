package com.woolfer.varteq.tasks.horseTrack.impl;

import com.woolfer.varteq.tasks.horseTrack.events.Payouts;
import com.woolfer.varteq.tasks.horseTrack.objectTypes.HorseOT;
import com.woolfer.varteq.tasks.horseTrack.commons.Horses;
import com.woolfer.varteq.tasks.horseTrack.objectTypes.MoneyOT;
import com.woolfer.varteq.tasks.horseTrack.services.MachineService;

import java.util.*;

/**
 * Created by pavlenko on 3/14/2015.
 */
public class MachineServiceImpl implements MachineService {

    private final Map<Integer, HorseOT> horsesList;
    private DollarTellerMachine tellerMachine;
    private int winHorseId;
    private int amount;
    private int winningAmount;
    private MoneyOT gainings;

    public MachineServiceImpl(DollarTellerMachine tellerMachine, Map<Integer, HorseOT> horsesList) {
        this.tellerMachine = tellerMachine;
        this.horsesList = horsesList;
    }

    @Override
    public void setBet(int horseId, int amount) {
        this.winHorseId = horseId;
        this.amount = amount;
    }

    @Override
    public String checkResult() {
        HorseOT horse = horsesList.get(winHorseId);
        if (horse.getLastResult() == Horses.WON) {
            winningAmount = getWinningAmount(amount, horse.getOdds());
            if (dispensing(winningAmount)) {
                Payouts.payoutWin(horse.getName() + "," + tellerMachine.getCurrency().getSymbol() + winningAmount);
                Payouts.dispensing(gainings.toString());
            }
        } else {
            Payouts.noPayout(horse.getName());
        }
        return null;
    }

    private boolean dispensing(int winningAmount) {
        Map<Integer, Integer> cash = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        Map<Integer, Integer> cashTellerMachine = tellerMachine.getMoney().getCash();
        cash.putAll(cashTellerMachine);

        Map<Integer, Integer> dispensingList = new TreeMap();
        for (Map.Entry entry : cashTellerMachine.entrySet()) {
            dispensingList.put((Integer) entry.getKey(), 0);
        }

        int payoutResult = 0;
        int remainderPayment = winningAmount;
        for (Map.Entry entry : cash.entrySet()) {

            Integer denominationInt = (Integer) entry.getKey();
            int denomination = denominationInt.intValue();
            Integer inventoryInt = (Integer) entry.getValue();
            int inventory = inventoryInt.intValue();

            int count = remainderPayment / denomination;
            if (inventory > 0) {
                if (count > inventory) count = inventory;
                payoutResult += count * denomination;
                inventory -= count;
                entry.setValue(Integer.valueOf(inventory));
                dispensingList.put(denominationInt, count);
                remainderPayment = remainderPayment - count * denomination;
            }
            if (payoutResult == winningAmount) {
                gainings = new MoneyOT(tellerMachine.getCurrency());
                gainings.setCash(dispensingList);
                tellerMachine.getMoney().setCash(new TreeMap<>(cash));
                return true;
            }
        }
        if (payoutResult != winningAmount) {
            Payouts.insufficientFunds(String.valueOf(winningAmount));
            return false;
        }
        return false;
    }

    private int getWinningAmount(int amount, int odds) {
        return amount * odds;
    }
}
