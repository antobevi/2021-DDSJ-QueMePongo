package domain;

import domain.Exceptions.NoTieneAccesoAGuardarropa;
import domain.Prenda.Prenda;
import domain.Propuestas.Propuesta;

import java.util.List;

public class Usuario {
  private List<Guardarropa> guardarropasPropios;
  private List<Guardarropa> guardarropasCompartidos;
  private List<Propuesta> propuestasPendientes;
  private List<Propuesta> propuestasAceptadas;

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

  public void recibirPropuesta(Propuesta propuesta) {
    propuestasPendientes.add(propuesta);
  }

  public void quitarPropuesta(Propuesta propuesta) {
    propuestasPendientes.remove(propuesta);
  }

  public void deshacerPropuestaAceptada(Propuesta propuesta) {
    propuestasAceptadas.remove(propuesta);
  }

  public void aceptarPropuesta(Propuesta propuesta) {
    this.quitarPropuesta(propuesta);
    propuestasAceptadas.add(propuesta);
  }

  public void proponerModificacion(Propuesta propuesta, Usuario usuario) {
    if(comparteGuardarropaCon(usuario)) {
      usuario.recibirPropuesta(propuesta);
    } else {
      throw new NoTieneAccesoAGuardarropa("No tiene acceso a este guardarropa!");
    }
  }

  public Boolean comparteGuardarropaCon(Usuario usuario) {
    // TODO: Falta validar que la propuesta sea sobre un guardarropa que compartan ambos usuarios?
    return guardarropasCompartidos.stream().anyMatch(guardarropa -> usuario.getGuardarropasCompartidos().contains(guardarropa));
  }
}
