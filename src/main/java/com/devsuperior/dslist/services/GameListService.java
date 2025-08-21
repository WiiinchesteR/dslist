package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dtos.GameListDTO;
import com.devsuperior.dslist.projecoes.GameProjecao;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameListService {

    private final GameListRepository gameListRepository;
    private final GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> listarListas() {
        var listas = gameListRepository.findAll();

        return listas.stream()
                .map(GameListDTO::new)
                .toList();
    }

    @Transactional
    public void moverLista(Long id, int posicaoOrigem, int posicaoDestino) {
        var listaGames = gameRepository.searchByList(id);

        GameProjecao objeto = listaGames.remove(posicaoOrigem);
        listaGames.add(posicaoDestino, objeto);

        var min = posicaoOrigem < posicaoDestino ? posicaoOrigem : posicaoDestino;

        var max = posicaoOrigem < posicaoDestino ? posicaoDestino : posicaoOrigem;

        for (int i = min; i <= max; i++) {
            gameListRepository.updatePertencimentoPosicao(id, listaGames.get(i).getId(), i);
        }
    }
}
