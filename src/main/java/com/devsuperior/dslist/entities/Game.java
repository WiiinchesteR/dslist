package com.devsuperior.dslist.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Integer ano;
    private String genero;
    private Double pontuacao;
    private String imgUrl;
    private String descricaoCurta;
    private String descricaoLonga;
}
