package edu.uees.tutorias.patrones.strategy;

public class CancelacionEstandarStrategy implements EstrategiaCancelacion {
    @Override
    public boolean puedeCancelar(int horasAnticipacion) {
        // Requiere al menos 24 horas de anticipación
        return horasAnticipacion >= 24;
    }
}