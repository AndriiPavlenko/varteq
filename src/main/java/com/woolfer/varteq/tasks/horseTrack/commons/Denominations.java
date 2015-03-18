package com.woolfer.varteq.tasks.horseTrack.commons;

/**
 * Created by pavlenko on 3/14/2015.
 */
public enum Denominations {
    ONE(1), FIVE(5), TEN(10), TWENTY(20), ONE_HUNDRED(100);

    private int denomination;
    Denominations(int denomination) {
        this.denomination = denomination;
    }

    public int getDenomination() {
        return denomination;
    }
}
