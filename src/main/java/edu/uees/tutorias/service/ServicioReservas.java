package edu.uees.tutorias.service;

import edu.uees.tutorias.domain.Estudiante;
import edu.uees.tutorias.domain.HorarioTutoria;
import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.notification.Notificador;

public class ServicioReservas {
    private final RepositorioReservas repositorio;
    private final Notificador notificador;

    public ServicioReservas(RepositorioReservas repositorio, Notificador notificador) {
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    public void crearReserva(Estudiante estudiante, HorarioTutoria horario, String motivo) {
        if (horario.estaDisponible()) {
            horario.reservarCupo();
            Reserva nuevaReserva = new Reserva("RES-" + System.currentTimeMillis(), motivo);
            repositorio.guardar(nuevaReserva);
            notificador.enviarMensaje(estudiante, "Tu reserva de tutoría ha sido registrada.");
        }
    }
}