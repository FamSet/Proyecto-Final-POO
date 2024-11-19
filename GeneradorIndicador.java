/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.Random;

public class GeneradorIndicador {
    private Random random;

    public GeneradorIndicador() {
        random = new Random();
    }

    // Generar un promedio aleatorio entre 5 y 10
    public double generarPromedio() {
        return 5 + (random.nextDouble() * 5);
    }

    // Calcular la escolaridad
    public double calcularEscolaridad(int materiasAprobadas) {
        // Determinar el número de materias inscritas redondeando al siguiente múltiplo de 5
        int materiasInscritas = ((materiasAprobadas + 4) / 5) * 5;
        return ((double) materiasAprobadas / materiasInscritas) * 100;
    }

    // Calcular la velocidad
    public double calcularVelocidad(int materiasAprobadas) {
        // Créditos obtenidos y créditos que debería tener
        int creditosObtenidos = materiasAprobadas * 10;
        int materiasInscritas = ((materiasAprobadas + 4) / 5) * 5;
        int creditosEsperados = materiasInscritas * 10;
        return ((double) creditosObtenidos / creditosEsperados)*100;
    }

    // Calcular el indicador escolar
    public double calcularIndicador(int materiasAprobadas) {
        double promedio = generarPromedio();
        double escolaridad = calcularEscolaridad(materiasAprobadas);
        double velocidad = calcularVelocidad(materiasAprobadas);
        return promedio * escolaridad * velocidad;
    }
}
