/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneradorDirecciones {
    private List<String> direcciones;
    private Random random;

    public GeneradorDirecciones(String archivo) throws IOException {
        direcciones = new ArrayList<>();
        random = new Random();
        cargarDirecciones(archivo);
    }

    // Método para cargar direcciones desde un archivo
    private void cargarDirecciones(String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                direcciones.add(linea.trim());
            }
        }
    }

    // Método para obtener una dirección aleatoria
    public String obtenerDireccionAleatoria() {
        return direcciones.get(random.nextInt(direcciones.size()));
    }
}
