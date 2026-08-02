package escenario3;

/**
 * Mediador que define las operaciones necesarias para administrar una sala y
 * centralizar la comunicación entre sus usuarios.
 */
public interface ChatMediator {

    boolean agregarUsuario(User usuario);

    boolean eliminarUsuario(User usuario);

    void enviar(String mensaje, User remitente);
}

