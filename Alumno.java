/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.List;
import java.util.Objects;

public class Alumno {
    private String nombreCompleto;
    private int edad;
    private String direccion;
    private List<String> historialAcademico;
    private int numeroMaterias;
    private String numeroInscripcion;
    private double indicadorEscolar;

    // Constructor
    public Alumno(String nombreCompleto, int edad, String direccion, 
                  List<String> historialAcademico, int numeroMaterias, 
                  String numeroInscripcion, double indicadorEscolar) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.direccion = direccion;
        this.historialAcademico = historialAcademico;
        this.numeroMaterias = numeroMaterias;
        this.numeroInscripcion = numeroInscripcion;
        this.indicadorEscolar = indicadorEscolar;
    }

    // Getters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<String> getHistorialAcademico() {
        return historialAcademico;
    }

    public int getNumeroMaterias() {
        return numeroMaterias;
    }

    public String getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public double getIndicadorEscolar() {
        return indicadorEscolar;
    }

    // Setters
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setHistorialAcademico(List<String> historialAcademico) {
        this.historialAcademico = historialAcademico;
    }

    public void setNumeroMaterias(int numeroMaterias) {
        this.numeroMaterias = numeroMaterias;
    }

    public void setIndicadorEscolar(double indicadorEscolar) {
        this.indicadorEscolar = indicadorEscolar;
    }

    // Método para actualizar el alumno
    public void actualizarAlumno(Alumno nuevoAlumno) {
        this.nombreCompleto = nuevoAlumno.getNombreCompleto();
        this.edad = nuevoAlumno.getEdad();
        this.direccion = nuevoAlumno.getDireccion();
        this.historialAcademico = nuevoAlumno.getHistorialAcademico();
        this.numeroMaterias = nuevoAlumno.getNumeroMaterias();
        this.indicadorEscolar = nuevoAlumno.getIndicadorEscolar();
    }

    // Sobrescribir equals() y hashCode() para comparación por número de inscripción
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alumno alumno = (Alumno) obj;
        return Objects.equals(numeroInscripcion, alumno.numeroInscripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroInscripcion);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto +
               "\nEdad: " + edad +
               "\nDirección: " + direccion +
               "\nNúmero de Materias: " + numeroMaterias +
               "\nIndicador Escolar: " + indicadorEscolar +
               "\nNúmero de Inscripción: " + numeroInscripcion;
    }
}

