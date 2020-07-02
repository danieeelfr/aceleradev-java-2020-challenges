package br.com.codenation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatisticUtil {

	public static int average(int[] elements) {
		if (elements.length > 0)
			return Arrays.stream(elements).sum() / elements.length;
		else
			return 0;
	}

	public static int mode(int[] elements) {
		List<Integer> modes = new ArrayList<Integer>(  );
		int maxCount=0;
		for (int i = 0; i < elements.length; ++i){
			int count = 0;
			for (int j = 0; j < elements.length; ++j){
				if (elements[j] == elements[i])
					++count;
			}
			if (count > maxCount){
				maxCount = count;
				modes.clear();

				if(!temNaLista(elements[i], modes)) {
					modes.add(elements[i] );
				}
			} else if ( count == maxCount ){
				if(!temNaLista(elements[i], modes)) {
					modes.add(elements[i] );
				}
			}
		}
		return modes.stream().mapToInt(x -> x.intValue()).sum();
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		double median;
		if (elements.length % 2 == 0)
			return ((int)elements[elements.length/2] + (int)elements[elements.length/2 - 1])/2;
		else
			return (int) elements[elements.length/2];
	}

	private static boolean temNaLista(int numero, List<Integer> lista) {
		for(int item : lista) {
			if(item == numero) return true;
		}
		return false;
	}


}