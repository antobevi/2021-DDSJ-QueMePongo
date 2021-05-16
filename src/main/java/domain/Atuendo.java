package domain;

import java.util.List;

public class Atuendo {
    private List<Prenda> prendas;

    // Constructor
    public Atuendo(List<Prenda> prendas) {
        this.prendas = prendas;
    }

    public List<Prenda> getPrendas() {
        return prendas;
    }

    public void agregarPrenda(Prenda prenda) {
        prendas.add(prenda);
    }

    public void quitarPrenda(Prenda prenda) {
        prendas.remove(prenda);
    }

}
