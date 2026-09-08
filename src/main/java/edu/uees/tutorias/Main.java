package edu.uees.tutorias;

import java.time.LocalDate;
import java.time.LocalTime;

import edu.uees.tutorias.domain.Docente;
import edu.uees.tutorias.domain.Estudiante;
import edu.uees.tutorias.domain.HorarioTutoria;
import edu.uees.tutorias.domain.Materia;
import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.patrones.builder.ReservaBuilder;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   SISTEMA DE GESTION DE TUTORIAS (UEES)  ");
        System.out.println("==========================================");

        // 1. Instanciar entidades del Dominio (Ae1)
        Estudiante estudiante = new Estudiante("S001", "Miriam Medina", "mmedina@uees.edu.ec", "0999999999", "Sistemas", 5, "MAT-2026");
        Docente docente = new Docente("D001", "Carlos Andrade", "candrade@uees.edu.ec", "0988888888", "Ingenieria", "Software");
        Materia materia = new Materia("MAT-01", "Diseño de Software", 4);
        HorarioTutoria horario = new HorarioTutoria("H001", LocalDate.now(), LocalTime.of(10, 0), LocalTime.of(11, 0), 3);

        // 2. Probar creación de Reserva mediante el Patrón Builder (Ae2)
        Reserva reserva = new ReservaBuilder("RES-001", estudiante, docente, materia, horario)
                .modalidad("Virtual")
                .duracionMinutos(60)
                .requiereGrabacion(true)
                .observaciones("Asesoria en Diseno OO")
                .prioridad("Alta")
                .build();

        System.out.println("\n[+] Reserva creada exitosamente mediante Builder:");
        System.out.println("    - ID: " + reserva.getId());
        System.out.println("    - Estudiante: " + reserva.getEstudiante().getNombre());
        System.out.println("    - Docente: " + reserva.getDocente().getNombre());
        System.out.println("    - Materia: " + reserva.getMateria().getNombre());
        System.out.println("    - Estado inicial: " + reserva.getEstado());

        // 3. Probar cambio de estados de la Reserva (Ae1)
        reserva.confirmar();
        System.out.println("\n[+] Confirmando reserva...");
        System.out.println("    - Estado actual: " + reserva.getEstado());

        // 4. Confirmación de compilación e integración limpia
        System.out.println("\n==========================================");
        System.out.println("   CONSOLIDACION DE BASE (Ae1 + Ae2) OK   ");
        System.out.println("==========================================");
    }
}