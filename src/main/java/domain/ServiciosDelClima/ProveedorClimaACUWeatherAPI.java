package domain.ServiciosDelClima;

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

}
