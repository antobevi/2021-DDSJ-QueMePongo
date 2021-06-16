package domain.Notificadores;

import domain.Alertas.Alerta;
import domain.Usuario;

import java.util.List;

public class NotificadorAlertaMetereologica {
  private Alerta alerta;

  public NotificadorAlertaMetereologica(Alerta alerta) {
    this.alerta = alerta;
  }

  public void enviar(List<Alerta> alertas, Usuario usuario) {
    alertas.stream().forEach(alerta -> alerta.notificar(usuario));
  }

}
