class PlataformaEscritorio implements Plataforma {
  @Override
  public void mostrarNotificacion(String titulo, String cuerpo) {
	System.out.println("ESCRITORIO Mostrando Notificación de Sistema - Título: " + titulo + " | Cuerpo: " + cuerpo);
  }
}
