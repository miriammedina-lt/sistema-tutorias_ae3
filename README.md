# Sistema de Gestión de Tutorías Académicas (UEES)

Este proyecto implementa el diseño orientado a objetos para la gestión automatizada de tutorías académicas, permitiendo la interacción entre estudiantes, docentes y el módulo de reservas.

---

## Decisiones Principales de Diseño

Para garantizar un código mantenible, extensible y alineado a los principios de la Programación Orientada a Objetos (POO), se tomaron las siguientes decisiones de modelado basadas en la estructura del proyecto:

### 1. Descomposición y Responsabilidades por Clase

- **Paquete `domain` (Entidades del Sistema):**
    - **`Usuario` (Clase Base):** Contiene los atributos comunes (`id`, `nombre`, `email`) compartidos por `Estudiante` y `Docente`. Se creó para aplicar **herencia** y evitar duplicación de código.
    - **`Estudiante` / `Docente`:** Especializan a `Usuario`. `Docente` gestiona sus horarios de atención, mientras que `Estudiante` solicita las sesiones.
    - **`Materia`:** Representa la asignatura académica sobre la cual se dictan las tutorías.
    - **`HorarioTutoria`:** Encapsula la disponibilidad de tiempo ofrecida por el docente.
    - **`Reserva`:** Modela el vínculo de asociación entre un `Estudiante` y un `HorarioTutoria`. Mantiene el estado de la cita.
    - **`ComprobanteAsistencia`:** Genera la evidencia documental que confirma que la tutoría fue realizada con éxito.

- **Paquete `service` (Lógica de Negocio y Persistencia):**
    - **`ServicioReservas`:** Aplica el **Principio de Responsabilidad Única (SRP)**. Separa la lógica de agendamiento y validación de disponibilidad para no recargar las clases de entidad (`Reserva` o `Estudiante`).
    - **`RepositorioReservas`:** Encapsula el acceso y almacenamiento de las reservas, aislando la lógica de datos del resto de la aplicación.

- **Paquete `notification` (Módulo de Mensajería):**
    - **`Notification`:** Define el objeto o estructura del mensaje que se enviará a los usuarios.
    - **`Notificador`:** Se encarga exclusivamente del envío de confirmaciones y alertas a estudiantes y docentes, desligando la mensajería del flujo central de reservas.

---

## Tecnologías Utilizadas

- **Lenguaje:** Java 17
- **Gestor de Dependencias:** Apache Maven
- **Modelado UML:** PlantUML

---

## Estructura del Proyecto

```text
sistema-tutorias/
├── docs/
│   ├── modelo-clases.puml        # Código fuente de PlantUML
│   └── modelo-clases.png         # Diagrama de clases exportado
├── src/
│   └── main/
│       └── java/
│           └── edu/
│               └── uees/
│                   └── tutorias/
│                       ├── Main.java
│                       ├── domain/        # Clases de entidad (Usuario, Reserva, Materia, etc.)
│                       ├── notification/  # Gestión de notificaciones (Notificador, Notification)
│                       └── service/       # Lógica de negocio (ServicioReservas, RepositorioReservas)
└── pom.xml

## Nota de Entorno de Desarrollo
* Profesor, el desarrollo y subida inicial del proyecto se realizaron en una computadora que me prestaron debido a mantenimiento de mi equipo personal. Las contribuciones registradas bajo el usuario Jonnathan1288 corresponden a la configuración previa del entorno en dicho equipo.*
```
