package domain.exceptions;

public class FaltanPrendasDeCategorias extends RuntimeException {

  public FaltanPrendasDeCategorias(String mensaje) {
    new Exception(mensaje);
  }

}
