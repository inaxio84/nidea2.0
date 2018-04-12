package com.ipartek.formacion.nidea.util;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.nidea.ejemplos.Ordenable;

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

	/**
	 * Metodo para ordenar una coleccion con el algoritmo bubblesort. Ordena de neor
	 * a mayor basandose en el metodo getValor() de la Interfaz Ordenable
	 * 
	 * @see package com.ipartek.formacion.nidea.ejemplos.Ordenable
	 * @param coleccion
	 *            List<Ordenable> coleccion con los elementos aordenar
	 * @return en caso de null retornamos una lista vacía
	 */
	public static List<Ordenable> bubblesort(List<Ordenable> coleccion) {
		List<Ordenable> resul = new ArrayList<Ordenable>();
		if (coleccion != null) {

			int n = coleccion.size();
			Ordenable temp = null;
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < (n - i); j++) {
					if (coleccion.get(j - 1).getValor() > coleccion.get(j).getValor()) {
						// swap elements
						temp = coleccion.get(j - 1);
						coleccion.set(j - 1, coleccion.get(j));
						coleccion.set(j, temp);
					}

				}

				// TODO implementar algoritmo bubblesort
				resul = coleccion;

			}
		}
		return resul;
	}

}
