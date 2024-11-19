/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    // Método para iniciar el QuickSort
    public static void quickSort(List<Alumno> lista, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particionar(lista, inicio, fin);
            quickSort(lista, inicio, indicePivote - 1);
            quickSort(lista, indicePivote + 1, fin);
        }
    }

    // Método de partición para QuickSort (orden inverso)
    private static int particionar(List<Alumno> lista, int inicio, int fin) {
        Alumno pivote = lista.get(fin);
        int i = inicio - 1;
        
        // Orden inverso: cambiamos el signo en la comparación
        for (int j = inicio; j < fin; j++) {
            if (lista.get(j).getIndicadorEscolar() > pivote.getIndicadorEscolar()) {
                i++;
                intercambiar(lista, i, j);
            }
        }
        intercambiar(lista, i + 1, fin);
        return i + 1;
    }

    // Método para intercambiar dos elementos en el ArrayList
    private static void intercambiar(List<Alumno> lista, int i, int j) {
        Alumno temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }
}

