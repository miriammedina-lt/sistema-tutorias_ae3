package edu.uees.tutorias.patrones.factory;

public class EmailNotificadorFactory extends NotificadorFactory {
    @Override
    public Notificacion crearNotificacion() {
        return new NotificacionEmail();
    }
}