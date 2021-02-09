package com.sportradar.scoreboard.service;

import com.sportradar.scoreboard.entity.Game;

import java.util.List;

public interface ScoreBoardService {

    /**
     * Start the game in the scoreboard
     *
     * @param homeTeam Name of the home team
     * @param awayTeam Name of the away team
     * @return Game created in the system
     */
    Game start(String homeTeam, String awayTeam);

    /**
     * End a game and remove it from the system
     *
     * @param id Id of the game to end
     */
    void end(String id);

    /**
     * Update a score of game
     *
     * @param id Id of the game to update
     * @param homeTeamScore Score of the home team
     * @param awayTeamScore Score of the away Team
     *
     * @return Game update in the system
     */
    Game update(String id, int homeTeamScore, int awayTeamScore);

    /**
     * Get all games in the system order by total of goals and most recent to start
     *
     * @return List of games
     */
    List<Game> get();
}
