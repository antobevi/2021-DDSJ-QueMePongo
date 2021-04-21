package domain;

public class NoCoincideTipoConCategoria extends RuntimeException {
    public NoCoincideTipoConCategoria(String mensaje) {
        new Exception(mensaje);
    }
}
