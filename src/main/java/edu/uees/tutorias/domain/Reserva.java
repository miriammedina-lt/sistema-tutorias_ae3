package edu.uees.tutorias.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.uees.tutorias.patrones.builder.ReservaBuilder;
import edu.uees.tutorias.patrones.observer.ReservaObserver;

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

    // --- LISTA DE OBSERVADORES (Ae3) ---
    private final List<ReservaObserver> observadores = new ArrayList<>();

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

    // --- METODOS DEL PATRON OBSERVER ---
    public void agregarObservador(ReservaObserver obs) {
        this.observadores.add(obs);
    }

    public void eliminarObservador(ReservaObserver obs) {
        this.observadores.remove(obs);
    }

    private void notificarObservadores() {
        for (ReservaObserver obs : observadores) {
            obs.notificar(this.id, this.estado);
        }
    }

    // --- METODOS AE1 ACTUALIZADOS ---
    public void confirmar() {
        this.estado = "CONFIRMADA";
        notificarObservadores(); 
    }

    public void cancelar() {
        if (!"COMPLETADA".equals(this.estado)) {
            this.estado = "CANCELADA";
            notificarObservadores(); 
        }
    }

    public void reprogramar() { }

    // --- Getters y Setters ---
    public String getId() { return id; }
    public LocalDateTime getFechaSolicitud() { return fechaSolicitud; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { 
        this.estado = estado; 
        notificarObservadores();
    }
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
}