package com.sportradar.scoreboard.service;

import com.sportradar.scoreboard.entity.Game;
import com.sportradar.scoreboard.comparator.GameComparator;
import com.sportradar.scoreboard.repository.GameRepository;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoardServiceImpl implements ScoreBoardService {

    private GameRepository gameRepository = new GameRepository();

    /**
     * Start the game in the scoreboard
     *
     * @param homeTeam Name of the home team
     * @param awayTeam Name of the away team
     * @return Game created in the system
     */
    @Override
    public Game start(String homeTeam, String awayTeam) {
        if (StringUtils.isEmpty(homeTeam)) {
            throw new RuntimeException("Home team can not be null or empty");
        }

        if (StringUtils.isEmpty(awayTeam)) {
            throw new RuntimeException("Away team can not be null or empty");
        }

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
     * @return Game update in the system
     */
    @Override
    public Game update(String id, int homeTeamScore, int awayTeamScore) {
        if (homeTeamScore < 0 && awayTeamScore < 0) {
            throw new RuntimeException("Score of teams should be zero or positive");
        }

        Game game = gameRepository.get(id);

        if (game == null) {
            throw new RuntimeException("Id game not found in the system");
        }

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
    public List<Game> getAllOrderByTotalGoalsAndStartTime() {
        return gameRepository.getAll()
                .stream()
                .sorted(new GameComparator())
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
