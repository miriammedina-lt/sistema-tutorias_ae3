package edu.uees.tutorias.patrones.factory;

public class NotificacionTeams implements Notificacion {
    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("[TEAMS enviado a " + destino + "]: " + mensaje);
    }
}