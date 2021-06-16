package domain.Alertas;

import domain.MediosDeComunicacion.NotificationService;
import domain.Usuario;

public class AlertaGranizo extends Alerta {
  String mensajeAlerta = "Va a caer granizo, evita salir con el auto!";

  protected String getMensajeAlerta() {
    return mensajeAlerta;
  }

  @Override
  protected void setearNotificador(Usuario usuario) {
    super.setearNotificador(usuario);
    notificadores.add(new NotificationService(mensajeAlerta, usuario));
  }

  public void notificar(Usuario usuario) {
    this.setearNotificador(usuario);

    notificadores.forEach(notificador -> notificador.enviar());
  }

}
