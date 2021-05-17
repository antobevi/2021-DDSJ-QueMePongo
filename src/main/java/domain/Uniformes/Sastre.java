package domain.Uniformes;

import domain.Prenda;

/*
Elijo usar Factory Method porque me permite separar la construcción del uso y no necesito,
al menos para los requerimientos actuales, la flexibilidad del Abstract Method al permitirle a otros objetos
utilizar al Sastre para construir uniformes. Como desventaja principal está el uso de herencia que genera más
acoplamiento y cohesión.
*/
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
