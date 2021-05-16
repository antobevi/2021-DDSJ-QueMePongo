package domain;

import domain.constants.Categoria;

import java.util.Objects;

public class TipoDePrenda {
  Categoria categoria; // De es

  // TODO: Preguntarle al profesor!
  //  ¿En este caso es valido tener atributos estaticos (atributos de clase)? ¿Como se validan que la categoria
  //  coincida con el tipo de prenda definido?
  static final TipoDePrenda REMERA = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
  static final TipoDePrenda BUZO = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
  static final TipoDePrenda CAMPERA = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
  static final TipoDePrenda PANTALON = new TipoDePrenda(Categoria.PARTE_INFERIOR);
  static final TipoDePrenda SHORT = new TipoDePrenda(Categoria.PARTE_INFERIOR);
  static final TipoDePrenda BERMUDA = new TipoDePrenda(Categoria.PARTE_INFERIOR);
  static final TipoDePrenda POLLERA = new TipoDePrenda(Categoria.PARTE_INFERIOR);
  static final TipoDePrenda ZAPATILLAS = new TipoDePrenda(Categoria.CALZADO);
  static final TipoDePrenda ZAPATOS = new TipoDePrenda(Categoria.CALZADO);

  public TipoDePrenda(Categoria categoria) {
    this.categoria = Objects.requireNonNull(categoria, "Falta ingresar la categoria!");
  }

  public Categoria getCategoria() {
    return categoria;
  }

}
