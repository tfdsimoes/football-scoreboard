package com.sportradar.scoreboard.repository;

import com.sportradar.scoreboard.entity.Game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameRepository {

    private static GameRepository gameRepository = null;

    private Map<String, Game> scoreBoard = new HashMap<>();

    public static GameRepository getInstance() {
        if(gameRepository == null) {
            gameRepository = new GameRepository();
        }
        return gameRepository;
    }

    public void add(Game game) {
        scoreBoard.put(game.getId(), game);
    }

    public Game get(String id) {
        return scoreBoard.get(id);
    }

    public void remove(String id) {
        scoreBoard.remove(id);
    }

    public void update(Game game) {
        scoreBoard.put(game.getId(), game);
    }

    public Collection<Game> getAll() {
        return scoreBoard.values();
    }

    public void cleanAll() {
        scoreBoard.clear();
    }
}
