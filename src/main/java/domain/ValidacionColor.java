package domain;

public class ValidacionColor {

    public void validar(Prenda prenda) {
        if (prenda.getColorPrincipal() == null) {
            throw new FaltaAtributo("Falta ingresar el color principal de la prenda!");
        }
    }
}
