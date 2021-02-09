package com.sportradar.scoreboard.service;

import com.sportradar.scoreboard.entity.Game;
import com.sportradar.scoreboard.repository.GameRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoardServiceImpl implements ScoreBoardService {

    private GameRepository gameRepository = new GameRepository();

    /**
     * Start the game in the scoreboard
     *
     * @param homeTeam Name of the home team
     * @param awayTeam Name of the away team
     *
     * @return Game created in the system
     */
    @Override
    public Game start(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        gameRepository.add(game);
        return game;
    }

    /**
     * End a game and remove it from the system
     *
     * @param id Id of the game to end
     */
    @Override
    public void end(String id) {
        gameRepository.remove(id);
    }

    /**
     * Update a score of game
     *
     * @param id            Id of the game to update
     * @param homeTeamScore Score of the home team
     * @param awayTeamScore Score of the away Team
     *
     * @return Game update in the system
     */
    @Override
    public Game update(String id, int homeTeamScore, int awayTeamScore) {
        Game game = gameRepository.get(id);
        game.setHomeTeamScore(homeTeamScore);
        game.setAwayTeamScore(awayTeamScore);
        gameRepository.update(game);
        return game;
    }

    /**
     * Get all games in the system order by total of goals and most recent to start
     *
     * @return List of games
     */
    @Override
    public List<Game> get() {

        Comparator<Game> comparator = Comparator.comparingInt(Game::getTotalGoals)
                .thenComparing(Game::getStartTime);

        return gameRepository.getAll()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    /**
     * Clean all the scoreboard
     */
    @Override
    public void cleanAll() {
        gameRepository.cleanAll();
    }
}
