
public class Main {
    public static void main(String[] args){
        // Creamos las plataformas disponibles
        Plataforma web = new PlataformaWeb();
        Plataforma movil = new PlataformaMovil();

        // Creamos notificaciones asignando la plataforma deseada
        Notificacion mensajeWeb = new NotificacionMensaje(web);
        Notificacion alertaMovil = new NotificacionAlerta(movil);

        // Enviamos las notificaciones
        mensajeWeb.enviar("Hola, tienes una nueva solicitud.");
        alertaMovil.enviar("Batería baja en el dispositivo.");

        // Flexibilidad en tiempo de ejecución: cambiamos de web a móvil
        System.out.println(" -- Cambiando plataforma dinámicamente ---");
        mensajeWeb.setPlataforma(movil);
        mensajeWeb.enviar("Hola, tienes una nueva solicitud.");

    }
}