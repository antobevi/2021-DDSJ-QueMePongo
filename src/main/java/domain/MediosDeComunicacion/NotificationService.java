package domain.MediosDeComunicacion;

import domain.Usuario;

// Notificaciones por la app.
public class NotificationService implements MedioDeComunicacion {
  private String mensaje;
  private Usuario usuario;

  public NotificationService(String mensaje, Usuario usuario) {
    this.mensaje = mensaje;
    this.usuario = usuario;
  } // TODO: Revisar

  public void enviar() {}

}
