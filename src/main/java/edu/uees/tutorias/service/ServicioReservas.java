package edu.uees.tutorias.service;

import edu.uees.tutorias.domain.Docente;
import edu.uees.tutorias.domain.Estudiante;
import edu.uees.tutorias.domain.HorarioTutoria;
import edu.uees.tutorias.domain.Materia;
import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.notification.Notificador;
import edu.uees.tutorias.patrones.builder.ReservaBuilder;

public class ServicioReservas {
    private final RepositorioReservas repositorio;
    private final Notificador notificador;

    public ServicioReservas(RepositorioReservas repositorio, Notificador notificador) {
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    // Sobrecarga usando el Builder directamente (Recomendado para Ae2)
    public Reserva crearReserva(ReservaBuilder builder) {
        Reserva reserva = builder.build();
        
        if (reserva.getHorario() != null && reserva.getHorario().estaDisponible()) {
            reserva.getHorario().reservarCupo();
            repositorio.guardar(reserva);
            
            if (notificador != null && reserva.getEstudiante() != null) {
                notificador.enviarMensaje(reserva.getEstudiante(), "Tu reserva de tutoría ha sido registrada.");
            }
        }
        return reserva;
    }

    // Método legacy adaptado para compatibilidad con parámetros sueltos
    public void crearReserva(Estudiante estudiante, Docente docente, Materia materia, HorarioTutoria horario, String motivo) {
        if (horario.estaDisponible()) {
            ReservaBuilder builder = new ReservaBuilder(
                "RES-" + System.currentTimeMillis(),
                estudiante,
                docente,
                materia,
                horario
            ).observaciones(motivo);

            crearReserva(builder);
        }
    }
}