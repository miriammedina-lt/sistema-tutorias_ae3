package edu.uees.tutorias.patrones.factory;

public class WhatsAppNotificadorFactory extends NotificadorFactory {
    @Override
    public Notificacion crearNotificacion() {
        return new NotificacionWhatsApp();
    }
}