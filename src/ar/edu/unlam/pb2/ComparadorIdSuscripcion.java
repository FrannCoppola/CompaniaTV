package ar.edu.unlam.pb2;

import java.util.Comparator;

public class ComparadorIdSuscripcion implements Comparator<Suscripcion>{

	@Override
	public int compare(Suscripcion o1, Suscripcion o2) {
		// TODO Auto-generated method stub
		return o1.getIdUnico().compareTo(o2.getIdUnico());
	}

}
