package escenario3;

/** Pruebas ejecutables sin librerías externas. */
public final class ChatRoomTest {

    private ChatRoomTest() {
    }

    public static void main(String[] args) {
        entregaMensajesExceptoAlRemitente();
        usuarioEliminadoDejaDeRecibirMensajes();
        usuarioPuedeCambiarDeSala();
        System.out.println("Pruebas completadas correctamente: 3/3");
    }

    private static void entregaMensajesExceptoAlRemitente() {
        ChatRoom sala = new ChatRoom();
        User ana = new User("Ana");
        User bruno = new User("Bruno");
        User carla = new User("Carla");
        sala.agregarUsuario(ana);
        sala.agregarUsuario(bruno);
        sala.agregarUsuario(carla);

        ana.enviar("Hola");

        verificar(ana.getMensajes().isEmpty(), "Ana no debe recibir su propio mensaje");
        verificar(bruno.getMensajes().size() == 1, "Bruno debe recibir el mensaje");
        verificar(carla.getMensajes().size() == 1, "Carla debe recibir el mensaje");
        verificar("Ana".equals(bruno.getMensajes().get(0).getRemitente()),
                "Debe conservarse el nombre del remitente");
    }

    private static void usuarioEliminadoDejaDeRecibirMensajes() {
        ChatRoom sala = new ChatRoom();
        User ana = new User("Ana");
        User bruno = new User("Bruno");
        sala.agregarUsuario(ana);
        sala.agregarUsuario(bruno);
        sala.eliminarUsuario(bruno);

        ana.enviar("¿Sigues ahí?");

        verificar(sala.cantidadUsuarios() == 1, "La sala debe tener un usuario");
        verificar(bruno.getMensajes().isEmpty(), "El usuario retirado no debe recibir mensajes");
        verificar(bruno.getSala() == null, "El usuario retirado no debe conservar la sala");
    }

    private static void usuarioPuedeCambiarDeSala() {
        ChatRoom primeraSala = new ChatRoom();
        ChatRoom segundaSala = new ChatRoom();
        User ana = new User("Ana");
        primeraSala.agregarUsuario(ana);

        segundaSala.agregarUsuario(ana);

        verificar(primeraSala.cantidadUsuarios() == 0,
                "La primera sala debe retirar al usuario");
        verificar(segundaSala.cantidadUsuarios() == 1,
                "La segunda sala debe registrar al usuario");
        verificar(ana.getSala() == segundaSala, "El usuario debe conocer su nueva sala");
    }

    private static void verificar(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError(mensaje);
        }
    }
}

