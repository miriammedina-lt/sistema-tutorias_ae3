package edu.uees.tutorias.patrones.builder;

public class Reserva {
    private final String estudiante;
    private final String docente;
    private final String materia;
    private final String horario;
    private final String modalidad;
    private final int duracionMinutos;
    private final boolean requiereGrabacion;
    private final String observaciones;
    private final String prioridad;

    protected Reserva(ReservaBuilder builder) {
        this.estudiante = builder.estudiante;
        this.docente = builder.docente;
        this.materia = builder.materia;
        this.horario = builder.horario;
        this.modalidad = builder.modalidad;
        this.duracionMinutos = builder.duracionMinutos;
        this.requiereGrabacion = builder.requiereGrabacion;
        this.observaciones = builder.observaciones;
        this.prioridad = builder.prioridad;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "estudiante='" + estudiante + '\'' +
                ", docente='" + docente + '\'' +
                ", materia='" + materia + '\'' +
                ", horario='" + horario + '\'' +
                ", modalidad='" + modalidad + '\'' +
                ", duracionMinutos=" + duracionMinutos +
                ", requiereGrabacion=" + requiereGrabacion +
                ", observaciones='" + observaciones + '\'' +
                ", prioridad='" + prioridad + '\'' +
                '}';
    }
}