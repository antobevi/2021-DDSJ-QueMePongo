package domain;

import domain.constants.Categoria;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Atuendo {
  private List<Prenda> prendas;

  public Atuendo(List<Prenda> prendas) {
    // TODO: Falta validar
    this.prendas = Objects.requireNonNull(prendas, "No puede crearse un atuendo sin prendas");
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }

  public List<Categoria> categoriasDeLasPrendas() {
    return prendas.stream().map(prenda -> prenda.getTipo().getCategoria()).collect(Collectors.toList());
  }

  public int cantidadPrendasPorCategoria(Categoria categoria) {
    return this.categoriasDeLasPrendas().stream()
        .filter(unaCategoria -> unaCategoria.equals(categoria))
        .collect(Collectors.toList()).size();
  }

  public boolean tiene1PrendaPorCategoria() {
    List<Categoria> categoriasObligatorias = Arrays.asList(Categoria.PARTE_SUPERIOR, Categoria.PARTE_INFERIOR,
        Categoria.ACCESORIO, Categoria.CALZADO);

    return categoriasObligatorias.stream().allMatch(categoria -> this.cantidadPrendasPorCategoria(categoria) == 1);
  }
}
