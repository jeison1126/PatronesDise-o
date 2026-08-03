class NotificacionMensaje extends Notificacion {

  public NotificacionMensaje(Plataforma plataforma) {
	super(plataforma);
  }

  @Override
  public void enviar(String mensaje) {
	String titulo = "Nuevo Mensaje";
	plataforma.mostrarNotificacion(titulo, mensaje);
  }
}
