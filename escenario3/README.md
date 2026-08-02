# Escenario 3 — Chat grupal

## Patrón seleccionado

- **Categoría:** patrón de comportamiento.
- **Patrón:** Mediator (Mediador).

`ChatRoom` centraliza el registro, retiro y comunicación de los usuarios. Cada
`User` solo conserva una referencia al contrato `ChatMediator`, por lo que no
conoce a los demás participantes. Agregar o eliminar usuarios no exige cambiar
ningún otro usuario.

## Participantes

- `ChatMediator`: interfaz del mediador.
- `ChatRoom`: mediador concreto que administra y comunica a los participantes.
- `User`: colega que envía y recibe mensajes mediante el mediador.
- `Message`: valor inmutable que almacena un mensaje recibido.
- `ChatApplication`: demostración ejecutable.

## Compilar y ejecutar

Desde la carpeta `escenario3`:

```bash
mkdir -p out
javac -d out src/main/java/escenario3/*.java src/test/java/escenario3/*.java
java -cp out escenario3.ChatApplication
java -cp out escenario3.ChatRoomTest
```

La implementación es compatible con Java 11 y no requiere dependencias
externas.
