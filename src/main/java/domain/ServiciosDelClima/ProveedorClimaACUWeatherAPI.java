package domain.ServiciosDelClima;

import domain.Repositorios.RepositorioAlertas;
import domain.Repositorios.RepositorioUsuarios;
import domain.Alertas.Alerta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// TODO: Falta la logica de no tener gastos innecesarios implementando una memoria cache
// Adapter
public class ProveedorClimaACUWeatherAPI implements ProveedorClima {
  private AccuWeatherAPI proveedorClima = new AccuWeatherAPI();

  public Map<String, Object> consultarCondicionesClimaticas(String ciudad) {
    return proveedorClima.getWeather(ciudad).get(0);
  }

  public Integer consultarTemperaturaPara(String ciudad) {
    return this.consultarCondicionesClimaticas(ciudad).get("Temperature").hashCode(); // TODO: Preguntar esto
  }

  public List<String> consultarUltimasAlertasPara(String ciudad) {
    Map<String, Object> alertas = proveedorClima.getAlertas("Buenos Aires");
    List<String> ultimasAlertas = (List<String>) alertas.get("CurrentAlerts"); //Devuelve un objeto como [“STORM”, “HAIL”, ...]

    if(ultimasAlertas != null) { // Para que no le avise si no hay alertas
      RepositorioAlertas.getInstance().actualizarAlertas(ultimasAlertas);
      RepositorioUsuarios.getInstance().getUsuarios().forEach(user -> user.hayAlertasNuevas(ultimasAlertas));
    }

    return ultimasAlertas;
  }

}
