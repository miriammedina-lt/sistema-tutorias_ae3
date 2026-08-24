package edu.uees.tutorias.domain;

public class Docente extends Usuario {
    private String facultad;
    private String especialidad;

    public Docente(String id, String nombre, String email, String cedula, String facultad, String especialidad) {
        super(id, nombre, email, cedula);
        this.facultad = facultad;
        this.especialidad = especialidad;
    }

    public void publicarHorario() { }
    public void registrarAsistencia() { }
}