package domain;

import java.util.Objects;

public class Borrador {
  private TipoDePrenda tipo;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario;
  private Temperatura temperaturaAdecuada;

  public void especificarTipoDePrenda(TipoDePrenda tipo) {
    this.tipo = Objects.requireNonNull(tipo, "Falta ingresar el tipo de prenda!");
  }

  public void especificarColorPrincipal(Color colorPrincipal) {
    this.colorPrincipal = Objects.requireNonNull(colorPrincipal, "Falta ingresar el color principal!");
  }

  public void especificarColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void especificarMaterial(Material material) {
    Objects.requireNonNull(material, "Falta ingresar el material de la prenda!");
    tipo.validarTipoDePrendaPara(material);
    this.material = material;
  }

  public void especificarTemperaturaAdecuada(Temperatura temperaturaAdecuada) {
    Objects.requireNonNull(temperaturaAdecuada, "Falta ingresar la temperatura adecuada para usar la prenda!");
    this.temperaturaAdecuada = temperaturaAdecuada;
  }

  public Prenda construirPrenda() {
    return new Prenda(tipo, material, colorPrincipal, colorSecundario, temperaturaAdecuada);
  }

}
