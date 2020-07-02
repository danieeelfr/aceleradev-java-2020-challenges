package br.com.codenation.calculadora;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CalculadoraSalario {

    private final double SALARIO_MINIMO = 1039D;

    public long calcularSalarioLiquido(double salarioBase) {
        if (salarioAbaixoDoSalarioMinimo(salarioBase) || salarioBase < 0) return 0L;

        double valorInss = calcularInss(salarioBase);
        double valorFGTS = calcularIR(salarioBase - valorInss);
        double salarioLiquido = salarioBase - (valorInss + valorFGTS);

        return Math.round(salarioLiquido);
    }

    private Boolean salarioAbaixoDoSalarioMinimo(double salarioBase) {
        return salarioBase < SALARIO_MINIMO;
    }
    private double calcularInss(double salarioBase) {
        Optional<Double> valorADescontar = obterFaixasInss()
                .entrySet()
                .stream()
                .filter(faixa -> {
                    Double[] valoresFaixa = faixa.getKey();
                    Double inicioFaixa = valoresFaixa[0];
                    Double fimFaixa = valoresFaixa[1];
                    return salarioBase >= inicioFaixa && salarioBase <= fimFaixa;
                })
                .map(faixa -> salarioBase * (faixa.getValue() / 100))
                .findAny();

        if (valorADescontar.isPresent()) {
            return valorADescontar.get();
        }

        return 0D;
    }

    private double calcularIR(double salario) {
        Optional<Double> valorADescontar = obterFaixasIR()
                .entrySet()
                .stream()
                .filter(faixa -> {
                    Double[] valoresFaixa = faixa.getKey();
                    Double inicioFaixa = valoresFaixa[0];
                    Double fimFaixa = valoresFaixa[1];
                    return faixa.getValue() > 0 && salario >= inicioFaixa && salario <= fimFaixa;
                })
                .map(faixa -> salario * (faixa.getValue() / 100))
                .findAny();

        if (valorADescontar.isPresent()) {
            return valorADescontar.get();
        }

        return 0D;
    }

    private Map<Double[], Double> obterFaixasInss() {
        Map<Double[], Double> faixasInss = new HashMap<>();

        faixasInss.put(new Double[]{0D, 1500D}, 8D);
        faixasInss.put(new Double[]{1500.01, 4000D}, 9D);
        faixasInss.put(new Double[]{4000.01, Double.MAX_VALUE}, 11D);

        return faixasInss;
    }

    private Map<Double[], Double> obterFaixasIR() {
        Map<Double[], Double> faixasIR = new HashMap<>();

        faixasIR.put(new Double[]{0D, 3000D}, 0D);
        faixasIR.put(new Double[]{3000.01, 6000D}, 7.5);
        faixasIR.put(new Double[]{6000.01, Double.MAX_VALUE}, 15D);

        return faixasIR;
    }
}