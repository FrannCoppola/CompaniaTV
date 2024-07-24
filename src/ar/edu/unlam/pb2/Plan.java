package ar.edu.unlam.pb2;

public class Plan {

	private Integer identificadorUnico;
	private String nombre;
	private Boolean esPremium;
	private Double precio;
	
	public Plan(Integer identificadorUnico, String nombre, Boolean esPremium) {
		
		this.identificadorUnico = identificadorUnico;
		this.nombre = nombre;
		this.esPremium = esPremium;
		this.precio = calculadorValorPlan();
	}

	public Double calculadorValorPlan() {
		
		Double valorFinal = 0.0;
		if(getEsPremium()) {
			valorFinal = 5000.0 * 1.20;
		} else {
			valorFinal = 5000.0;
		}
		return valorFinal;
	}

	public Integer getIdentificadorUnico() {
		return identificadorUnico;
	}

	public void setIdentificadorUnico(Integer identificadorUnico) {
		this.identificadorUnico = identificadorUnico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEsPremium() {
		return esPremium;
	}

	public void setEsPremium(Boolean esPremium) {
		this.esPremium = esPremium;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Plan [identificadorUnico=" + identificadorUnico + ", nombre=" + nombre + ", esPremium=" + esPremium
				+ ", precio=" + precio + "]";
	}
	
}
