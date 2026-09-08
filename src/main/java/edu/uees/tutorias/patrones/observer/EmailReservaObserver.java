package edu.uees.tutorias.patrones.observer;

public class EmailReservaObserver implements ReservaObserver {
    @Override
    public void notificar(String reservaId, String nuevoEstado) {
        System.out.println("[OBSERVER - EMAIL] Enviando correo al estudiante: La reserva " 
            + reservaId + " ha cambiado a estado '" + nuevoEstado + "'.");
    }
}