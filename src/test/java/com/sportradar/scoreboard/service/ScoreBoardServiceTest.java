package com.sportradar.scoreboard.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreBoardServiceTest {

    /**
     * Assert the creation of a game with the parameters correct
     */
    @Test
    public void startGameSuccess(){

    }

    /**
     * Assert the error creation a game with a team with null value
     */
    @Test
    public void startGameErrorTeamNull(){

    }

    /**
     * Assert the error of creation a game with a team with no value
     */
    @Test
    public void startGameErrorTeamEmpty() {

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