package domain.Repositorios;

import domain.Alertas.Alerta;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAlertas {
  private static final RepositorioAlertas instance = new RepositorioAlertas();
  private List<Alerta> alertas;

  private RepositorioAlertas() {
    this.alertas = new ArrayList<>();
  }

  public static RepositorioAlertas getInstance() {
    return instance;
  }

  public List<Alerta> getAlertas() {
    return alertas;
  }

  public void actualizarAlertas(List<Alerta> alertas) {
    this.alertas = alertas;
  }

}
