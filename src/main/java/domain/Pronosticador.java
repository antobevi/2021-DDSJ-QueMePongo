package domain;

import java.util.List;
import java.util.Map;

public class Pronosticador {
  AccuWeatherAPI servicioClimatico = new AccuWeatherAPI(); // TODO: Ver tipo de dato para generalizar

  private static Pronosticador instance = null;

  private Pronosticador() {
    // Asi nadie puede llamar al constructor de esta clase
  }

  public static Pronosticador getInstance() {
    if(instance == null)
      instance = new Pronosticador();
    return instance;
  }

  List<Map<String, Object>> consultarCondicionesClimaticasParaBsAs() {
    return servicioClimatico.getWeather("Buenos Aires");
  }

  public Object getServicioClimatico() {
    return servicioClimatico;
  }

  public void setServicioClimatico(AccuWeatherAPI servicioClimatico) {
    this.servicioClimatico = servicioClimatico;
  }
}
