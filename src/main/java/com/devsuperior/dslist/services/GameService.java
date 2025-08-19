package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dtos.GameDTO;
import com.devsuperior.dslist.dtos.GameDetalhadoDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.excecao.NaoEncontrado;
import com.devsuperior.dslist.projecoes.GameProjecao;
import com.devsuperior.dslist.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameDTO> listarGames () {
        List<Game> lista = gameRepository.findAll();

//      Código abaixo é o mesmo do retorno, só escrito de forma diferente.
//      List<GameDTO> dto = lista.stream().map(x -> new GameDTO(x)).toList();

        return lista.stream()
                .map(GameDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public GameDetalhadoDTO buscarGame(Long id) {
        var game = gameRepository.findById(id).orElseThrow(
                () -> new NaoEncontrado("id não encontrado.")
        );

        // Convertendo a entidade para dto
        return new GameDetalhadoDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameDTO> buscarListas(Long id) {
        var listaGames = gameRepository.searchByList(id);

        return listaGames.stream()
                .map(GameDTO::new)
                .toList();
    }
}
