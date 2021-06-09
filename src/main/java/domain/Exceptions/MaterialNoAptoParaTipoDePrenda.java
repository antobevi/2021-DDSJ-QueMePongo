package domain.Exceptions;

public class MaterialNoAptoParaTipoDePrenda extends RuntimeException {

  public MaterialNoAptoParaTipoDePrenda(String mensaje) {
    new Exception(mensaje);
  }

}
