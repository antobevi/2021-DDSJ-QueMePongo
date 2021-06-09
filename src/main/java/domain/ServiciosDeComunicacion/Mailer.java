package domain.ServiciosDeComunicacion;

public interface Mailer {
  void enviarMail(Mail mail);
  /*
  void enviarMail(Mail mail) {
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
  }
  */
}
