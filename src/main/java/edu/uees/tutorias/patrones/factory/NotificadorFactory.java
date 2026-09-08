package edu.uees.tutorias.patrones.factory;

public abstract class NotificadorFactory {
    public abstract Notificacion crearNotificacion();

    public void notificarUsuario(String destino, String mensaje) {
        Notificacion notificacion = crearNotificacion();
        notificacion.enviar(destino, mensaje);
    }
}