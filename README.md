# Sistema de Gestión de Tutorías Académicas (UEES)

Este proyecto integra y consolida la arquitectura orientada a objetos para el sistema de gestión de tutorías (Ae1, Ae2 y Ae3). Demuestra el uso de buenas prácticas de modelado, diseño limpio y la implementación de cuatro patrones de diseño fundamentales: **Abstract Factory**, **Builder**, **Observer** y **Strategy**.

---

## Decisiones Principales de Diseño

### 1. Modelo de Dominio Base (Ae1)

- **`Usuario` (Clase Base):** Encapsula atributos comunes (`id`, `nombre`, `email`, `cedula`) mediante herencia para `Estudiante` y `Docente`.
- **`Estudiante` / `Docente`:** Especializan a `Usuario` para representar a los actores clave de las tutorías.
- **`Materia` & `HorarioTutoria`:** Definen la asignatura académica, las ventanas de atención y la gestión de cupos libres.
- **`Reserva`:** Entidad central del sistema que coordina la relación entre estudiante, docente, materia y horario.
- **`ComprobanteAsistencia`:** Genera la evidencia documental tras realizar la sesión.

### 2. Patrones de Diseño Implementados (Ae2 + Ae3)

| Patrón             | Paquete             | Propósito y Solución                                                                                                                                                                           |
| :----------------- | :------------------ | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Builder**        | `patrones.builder`  | Permite la construcción paso a paso de objetos `Reserva` mediante Fluent API, separando parámetros requeridos de opcionales (modalidad, grabación, prioridad, etc.).                           |
| **Factory Method** | `patrones.factory`  | Desacopla la creación de notificadores (Email, SMS, Teams, WhatsApp) eliminando la necesidad de estructuras condicionales `if-else` o `switch`.                                                |
| **Observer**       | `patrones.observer` | Notifica automáticamente a los observadores registrados (`EmailReservaObserver`, `LogReservaObserver`) ante cambios de estado en la `Reserva` (`CONFIRMADA`, `CANCELADA`).                     |
| **Strategy**       | `patrones.strategy` | Evalúa dinámicamente las políticas de cancelación de tutorías (`CancelacionEstandarStrategy` vs `CancelacionPrioritariaStrategy`), independizando las reglas de negocio del dominio principal. |

---

## Estructura del Repositorio

```text
sistema-tutorias/
├── docs/
│   ├── builder.puml
│   ├── factory-method.png
│   ├── factory-method.puml
│   ├── modelo-clases.png
│   └── modelo-clases.puml
├── src/
│   └── main/
│       └── java/
│           └── edu/uees/tutorias/
│               ├── Main.java
│               ├── domain/
│               │   ├── ComprobanteAsistencia.java
│               │   ├── Docente.java
│               │   ├── Estudiante.java
│               │   ├── HorarioTutoria.java
│               │   ├── Materia.java
│               │   ├── Reserva.java
│               │   └── Usuario.java
│               ├── notification/
│               │   ├── Notificacion.java
│               │   └── Notificador.java
│               ├── patrones/
│               │   ├── builder/
│               │   │   └── ReservaBuilder.java
│               │   ├── factory/
│               │   │   ├── EmailNotificadorFactory.java
│               │   │   ├── Notificacion.java
│               │   │   ├── NotificacionEmail.java
│               │   │   ├── NotificacionSMS.java
│               │   │   ├── NotificacionTeams.java
│               │   │   ├── NotificacionWhatsApp.java
│               │   │   ├── NotificadorFactory.java
│               │   │   ├── SMSNotificadorFactory.java
│               │   │   ├── TeamsNotificadorFactory.java
│               │   │   └── WhatsAppNotificadorFactory.java
│               │   ├── observer/
│               │   │   ├── EmailReservaObserver.java
│               │   │   ├── LogReservaObserver.java
│               │   │   └── ReservaObserver.java
│               │   └── strategy/
│               │       ├── CancelacionEstandarStrategy.java
│               │       ├── CancelacionPrioritariaStrategy.java
│               │       └── EstrategiaCancelacion.java
│               └── service/
│                   ├── RepositorioReservas.java
│                   └── ServicioReservas.java
└── pom.xml

```
