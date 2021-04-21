package domain;

import domain.constants.TipoDePrenda;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    List<TipoDePrenda> tiposPermitidos = new ArrayList<>();

    public List<TipoDePrenda> getTiposPermitidos() {
        return tiposPermitidos;
    }

    public void agregarTipoDePrenda(TipoDePrenda tipo) {
        tiposPermitidos.add(tipo);
    }
}
