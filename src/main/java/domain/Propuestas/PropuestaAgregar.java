package domain.Propuestas;

import domain.Guardarropas.Guardarropa;
import domain.Prenda;

public class PropuestaAgregar implements Propuesta {
  private Prenda prendaAAgregar;

  public void modificarGuardarropa(Guardarropa guardarropa) {
    guardarropa.agregarPrenda(prendaAAgregar);
  }

}
