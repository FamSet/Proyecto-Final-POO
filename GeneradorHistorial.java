/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GeneradorHistorial {
    private List<String> materias;
    private Random random;

    public GeneradorHistorial(String archivoMaterias) throws IOException {
        materias = new ArrayList<>();
        random = new Random();
        cargarMaterias(archivoMaterias);
    }

    // Método para cargar las materias desde el archivo
    private void cargarMaterias(String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                materias.add(linea.trim());
            }
        }
    }

    // Generar un historial académico aleatorio (entre 5 y 40 materias)
    public List<String> generarHistorial() {
        int numMaterias = 5 + random.nextInt(36);
        List<String> historial = new ArrayList<>(materias);
        Collections.shuffle(historial);
        return historial.subList(0, numMaterias);
    }
}
