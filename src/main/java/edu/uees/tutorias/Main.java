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
import edu.uees.tutorias.patrones.strategy.CancelacionEstandarStrategy;
import edu.uees.tutorias.patrones.strategy.CancelacionPrioritariaStrategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   SISTEMA DE GESTION DE TUTORIAS (UEES)  ");
        System.out.println("==========================================");

        // 1. Instanciar entidades del Dominio
        Estudiante estudiante = new Estudiante("S001", "Miriam Medina", "miriam.medina@uees.edu.ec", "0999999999", "Ing. Ciencias de la Computación", 5, "INGCC-2026");
        Docente docente = new Docente("D001", "Ing. Jaime Paúl Sayago Heredia ", "jaime.sayago@uees.edu.ec", "0988888888", "Ingenieria", "Software");
        Materia materia = new Materia("UCOM0310", "Diseño de Software", 3);
        HorarioTutoria horario = new HorarioTutoria("H001", LocalDate.now(), LocalTime.of(10, 0), LocalTime.of(11, 0), 3);

        // 2. Crear Reserva mediante el Patrón Builder
        Reserva reserva = new ReservaBuilder("RES-001", estudiante, docente, materia, horario)
                .modalidad("Virtual")
                .duracionMinutos(60)
                .requiereGrabacion(true)
                .observaciones("Asesoria en Proyecto Integrador")
                .prioridad("Alta")
                .build();


        // 3. REGISTRAR LOS OBSERVADORES (OBLIGATORIO ANTES DE CAMBIAR DE ESTADO)
        reserva.agregarObservador(new EmailReservaObserver());
        reserva.agregarObservador(new LogReservaObserver());

        
        // 4. Probar Strategy
        System.out.println("\n--- PROBANDO PATRÓN STRATEGY ---");
        
        System.out.println("\n[Intento 1] Cancelar con 5 horas de anticipación usando Estrategia Estándar:");
        reserva.cancelarConEstrategia(5, new CancelacionEstandarStrategy()); // Debería rechazar (requiere 24h)

        System.out.println("\n[Intento 2] Cancelar con 5 horas de anticipación usando Estrategia Prioritaria:");
        reserva.cancelarConEstrategia(5, new CancelacionPrioritariaStrategy()); // Debería aprobar (requiere 2h)
    }
}