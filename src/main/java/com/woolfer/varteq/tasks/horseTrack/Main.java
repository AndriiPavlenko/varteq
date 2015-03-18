package com.woolfer.varteq.tasks.horseTrack;

import com.woolfer.varteq.tasks.horseTrack.commons.Commands;
import com.woolfer.varteq.tasks.horseTrack.events.InputErrors;
import com.woolfer.varteq.tasks.horseTrack.impl.DollarTellerMachine;

import com.woolfer.varteq.tasks.horseTrack.impl.HorseServiceImpl;
import com.woolfer.varteq.tasks.horseTrack.impl.MachineServiceImpl;
import com.woolfer.varteq.tasks.horseTrack.objectTypes.HorseOT;
import com.woolfer.varteq.tasks.horseTrack.services.*;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pavlenko on 3/14/2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        final String SPACE = " ";

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String inputString;

        DollarTellerMachine tellerMachine = new DollarTellerMachine();
        Map<Integer, HorseOT> horsesList = new HashMap<>();
        MachineService machine = new MachineServiceImpl(tellerMachine, horsesList);
        HorseService horseService = new HorseServiceImpl(horsesList);
        horseService.declareHorses();

        do {
            System.out.println("Inventory:");
            System.out.print(tellerMachine.getMoney().toString());
            System.out.println("Horses:");
            System.out.print(horseService.showHorsesList());

            inputString = console.readLine();
            inputString = StringUtils.trim(inputString);

            if (inputString.matches("\\d+\\s.+")) {
                /*Set bet*/
                int horseId = Integer.parseInt(StringUtils.substringBefore(inputString, SPACE));
                if (!horsesList.containsKey(Integer.valueOf(horseId))) {
                    InputErrors.invalidHorseId(String.valueOf(horseId));
                } else {
                    try {
                        int bet = Integer.parseInt(StringUtils.substringAfter(inputString, SPACE));
                        machine.setBet(horseId, bet);
                        machine.checkResult();
                    } catch (NumberFormatException e) {
                        InputErrors.invalidBet(StringUtils.substringAfter(inputString, SPACE));
                    }
                }
            } else if (inputString.matches("[a-zA-Z]\\s.+")) {
                switch (inputString.substring(0, 1).toUpperCase()) {
                    case "W":
                        /*Set the winning horse number*/
                        String horseIdStr = StringUtils.substringAfter(inputString, SPACE);
                        try {
                            int horseId = Integer.parseInt(horseIdStr);
                            if (horsesList.containsKey(Integer.valueOf(horseId))) {
                                horseService.setWinner(horseId);
                            } else {
                                InputErrors.invalidHorseId(String.valueOf(horseId));
                            }
                        } catch (NumberFormatException e) {
                            InputErrors.invalidHorseId(horseIdStr);
                        }
                        break;
                    default:
                        InputErrors.invalidCommand(inputString);
                        break;
                }
            } else {
                switch (inputString.toUpperCase()) {
                    case "R":
                        /*Restock the cash machine*/
                        tellerMachine.restockCashInventory();
                        break;
                    case "Q":
                        break;
                    default:
                        InputErrors.invalidCommand(inputString);
                        break;
                }
            }
        } while (!inputString.toUpperCase().equals(Commands.QUIT.getCommand()));
    }
}
