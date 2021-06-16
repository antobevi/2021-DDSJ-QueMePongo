package domain.Notificadores;

import domain.Alertas.Alerta;
import domain.Alertas.TipoAlerta;
import domain.Usuario;

import java.util.List;

public class NotificadorAlertaTormenta implements Notificador {

  // La alerta se encarga de notificar por los medios de comunicacion correspondientes.
  public void enviar(List<String> alertas, Usuario usuario) {
    if(alertas.contains("STORM")) {
      new Alerta("Va a haber una tormenta! Si salis, llevate un paraguas.", TipoAlerta.STORM).notificar(usuario);
    }
  }

}
