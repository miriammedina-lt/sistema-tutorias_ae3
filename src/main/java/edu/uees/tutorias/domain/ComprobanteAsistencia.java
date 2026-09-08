package edu.uees.tutorias.domain;

import java.time.LocalDateTime;

public class ComprobanteAsistencia {
    private String id;
    private LocalDateTime fechaRealizacion;
    private String observaciones;
    private boolean asistio;

    public ComprobanteAsistencia(String id, String observaciones, boolean asistio) {
        this.id = id;
        this.fechaRealizacion = LocalDateTime.now();
        this.observaciones = observaciones;
        this.asistio = asistio;
    }

    public void completarRegistro() { }
    // --- GETTERS ---
    public String getId() { return id; }
    public LocalDateTime getFechaRealizacion() { return fechaRealizacion; }
    public String getObservaciones() { return observaciones; }
    public boolean isAsistio() { return asistio; }
}