package ar.edu.unlam.pb2;

import java.util.Comparator;

public class ComparadorIdPlan implements Comparator<Plan> {

	@Override
	public int compare(Plan o1, Plan o2) {
		// TODO Auto-generated method stub
		return o1.getIdentificadorUnico().compareTo(o2.getIdentificadorUnico());
	}

}
