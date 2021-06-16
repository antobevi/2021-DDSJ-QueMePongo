package domain.Alertas;

import domain.MediosDeComunicacion.Mail;
import domain.MediosDeComunicacion.MailSender;
import domain.MediosDeComunicacion.MedioDeComunicacion;
import domain.MediosDeComunicacion.NotificationService;
import domain.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Alerta {
  private String mensajeAlerta;
  private TipoAlerta tipo; // Enum
  private List<MedioDeComunicacion> notificadores;

  public Alerta(String mensajeAlerta, TipoAlerta tipo) {
    this.mensajeAlerta = mensajeAlerta;
    this.tipo = tipo;
    this.notificadores = new ArrayList<>();
  }

  public TipoAlerta getTipo() {
    return tipo;
  }

  public void setearNotificadores(Usuario usuario) {
    MailSender mailer = new MailSender();
    Mail mail = new Mail(usuario.getEmail(), "Nueva alerta metereologica", mensajeAlerta);

    mailer.agregarMailAEnviar(mail); // TODO: El Mailer en realidad no tiene como atributo una lista de mails, ver otra forma de encararlo polimorficamente!

    notificadores.add(mailer);
    notificadores.add(new NotificationService(mensajeAlerta, usuario));
  }

  public void notificar(Usuario usuario) {
    this.setearNotificadores(usuario);
    notificadores.stream().forEach(notificador -> notificador.enviar());
  }

}

