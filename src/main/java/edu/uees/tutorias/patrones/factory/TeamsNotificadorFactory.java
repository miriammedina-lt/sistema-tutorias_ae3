package edu.uees.tutorias.patrones.factory;

public class TeamsNotificadorFactory extends NotificadorFactory {
    @Override
    public Notificacion crearNotificacion() {
        return new NotificacionTeams();
    }
}