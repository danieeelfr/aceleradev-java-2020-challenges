package br.com.codenation.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {
    @Getter @Setter private final Long id;
    @Getter @Setter private final String nome;
    @Getter @Setter private final LocalDate dataCriacao;
    @Getter @Setter private final String corUniformePrincipal;
    @Getter @Setter private final String corUniformeSecundario;
    @Getter @Setter private Long capitao;
    @Getter private final List<Jogador> jogadores;
    public Time(Long id,
                String nome,
                LocalDate dataCriacao,
                String corUniformePrincipal,
                String corUniformeSecundario) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
        this.jogadores = new ArrayList<>();
    }
}