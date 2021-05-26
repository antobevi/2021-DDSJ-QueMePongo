package domain.Propuestas;

import domain.Guardarropas.Guardarropa;
import domain.Prenda;

public class PropuestaQuitar implements Propuesta {
  private Prenda prendaAQuitar;

  public void modificarGuardarropa(Guardarropa guardarropa) {
    guardarropa.quitarPrenda(prendaAQuitar);
  }

}
