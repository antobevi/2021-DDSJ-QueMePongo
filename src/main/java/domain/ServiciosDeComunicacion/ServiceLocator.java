package domain.ServiciosDeComunicacion;

import java.util.HashMap;
import java.util.Map;

/*
* Es un patron de disenio.
* Es una clase que sepa cómo obtener todos los servicios que utiliza nuestra aplicación.
* Así que, el Service Locator tendría una propiedad por cada uno de esos servicios, que devolvería un
* objeto del tipo adecuado cuando se lo soliciten.
* */

public class ServiceLocator {
  private static ServiceLocator instance = new ServiceLocator(); // Singleton
  // Designa claves únicas para los valores correspondientes que se pueden recuperar en cualquier punto dado.
  Map<Class,Object> servicios = new HashMap<>();

  public void registrar(Class clazz, Object instance) {
    servicios.put(clazz, instance);
  }

  public Object get(Class clazz) {
    return servicios.get(clazz);
  }

  public static ServiceLocator getServiceLocator() {
    return instance;
  }

  // Para testing
  public void eliminarServicios(){
    this.servicios = new HashMap<>();
  }
}
