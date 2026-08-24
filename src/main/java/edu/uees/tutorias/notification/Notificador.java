package edu.uees.tutorias.notification;

import edu.uees.tutorias.domain.Usuario;

public interface Notificador {
    void enviarMensaje(Usuario destinatario, String mensaje);
}