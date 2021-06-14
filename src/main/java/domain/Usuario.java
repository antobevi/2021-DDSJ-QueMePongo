package domain;

import domain.Exceptions.NoTieneAccesoAGuardarropa;
import domain.Prenda.Prenda;
import domain.Sugerencias.Estado;
import domain.Sugerencias.Sugerencia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
  private List<Guardarropa> guardarropasPropios = new ArrayList<>();
  private List<Guardarropa> guardarropasCompartidos = new ArrayList<>();
  private List<Sugerencia> sugerencias = new ArrayList<>();

  public void crearGuardarropaCompartido(Usuario usuario, List<Prenda> prendas) {
    Guardarropa nuevoGuardarropa = new Guardarropa(prendas);
    this.compartirGuardarropaCon(usuario, nuevoGuardarropa);
  }

  public void compartirGuardarropaCon(Usuario usuario, Guardarropa guardarropa) {
    usuario.agregarGuardarropaCompartido(guardarropa);
  }

  public List<Guardarropa> getGuardarropasPropios() {
    return guardarropasPropios;
  }

  public List<Guardarropa> getGuardarropasCompartidos() {
    return guardarropasCompartidos;
  }

  public void agregarGuardarropaPropio(Guardarropa guardarropa) {
    guardarropasPropios.add(guardarropa);
  }

  public void agregarGuardarropaCompartido(Guardarropa guardarropa) {
    guardarropasCompartidos.add(guardarropa);
  }

  public List<Sugerencia> getSugerenciasPendientes() {
    return sugerencias.stream().filter(sugerencia -> sugerencia.getEstado().equals(Estado.PENDIENTE))
        .collect(Collectors.toList());
  }

  public List<Sugerencia> getSugerenciasAceptadas() {
    return sugerencias.stream().filter(sugerencia -> sugerencia.getEstado().equals(Estado.ACEPTADA))
        .collect(Collectors.toList());
  }

  public List<Sugerencia> getSugerenciasRechazadas() {
    return sugerencias.stream().filter(sugerencia -> sugerencia.getEstado().equals(Estado.RECHAZADA))
        .collect(Collectors.toList());
  }

  public void recibirPropuesta(Sugerencia sugerencia) {
    sugerencias.add(sugerencia);
  }

  public void sugerirModificacion(Sugerencia sugerencia, Usuario usuario) {
    if(guardarropasCompartidosCon(usuario).contains(sugerencia.getGuardarropa())) {
      usuario.recibirPropuesta(sugerencia);
    } else {
      throw new NoTieneAccesoAGuardarropa("No tiene acceso a este guardarropa!");
    }
  }

  public List<Guardarropa> guardarropasCompartidosCon(Usuario usuario) {
    return guardarropasCompartidos.stream()
        .filter(guardarropa -> usuario.getGuardarropasCompartidos().contains(guardarropa))
        .collect(Collectors.toList());
  }
}
