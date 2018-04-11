package com.ipartek.formacion.nidea.util;

public class Utilidades {

	/**
	 * Metodo estatico para poder usarse desde la propia Clase, sin tener que
	 * instanciar un objeto.<br>
	 * 
	 * Limpia los espacios en blanco " " de una cadena String. <br>
	 * Hacemos trim, ademas de sustituir todos los espacios en blanco de entre medio
	 * por uno unico, ej: <br>
	 * " hola ke ase " => "hola ke ase"
	 * 
	 * @param cadena
	 * @return en caso de null retorna cadena vacía
	 */
	public static String limpiarEspacios(String cadena) {
		String resul = "";
		if (cadena != null) {
			resul = cadena.trim();
			resul = resul.replaceAll("\\s+", " ");
		}
		return resul;
	}

}
