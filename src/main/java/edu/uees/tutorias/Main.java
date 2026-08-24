package edu.uees.tutorias;

import edu.uees.tutorias.domain.Reserva;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("  SISTEMA DE GESTION DE TUTORIAS (UEES)  ");
        System.out.println("==========================================");

        // 1. Probar instanciación de Reserva
        Reserva reserva = new Reserva("RES-001", "Asesoria en Diseno OO");
        System.out.println("\n[+] Reserva creada exitosamente.");
        System.out.println("    - ID: " + reserva.getId());
        System.out.println("    - Estado inicial: " + reserva.getEstado());

        // 2. Probar cambio de estados de la Reserva
        reserva.confirmar();
        System.out.println("\n[+] Confirmando reserva...");
        System.out.println("    - Estado actual: " + reserva.getEstado());

        // 3. Confirmación de compilación limpia
        System.out.println("\n==========================================");
        System.out.println("   EL PROYECTO COMPILO  ");
        System.out.println("==========================================");
    }
}