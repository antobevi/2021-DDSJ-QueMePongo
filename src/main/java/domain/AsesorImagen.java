package domain;

import ServiciosDelClima.ProveedorClima;
import domain.Guardarropas.Guardarropa;

import java.util.List;

public class AsesorImagen {
  private ProveedorClima servicioClimatico;

  public AsesorImagen(ProveedorClima servicioClimatico) {
    this.servicioClimatico = servicioClimatico;
  }

  public Atuendo sugerirAtuendo(Guardarropa guardarropa, String ciudad) {
    Integer temperatura = servicioClimatico.consultarTemperaturaPara(ciudad);

    return this.atuendoParaTemperaturaAdecuada(temperatura, guardarropa);
  }
    public Atuendo atuendoParaTemperaturaAdecuada(Integer temperatura, Guardarropa guardarropa) {
      return this.atuendosPosibles(guardarropa).stream().filter(atuendo -> atuendo.esAdecuadoPara(temperatura))
          .first();
    }

    public List<Atuendo> atuendosPosibles(Guardarropa guardarropa) {
    // TODO:
    return null;
    }

  /*
    // Por cada atuendo filtro los que tienen todas sus prendas adecuadas para la temperatura actual.
    public List<Atuendo> atuendosAdecuados(Double temperatura) {
      return atuendoParaTemperaturaAdecuada(temperatura).stream()
          .filter(atuendo -> this.tieneTodasPrendasAdecuadas(atuendo, temperatura)).collect(Collectors.toList());
    }

    // Verifico si para dicho atuendo todas las temperaturas estan acordes con la temperatura del dia.
    public boolean tieneTodasPrendasAdecuadas(Atuendo atuendo, Double temperatura) {
      return this.temperaturasSegunPrendas(atuendo).stream()
        .allMatch(unaTemperatura -> unaTemperatura.esAdecuada(temperatura));
    }

    // Tomo las temperaturas de cada prenda de un atuendo.
    public List<Temperatura> temperaturasSegunPrendas(Atuendo atuendo) {
      return atuendo.getPrendas().stream().map(prenda -> prenda.getTemperaturaAdecuada()).collect(Collectors.toList());
    }

    // Filtro los atuendos con 1 prenda por categoria.
    public List<Atuendo> atuendosConUnaPrendaPorCategoria() {
     return conjuntos.stream().filter(atuendo -> atuendo.tiene1PrendaPorCategoria()).collect(Collectors.toList());
    }
  */
}
