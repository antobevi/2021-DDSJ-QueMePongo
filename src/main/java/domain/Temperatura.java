package domain;

public class Temperatura {
  private Integer temperaturaMaxima;
  private Integer temperaturaMinima;

  public Integer getTemperaturaMaxima() {
    return temperaturaMaxima;
  }

  public Integer getTemperaturaMinima() {
    return temperaturaMinima;
  }

  public boolean esAdecuada(Integer temperatura) {
    return temperaturaMinima <= temperatura && temperatura <= temperaturaMaxima;
  }
}
