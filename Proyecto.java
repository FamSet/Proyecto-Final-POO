
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Proyecto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        // Autenticación al inicio
        System.out.println("=== Sistema de Servicios Escolares ===");
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        // Verificar autenticación
        if (!login.autenticar(nombreUsuario, contraseña)) {
            System.out.println("Autenticación fallida. Acceso denegado.");
            return; // Salir del programa si la autenticación falla
        }

        System.out.println("Autenticación exitosa. Bienvenido al sistema.");

        // Generar automáticamente 1000 alumnos al inicio
        List<Alumno> listaAlumnos = generarAlumnos();

        // Inicializar el módulo CRUD con la lista generada
        AlumnoCRUD alumnoCRUD = new AlumnoCRUD(listaAlumnos);
        boolean continuar = true;

        // Menú CRUD interactivo
        while (continuar) {
            System.out.println("\n--- Menú CRUD ---");
            System.out.println("1. Crear Alumno");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Buscar Alumno");
            System.out.println("4. Actualizar Alumno");
            System.out.println("5. Eliminar Alumno");
            System.out.println("6. Exportar a CSV");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    alumnoCRUD.crearAlumno();
                    break;
                case 2:
                    alumnoCRUD.listarAlumnos();
                    break;
                case 3:
                    System.out.print("Ingrese el número de inscripción: ");
                    String numeroBusqueda = scanner.nextLine();
                    Alumno alumnoBuscado = alumnoCRUD.obtenerAlumno(numeroBusqueda);
                    if (alumnoBuscado != null) {
                        System.out.println(alumnoBuscado);
                    } else {
                        System.out.println("Alumno no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el número de inscripción a actualizar: ");
                    String numeroActualizar = scanner.nextLine();
                    alumnoCRUD.actualizarAlumno(numeroActualizar);
                    break;
                case 5:
                    System.out.print("Ingrese el número de inscripción a eliminar: ");
                    String numeroEliminar = scanner.nextLine();
                    alumnoCRUD.eliminarAlumno(numeroEliminar);
                    break;
                case 6:
                    System.out.print("Ingrese el nombre del archivo CSV (por ejemplo, alumnos.csv): ");
                    String nombreArchivo = scanner.nextLine();
                    alumnoCRUD.exportarCSV(nombreArchivo);
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    // Método para generar 1000 alumnos automáticamente
    private static List<Alumno> generarAlumnos() {
        List<Alumno> listaAlumnos = new ArrayList<>();
        try {
            GeneradorNombres generadorNombres = new GeneradorNombres("nombres_apellidos.csv");
            GeneradorDirecciones generadorDirecciones = new GeneradorDirecciones("direcciones.txt");
            GeneradorHistorial generadorHistorial = new GeneradorHistorial("materias.txt");
            GeneradorEdad generadorEdad = new GeneradorEdad();
            GeneradorIndicador generadorIndicador = new GeneradorIndicador();

            for (int i = 0; i < 1000; i++) {
                String nombreCompleto = generadorNombres.generarNombreCompleto();
                String direccion = generadorDirecciones.obtenerDireccionAleatoria();
                List<String> historialAcademico = generadorHistorial.generarHistorial();
                int numeroMaterias = historialAcademico.size();
                int edad = generadorEdad.generarEdad(numeroMaterias);
                double indicadorEscolar = generadorIndicador.calcularIndicador(numeroMaterias);
                String numeroInscripcion = String.format("%04d", i + 1);

                Alumno alumno = new Alumno(
                        nombreCompleto, edad, direccion, historialAcademico,
                        numeroMaterias, numeroInscripcion, indicadorEscolar
                );

                listaAlumnos.add(alumno);
            }
        } catch (IOException e) {
            System.err.println("Error al generar alumnos: " + e.getMessage());
        }
        return listaAlumnos;
    }
}
