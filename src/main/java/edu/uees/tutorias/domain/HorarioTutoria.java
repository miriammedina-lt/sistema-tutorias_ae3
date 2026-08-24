package edu.uees.tutorias.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class HorarioTutoria {
    private String id;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int cupoLibre;

    public HorarioTutoria(String id, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, int cupoLibre) {
        this.id = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.cupoLibre = cupoLibre;
    }

    public boolean reservarCupo() {
        if (this.cupoLibre > 0) {
            this.cupoLibre--;
            return true;
        }
        return false;
    }

    public void liberarCupo() {
        this.cupoLibre++;
    }

    public boolean estaDisponible() {
        return this.cupoLibre > 0;
    }
}