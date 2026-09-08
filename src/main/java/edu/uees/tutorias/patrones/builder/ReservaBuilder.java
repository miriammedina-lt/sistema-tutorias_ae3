package edu.uees.tutorias.patrones.builder;

import edu.uees.tutorias.domain.Docente;
import edu.uees.tutorias.domain.Estudiante;
import edu.uees.tutorias.domain.HorarioTutoria;
import edu.uees.tutorias.domain.Materia;
import edu.uees.tutorias.domain.Reserva;

public class ReservaBuilder {
    private String id;
    private Estudiante estudiante;
    private Docente docente;
    private Materia materia;
    private HorarioTutoria horario;
    private String modalidad = "Presencial";
    private int duracionMinutos = 60;
    private boolean requiereGrabacion = false;
    private String observaciones = "Sin observaciones";
    private String prioridad = "Normal";

    public ReservaBuilder(String id, Estudiante estudiante, Docente docente, Materia materia, HorarioTutoria horario) {
        this.id = id;
        this.estudiante = estudiante;
        this.docente = docente;
        this.materia = materia;
        this.horario = horario;
    }

    public ReservaBuilder modalidad(String modalidad) {
        this.modalidad = modalidad;
        return this;
    }

    public ReservaBuilder duracionMinutos(int duracion) {
        this.duracionMinutos = duracion;
        return this;
    }

    public ReservaBuilder requiereGrabacion(boolean requiere) {
        this.requiereGrabacion = requiere;
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

    // Getters utilizados por el constructor de Reserva
    public String getId() { return id; }
    public Estudiante getEstudiante() { return estudiante; }
    public Docente getDocente() { return docente; }
    public Materia getMateria() { return materia; }
    public HorarioTutoria getHorario() { return horario; }
    public String getModalidad() { return modalidad; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public boolean isRequiereGrabacion() { return requiereGrabacion; }
    public String getObservaciones() { return observaciones; }
    public String getPrioridad() { return prioridad; }
}