package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_pertencimento")
public class Pertencimento {

    @EmbeddedId
    private PertencimentoPK id = new PertencimentoPK();

    private Integer posicao;

    public Pertencimento(Game game, GameList lista, Integer posicao) {
        id.setGame(game);
        id.setLista(lista);

        this.posicao = posicao;
    }

}
