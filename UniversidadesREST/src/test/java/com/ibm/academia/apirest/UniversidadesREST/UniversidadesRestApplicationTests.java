package com.ibm.academia.apirest.UniversidadesREST;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;


class UniversidadesRestApplicationTests {

	@Test
	@DisplayName("Test suma de valores")
	void sumarValores()
	{
		//Given: Define el contexto o las precondiciones
		Integer valorA =2;
		Integer valorB =3;

		// When: Ejecuta la accion, es decir, lo que vamos a probar

		Calculadora calculadora = new Calculadora();
		Integer expected = calculadora.sumar(valorA, valorB);

		//Then: Validar que lo que se esta ejecutando funciona correctamente
		Integer resultadoEsperado =5;
		assertThat(expected).isEqualTo(resultadoEsperado);


	}

	class Calculadora{
		Integer sumar(Integer a, Integer b){
			return a+b;
		}
	}

	@Test
	void contextLoads() {
	}

}
