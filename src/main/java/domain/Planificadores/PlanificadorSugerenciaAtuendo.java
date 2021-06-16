package domain.Planificadores;

import domain.Repositorios.RepositorioUsuarios;

import java.util.*;

public class PlanificadorSugerenciaAtuendo {

  // Automatizamos el envio de la sugerencia diaria.
  public void notificarSugerenciaDiaria() {
    int tiempoRepeticion = 86400000; // 24 hs
    Timer timer = new Timer();
    Date horaSugerenciaDiaria = new Date(System.currentTimeMillis());
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 6); // 6 am
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    timer.schedule(this.sugerirAtuendoDiario(), horaSugerenciaDiaria, tiempoRepeticion);
  }

  public TimerTask sugerirAtuendoDiario() {
    TimerTask timerTask = new TimerTask() {
      @Override
      public void run() {
        //TODO: La sugerencia matutina es por notificacion de escritorio.
        RepositorioUsuarios.getInstance().getUsuarios().forEach(usuario -> usuario.haySugerenciaNueva());
      }
    };
    return timerTask;
  }

}
