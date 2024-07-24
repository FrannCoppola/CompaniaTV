package ar.edu.unlam.pb2;

import java.util.TreeMap;
import java.util.TreeSet;

public class Compania {

	private TreeSet<Canal> canales;
	private TreeSet<Cliente> clientes;
	private TreeMap<Plan, TreeSet<Cliente>> planes;
	private TreeSet<Suscripcion> suscripciones;

	public Compania() {
		
		this.canales = new TreeSet<>(new ComparadorNumeroCanal());
		this.clientes = new TreeSet<>(new ComparadorDni());
		this.planes = new TreeMap<Plan, TreeSet<Cliente>>(new ComparadorIdPlan());
		this.suscripciones = new TreeSet<>(new ComparadorIdSuscripcion());
	}

	public boolean agregarCliente(Cliente cliente) throws ClienteExistenteException {
		
		if(clientes.contains(cliente)) {
			throw new ClienteExistenteException();
		}
		return this.clientes.add(cliente);
	}
	
	public void agregarPlan(Plan plan) {
		
		planes.put(plan, clientes);
	}
	
	public void agregarSuscripcion(Suscripcion suscripcion) {
		
		suscripciones.add(suscripcion);
	}
	
	public TreeSet<Suscripcion> devolverListaSuscriptoresPremium(){
		
		TreeSet<Suscripcion> nuevasSuscripciones = new TreeSet<Suscripcion>(new ComparadorIdSuscripcion());
		for(Suscripcion i : suscripciones) {
			if(i.getPlan().getEsPremium() == true) {
				nuevasSuscripciones.add(i);
			}
		}
		return nuevasSuscripciones;
	}
	
	public TreeSet<Suscripcion> devolverListaSuscriptoresBasico(){
		
		TreeSet<Suscripcion> nuevasSuscripciones = new TreeSet<Suscripcion>(new ComparadorIdSuscripcion());
		for(Suscripcion i : suscripciones) {
			if(i.getPlan().getEsPremium() == false) {
				nuevasSuscripciones.add(i);
			}
		}
		return nuevasSuscripciones;
	}

	public Double obtenerValorTotalDeLosPlanes() {
		Double valorTotal = 0.0;
		for(Suscripcion i : suscripciones) {
			valorTotal += i.getPlan().calculadorValorPlan();
		}
		
		return valorTotal;
	}
	
	 public TreeMap<Plan, TreeSet<Cliente>> ordenarPorDniDescendente() {
	        TreeMap<Plan, TreeSet<Cliente>> mapaDePlanes = new TreeMap<>();
	        
	        for (Suscripcion suscripcion : suscripciones) {
	            Plan plan = suscripcion.getPlan();
	            Cliente cliente = suscripcion.getCliente();
	            
	            mapaDePlanes.computeIfAbsent(plan, k -> new TreeSet<>(new ComparadorDniDescendiente()))
	                        .add(cliente);
	        }
	        
	        return mapaDePlanes;
	    }
	
	public TreeSet<Canal> getCanales() {
		return canales;
	}

	public void setCanales(TreeSet<Canal> canales) {
		this.canales = canales;
	}

	public TreeSet<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(TreeSet<Cliente> clientes) {
		this.clientes = clientes;
	}

	public TreeMap<Plan, TreeSet<Cliente>> getPlanes() {
		return planes;
	}

	public void setPlanes(TreeMap<Plan, TreeSet<Cliente>> planes) {
		this.planes = planes;
	}

	public TreeSet<Suscripcion> getSuscripciones() {
		return suscripciones;
	}

	public void setSuscripciones(TreeSet<Suscripcion> suscripciones) {
		this.suscripciones = suscripciones;
	}
	
	
}
