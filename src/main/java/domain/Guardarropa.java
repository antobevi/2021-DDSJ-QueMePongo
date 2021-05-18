package domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Guardarropa {
    private List<Atuendo> conjuntos;

    public Atuendo sugerirAtuendo() {
      Pronosticador pronosticador = Pronosticador.getInstance();
      List<Map<String, Object>> condicionesClimaticas = pronosticador.consultarCondicionesClimaticasParaBsAs();
      Double temperatura = (Double) condicionesClimaticas.get(0).get("Temperature");

      return this.atuendoParaTemperaturaAdecuada(temperatura).get(0); // Tomo el primero
    }

    public List<Atuendo> atuendoParaTemperaturaAdecuada(Double temperatura) {
      return conjuntos.stream().filter(atuendo -> this.tieneTodasPrendasAdecuadas(atuendo, temperatura)).collect(Collectors.toList());
    }

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

}
