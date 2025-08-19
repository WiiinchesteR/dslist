package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dtos.GameListDTO;
import com.devsuperior.dslist.repositories.GameListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameListService {

    private final GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> listarListas() {
        var listas = gameListRepository.findAll();

        return listas.stream()
                .map(GameListDTO::new)
                .toList();
    }
}
