package domain.Notificadores;

import domain.Alertas.Alerta;
import domain.Usuario;

import java.util.List;

public class NotificadorSugerenciaAtuendo implements Notificador {

  // Si el usuario quiere recibir una nueva sugerencia cada vez que haya una alerta:
  public void enviar(List<Alerta> alertas, Usuario usuario) {
    // TODO: Se realiza la sugerencia de atuendo por medio de una notificacion?
    // TODO: Sugerir deberia conocer la alerta y sugerir de acuerdo a la situacion?
    //  O con que el asesor pida las condiciones climaticas en el momento alcanza?
    usuario.haySugerenciaNueva();
  }

}
