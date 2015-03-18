package com.woolfer.varteq.tasks.horseTrack.commons;

/**
 * Created by pavlenko on 3/14/2015.
 */
public enum Commands {
    RESTOCK("R"), QUIT("Q"), WIN("W");

    private String command;
    Commands(String command) {
        this.command = command;
    }
    public String getCommand(){
        return command;
    }
}
