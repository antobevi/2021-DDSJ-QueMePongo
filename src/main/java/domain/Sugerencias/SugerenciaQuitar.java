package domain.Sugerencias;

import domain.Guardarropa;
import domain.Prenda.Prenda;

public class SugerenciaQuitar extends Sugerencia {
  private Prenda prendaAQuitar;

  public SugerenciaQuitar(Guardarropa guardarropa, Prenda prendaAQuitar) {
    super(guardarropa);
    this.prendaAQuitar = prendaAQuitar;
  }

  public void aceptarSugerencia() {
    guardarropa.quitarPrenda(prendaAQuitar);
  }

  public void deshacerSugerencia() {
    guardarropa.agregarPrenda(prendaAQuitar);
  }

}
