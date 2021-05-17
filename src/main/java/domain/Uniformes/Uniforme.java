package domain.Uniformes;

import domain.Prenda;

public class Uniforme {
  Prenda prendaParteSuperior;
  Prenda prendaParteInferior;
  Prenda calzado;

  public Uniforme(Prenda prendaParteSuperior, Prenda prendaParteInferior, Prenda calzado) {
    this.prendaParteSuperior = prendaParteSuperior;
    this.prendaParteInferior = prendaParteInferior;
    this.calzado = calzado;
  }

  public Prenda getPrendaParteSuperior() {
    return prendaParteSuperior;
  }

  public Prenda getPrendaParteInferior() {
    return prendaParteInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }
}
