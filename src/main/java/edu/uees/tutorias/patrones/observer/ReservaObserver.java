package edu.uees.tutorias.patrones.observer;

public interface ReservaObserver {
    void notificar(String reservaId, String nuevoEstado);
}