package domain.Prenda;

import domain.Constants.Categoria;
import domain.Constants.Tela;
import domain.Exceptions.MaterialNoAptoParaTipoDePrenda;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TipoDePrenda {
  private Categoria categoria;
  private List<Tela> telasInvalidas;

  // TODO: Preguntarle al profesor!
  //  ¿En este caso es valido tener atributos estaticos (atributos de clase)?
  //  ¿Como se validan que la categoria coincida con el tipo de prenda definido?
  public static TipoDePrenda REMERA = new TipoDePrenda(Categoria.PARTE_SUPERIOR,
      Arrays.asList(Tela.CUERO, Tela.JEAN, Tela.GABARDINA, Tela.ACETATO));
  public static TipoDePrenda CAMISA = new TipoDePrenda(Categoria.PARTE_SUPERIOR,
      Arrays.asList(Tela.CUERO, Tela.GABARDINA, Tela.LONA, Tela.LANA, Tela.ACETATO, Tela.PIQUE));
  public static TipoDePrenda PANTALON = new TipoDePrenda(Categoria.PARTE_INFERIOR,
      Arrays.asList(Tela.LANA, Tela.PIQUE));
  public static TipoDePrenda ZAPATILLAS = new TipoDePrenda(Categoria.CALZADO,
      Arrays.asList(Tela.SEDA, Tela.PIQUE, Tela.LANA));
  public static TipoDePrenda ZAPATOS = new TipoDePrenda(Categoria.CALZADO,
      Arrays.asList(Tela.LANA, Tela.SEDA, Tela.PIQUE, Tela.LONA, Tela.ACETATO, Tela.GABARDINA, Tela.ALGODON, Tela.JEAN));

  public TipoDePrenda(Categoria categoria, List<Tela> telasInvalidas) {
    this.categoria = Objects.requireNonNull(categoria, "Falta ingresar la categoria!");
    this.telasInvalidas = telasInvalidas;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void validarTipoDePrendaPara(Material material) {
    if(telasInvalidas.contains(material)) {
      throw new MaterialNoAptoParaTipoDePrenda("No es posible construir una prenda de este material!");
    }
  }

  public void agregarTelaInvalida(Tela tela) {
    telasInvalidas.add(tela);
  }

  public void quitarTelaInvalida(Tela tela) {
    telasInvalidas.remove(tela);
  }

}
