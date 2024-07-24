package ar.edu.unlam.pb2;

import java.util.Comparator;

public class ComparadorDniDescendiente implements Comparator<Cliente> {

	@Override
	public int compare(Cliente o1, Cliente o2) {
		return o2.getDni().compareTo(o1.getDni());
	}

}
