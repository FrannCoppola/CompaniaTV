package ar.edu.unlam.pb2;

import java.util.Comparator;

public class ComparadorNumeroCanal implements Comparator<Canal> {

	@Override
	public int compare(Canal o1, Canal o2) {
		
		return o1.getNumero().compareTo(o2.getNumero());
	}
	
	
}
