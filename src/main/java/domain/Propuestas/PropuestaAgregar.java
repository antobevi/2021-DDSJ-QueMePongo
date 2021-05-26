package domain.Propuestas;

import domain.Guardarropa;
import domain.Prenda.Prenda;

public class PropuestaAgregar implements Propuesta {
  private Prenda prendaAAgregar;

  public void modificarGuardarropa(Guardarropa guardarropa) {
    guardarropa.agregarPrenda(prendaAAgregar);
  }

}
