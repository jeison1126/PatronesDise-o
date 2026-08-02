package escenario3;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Mediador concreto. Conoce a los participantes y distribuye sus mensajes,
 * evitando que los usuarios deban mantener referencias entre ellos.
 */
public final class ChatRoom implements ChatMediator {

    private final Set<User> usuarios = new LinkedHashSet<>();

    @Override
    public boolean agregarUsuario(User usuario) {
        Objects.requireNonNull(usuario, "El usuario no puede ser nulo");

        if (usuarios.contains(usuario)) {
            return false;
        }

        ChatMediator salaAnterior = usuario.getSala();
        if (salaAnterior != null && salaAnterior != this) {
            salaAnterior.eliminarUsuario(usuario);
        }

        usuarios.add(usuario);
        usuario.unirseA(this);
        return true;
    }

    @Override
    public boolean eliminarUsuario(User usuario) {
        Objects.requireNonNull(usuario, "El usuario no puede ser nulo");

        if (!usuarios.remove(usuario)) {
            return false;
        }

        usuario.salirDe(this);
        return true;
    }

    @Override
    public void enviar(String mensaje, User remitente) {
        Objects.requireNonNull(remitente, "El remitente no puede ser nulo");

        if (!usuarios.contains(remitente)) {
            throw new IllegalStateException(
                    remitente.getNombre() + " no pertenece a esta sala");
        }

        String mensajeValidado = validarMensaje(mensaje);
        for (User destinatario : usuarios) {
            if (destinatario != remitente) {
                destinatario.recibir(mensajeValidado, remitente.getNombre());
            }
        }
    }

    public int cantidadUsuarios() {
        return usuarios.size();
    }

    private String validarMensaje(String mensaje) {
        if (mensaje == null || mensaje.trim().isEmpty()) {
            throw new IllegalArgumentException("El mensaje no puede estar vacío");
        }
        return mensaje.trim();
    }
}

