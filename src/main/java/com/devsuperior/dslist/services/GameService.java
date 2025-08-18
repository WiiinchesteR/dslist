package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dtos.GameDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public List<GameDTO> listarGames () {
        List<Game> lista = gameRepository.findAll();

//      Código abaixo é o mesmo do retorno, só escrito de forma diferente.
//      List<GameDTO> dto = lista.stream().map(x -> new GameDTO(x)).toList();

        return lista.stream()
                .map(GameDTO::new)
                .toList();
    }
}
