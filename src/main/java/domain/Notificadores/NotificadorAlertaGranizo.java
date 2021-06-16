package domain.Notificadores;

import domain.Alertas.Alerta;
import domain.Alertas.TipoAlerta;
import domain.Usuario;

import java.util.List;

public class NotificadorAlertaGranizo {

  // La alerta se encarga de notificar por los medios de comunicacion correspondientes.
  public void enviar(List<String> alertas, Usuario usuario) {
    if (alertas.contains("HAIL")) { // TODO: Se podria abstraer esta parte que solo depende de un string estado?
      new Alerta("Va a caer granizo! Evita salir con el auto.", TipoAlerta.HAIL).notificar(usuario);
    }
  }

}
