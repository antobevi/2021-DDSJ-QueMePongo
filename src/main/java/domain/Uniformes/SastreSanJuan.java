package domain.Uniformes;

import domain.Prenda.*;
import domain.constants.Tela;

public class SastreSanJuan extends Sastre {
  @Override
  protected Prenda fabricarParteSuperior() {
    Borrador chombaVerdePique = new Borrador();
    /*
    List<Tela> telasInvalidas = new ArrayList<>();
    telasInvalidas.add(Tela.CUERO);
    telasInvalidas.add(Tela.GABARDINA);
    telasInvalidas.add(Tela.LONA);
    TipoDePrenda remera = new TipoDePrenda(Categoria.PARTE_SUPERIOR, telasInvalidas);
    */
    chombaVerdePique.especificarTipoDePrenda(TipoDePrenda.REMERA);
    chombaVerdePique.especificarMaterial(new Material(Tela.PIQUE, null));
    Color verde = new Color(192, 192, 192);
    chombaVerdePique.especificarColorPrincipal(verde);

    return chombaVerdePique.construirPrenda();
  }

  @Override
  protected Prenda fabricarParteInferior() {
    Borrador pantalonGris = new Borrador();
    /*
    List<Tela> telasInvalidas = new ArrayList<>();
    telasInvalidas.add(Tela.LANA);
    telasInvalidas.add(Tela.LONA);
    telasInvalidas.add(Tela.PIQUE);
    TipoDePrenda pantalon = new TipoDePrenda(Categoria.PARTE_INFERIOR, telasInvalidas);
    */
    pantalonGris.especificarTipoDePrenda(TipoDePrenda.PANTALON);
    pantalonGris.especificarMaterial(new Material(Tela.ACETATO, null));
    Color gris = new Color(130, 130, 130);
    pantalonGris.especificarColorPrincipal(gris);

    return pantalonGris.construirPrenda();
  }

  @Override
  protected Prenda fabricarCalzado() {
    Borrador zapatillasBlancas = new Borrador();
    /*
    List<Tela> telasInvalidas = new ArrayList<>();
    telasInvalidas.add(Tela.GABARDINA);
    telasInvalidas.add(Tela.PIQUE);
    telasInvalidas.add(Tela.LANA);
    telasInvalidas.add(Tela.SEDA);
    TipoDePrenda zapatillas = new TipoDePrenda(Categoria.CALZADO, telasInvalidas);
    */
    zapatillasBlancas.especificarTipoDePrenda(TipoDePrenda.ZAPATILLAS);
    zapatillasBlancas.especificarMaterial(new Material(Tela.LONA, null));
    Color blanco = new Color(255, 255, 255);
    zapatillasBlancas.especificarColorPrincipal(blanco);

    return zapatillasBlancas.construirPrenda();
  }
}
