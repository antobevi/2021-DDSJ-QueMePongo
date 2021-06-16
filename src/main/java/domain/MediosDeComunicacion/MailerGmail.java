package domain.MediosDeComunicacion;

//import Exceptions.NoSePuedeEnviarMail;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailerGmail { // implements MailSender
  private String remitente = "@gmail.com";
  private String clave = "claveMail214&";

  public void notificar() { // Mail mail por param

    //Establecemos la conexión a gmail
    Properties propiedad = new Properties();
    propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
    propiedad.setProperty("mail.smtp.port", "587");
    propiedad.setProperty("mail.smtp.auth", "true");
    propiedad.setProperty("mail.smtp.starttls.enable", "true");
    propiedad.setProperty("mail.smtp.user", this.remitente);
    propiedad.setProperty("mail.smtp.clave", this.clave);
    propiedad.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

    Session session = Session.getDefaultInstance(propiedad);
    MimeMessage mensaje = new MimeMessage(session);

    try {
      //mensaje.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(mail.getDestinatario())));
      //mensaje.setSubject(mail.getAsunto());
      //mensaje.setText(mail.getCuerpoDelMensaje());
      Transport transport = session.getTransport("smtp");
      transport.connect("smtp.gmail.com", remitente, clave);
      transport.sendMessage(mensaje, mensaje.getAllRecipients());
      transport.close();
    } catch (Exception e) {
      e.printStackTrace();
      //throw new NoSePuedeEnviarMailException("No se pudo realizar el envío del mail");
    }
  }

}
