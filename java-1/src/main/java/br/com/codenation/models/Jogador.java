package br.com.codenation.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class Jogador {
    @Getter @Setter private Long id;
    @Getter @Setter private Long idTime;
    @Getter @Setter private String nome;
    @Getter @Setter private LocalDate dataNascimento;
    @Getter @Setter private Integer nivelHabilidade;
    @Getter @Setter private BigDecimal salario;
}
