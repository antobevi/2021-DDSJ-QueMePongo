package domain;

public class ValidacionMaterial {

    public void validar(Prenda prenda) {
        if (prenda.getMaterial() == null) {
            throw new FaltaAtributo("Falta ingresar el material de la prenda!");
        }
    }
}
