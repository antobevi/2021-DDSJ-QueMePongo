package domain.MediosDeComunicacion;

import java.util.ArrayList;
import java.util.List;

public class MailSender implements MedioDeComunicacion {
  // TODO: Le agrego una lista de mails a enviar para poder cumplir con el requerimiento de la iteracion 6:
  // TODO: enviarle al usuario un mail cada vez que se produzca una alerta metereologica.
  List<Mail> mailsAEnviar;

  public MailSender() {
    this.mailsAEnviar = new ArrayList<>();
  }

  public void agregarMailAEnviar(Mail mail) {
    mailsAEnviar.add(mail);
  }

  public void enviar() { // metodo polimorfico a todos los medios de comunicacion disponibles
    mailsAEnviar.stream().forEach(mail -> this.enviarMail(mail));
  }

  void enviarMail(Mail mail) {
    /*
    try {
      // Propiedades de la conexión
      Properties props = new Properties();
      props.setProperty("mail.smtp.host", "smtp.gmail.com");
      props.setProperty("mail.smtp.starttls.enable", "true");
      props.setProperty("mail.smtp.port", "587");
      props.setProperty("mail.smtp.user", "chuidiang@gmail.com");
      props.setProperty("mail.smtp.auth", "true");

      // Preparamos la sesion
      Session session = Session.getDefaultInstance(props);

      // Construimos el mensaje
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress("yo@yo.com"));
      message.addRecipient(
          Message.RecipientType.TO,
          new InternetAddress("chuidiang@gmail.com"));
      message.setSubject("Hola");
      message.setText("Mensaje con Java Mail");

      // Lo enviamos.
      Transport t = session.getTransport("smtp");
      t.connect("chuidiang@gmail.com", "la clave");
      t.sendMessage(message, message.getAllRecipients());

      // Cierre.
      t.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    */
  }

}
