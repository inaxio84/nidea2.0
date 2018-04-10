package com.ipartek.formacion.nidea.ejemplos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilidadesTest {

	@Test
	public void testlimpiarEspacios() {

		assertEquals("hola ke ase", Utilidades.limpiarEspacios("   hola   ke     ase    "));
		assertEquals("", Utilidades.limpiarEspacios(null));
	}

}
