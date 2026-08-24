# Sistema de Gestión de Tutorías Académicas (UEES)

## Este proyecto implementa el diseño orientado a objetos para la gestión automatizada de tutorías académicas, permitiendo la interacción entre estudiantes, docentes y el módulo de reservas.

## Tecnologías Utilizadas

- **Lenguaje:** Java 17
- **Gestor de Dependencias:** Apache Maven
- **Modelado UML:** PlantUML

---

## Estructura del Proyecto

```text
sistema-tutorias/
├── docs/
│   ├── modelo-clases.puml      # Código fuente de PlantUML
│   └── modelo-clases.png       # Diagrama de clases exportado
├── src/
│   └── main/
│       └── java/
│           └── edu/
│               └── uees/
│                   └── tutorias/
│                       ├── Main.java
│                       ├── domain/       # Clases de entidad (Usuario, Reserva, etc.)
│                       ├── service/      # Interfaces y lógica de negocio
│                       └── notification/ # Canal de notificaciones
└── pom.xml
```

## Nota de Entorno de Desarrollo

_Profesor como aclaración de mi actividad, el desarrollo y subida inicial del proyecto se realizaron desde una computadora prestada debido a mantenimiento de mi equipo personal. Las contribuciones registradas bajo el usuario Jonnathan1288 corresponden a la configuración previa del entorno en dicho equipo._
