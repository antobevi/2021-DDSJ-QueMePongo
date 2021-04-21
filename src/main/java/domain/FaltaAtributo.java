package domain;

public class FaltaAtributo extends RuntimeException {
    public FaltaAtributo(String mensaje) {
        new Exception(mensaje);
    }

}
