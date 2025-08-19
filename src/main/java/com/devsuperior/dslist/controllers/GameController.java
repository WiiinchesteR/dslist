package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dtos.GameDTO;
import com.devsuperior.dslist.dtos.GameDetalhadoDTO;
import com.devsuperior.dslist.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameDTO>> listarJogos() {
        return ResponseEntity.ok(gameService.listarGames());
    }

    @GetMapping("{id}")
    public ResponseEntity<GameDetalhadoDTO> buscarGame(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.buscarGame(id));
    }
}
