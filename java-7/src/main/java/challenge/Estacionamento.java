package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Carro> carrosNoEstacionamento = new ArrayList<>();

    public void estacionar(Carro carro) {

        validarMotorista(carro);

        if (carrosNoEstacionamento.size() >= 10)
            verificarQuemDeveSair(carro);
        else
            if (!carroEstacionado(carro))
                carrosNoEstacionamento.add(carro);
    }

    private void verificarQuemDeveSair(Carro carro) {
        if (carrosNoEstacionamento.get(0).getMotorista().getIdade() > 55) {
            for (int x=0; x < carrosNoEstacionamento.size(); x++) {
                if (carrosNoEstacionamento.get(x).getMotorista().getIdade() <= 55) {
                    carrosNoEstacionamento.remove(x);
                    carrosNoEstacionamento.add(carro);
                    return;
                }
            }
            throw new EstacionamentoException("Não existem vagas disponíveis!");
        }
        if (!carroEstacionado(carro)) {
            carrosNoEstacionamento.remove(0);
            carrosNoEstacionamento.add(carro);
        }
    }

    private void validarMotorista(Carro carro) {
        if (carro.getMotorista() == null)
            throw new EstacionamentoException("Não deve ter carro autônomo!");

        if (carro.getMotorista().getPontos() > 20)
            throw new EstacionamentoException("Carteira suspensa!");

        if (carro.getMotorista().getIdade() < 18)
            throw new EstacionamentoException("Motorista inabilitado!");
    }

    public int carrosEstacionados() {
        return carrosNoEstacionamento.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carrosNoEstacionamento.stream()
                .anyMatch(car -> compareCars(carro, car));
    }

    private boolean compareCars(Carro carro, Carro car) {
        return car.getPlaca().equals(carro.getPlaca())
                && car.getCor().equals(carro.getCor())
                && car.getMotorista().getHabilitacao().equals(carro.getMotorista().getHabilitacao())
                && car.getMotorista().getNome().equals(carro.getMotorista().getNome());
    }
}
