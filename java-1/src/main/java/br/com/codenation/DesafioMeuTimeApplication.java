package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.models.Jogador;
import br.com.codenation.models.Time;
import br.com.codenation.validators.JogadorValidador;
import br.com.codenation.validators.TimeValidador;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

    List<Time> times = new ArrayList<>();
    List<Jogador> jogadores = new ArrayList<>();

    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        if (times.stream().anyMatch(time -> time.getId().equals(id))) {
            throw new IdentificadorUtilizadoException();
        }

        Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
        TimeValidador.ValidarCamposObrigatorios(time);
        times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
    }

    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        if (jogadores.stream().anyMatch(jogador -> jogador.getId().equals(id))) {
            throw new IdentificadorUtilizadoException();
        }
        if (!times.stream().anyMatch(time -> time.getId().equals(idTime))) {
            throw new TimeNaoEncontradoException();
        }
        Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
        JogadorValidador.ValidarCamposObrigatorios(jogador);
        jogadores.add(jogador);
    }

    public void definirCapitao(Long idJogador) {
        if (!jogadores.stream().anyMatch(jogador -> jogador.getId().equals(idJogador))) {
            throw new JogadorNaoEncontradoException();
        }
        jogadores.stream()
                .filter(jogador -> jogador.getId().equals(idJogador))
                .forEach(jogador -> times.stream()
                        .filter(time -> time.getId().equals(jogador.getIdTime()))
                        .forEach(time -> time.setCapitao(idJogador)));
    }

    public Long buscarCapitaoDoTime(Long idTime) {
        if (!times.stream().anyMatch(time -> time.getId().equals(idTime))) {
            throw new TimeNaoEncontradoException();
        }

        times.stream()
                .filter(time -> time.getId().equals(idTime))
                .forEach(time -> {
                    if (time.getCapitao() == null) {
                        throw new CapitaoNaoInformadoException();
                    }
                });

        return times.stream()
                .filter(time -> time.getId().equals(idTime))
                .map(Time::getCapitao)
                .findFirst()
                .orElseThrow(TimeNaoEncontradoException::new);
    }

    public String buscarNomeJogador(Long idJogador) {
        return jogadores.stream()
                .filter(jogador -> jogador.getId().equals(idJogador))
                .map(Jogador::getNome)
                .findFirst()
                .orElseThrow(JogadorNaoEncontradoException::new);
    }

    public String buscarNomeTime(Long idTime) {
        return times.stream()
                .filter(time -> time.getId().equals(idTime))
                .map(Time::getNome)
                .findFirst()
                .orElseThrow(TimeNaoEncontradoException::new);
    }

    public List<Long> buscarJogadoresDoTime(Long idTime) {
        return times.stream()
                .filter(time -> time.getId().equals(idTime))
                .map(time -> jogadores.stream()
                        .filter(jogador -> jogador.getIdTime().equals(idTime))
                        .map(Jogador::getId)
                        .collect(Collectors.toList()))
                .findAny()
                .orElseThrow(TimeNaoEncontradoException::new);
    }

    public Long buscarMelhorJogadorDoTime(Long idTime) {
        return jogadores.stream()
                .filter(jogador -> jogador.getIdTime().equals(idTime))
                .max(Comparator.comparing(Jogador::getNivelHabilidade))
                .map(Jogador::getId)
                .orElseThrow(TimeNaoEncontradoException::new);
    }

    public Long buscarJogadorMaisVelho(Long idTime) {
        return jogadores.stream()
                .filter(jogador -> jogador.getIdTime().equals(idTime))
                .min(Comparator.comparing(Jogador::getDataNascimento))
                .map(Jogador::getId)
                .orElseThrow(TimeNaoEncontradoException::new);
    }

    public List<Long> buscarTimes() {
        return times.stream()
                .map(Time::getId)
                .collect(Collectors.toList());
    }

    public Long buscarJogadorMaiorSalario(Long idTime) {
        return jogadores.stream()
                .filter(jogador -> jogador.getIdTime().equals(idTime))
                .max(Comparator.comparing(Jogador::getSalario))
                .map(Jogador::getId)
                .orElseThrow(TimeNaoEncontradoException::new);
    }

    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        return jogadores.stream()
                .filter(jogador -> jogador.getId().equals(idJogador))
                .map(Jogador::getSalario)
                .findFirst()
                .orElseThrow(JogadorNaoEncontradoException::new);
    }

    public List<Long> buscarTopJogadores(Integer top) {
        return jogadores.stream()
                .sorted(Comparator.comparingInt(Jogador::getNivelHabilidade).reversed())
                .map(Jogador::getId)
                .limit(top)
                .collect(Collectors.toList());
    }
}
