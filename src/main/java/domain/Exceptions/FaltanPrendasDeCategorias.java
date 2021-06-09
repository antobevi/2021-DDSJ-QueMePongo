package domain.Exceptions;

public class FaltanPrendasDeCategorias extends RuntimeException {

  public FaltanPrendasDeCategorias(String mensaje) {
    new Exception(mensaje);
  }

}
