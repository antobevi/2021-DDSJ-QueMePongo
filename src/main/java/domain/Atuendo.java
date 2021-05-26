package domain;

import domain.Prenda.Prenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Atuendo {

  private List<Prenda> prendasSuperiores;
  private Prenda prendaInferior;
  private Prenda calzado;
  private List<Prenda> accesorios;

  public Atuendo(List<Prenda> prendasSuperiores, Prenda prendaInferior,
                 Prenda calzado, List<Prenda> accesorios) {
    this.prendasSuperiores = Objects.requireNonNull(prendasSuperiores,
        "El atuendo debe tener al menos una prenda superior!");
    this.prendaInferior = Objects.requireNonNull(prendaInferior,
        "El atuendo debe tener al menos una prenda inferior!");
    this.calzado = Objects.requireNonNull(calzado,
        "El atuendo debe tener un calzado!");
    this.accesorios = Objects.requireNonNull(accesorios,
        "El atuendo debe tener al menos un accesorio");
  }

  public List<Prenda> getPrendasSuperiores() {
    return prendasSuperiores;
  }

  public Prenda getPrendaInferior() {
    return prendaInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }

  public List<Prenda> getAccesorios() {
    return accesorios;
  }

  public boolean esAptoParaTemperatura(Integer temperatura) {
    return this.crearListaDePrendas().stream()
        .allMatch(prenda -> prenda.getTemperaturaAdecuada().esAdecuada(temperatura));
  }

  public List<Prenda> crearListaDePrendas() {
    List<Prenda> prendas = new ArrayList<>();
    prendas.addAll(prendasSuperiores);
    prendas.add(prendaInferior);
    prendas.add(calzado);
    prendas.addAll(accesorios);

    return prendas;
  }
}
