package com.sportradar.scoreboard.service;

import com.sportradar.scoreboard.entity.Game;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardServiceTest {

    private static ScoreBoardService scoreBoardService;

    @BeforeAll
    public static void setup() {
        scoreBoardService = new ScoreBoardServiceImpl();
    }

    @AfterEach
    public void tearDownTest() {
        scoreBoardService.cleanAll();
    }

    /**
     * Assert the creation of a game with the parameters correct
     */
    @Test
    public void startGameSuccess(){
        Game game = scoreBoardService.start("a", "b");

        assertEquals("a", game.getHomeTeam(), "Home team is not correct");
        assertEquals("b", game.getAwayTeam(), "Away team is not correct");
    }

    /**
     * Assert the error creation a game with a team with null value
     */
    @Test
    public void startGameErrorTeamNull(){
        try {
            scoreBoardService.start(null, "b");
        } catch (RuntimeException exception) {
            assertEquals("Home team can not be null or empty", exception.getMessage(), "Error message should be different");
        }

    }

    /**
     * Assert the error of creation a game with a team with no value
     */
    @Test
    public void startGameErrorTeamEmpty() {
        try {
            scoreBoardService.start("a", "");
        } catch (RuntimeException exception) {
            assertEquals("Away team can not be null or empty", exception.getMessage(), "Error message should be different");
        }
    }

    /**
     * Assert the end of a game
     */
    @Test
    public void endGameSuccess() {

    }

    /**
     * Assert the error of end a game with an id not valid
     */
    @Test
    public void endGameErrorIdNotFound() {

    }

    /**
     * Assert the update of a score of a game
     */
    @Test
    public void updateGameSuccess() {

    }

    /**
     * Assert the error of update a game when the id does not exist
     */
    @Test
    public void updateGameErrorIdNotFound() {

    }

    /**
     * Assert the error of update a game when one of the score is negative
     */
    @Test
    public void updateGameErrorNegativeScore() {

    }

    /**
     * Assert the case of scoreboard is empty
     */
    @Test
    public void getGamesEmpty() {

    }

    /**
     * Assert the case of scoreboard have only one game
     */
    @Test
    public void getGameOneGame() {

    }

    /**
     * Assert the case of list of games with different scores
     */
    @Test
    public void getGameSeveralGamesDifferentScores() {

    }

    /**
     * Assert the case of list of games with equal score
     */
    @Test
    public void getGameSeveralGamesEqualsScores() {

    }
}