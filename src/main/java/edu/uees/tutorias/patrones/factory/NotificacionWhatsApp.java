package edu.uees.tutorias.patrones.factory;

public class NotificacionWhatsApp implements Notificacion {
    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("[WHATSAPP enviado a " + destino + "]: " + mensaje);
    }
}