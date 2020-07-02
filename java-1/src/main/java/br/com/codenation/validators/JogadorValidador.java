package br.com.codenation.validators;
import br.com.codenation.models.Jogador;
import lombok.SneakyThrows;

public class JogadorValidador {

    @SneakyThrows
    public static void ValidarCamposObrigatorios(Jogador jogador) {
        boolean jogadorValido = (jogador.getId() != null
                && jogador.getDataNascimento() != null
                && jogador.getIdTime() != null
                && jogador.getNivelHabilidade() != null
                && !jogador.getNome().isEmpty()
                && jogador.getSalario() != null);

        if (!jogadorValido) {
            throw new Exception("Algum campo obrigatório não foi informado");
        }
    }
}
