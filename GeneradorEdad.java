/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.Random;

public class GeneradorEdad {
    private Random random;

    public GeneradorEdad() {
        random = new Random();
    }

    // Método para generar la edad considerando el número de materias cursadas
    public int generarEdad(int numeroMaterias) {
        int edad;
        
        // Si el alumno tiene entre 20 y 25 materias, se asume que está en 5to semestre
        if (numeroMaterias >= 20 && numeroMaterias <= 25) {
            edad = 19 + random.nextInt(9); // Generar edad entre 19 y 27
        } else {
            edad = 18 + random.nextInt(10); // Generar edad entre 18 y 27
        }
        
        return edad;
    }
}
