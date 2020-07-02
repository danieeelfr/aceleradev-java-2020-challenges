package br.com.codenation.calculadora;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CalculadoraSalarioTest {

	@Test
	public void salarioLiquidoIsNotNull() {
		assertNotNull(new CalculadoraSalario().calcularSalarioLiquido(1000.0));
		assertNotNull(new CalculadoraSalario().calcularSalarioLiquido(5000.0));
		assertNotNull(new CalculadoraSalario().calcularSalarioLiquido(10000.0));
	}

	@Test
	public void salarioLiquidoFaixa1() {
		double salarioBruto = 1000D;
		double salarioLiquidoEsperado = 0D;
		double salarioLiquidoCalculado = new CalculadoraSalario().calcularSalarioLiquido(salarioBruto);

		assertEquals(salarioLiquidoEsperado, salarioLiquidoCalculado, 0.9);
	}

	@Test
	public void salarioLiquidoFaixa2() {
		double salarioBruto = 3500D;
		double descontoInssEsperado = salarioBruto * 0.09;
		double descontoIREsperado = (salarioBruto - descontoInssEsperado) * 0.075;
		double salarioLiquidoEsperado = Math.round(salarioBruto - (descontoInssEsperado + descontoIREsperado));

		double salarioLiquidoCalculado = new CalculadoraSalario().calcularSalarioLiquido(salarioBruto);

		assertEquals(salarioLiquidoEsperado, salarioLiquidoCalculado, 0.9);
	}

	@Test
	public void salarioLiquidoFaixa3() {
		double salarioBruto = 10000D;
		double descontoInssEsperado = salarioBruto * 0.11;
		double descontoIREsperado = (salarioBruto - descontoInssEsperado) * 0.15;
		double salarioLiquidoEsperado = Math.round(salarioBruto - (descontoInssEsperado + descontoIREsperado));

		double salarioLiquidoCalculado = new CalculadoraSalario().calcularSalarioLiquido(salarioBruto);

		assertEquals(salarioLiquidoEsperado, salarioLiquidoCalculado, 0.9);
	}
}