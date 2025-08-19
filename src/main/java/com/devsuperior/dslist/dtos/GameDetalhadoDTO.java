package com.devsuperior.dslist.dtos;

import com.devsuperior.dslist.entities.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Getter
@NoArgsConstructor
public class GameDetalhadoDTO {

    private Long id;
    private String titulo;
    private Integer ano;
    private String plataforma;
    private String genero;
    private Double pontuacao;
    private String imgUrl;
    private String descricaoCurta;
    private String descricaoLonga;

    // Transferindo os dados da entidade para o DTO
    public GameDetalhadoDTO(Game entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        ano = entity.getAno();
        plataforma = entity.getPlataforma();
        genero = entity.getGenero();
        pontuacao = entity.getPontuacao();
        imgUrl = entity.getImgUrl();
        descricaoCurta = entity.getDescricaoCurta();
        descricaoLonga = entity.getDescricaoLonga();
    }

//    O código abaixo, funciona da mesma forma que o código acima, é apenas um facilitador, porém é necessario os setters.
//    public GameDetalhadoDTO(Game entity) {
//        BeanUtils.copyProperties(entity, this);
//    }

}
