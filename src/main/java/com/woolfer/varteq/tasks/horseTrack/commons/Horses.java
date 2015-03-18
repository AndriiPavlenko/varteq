package com.woolfer.varteq.tasks.horseTrack.commons;


/**
 * Created by pavlenko on 3/14/2015.
 */
public enum Horses {
    ThatDarnGrayCat("That Darn Gray Cat", 5, Horses.WON),
    FortUtopia("Fort Utopia", 10, Horses.LOST),
    CountSheep("Count Sheep", 9, Horses.LOST),
    MsTraitour("Ms Traitour", 4, Horses.LOST),
    RealPrincess("Real Princess", 3, Horses.LOST),
    PaKettle("Pa Kettle", 5, Horses.LOST),
    GinStinger("Gin Stinger", 6, Horses.LOST);

    private String lastResult;
    private String name;
    private int odds;

    public static final String WON = "won";
    public static final String LOST = "lost";

    Horses(String name, int odds, String lastResult) {
        this.name = name;
        this.odds = odds;
        this.lastResult = lastResult;
    }
    public String getName() {
        return name;
    }
    public int getOdds(){
        return odds;
    }
    public String getLastResult(){return lastResult;}
}
