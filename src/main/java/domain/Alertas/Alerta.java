package domain.Alertas;

import domain.MediosDeComunicacion.Mail;
import domain.MediosDeComunicacion.MailSender;
import domain.MediosDeComunicacion.MedioDeComunicacion;
import domain.MediosDeComunicacion.NotificationService;
import domain.Usuario;

import java.util.ArrayList;
import java.util.List;

public abstract class Alerta {
  List<MedioDeComunicacion> notificadores;

  public Alerta() {
    this.notificadores = new ArrayList<>();
  }

  protected void setearNotificador(Usuario usuario) {
    MailSender mailer = new MailSender();
    Mail mail = new Mail(usuario.getEmail(), "Nueva alerta metereologica", this.getMensajeAlerta());

    mailer.agregarMailAEnviar(mail); // TODO: El Mailer en realidad no tiene como atributo una lista de mails, ver otra forma de encararlo polimorficamente!

    notificadores.add(mailer);
  }

  protected abstract String getMensajeAlerta();
  public abstract void notificar(Usuario usuario);

}

