package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projecoes.GameProjecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.titulo, tb_game.ano, tb_game.img_url AS imgUrl,
		tb_game.descricao_curta AS descricaoCurta, tb_pertencimento.posicao
		FROM tb_game
		INNER JOIN tb_pertencimento ON tb_game.id = tb_pertencimento.game_id
		WHERE tb_pertencimento.lista_id = :listaId
		ORDER BY tb_pertencimento.posicao
			""")
    List<GameProjecao> searchByList(Long listaId);
}
