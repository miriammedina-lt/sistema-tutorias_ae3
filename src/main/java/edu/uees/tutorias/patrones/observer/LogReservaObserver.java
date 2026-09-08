package edu.uees.tutorias.patrones.observer;

public class LogReservaObserver implements ReservaObserver {
    @Override
    public void notificar(String reservaId, String nuevoEstado) {
        System.out.println("[OBSERVER - LOG] Registrando en bitácora de auditoría: Reserva " 
            + reservaId + " -> " + nuevoEstado);
    }
}