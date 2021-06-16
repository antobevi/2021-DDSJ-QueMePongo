package domain.ServiciosDelClima;

import domain.Alertas.Alerta;

import java.util.List;

public interface ProveedorClima {

  Integer consultarTemperaturaPara(String ciudad);

  List<String> consultarUltimasAlertasPara(String ciudad);

}
