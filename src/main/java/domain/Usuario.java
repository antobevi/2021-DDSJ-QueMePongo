package domain;

import domain.Prenda.Prenda;
import domain.Propuestas.Propuesta;

import java.util.List;

public class Usuario {
  private List<Guardarropa> guardarropas;
  private List<Propuesta> propuestasPendientes;
  private List<Propuesta> propuestasAceptadas; // Elijo tener una lista porque necesito sacarla de pendientes y guardarla en algun lado

  public void crearGuardarropaCompartido(Usuario usuario, List<Prenda> prendas) {
    Guardarropa nuevoGuardarropa = new Guardarropa(prendas);
    this.compartirGuardarropaCon(usuario, nuevoGuardarropa);
    this.agregarGuardarropa(nuevoGuardarropa);
  }

  public void agregarGuardarropa(Guardarropa guardarropa) {
    guardarropas.add(guardarropa);
  }

  public void compartirGuardarropaCon(Usuario usuario, Guardarropa guardarropa) {
    usuario.agregarGuardarropa(guardarropa);
  }

  public void recibirPropuesta(Propuesta propuesta) {
    propuestasPendientes.add(propuesta);
  }

  public void quitarPropuestaPendiente(Propuesta propuesta) {
    propuestasPendientes.remove(propuesta);
  }

  public void rechazarPropuesta(Propuesta propuesta) {
    propuestasPendientes.remove(propuesta);
    // TODO: ¿Se agrega a alguna lista? Si no, repite logica
  }

  public void deshacerPropuestaAceptada(Propuesta propuesta) {
    propuestasAceptadas.remove(propuesta);
  }

  public void aceptarPropuesta(Propuesta propuesta) {
    this.quitarPropuestaPendiente(propuesta);
    propuestasAceptadas.add(propuesta);
  }

  public void proponerModificacion(Propuesta propuesta, Usuario usuario) {
    usuario.recibirPropuesta(propuesta);
  }
}
