package domain.Uniformes;

import domain.*;
import domain.constants.Categoria;
import domain.constants.Tela;

import java.util.ArrayList;
import java.util.List;

public class SastreJohnson extends Sastre {

  @Override
  protected Prenda fabricarParteSuperior() {
    Borrador camisaBlanca = new Borrador();
    /*
    List<Tela> telasInvalidas = new ArrayList<>();
    telasInvalidas.add(Tela.CUERO);
    telasInvalidas.add(Tela.GABARDINA);
    telasInvalidas.add(Tela.LONA);
    telasInvalidas.add(Tela.LANA);
    telasInvalidas.add(Tela.ACETATO);
    telasInvalidas.add(Tela.PIQUE);
    TipoDePrenda camisa = new TipoDePrenda(Categoria.PARTE_SUPERIOR, telasInvalidas);
    */
    camisaBlanca.especificarTipoDePrenda(TipoDePrenda.CAMISA);
    Material material = new Material(Tela.ALGODON, null);
    camisaBlanca.especificarMaterial(material);
    Color blanco = new Color(255, 255, 255);
    camisaBlanca.especificarColorPrincipal(blanco);
    return camisaBlanca.construirPrenda();
  }

  @Override
  protected Prenda fabricarParteInferior() {
    Borrador pantalonNegro = new Borrador();
    /*
    List<Tela> telasInvalidas = new ArrayList<>();
    telasInvalidas.add(Tela.LANA);
    telasInvalidas.add(Tela.LONA);
    telasInvalidas.add(Tela.PIQUE);
    TipoDePrenda pantalon = new TipoDePrenda(Categoria.PARTE_INFERIOR, telasInvalidas);
    */
    pantalonNegro.especificarTipoDePrenda(TipoDePrenda.PANTALON);
    pantalonNegro.especificarMaterial(new Material(Tela.ACETATO, null));
    Color negro = new Color(0, 0, 0);
    pantalonNegro.especificarColorPrincipal(negro);
    return pantalonNegro.construirPrenda();
  }

  @Override
  protected Prenda fabricarCalzado() {
    Borrador zapatosNegros = new Borrador();
    /*
    List<Tela> telasInvalidas = new ArrayList<>();
    telasInvalidas.add(Tela.GABARDINA);
    telasInvalidas.add(Tela.PIQUE);
    telasInvalidas.add(Tela.LANA);
    telasInvalidas.add(Tela.SEDA);
    telasInvalidas.add(Tela.ALGODON);
    telasInvalidas.add(Tela.ACETATO);
    TipoDePrenda zapatos = new TipoDePrenda(Categoria.CALZADO, telasInvalidas);
    */
    zapatosNegros.especificarTipoDePrenda(TipoDePrenda.ZAPATOS);
    zapatosNegros.especificarMaterial(new Material(Tela.CUERO, null));
    Color negro = new Color(0, 0, 0);
    zapatosNegros.especificarColorPrincipal(negro);
    return zapatosNegros.construirPrenda();
  }
}
