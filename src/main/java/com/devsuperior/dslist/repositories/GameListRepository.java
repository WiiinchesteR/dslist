package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Modifying
    @Query(nativeQuery = true, value = """
            UPDATE tb_pertencimento SET posicao = :novaPosicao 
            WHERE lista_id = :listaId AND game_id = :gameId
            """)
    void updatePertencimentoPosicao(Long listaId, Long gameId, Integer novaPosicao);

}
