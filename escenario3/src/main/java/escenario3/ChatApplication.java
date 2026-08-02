package escenario3;

/** Ejemplo de uso del patrón Mediator en el chat grupal. */
public final class ChatApplication {

    private ChatApplication() {
    }

    public static void main(String[] args) {
        ChatRoom sala = new ChatRoom();
        User ana = new User("Ana");
        User bruno = new User("Bruno");
        User carla = new User("Carla");

        sala.agregarUsuario(ana);
        sala.agregarUsuario(bruno);
        sala.agregarUsuario(carla);

        ana.enviar("¡Hola a todos!");
        bruno.enviar("Hola, Ana.");

        sala.eliminarUsuario(carla);
        ana.enviar("Carla ya salió de la sala.");
    }
}

