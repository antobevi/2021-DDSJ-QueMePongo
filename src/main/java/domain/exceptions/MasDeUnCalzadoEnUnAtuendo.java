package domain.exceptions;

public class MasDeUnCalzadoEnUnAtuendo extends RuntimeException {

  public MasDeUnCalzadoEnUnAtuendo(String mensaje) {
    new Exception(mensaje);
  }

}
