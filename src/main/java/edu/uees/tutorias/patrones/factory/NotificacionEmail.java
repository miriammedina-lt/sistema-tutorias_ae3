package edu.uees.tutorias.patrones.factory;

public class NotificacionEmail implements Notificacion {
    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("[EMAIL enviado a " + destino + "]: " + mensaje);
    }
}