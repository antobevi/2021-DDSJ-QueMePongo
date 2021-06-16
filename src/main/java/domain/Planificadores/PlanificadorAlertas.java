package domain.Planificadores;

import domain.ServiciosDelClima.ProveedorClima;

import java.util.*;

public class PlanificadorAlertas {

  // Automatizamos la actualizacion de las alertas
  public void notificarNuevasAlertas(ProveedorClima proveedorClima) {
    int tiempoRepeticion = 300000; // 5 minutos
    int tiempoDeRetraso = 60000; // 1 minuto
    Timer timer = new Timer();

    timer.schedule(this.nuevaAlerta(proveedorClima), tiempoDeRetraso, tiempoRepeticion);
  }

  public TimerTask nuevaAlerta(ProveedorClima proveedorClima) {
    TimerTask timerTask = new TimerTask() {
      @Override
      public void run() {
        proveedorClima.consultarUltimasAlertasPara("Buenos Aires");
      }
    };
    return timerTask;
  }
}
