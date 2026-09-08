package edu.uees.tutorias;

import java.time.LocalDate;
import java.time.LocalTime;

import edu.uees.tutorias.domain.Docente;
import edu.uees.tutorias.domain.Estudiante;
import edu.uees.tutorias.domain.HorarioTutoria;
import edu.uees.tutorias.domain.Materia;
import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.patrones.builder.ReservaBuilder;
import edu.uees.tutorias.patrones.observer.EmailReservaObserver;
import edu.uees.tutorias.patrones.observer.LogReservaObserver;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   SISTEMA DE GESTION DE TUTORIAS (UEES)  ");
        System.out.println("==========================================");

        // 1. Instanciar entidades del Dominio
        Estudiante estudiante = new Estudiante("S001", "Miriam Medina", "mmedina@uees.edu.ec", "0999999999", "Sistemas", 5, "MAT-2026");
        Docente docente = new Docente("D001", "Carlos Andrade", "candrade@uees.edu.ec", "0988888888", "Ingenieria", "Software");
        Materia materia = new Materia("MAT-01", "Diseño de Software", 4);
        HorarioTutoria horario = new HorarioTutoria("H001", LocalDate.now(), LocalTime.of(10, 0), LocalTime.of(11, 0), 3);

        // 2. Crear Reserva mediante el Patrón Builder
        Reserva reserva = new ReservaBuilder("RES-001", estudiante, docente, materia, horario)
                .modalidad("Virtual")
                .duracionMinutos(60)
                .requiereGrabacion(true)
                .observaciones("Asesoria en Diseno OO")
                .prioridad("Alta")
                .build();

        System.out.println("\n[+] Reserva creada con exito: " + reserva.getId());
        System.out.println("    - Estado inicial: " + reserva.getEstado());

        // 3. REGISTRAR LOS OBSERVADORES (OBLIGATORIO ANTES DE CAMBIAR DE ESTADO)
        System.out.println("\n[+] Registrando Observadores...");
        reserva.agregarObservador(new EmailReservaObserver());
        reserva.agregarObservador(new LogReservaObserver());

        // 4. CAMBIAR DE ESTADO (AHORA SÍ DISPARARÁ LAS NOTIFICACIONES)
        System.out.println("\n[+] Cambiando estado a CONFIRMADA:");
        reserva.confirmar();

        System.out.println("\n[+] Cambiando estado a CANCELADA:");
        reserva.cancelar();

        System.out.println("\n==========================================");
        System.out.println("     PRUEBA PATRON OBSERVER EXITOSA       ");
        System.out.println("==========================================");
    }
}