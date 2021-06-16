package domain.Repositorios;

import domain.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {
  private static final RepositorioUsuarios instance = new RepositorioUsuarios();
  private final List<Usuario> usuarios;

  private RepositorioUsuarios() {
    this.usuarios = new ArrayList<>();
  }

  public static RepositorioUsuarios getInstance() {
      return instance;
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }
}
