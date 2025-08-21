package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dtos.GameDTO;
import com.devsuperior.dslist.dtos.GameListDTO;
import com.devsuperior.dslist.dtos.ReposicionamentoDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listas")
@RequiredArgsConstructor
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> listarListas() {
        return ResponseEntity.ok(gameListService.listarListas());
    }

    @GetMapping("/{id}/games")
    public ResponseEntity<List<GameDTO>> listarListas(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.buscarListas(id));
    }

    @PostMapping("/{id}/reposicionamento")
    public void moverListas(@PathVariable Long id, @RequestBody ReposicionamentoDTO dto) {
        gameListService.moverLista(id, dto.getPosicaoOrigem(), dto.getPosicaoDestino());
    }
}
