package edu.uees.tutorias.patrones.builder;

public class ReservaBuilder {
    protected final String estudiante;
    protected final String docente;
    protected final String materia;
    protected final String horario;

    protected String modalidad = "Presencial";
    protected int duracionMinutos = 60;
    protected boolean requiereGrabacion = false;
    protected String observaciones = "Sin observaciones";
    protected String prioridad = "Normal"; // Valor por defecto

    public ReservaBuilder(String estudiante, String docente, String materia, String horario) {
        this.estudiante = estudiante;
        this.docente = docente;
        this.materia = materia;
        this.horario = horario;
    }

    public ReservaBuilder modalidad(String modalidad) {
        this.modalidad = modalidad;
        return this;
    }

    public ReservaBuilder duracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
        return this;
    }

    public ReservaBuilder requiereGrabacion(boolean requiereGrabacion) {
        this.requiereGrabacion = requiereGrabacion;
        return this;
    }

    public ReservaBuilder observaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }

    public ReservaBuilder prioridad(String prioridad) {
        this.prioridad = prioridad;
        return this;
    }

    // validaciones
    public Reserva build() {
        if (estudiante == null || docente == null || materia == null || horario == null) {
            throw new IllegalArgumentException("Los campos obligatorios no pueden ser nulos");
        }
        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor a 0 minutos");
        }
        return new Reserva(this);
    }
}