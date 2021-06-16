package domain.Notificadores;

import domain.Usuario;

import java.util.List;

// En el Patron Observer es el observador, el que espera que le avisen de un evento.
public interface Notificador {

  void enviar(List<String> alertas, Usuario usuario);

}
