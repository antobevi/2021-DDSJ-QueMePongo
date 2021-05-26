package domain.Guardarropas;

import domain.Prenda;
import domain.constants.Categoria;

import java.util.List;
import java.util.stream.Collectors;

public class Guardarropa {
    private List<Prenda> prendas;

  public Guardarropa(List<Prenda> prendas) {
    this.prendas = prendas;
  }

  public Guardarropa() {
    this.prendas = null;
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }

  // Metodos para logica de la temperatura en la cuarta iteracion
  public List<Prenda> prendasSuperiores(Integer temperatura) {
    return prendas.stream()
        .filter(prenda -> prenda.getTipo().getCategoria().equals(Categoria.PARTE_SUPERIOR))
        .filter(prenda -> prenda.getTemperaturaAdecuada().esAdecuada(temperatura))
        .collect(Collectors.toList());
  }

  public List<Prenda> prendasInferiores() {
    return prendas.stream()
        .filter(prenda -> prenda.getTipo().getCategoria().equals(Categoria.PARTE_INFERIOR))
        .collect(Collectors.toList());
  }

  public List<Prenda> calzados() {
    return prendas.stream()
        .filter(prenda -> prenda.getTipo().getCategoria().equals(Categoria.CALZADO))
        .collect(Collectors.toList());
  }

  public List<Prenda> accesorios() {
    return prendas.stream()
        .filter(prenda -> prenda.getTipo().getCategoria().equals(Categoria.ACCESORIO))
        .collect(Collectors.toList());
  }

  // Quinta iteracion
  public void agregarPrenda(Prenda prenda) {
    prendas.add(prenda);
  }

  public void quitarPrenda(Prenda prenda) {
    prendas.remove(prenda);
  }

}
