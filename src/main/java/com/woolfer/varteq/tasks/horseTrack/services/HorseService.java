package com.woolfer.varteq.tasks.horseTrack.services;

import java.util.Collections;

/**
 * Created by pavlenko on 3/14/2015.
 */
public interface HorseService {
    public void declareHorses();
    public void setWinner(int horseId);
    public String showHorsesList();
}
