package edu.uees.tutorias.notification;

import java.time.LocalDateTime;

import edu.uees.tutorias.domain.Usuario;

public class Notificacion {
    private String id;
    private Usuario destinatario;
    private String asunto;
    private String cuerpoMensaje;
    private LocalDateTime fechaEnvio;
    private String canal;

    public Notificacion(String id, Usuario destinatario, String asunto, String cuerpoMensaje, String canal) {
        this.id = id;
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.cuerpoMensaje = cuerpoMensaje;
        this.fechaEnvio = LocalDateTime.now();
        this.canal = canal;
    }
}
