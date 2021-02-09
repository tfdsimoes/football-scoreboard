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
        assertEquals(0, game.getHomeTeamScore(), "Home score should be 0");
        assertEquals(0, game.getAwayTeamScore(), "Away score should be 0");
    }

    /**
     * Assert the error creation a game with a team with null value
     */
    @Test
    public void startGameErrorTeamNull(){
        try {
            scoreBoardService.start(null, "b");
        } catch (RuntimeException exception) {
            assertEquals("Home team can not be null or empty", exception.getMessage(), "Exception message should be different");
        }

        try {
            scoreBoardService.start("a", null);
        } catch (RuntimeException exception) {
            assertEquals("Away team can not be null or empty", exception.getMessage(), "Exception message should be different");
        }

    }

    /**
     * Assert the error of creation a game with a team with no value
     */
    @Test
    public void startGameErrorTeamEmpty() {
        try {
            scoreBoardService.start("", "b");
        } catch (RuntimeException exception) {
            assertEquals("Home team can not be null or empty", exception.getMessage(), "Exception message should be different");
        }

        try {
            scoreBoardService.start("a", "");
        } catch (RuntimeException exception) {
            assertEquals("Away team can not be null or empty", exception.getMessage(), "Exception message should be different");
        }
    }

    /**
     * Assert the end of a game
     */
    @Test
    public void endGameSuccess() {
        Game game = scoreBoardService.start("a", "b");
        scoreBoardService.end(game.getId());
    }

    /**
     * Assert the error of end a game with an id not valid
     */
    @Test
    public void endGameErrorIdNotFound() {
        try {
            scoreBoardService.end("a");
        } catch (RuntimeException exception) {
            assertEquals("Id does not exist in the system", exception.getMessage(), "Exception message should be different");
        }
    }

    /**
     * Assert the update of a score of a game
     */
    @Test
    public void updateGameSuccess() {
        Game game = scoreBoardService.start("a", "b");
        game = scoreBoardService.update(game.getId(), 1, 1);

        assertEquals("a", game.getHomeTeam(), "Home team is not correct");
        assertEquals("b", game.getAwayTeam(), "Away team is not correct");
        assertEquals(1, game.getHomeTeamScore(), "Home score should be 1");
        assertEquals(1, game.getAwayTeamScore(), "Away score should be 1");
    }

    /**
     * Assert the error of update a game when the id does not exist
     */
    @Test
    public void updateGameErrorIdNotFound() {
        try {
            scoreBoardService.update("a", 1, 1);
        } catch (RuntimeException exception) {
            assertEquals("Id game not found in the system", exception.getMessage(), "Exception message should be different");
        }
    }

    /**
     * Assert the error of update a game when one of the score is negative
     */
    @Test
    public void updateGameErrorNegativeScore() {
        Game game = scoreBoardService.start("a", "b");

        try {
            scoreBoardService.update(game.getId(), -1, 1);
        } catch (RuntimeException exception) {
            assertEquals("Score of teams should be zero or positive", exception.getMessage(), "Exception message should be different");
        }

        try {
            scoreBoardService.update(game.getId(), 1, -1);
        } catch (RuntimeException exception) {
            assertEquals("Score of teams should be zero or positive", exception.getMessage(), "Exception message should be different");
        }
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