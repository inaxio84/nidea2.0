package com.ipartek.formacion.nidea.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ipartek.formacion.nidea.util.Utilidades;

public class UtilidadesTest {

	@Test
	public void testlimpiarEspacios() {

		assertEquals("hola ke ase", Utilidades.limpiarEspacios("   hola   ke     ase    "));
		assertEquals("", Utilidades.limpiarEspacios(null));
	}

}
