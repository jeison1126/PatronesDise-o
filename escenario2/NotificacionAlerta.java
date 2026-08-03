class NotificacionAlerta extends Notificacion {

  public NotificacionAlerta(Plataforma plataforma) {
	super(plataforma);
  }

  @Override

  public void enviar(String mensaje) {
	String titulo = "⚠ ALERTA IMPORTANTE";
	plataforma.mostrarNotificacion(titulo, mensaje.toUpperCase());
  }
}
