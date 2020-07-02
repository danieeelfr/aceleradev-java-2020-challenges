package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesafioApplication {

	private static final int MAX_VALUE = 350;

	public static List<Integer> fibonacci() {
		List<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(1);

		int index = result.size();
		int next;
		do {
			next = result.get(index - 2) + result.get(index - 1);
			result.add(next);
			index++;
		} while (next <= MAX_VALUE);

		return result;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}
}