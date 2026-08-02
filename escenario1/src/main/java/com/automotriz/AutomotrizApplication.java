package com.automotriz;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.automotriz.modelo.Automovil;

/**
 * Clase principal.
 * <p>
 * En este escenario, la clase actúa también como ejecutor de prueba para demostrar 
 * la instanciación de objetos {@link Automovil} aplicando el patrón creacional <strong>Builder</strong>.
 * </p>
 * 
 * @author Equipo de Arquitectura
 * @version 1.0
 */
@SpringBootApplication
public class AutomotrizApplication {

	public static void main(String[] args) {
		//Construcción de un vehículo de alta gama con opcionales completos.
        Automovil autoDeportivo = new Automovil.AutomovilBuilder("V8 Twin-Turbo", "Rojo")
                .llantas("Deportivas 20 pulgadas")
                .sistemaSonido("Bose Surround 10 parlantes")
                .interiores("Cuero Negro")
                .techoSolar(true)
                .navegacionGPS(true)
                .build();

        //Construcción de un vehículo básico omitiendo atributos opcionales.
        Automovil autoBasico = new Automovil.AutomovilBuilder("1.6L 4 Cilindros", "Blanco")
                .navegacionGPS(true)
                .build();

        System.out.println("Configuración Auto Deportivo:\n" + autoDeportivo);
        System.out.println("\nConfiguración Auto Básico:\n" + autoBasico);
	}

}
