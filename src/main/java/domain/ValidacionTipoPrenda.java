package domain;

public class ValidacionTipoPrenda {

    public void validar(Prenda prenda) {
        if (prenda.getTipo() == null) {
            throw new FaltaAtributo("Falta ingresar el tipo de prenda!");
        }
    }
}
