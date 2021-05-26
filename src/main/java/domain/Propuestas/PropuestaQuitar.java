package domain.Propuestas;

import domain.Guardarropa;
import domain.Prenda.Prenda;

public class PropuestaQuitar implements Propuesta {
  private Prenda prendaAQuitar;

  public void modificarGuardarropa(Guardarropa guardarropa) {
    guardarropa.quitarPrenda(prendaAQuitar);
  }

}
