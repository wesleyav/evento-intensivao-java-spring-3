package com.github.wesleyav.dslist.services;

import com.github.wesleyav.dslist.dto.GameMinDTO;
import com.github.wesleyav.dslist.entities.Game;
import com.github.wesleyav.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
