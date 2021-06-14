package domain.Sugerencias;

import domain.Guardarropa;

// Command
public abstract class Sugerencia {
  public Guardarropa guardarropa;
  public Estado estado;

  public Sugerencia(Guardarropa guardarropa) {
    this.guardarropa = guardarropa;
    this.estado = Estado.PENDIENTE;
  }

  public Guardarropa getGuardarropa() { return guardarropa; }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  public void aceptar() {
    this.setEstado(Estado.ACEPTADA);
    this.aceptarSugerencia();
  }

  public void deshacer() {
    this.rechazar(); // TODO: Preguntar si al deshacer se rechaza o se pone como pendiente de nuevo
    this.deshacerSugerencia();
  }

  public void rechazar() {
    setEstado(Estado.RECHAZADA);
  }

  public abstract void aceptarSugerencia();

  public abstract void deshacerSugerencia();
}
