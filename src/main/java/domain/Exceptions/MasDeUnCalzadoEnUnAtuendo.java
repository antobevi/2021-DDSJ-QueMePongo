package domain.Exceptions;

public class MasDeUnCalzadoEnUnAtuendo extends RuntimeException {

  public MasDeUnCalzadoEnUnAtuendo(String mensaje) {
    new Exception(mensaje);
  }

}
