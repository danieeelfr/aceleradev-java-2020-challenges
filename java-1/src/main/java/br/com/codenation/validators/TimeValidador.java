package br.com.codenation.validators;
import br.com.codenation.models.Time;
import lombok.SneakyThrows;

public class TimeValidador {

    @SneakyThrows
    public static void ValidarCamposObrigatorios(Time time) {
        boolean timeValido = (time.getId() != null
                && time.getDataCriacao() != null
                && !time.getNome().isEmpty()
                && !time.getCorUniformePrincipal().isEmpty()
                && !time.getCorUniformeSecundario().isEmpty());

        if (!timeValido) {
            throw new Exception("Algum campo obrigatório não foi informado");
        }
    }
}