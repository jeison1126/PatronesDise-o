class PlataformaWeb implements Plataforma {
  @Override
  public void mostrarNotificacion(String titulo, String cuerpo) {
	System.out.println("WEB : " + titulo + " | Cuerpo: " + cuerpo);
  }
}
