package com.woolfer.varteq.tasks.horseTrack.events;

/**
 * Created by pavlenko on 3/15/2015.
 */
public class InputErrors {
    private static final String INVALID_BET = "Invalid Bet: ";
    private static final String INVALID_HORSE_ID = "Invalid Horse Number: ";
    private static final String INVALID_COMMAND = "Invalid Command: ";

    public static void invalidBet(String betStr) {
        System.out.println(INVALID_BET + betStr);
    }

    public static void invalidHorseId(String horseId) {
        System.out.println(INVALID_HORSE_ID + horseId);
    }

    public static void invalidCommand(String inputLine){
        System.out.println(INVALID_COMMAND + inputLine);
    }
}
