package com.woolfer.varteq.tasks.horseTrack.services;

/**
 * Created by pavlenko on 3/14/2015.
 */
public interface MachineService {
    public void setBet(int horseId, int amount);
    public String checkResult();
}
