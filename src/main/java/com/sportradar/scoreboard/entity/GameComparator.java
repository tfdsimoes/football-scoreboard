package com.sportradar.scoreboard.entity;

import java.util.Comparator;

public class GameComparator implements Comparator<Game> {

    @Override
    public int compare(Game game1, Game game2) {
        if (game1.getTotalGoals() < game2.getTotalGoals()) {
            return 1;
        } else if (game1.getTotalGoals() > game2.getTotalGoals()) {
            return -1;
        } else {
            if (game1.getStartTime().isBefore(game2.getStartTime())) {
                return 1;
            } else if (game1.getStartTime().isAfter(game2.getStartTime())){
                return -1;
            } else {
                return 0;
            }
        }
    }
}