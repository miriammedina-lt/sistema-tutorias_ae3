package edu.uees.tutorias.domain;

public class Estudiante extends Usuario {
    private String carrera;
    private int semestre;
    private String matricula;

    public Estudiante(String id, String nombre, String email, String cedula, String carrera, int semestre, String matricula) {
        super(id, nombre, email, cedula);
        this.carrera = carrera;
        this.semestre = semestre;
        this.matricula = matricula;
    }

    public void solicitarTutoria() { }
    public void cancelarReserva() { }
}