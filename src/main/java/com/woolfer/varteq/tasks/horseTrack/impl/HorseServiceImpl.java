package com.woolfer.varteq.tasks.horseTrack.impl;

import com.woolfer.varteq.tasks.horseTrack.objectTypes.HorseOT;
import com.woolfer.varteq.tasks.horseTrack.commons.Horses;
import com.woolfer.varteq.tasks.horseTrack.services.HorseService;

import java.util.*;

/**
 * Created by pavlenko on 3/14/2015.
 */
public class HorseServiceImpl implements HorseService {

    private Map<Integer, HorseOT> horsesList;

    public HorseServiceImpl(Map<Integer, HorseOT> horsesList) {
        this.horsesList = horsesList;
    }

    @Override
    public void declareHorses() {
        if(horsesList == null) {
            horsesList = new HashMap<>();
        } else {
            horsesList.clear();
        }
        for (Horses horse : Horses.values()) {
            int id = horse.ordinal() + 1;
            horsesList.put(id, new HorseOT(id, horse.getName(), horse.getOdds(), horse.getLastResult()));

        }
    }

    @Override
    public void setWinner(int winHorseId) {
        Iterator iter = horsesList.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            HorseOT horse = (HorseOT) entry.getValue();
            if(horse.getId() == winHorseId) {
               horse.setLastResult(Horses.WON);
            } else {
                horse.setLastResult(Horses.LOST);
            }
        }
    }

    @Override
    public String showHorsesList() {
        StringBuilder str = new StringBuilder();
        Iterator iter = horsesList.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            HorseOT horse = (HorseOT) entry.getValue();
            str.append(horse.getId() + ",");
            str.append(horse.getName() + ",");
            str.append(horse.getOdds() + ",");
            str.append(horse.getLastResult() + "\n");
        }
        return str.toString();
    }
}
