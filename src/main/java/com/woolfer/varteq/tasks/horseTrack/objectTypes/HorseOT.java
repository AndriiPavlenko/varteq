package com.woolfer.varteq.tasks.horseTrack.objectTypes;

/**
 * Created by pavlenko on 3/14/2015.
 */
public class HorseOT {
    private int id;
    private String name;
    private int odds;
    private String lastResult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HorseOT() {
    }

    public HorseOT(int id, String name, int odds, String lastResult) {

        this.id = id;
        this.name = name;
        this.odds = odds;
        this.lastResult = lastResult;
    }

    public String getLastResult() {
        return lastResult;
    }

    public void setLastResult(String lastResult) {
        this.lastResult = lastResult;
    }

    public int getOdds() {
        return odds;
    }

    public void setOdds(int odds) {
        this.odds = odds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ", " + odds + ", " + lastResult;
    }
}
