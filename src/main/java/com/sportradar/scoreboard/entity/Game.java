package com.sportradar.scoreboard.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Game {
    private String id;

    private final String homeTeam;

    private final String awayTeam;

    private int homeTeamScore = 0;

    private int awayTeamScore = 0;

    private final LocalDateTime startTime;

    public Game(String homeTeam, String awayTeam) {
        id = UUID.randomUUID().toString();
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        startTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}
