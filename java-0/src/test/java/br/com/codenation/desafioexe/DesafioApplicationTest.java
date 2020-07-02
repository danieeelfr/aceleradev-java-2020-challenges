package br.com.codenation.desafioexe;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DesafioApplicationTest {

	Integer[] fibonacciValuesUnder350 = new Integer[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377};

	@Test
	public void fibonacci() {
		List<Integer> result = DesafioApplication.fibonacci();
		assertTrue(Arrays.deepEquals(fibonacciValuesUnder350, result.toArray()));
	}

	@Test
	public void isFibonacci() {
		Arrays.stream(fibonacciValuesUnder350)
				.forEach(n -> assertTrue(DesafioApplication.isFibonacci(n)));

		assertTrue(DesafioApplication.isFibonacci(377));
		assertFalse(DesafioApplication.isFibonacci(4));
		assertFalse(DesafioApplication.isFibonacci(250));
		assertFalse(DesafioApplication.isFibonacci(-1));

	}
}