package edu.uees.tutorias.patrones.factory;

public class SMSNotificadorFactory extends NotificadorFactory {
    @Override
    public Notificacion crearNotificacion() {
        return new NotificacionSMS();
    }
}