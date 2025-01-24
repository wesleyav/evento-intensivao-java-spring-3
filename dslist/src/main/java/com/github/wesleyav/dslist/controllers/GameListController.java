package com.github.wesleyav.dslist.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.wesleyav.dslist.dto.GameListDTO;
import com.github.wesleyav.dslist.dto.GameMinDTO;
import com.github.wesleyav.dslist.dto.ReplacementDTO;
import com.github.wesleyav.dslist.services.GameListService;
import com.github.wesleyav.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	private final GameListService gameListService;
	private final GameService gameService;

	public GameListController(GameListService gameListService, GameService gameService) {
		this.gameListService = gameListService;
		this.gameService = gameService;
	}

	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}

	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}

	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
}
