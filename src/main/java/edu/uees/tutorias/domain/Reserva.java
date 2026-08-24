package edu.uees.tutorias.domain;

import java.time.LocalDateTime;

public class Reserva {
    private String id;
    private LocalDateTime fechaSolicitud;
    private String estado; // PENDIENTE, CONFIRMADA, CANCELADA, COMPLETADA
    private String motivo;

    public Reserva(String id, String motivo) {
        this.id = id;
        this.fechaSolicitud = LocalDateTime.now();
        this.estado = "PENDIENTE";
        this.motivo = motivo;
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
    
    public String getEstado() { 
        return estado; 
    }
    
    public String getId() {
    return this.id;
}
}