package com.example.microserv1.resource;

import com.example.microserv1.dto.PlayerRequest;
import com.example.microserv1.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = PlayerController.BASE_URL)
public class PlayerController {

  static final String BASE_URL = "/api/v1/players";

  private final PlayerService playerService;

  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }

  @PostMapping()
  public ResponseEntity<Object> createPlayer(@RequestBody PlayerRequest playerRequest) {
    final var playerResponse = playerService.createPlayer(playerRequest);
    return ResponseEntity.ok(playerResponse);
  }


}
