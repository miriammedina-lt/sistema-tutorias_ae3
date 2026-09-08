package edu.uees.tutorias.domain;

public class Materia {
    private String codigo;
    private String nombre;
    private int creditos;

    public Materia(String codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    // --- AGREGAR GETTERS ---
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public boolean esImpartidaPor(Docente docente) {
        return true;
    }
}