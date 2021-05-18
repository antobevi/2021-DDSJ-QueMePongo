package domain;

public class Temperatura {
  private Double temperaturaMaxima;
  private Double temperaturaMinima;

  public Double getTemperaturaMaxima() {
    return temperaturaMaxima;
  }

  public Double getTemperaturaMinima() {
    return temperaturaMinima;
  }

  public boolean esAdecuada(Double temperatura) {
    return temperaturaMinima <= temperatura && temperatura <= temperaturaMaxima;
  }
}
