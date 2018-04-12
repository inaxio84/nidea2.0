package com.ipartek.formacion.nidea.ejemplos;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrdenacionInterfacesTest {

	static ArrayList<Ordenable> coleccion;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		coleccion = new ArrayList<Ordenable>();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		coleccion = null;
	}

	@Before
	public void setUp() throws Exception {

		Circulo e1 = new Circulo();
		e1.setRadio(3);

		Perro e2 = new Perro();
		e2.setNumeroVacunas(1);

		Circulo e3 = new Circulo();
		e3.setRadio(0);

		Circulo e4 = new Circulo();
		e4.setRadio(9);

		coleccion.add(e1);
		coleccion.add(e2);
		coleccion.add(e3);
		coleccion.add(e4);
	}

	@After
	public void tearDown() throws Exception {
		coleccion = null;
	}

	/*
	 * @Test public void testBubbleSort() { Utilidades.bubblesort(coleccion);
	 * assertEquals(0, coleccion.get(0).getValor()); assertEquals(1,
	 * coleccion.get(1).getValor()); assertEquals(3, coleccion.get(2).getValor());
	 * assertEquals(9, coleccion.get(3).getValor());
	 * 
	 * Ordenable elemento = coleccion.get(0); if (elemento instanceof Circulo) {
	 * Circulo c = (Circulo) elemento;
	 * 
	 * } else if (elemento instanceof Perro) {
	 * fail("No esperamos esta clase de objetos"); } }
	 */

	@Test
	public void testCollectionSort() {

		Collections.sort(coleccion, new ComparatorOrdenables());

		assertEquals(0, coleccion.get(0).getValor());
		assertEquals(1, coleccion.get(1).getValor());
		assertEquals(3, coleccion.get(2).getValor());
		assertEquals(9, coleccion.get(3).getValor());

	}

}
