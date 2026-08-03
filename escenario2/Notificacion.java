abstract class Notificacion {
  // Referencia a la plataforma (El "Puente")
  protected Plataforma plataforma;

  public Notificacion(Plataforma plataforma) {
	this.plataforma = plataforma;
  }

  // Cumple con el beneficio: Flexibilidad en tiempo de ejecución
  public void setPlataforma(Plataforma plataforma) {
	this.plataforma = plataforma;
  }

  public abstract void enviar(String mensaje);
}
