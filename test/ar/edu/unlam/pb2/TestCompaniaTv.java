package ar.edu.unlam.pb2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.*;

import org.junit.Test;

public class TestCompaniaTv {

	@Test
	public void dadoQueExisteUnaCompaniaSePuedeAgregarUnCliente() throws ClienteExistenteException{
		
		Compania compania = new Compania();
		Cliente cliente = new Cliente(44318645, "Franco", "Coppola", 22);
		
		boolean seAgrego = compania.agregarCliente(cliente);
		
		assertTrue(seAgrego);
		
	}
	
	@Test (expected = ClienteExistenteException.class)
	public void dadoQueExisteUnaCompaniaAlAgregarUnClienteExistenteSeLanzaUnaClienteExistenteException() throws ClienteExistenteException{
		
		Compania compania = new Compania();
		Cliente cliente = new Cliente(44318645, "Franco", "Coppola", 22);
		Cliente cliente2 = new Cliente(44318645, "Franco", "Coppola", 22);
		
		boolean seAgrego = compania.agregarCliente(cliente);
		boolean seAgrego2 = compania.agregarCliente(cliente2);
		
		assertTrue(seAgrego);
		assertTrue(seAgrego2);
		
	}
	
	@Test
	public void dadoQueExisteUnaCompaniaConUnPlanBasicoYUnPlanPremiumCuandoSeObtieneElPrecioDeUnPlanPremiumDevuelve6000() {
		
		Compania compania = new Compania();
		Plan planBasico = new Plan(1, "Basico", false);
		Plan planPremium = new Plan(2, "Premium", true);
		
		compania.agregarPlan(planBasico);
		compania.agregarPlan(planPremium);
		
		Double valorObtenido = planPremium.getPrecio();
		Double valorEsperado = 6000.0;
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void dadoQueExisteUnaCompaniaConClientesSePuedenListarLosClientesOrdenadosDeManeraAscendentePorSuDni() throws ClienteExistenteException {
		
		Compania compania = new Compania();
		Cliente cliente1 = new Cliente(44318645, "Franco", "Coppola", 22);
		Cliente cliente2 = new Cliente(12731232, "Juan", "Coppola", 60);
		Cliente cliente3 = new Cliente(24047809, "Lorena", "Coppola", 48);
		
		compania.agregarCliente(cliente1);
		compania.agregarCliente(cliente2);
		compania.agregarCliente(cliente3);
		
		TreeSet<Cliente> clientes = compania.getClientes();
		
		ArrayList<Cliente> clientesOrdenadosLista = new ArrayList<>(clientes);
		
		assertEquals(cliente2, clientesOrdenadosLista.get(0));
		assertEquals(cliente3, clientesOrdenadosLista.get(1));
		assertEquals(cliente1, clientesOrdenadosLista.get(2));
	}
	
	@Test
	public void dadoQueExisteUnaCompaniaConSuscripcionesAPlanesBasicosYPremiumSePuedenListarLasSuscripcionesAPlanesPremium() throws ClienteExistenteException {
		
		Compania compania = new Compania();
		Plan planBasico = new Plan(1, "Basico", false);
		Plan planPremium = new Plan(2, "Premium", true);
		Cliente cliente1 = new Cliente(44318645, "Franco", "Coppola", 22);
		Cliente cliente2 = new Cliente(12731232, "Juan", "Coppola", 60);
		Suscripcion suscripcion1 = new Suscripcion(1, cliente1, planBasico);
		Suscripcion suscripcion2 = new Suscripcion(2, cliente2, planPremium);
		
		compania.agregarPlan(planBasico);
		compania.agregarPlan(planPremium);
		compania.agregarCliente(cliente1);
		compania.agregarCliente(cliente2);
		compania.agregarSuscripcion(suscripcion1);
		compania.agregarSuscripcion(suscripcion2);
		
		Integer obtenido = compania.devolverListaSuscriptoresPremium().size();
		Integer esperado = 1;
		
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void dadoQueExisteUnaCompaniaConSuscripcionesAPlanesBasicosYPremiumSePuedenListarLosClientesSuscritosAPlanesBasicos() throws ClienteExistenteException {
		
		Compania compania = new Compania();
		Plan planBasico = new Plan(1, "Basico", false);
		Plan planPremium = new Plan(2, "Premium", true);
		Cliente cliente1 = new Cliente(44318645, "Franco", "Coppola", 22);
		Cliente cliente2 = new Cliente(12731232, "Juan", "Coppola", 60);
		Cliente cliente3 = new Cliente(24047809, "Lorena", "Coppola", 40);
		Suscripcion suscripcion1 = new Suscripcion(1, cliente1, planBasico);
		Suscripcion suscripcion2 = new Suscripcion(2, cliente2, planPremium);
		Suscripcion suscripcion3 = new Suscripcion(3, cliente3, planBasico);
		
		compania.agregarPlan(planBasico);
		compania.agregarPlan(planPremium);
		compania.agregarCliente(cliente1);
		compania.agregarCliente(cliente2);
		compania.agregarCliente(cliente3);
		compania.agregarSuscripcion(suscripcion1);
		compania.agregarSuscripcion(suscripcion2);
		compania.agregarSuscripcion(suscripcion3);
		
		Integer obtenido = compania.devolverListaSuscriptoresBasico().size();
		Integer esperado = 2;
		
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void dadoQueExisteUnaCompaniaConSuscripcionesAPlanesBasicosYPremiumSePuedeMostrarElTotalDePrecioParaUnPlanBasicoOPremium() throws ClienteExistenteException {
		
		Compania compania = new Compania();
		Plan planBasico = new Plan(1, "Basico", false);
		Plan planPremium = new Plan(2, "Premium", true);
		Cliente cliente1 = new Cliente(44318645, "Franco", "Coppola", 22);
		Cliente cliente2 = new Cliente(12731232, "Juan", "Coppola", 60);
		Suscripcion suscripcion1 = new Suscripcion(1, cliente1, planBasico);
		Suscripcion suscripcion2 = new Suscripcion(2, cliente2, planPremium);
		
		compania.agregarPlan(planBasico);
		compania.agregarPlan(planPremium);
		compania.agregarCliente(cliente1);
		compania.agregarCliente(cliente2);
		compania.agregarSuscripcion(suscripcion1);
		compania.agregarSuscripcion(suscripcion2);
		
		Double obtenido = compania.obtenerValorTotalDeLosPlanes();
		Double esperado = 11000.0;
		
		assertEquals(esperado, obtenido);
	}
	/*
	@Test
	public void dadoQueExisteUnCompaniaConClientesSuscritosAPlanesBasicosOPremiumSePuedeObtnerUnMapaConElPlanComoClaveYUnaListaDeClientesOrdenadosDeManeraDescendentePorDniDelClienteComoValores() {
		
		Compania compania = new Compania();
		Plan planBasico = new Plan(1, "Basico", false);
		Plan planPremium = new Plan(2, "Premium", true);
		Cliente cliente1 = new Cliente(44318645, "Franco", "Coppola", 22);
		Cliente cliente2 = new Cliente(12731232, "Juan", "Coppola", 60);
		Cliente cliente3 = new Cliente(24047809, "Lorena", "Coppola", 48);
		Suscripcion suscripcion1 = new Suscripcion(1, cliente1, planBasico);
		Suscripcion suscripcion2 = new Suscripcion(2, cliente2, planPremium);
		Suscripcion suscripcion3 = new Suscripcion(3, cliente3, planBasico);
		
		compania.agregarSuscripcion(suscripcion1);
		compania.agregarSuscripcion(suscripcion2);
		compania.agregarSuscripcion(suscripcion3);
		
		TreeMap<Plan, TreeSet<Cliente>> mapaDePlanes = compania.ordenarPorDniDescendente();
		
		assertTrue(mapaDePlanes.containsKey(planPremium));
		assertTrue(mapaDePlanes.containsKey(planBasico));
	}
*/
}
