package com.devsuperior.dslist.dtos;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projecoes.GameProjecao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class GameDTO {

    private Long id;
    private String titulo;
    private Integer ano;
    private String imgUrl;
    private String descricaoCurta;

    // Transferindo os dados da entidade para o DTO
    public GameDTO(Game entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        ano = entity.getAno();
        imgUrl = entity.getImgUrl();
        descricaoCurta = entity.getDescricaoCurta();
    }

    public GameDTO(GameProjecao projecao) {
        id = projecao.getId();
        titulo = projecao.getTitulo();
        ano = projecao.getAno();
        imgUrl = projecao.getImgUrl();
        descricaoCurta = projecao.getDescricaoCurta();
    }
}
