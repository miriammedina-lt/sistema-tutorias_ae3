package edu.uees.tutorias.patrones.strategy;

public class CancelacionPrioritariaStrategy implements EstrategiaCancelacion {
    @Override
    public boolean puedeCancelar(int horasAnticipacion) {
        // Permite cancelar con hasta 2 horas de anticipación
        return horasAnticipacion >= 2;
    }
}