package edu.uees.tutorias.domain;

import java.time.LocalDateTime;

import edu.uees.tutorias.patrones.builder.ReservaBuilder;

public class Reserva {
    private String id;
    private LocalDateTime fechaSolicitud;
    private String estado;
    private String motivo;

    private final Estudiante estudiante;
    private final Docente docente;
    private final Materia materia;
    private final HorarioTutoria horario;
    private final String modalidad;
    private final int duracionMinutos;
    private final boolean requiereGrabacion;
    private final String observaciones;
    private final String prioridad;

    public Reserva(ReservaBuilder builder) {
        this.id = builder.getId();
        this.fechaSolicitud = LocalDateTime.now();
        this.estado = "PENDIENTE";
        this.motivo = builder.getObservaciones();
        this.estudiante = builder.getEstudiante();
        this.docente = builder.getDocente();
        this.materia = builder.getMateria();
        this.horario = builder.getHorario();
        this.modalidad = builder.getModalidad();
        this.duracionMinutos = builder.getDuracionMinutos();
        this.requiereGrabacion = builder.isRequiereGrabacion();
        this.observaciones = builder.getObservaciones();
        this.prioridad = builder.getPrioridad();
    }

    public void confirmar() {
        this.estado = "CONFIRMADA";
    }

    public void cancelar() {
        if (!"COMPLETADA".equals(this.estado)) {
            this.estado = "CANCELADA";
        }
    }

    public void reprogramar() { }

    public String getId() { return id; }
    public LocalDateTime getFechaSolicitud() { return fechaSolicitud; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getMotivo() { return motivo; }
    public Estudiante getEstudiante() { return estudiante; }
    public Docente getDocente() { return docente; }
    public Materia getMateria() { return materia; }
    public HorarioTutoria getHorario() { return horario; }
    public String getModalidad() { return modalidad; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public boolean isRequiereGrabacion() { return requiereGrabacion; }
    public String getObservaciones() { return observaciones; }
    public String getPrioridad() { return prioridad; }

    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", estado='" + estado + '\'' +
                ", estudiante=" + (estudiante != null ? estudiante.getNombre() : "N/A") +
                ", docente=" + (docente != null ? docente.getNombre() : "N/A") +
                ", materia=" + (materia != null ? materia.getNombre() : "N/A") +
                ", modalidad='" + modalidad + '\'' +
                '}';
    }
}