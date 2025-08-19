package com.devsuperior.dslist.dtos;

import com.devsuperior.dslist.entities.GameList;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GameListDTO {

    private Long id;
    private String nome;

    public GameListDTO(GameList entity) {
        id = entity.getId();
        nome = entity.getNome();
    }

}
