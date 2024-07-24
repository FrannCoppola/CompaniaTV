package ar.edu.unlam.pb2;

public class Canal {

	private Integer numero;
	private String nombre;
	private TipoDeCanal tipoDeCanal;
	private Boolean esPremium;
	
	public Canal(Integer numero, String nombre, TipoDeCanal tipoDeCanal, Boolean esPremium) {
		
		this.numero = numero;
		this.nombre = nombre;
		this.tipoDeCanal = tipoDeCanal;
		this.esPremium = esPremium;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDeCanal getTipoDeCanal() {
		return tipoDeCanal;
	}

	public void setTipoDeCanal(TipoDeCanal tipoDeCanal) {
		this.tipoDeCanal = tipoDeCanal;
	}

	public Boolean getEsPremium() {
		return esPremium;
	}

	public void setEsPremium(Boolean esPremium) {
		this.esPremium = esPremium;
	}

	@Override
	public String toString() {
		return "Canal [numero=" + numero + ", nombre=" + nombre + ", tipoDeCanal=" + tipoDeCanal + ", esPremium="
				+ esPremium + "]";
	}

}
