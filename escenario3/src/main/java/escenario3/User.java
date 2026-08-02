package escenario3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Colega del patrón Mediator. Solo conoce a su mediador y nunca mantiene
 * referencias directas a otros usuarios.
 */
public final class User {

    private final String nombre;
    private final List<Message> mensajes = new ArrayList<>();
    private ChatMediator sala;

    public User(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El usuario debe tener un nombre");
        }
        this.nombre = nombre.trim();
    }

    public void enviar(String mensaje) {
        if (sala == null) {
            throw new IllegalStateException(nombre + " no está en una sala");
        }
        sala.enviar(mensaje, this);
    }

    void recibir(String contenido, String nombreRemitente) {
        Message mensaje = new Message(nombreRemitente, contenido);
        mensajes.add(mensaje);
        System.out.printf("[%s] %s%n", nombre, mensaje);
    }

    void unirseA(ChatMediator nuevaSala) {
        sala = nuevaSala;
    }

    void salirDe(ChatMediator salaAbandonada) {
        if (sala == salaAbandonada) {
            sala = null;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public ChatMediator getSala() {
        return sala;
    }

    public List<Message> getMensajes() {
        return Collections.unmodifiableList(mensajes);
    }
}

