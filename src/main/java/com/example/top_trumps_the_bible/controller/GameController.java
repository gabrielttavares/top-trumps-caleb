package com.example.top_trumps_the_bible.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.top_trumps_the_bible.model.Game;
import com.example.top_trumps_the_bible.service.GameService;

@RestController
@RequestMapping("/api/game")
public class GameController {
	private final GameService gameService;
	
	@Autowired
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}
	
	@PostMapping("/start")
	public String startGame() {
		gameService.startNewGame();
		return "Game started successfully!";
	}
	
	@PostMapping("/play-round")
	public String playRound(@RequestParam String attribute) {
		return gameService.playRound(attribute);
	}
	
	@GetMapping("/status")
	public Game getGameStatus() {
		return gameService.getCurrentGameStatus();
	}
}
