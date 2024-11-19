/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.ArrayList;


public class AlumnoCRUD {
    private List<Alumno> listaAlumnos;
    private int contadorInscripcion = 1001;

    // Constructor que recibe la lista de alumnos generada
    public AlumnoCRUD(List<Alumno> listaAlumnos) { 
        this.listaAlumnos = listaAlumnos;
    }

    // Crear un nuevo alumno
    public void agregarAlumno(Alumno alumno) {
        listaAlumnos.add(alumno);
        System.out.println("Alumno añadido con éxito: " + alumno.getNombreCompleto());
    }

    // Leer los datos de un alumno por número de inscripción
    public Alumno obtenerAlumno(String numeroInscripcion) {
        return listaAlumnos.stream()
                .filter(alumno -> alumno.getNumeroInscripcion().equals(numeroInscripcion))
                .findFirst()
                .orElse(null);
    }

    // Actualizar los datos de un alumno por número de inscripción
    public void actualizarAlumno(String numeroInscripcion) {
        Optional<Alumno> alumnoExistente = listaAlumnos.stream()
                .filter(alumno -> alumno.getNumeroInscripcion().equals(numeroInscripcion))
                .findFirst();

        if (alumnoExistente.isPresent()) {
            Alumno alumno = alumnoExistente.get();
            Scanner scanner = new Scanner(System.in);

            // Editar nombre
            System.out.print("Ingrese el nuevo nombre (actual: " + alumno.getNombreCompleto() + "): ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.trim().isEmpty()) {
                alumno.setNombreCompleto(nuevoNombre);
            }

            // Editar dirección
            System.out.print("Ingrese la nueva dirección (actual: " + alumno.getDireccion() + "): ");
            String nuevaDireccion = scanner.nextLine();
            if (!nuevaDireccion.trim().isEmpty()) {
                alumno.setDireccion(nuevaDireccion);
            }

            // Editar edad
            System.out.print("Ingrese la nueva edad (actual: " + alumno.getEdad() + "): ");
            String nuevaEdadStr = scanner.nextLine();
            try {
                int nuevaEdad = Integer.parseInt(nuevaEdadStr);
                if (nuevaEdad >= 18 && nuevaEdad <= 27) {
                    alumno.setEdad(nuevaEdad);
                } else {
                    System.out.println("Edad no válida. Debe estar entre 18 y 27 años.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. No se cambió la edad.");
            }

            System.out.println("Alumno actualizado con éxito.");
        } else {
            System.out.println("Alumno no encontrado con el número de inscripción: " + numeroInscripcion);
        }
    }


    // Eliminar un alumno por número de inscripción
    public void eliminarAlumno(String numeroInscripcion) {
        boolean eliminado = listaAlumnos.removeIf(alumno -> alumno.getNumeroInscripcion().equals(numeroInscripcion));
        if (eliminado) {
            System.out.println("Alumno eliminado con éxito.");
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    // Listar todos los alumnos
    public void listarAlumnos() {
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            listaAlumnos.forEach(alumno -> {
                System.out.println(alumno);
                System.out.println("----------------------");
            });
        }
    }
    
    public void crearAlumno() {
        Scanner scanner = new Scanner(System.in);

        // Ingresar nombre
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();

        // Ingresar dirección
        System.out.print("Ingrese la dirección: ");
        String direccion = scanner.nextLine();

        // Ingresar edad
        System.out.print("Ingrese la edad (entre 18 y 27): ");
        int edad = -1;
        try {
            edad = Integer.parseInt(scanner.nextLine());
            if (edad < 18 || edad > 27) {
                System.out.println("Edad no válida. Debe estar entre 18 y 27 años.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida para la edad.");
            return;
        }

        // Generar automáticamente el historial académico
        List<String> historialAcademico = new ArrayList<>();
        try {
            GeneradorHistorial generadorHistorial = new GeneradorHistorial("materias.txt");
            historialAcademico = generadorHistorial.generarHistorial();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo de materias: " + e.getMessage());
            return;
        }

        // Calcular el número de materias basadas en el historial generado
        int numeroMaterias = historialAcademico.size();

        // Calcular el indicador escolar
        GeneradorIndicador generadorIndicador = new GeneradorIndicador();
        double indicadorEscolar = generadorIndicador.calcularIndicador(numeroMaterias);

        // Generar el número de inscripción único
        String numeroInscripcion = String.format("%04d", contadorInscripcion++);
        
        // Crear el nuevo alumno
        Alumno nuevoAlumno = new Alumno(
                nombre,
                edad,
                direccion,
                historialAcademico,
                numeroMaterias,
                numeroInscripcion,
                indicadorEscolar
        );

        // Agregar el alumno a la lista
        listaAlumnos.add(nuevoAlumno);
        System.out.println("Alumno creado con éxito: " + nuevoAlumno.getNombreCompleto());
    }
    
    public void exportarCSV(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            // Escribir encabezados del archivo CSV
            writer.write("Nombre,Edad,Dirección,Número de Materias,Historial Académico,Número de Inscripción,Indicador Escolar\n");

            // Escribir la información de cada alumno
            for (Alumno alumno : listaAlumnos) {
                String historial = String.join(" | ", alumno.getHistorialAcademico());
                writer.write(String.format("%s,%d,%s,%d,%s,%s,%.2f\n",
                        alumno.getNombreCompleto(),
                        alumno.getEdad(),
                        alumno.getDireccion(),
                        alumno.getNumeroMaterias(),
                        historial,
                        alumno.getNumeroInscripcion(),
                        alumno.getIndicadorEscolar()
                ));
            }
            System.out.println("Datos exportados exitosamente al archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al exportar datos a CSV: " + e.getMessage());
        }
    }
}
