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

public class GeneradorNombres {
    private List<String> nombres;
    private List<String> apellidos;
    private Random random;

    public GeneradorNombres() {
    }
    
    

    public GeneradorNombres(String archivoCSV) throws IOException {
        nombres = new ArrayList<>();
        apellidos = new ArrayList<>();
        random = new Random();
        cargarDatos(archivoCSV);
    }

    private void cargarDatos(String archivoCSV) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            br.readLine(); // Saltar encabezado
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    nombres.add(datos[0].trim());
                    apellidos.add(datos[1].trim());
                }
            }
        }
    }

    public String generarNombreCompleto() {
        StringBuilder nombreCompleto = new StringBuilder();

        // 20% de probabilidad de tener dos nombres
        if (random.nextDouble() < 0.2) {
            nombreCompleto.append(obtenerNombreAleatorio()).append(" ");
        }
        
        nombreCompleto.append(obtenerNombreAleatorio());
        
        // Añadir dos apellidos
        nombreCompleto.append(" ")
                      .append(obtenerApellidoAleatorio())
                      .append(" ")
                      .append(obtenerApellidoAleatorio());

        return nombreCompleto.toString();
    }

    private String obtenerNombreAleatorio() {
        return nombres.get(random.nextInt(nombres.size()));
    }

    private String obtenerApellidoAleatorio() {
        return apellidos.get(random.nextInt(apellidos.size()));
    }
}
