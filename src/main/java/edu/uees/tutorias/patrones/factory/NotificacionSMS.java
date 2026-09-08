package edu.uees.tutorias.patrones.factory;

public class NotificacionSMS implements Notificacion {
    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("[SMS enviado a " + destino + "]: " + mensaje);
    }
}