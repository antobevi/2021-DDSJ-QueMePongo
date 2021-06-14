package domain.Sugerencias;

import domain.Guardarropa;
import domain.Prenda.Prenda;

public class SugerenciaAgregar extends Sugerencia {
  private Prenda prendaAAgregar;

  public SugerenciaAgregar(Guardarropa guardarropa, Prenda prendaAAgregar) {
    super(guardarropa);
    this.prendaAAgregar = prendaAAgregar;
  }

  public void aceptarSugerencia() {
    guardarropa.agregarPrenda(prendaAAgregar);
  }

  public void deshacerSugerencia() {
    guardarropa.quitarPrenda(prendaAAgregar);
  }

}
