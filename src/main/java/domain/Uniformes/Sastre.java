package domain.Uniformes;

import domain.Prenda.Prenda;

public abstract class Sastre {
  public void crearUniforme() {
    new Uniforme(
        this.fabricarParteSuperior(),
        this.fabricarParteInferior(),
        this.fabricarCalzado()
    );
  }

  protected abstract Prenda fabricarParteSuperior();
  protected abstract Prenda fabricarParteInferior();
  protected abstract Prenda fabricarCalzado();

}
