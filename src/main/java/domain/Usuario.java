package domain;

import domain.Notificadores.Notificador;
import domain.Alertas.Alerta;
import domain.Exceptions.NoTieneAccesoAGuardarropa;
import domain.Prenda.Prenda;
import domain.Sugerencias.Estado;
import domain.Sugerencias.Sugerencia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// En el Patron Observer es un interesado
public class Usuario {
  private String email;
  private List<Guardarropa> guardarropasPropios = new ArrayList<>();
  private List<Guardarropa> guardarropasCompartidos = new ArrayList<>();
  private List<Sugerencia> sugerencias = new ArrayList<>();
  /*  Iteracion 5
  private List<Sugerencia> sugerenciasPendientes = new ArrayList<>();
  private List<Sugerencia> sugerenciasAceptadas = new ArrayList<>();
  private List<Sugerencia> sugerenciasRechazadas = new ArrayList<>();
  */
  private List<Atuendo> sugerenciasAtuendos = new ArrayList<>(); // Asumo que la sugerencia del dia es un atuendo por guardarropa propio
  private List<Notificador> notificablesPreferentes; // Tipos de notificaciones o acciones a las que se suscribio el usuario

  public String getEmail() {
    return email;
  }

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

  /* Iteracion 5
  public void aceptarSugerencia(Sugerencia sugerencia) {
    sugerencia.aceptar();
    sugerenciasAceptadas.add(sugerencia);
  }

  public void rechazarSugerencia(Sugerencia sugerencia) {
    sugerencia.rechazar();
    sugerenciasRechazadas.add(sugerencia);
  }

  public void deshacerSugerencia(Sugerencia sugerencia) {
    sugerencia.deshacer();
    sugerenciasAceptadas.remove(sugerencia);
  }
  */

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

  public void haySugerenciaNueva() {
    // Recibe una sugerencia por cada guardarropa.
    List<Atuendo> sugerencias = guardarropasPropios.stream().map(guardarropa -> ((AsesorImagen) ServiceLocator.getInstance()
        .get(AsesorImagen.class)).sugerirAtuendo(guardarropa, "Buenos Aires")).collect(Collectors.toList());

    sugerenciasAtuendos.clear();
    sugerenciasAtuendos.addAll(sugerencias);
  }

  // El proveedor del clima cuando hay nuevas alertas le avisa al usuario
  // y el usuario "pide" que le envien las notificaciones a las que se suscribio
  public void hayAlertasNuevas(List<Alerta> alertas) {
    // Cuando el proveedor de clima actualiza las alertas debe actualizarse la sugerencia diaria
    notificablesPreferentes.forEach(notificable -> notificable.enviar(alertas, this));
  }

}
