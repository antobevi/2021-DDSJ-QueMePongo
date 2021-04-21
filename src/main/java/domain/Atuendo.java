package domain;

import java.util.ArrayList;
import java.util.List;

public class Atuendo {
    private List<Prenda> prendas = new ArrayList<>();

    public List<Prenda> getPrendas() {
        return prendas;
    }

    public void agregarPrenda(Prenda prenda) {
        prendas.add(prenda);
    }

    public void quitarPrenda(Prenda prenda) {
        prendas.remove(prenda);
    }

    public void validadAtuendo() {
        ValidadorDePrendas validador = ValidadorDePrendas.getInstance();
        prendas.forEach(prenda -> validador.validarPrenda(prenda));
    }

}
