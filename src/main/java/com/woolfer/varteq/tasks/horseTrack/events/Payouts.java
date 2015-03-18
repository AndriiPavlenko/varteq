package com.woolfer.varteq.tasks.horseTrack.events;

/**
 * Created by pavlenko on 3/15/2015.
 */
public class Payouts {
    private static final String PAYOUT_WIN = "Payout: ";
    private static final String NO_PAYOUT = "No Payout: ";
    private static final String DISPENSING = "Dispensing:";
    private static final String INSUFFICIENT_FUNDS = "Insufficient Funds: ";

    public static void payoutWin(String winningStr) {
        System.out.println(PAYOUT_WIN + winningStr);
    }
    public static void noPayout(String str) {
        System.out.println(NO_PAYOUT + str);
    }

    public static void insufficientFunds(String payout) {
        System.out.println(INSUFFICIENT_FUNDS + payout);
    }

    public static void dispensing(String str) {
        System.out.print(DISPENSING + "\n" + str);
    }
}
