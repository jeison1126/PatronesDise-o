package escenario3;

import java.util.Objects;

/** Valor inmutable que representa un mensaje recibido. */
public final class Message {

    private final String remitente;
    private final String contenido;

    public Message(String remitente, String contenido) {
        this.remitente = Objects.requireNonNull(remitente);
        this.contenido = Objects.requireNonNull(contenido);
    }

    public String getRemitente() {
        return remitente;
    }

    public String getContenido() {
        return contenido;
    }

    @Override
    public String toString() {
        return remitente + ": " + contenido;
    }
}

