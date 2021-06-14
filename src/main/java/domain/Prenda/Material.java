package domain.Prenda;

import domain.Constants.Tela;
import domain.Constants.Trama;

import java.util.Objects;

// Creo una clase Material para no tener un constructor muy grande ya que no se sabe si a futuro se van a agregar
// caracteristicas en la prenda.
public class Material {
  private Tela tela;
  private Trama trama;

  public Material(Tela tela, Trama trama) {
    this.tela = Objects.requireNonNull(tela, "Debe ingresar la tela de la prenda!");
    if(trama == null) {
      this.trama = Trama.LISA;
    } else {
      this.trama = trama;
    }
  }

}
