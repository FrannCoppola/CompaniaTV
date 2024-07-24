package ar.edu.unlam.pb2;

import java.util.TreeSet;

public class Suscripcion {

	private Integer idUnico;
	private Cliente cliente;
	private Plan plan;
	private TreeSet<Canal> canales;
	
	public Suscripcion(Integer idUnico, Cliente cliente, Plan plan) {
		
		this.idUnico = idUnico;
		this.cliente = cliente;
		this.plan = plan;
		this.canales = listaCanalesBasicosYPremium();
	}

	private TreeSet<Canal> listaCanalesBasicosYPremium() {
		
		TreeSet<Canal> canalesDisponibles = new TreeSet<>(new ComparadorNumeroCanal());
		
		Canal canal1 = new Canal(1, "Telefe", TipoDeCanal.NOTICIAS, false);
		Canal canal2 = new Canal(1, "TyC", TipoDeCanal.DEPORTES, true);
		Canal canal3 = new Canal(1, "Disney", TipoDeCanal.INFANTIL, true);
		Canal canal4 = new Canal(1, "Gourmet", TipoDeCanal.VARIOS, false);
		
		canalesDisponibles.add(canal1);
		canalesDisponibles.add(canal4);
		
		if (plan.getEsPremium()) {
			
			canalesDisponibles.add(canal2);
			canalesDisponibles.add(canal3);
		}
		return canalesDisponibles;
	}

	public Integer getIdUnico() {
		return idUnico;
	}

	public void setIdUnico(Integer idUnico) {
		this.idUnico = idUnico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public TreeSet<Canal> getCanales() {
		return canales;
	}

	public void setCanales(TreeSet<Canal> canales) {
		this.canales = canales;
	}

	@Override
	public String toString() {
		return "Suscripcion [idUnico=" + idUnico + ", cliente=" + cliente + ", plan=" + plan + ", canales=" + canales
				+ "]";
	}
	
	
}
