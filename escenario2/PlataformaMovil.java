class PlataformaMovil implements Plataforma {
  @Override
  public void mostrarNotificacion(String titulo, String cuerpo) {
	System.out.println("Movil - Título: " + titulo + " | Cuerpo: " + cuerpo);
  }
}
