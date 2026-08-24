package edu.uees.tutorias.domain;

public abstract class Usuario {
    protected String id;
    protected String nombre;
    protected String email;
    protected String cedula;

    public Usuario(String id, String nombre, String email, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.cedula = cedula;
    }

    public boolean validarEmail() {
        return email != null && email.contains("@");
    }

    public boolean autenticar() {
        return true;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
}
