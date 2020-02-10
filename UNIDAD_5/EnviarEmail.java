import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EnviarEmail {
	
	public static void main(String[] args) {
	    String destinatario =  "xxxx@gmail.com"; //A quien le quieres escribir.
	    String asunto = "Correo de prueba enviado desde el equipo de Luis";
	    String cuerpo = "Esta es una prueba de correo desde Luis";

	    enviarConGMail(destinatario, asunto, cuerpo);
	}
	private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
	    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
	    String remitente = "psp2dam";  //Para la dirección psp2dam@gmail.com

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "xxxx");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);
	    
	    BodyPart adjunto = new MimeBodyPart();
	    MimeMultipart multiParte = new MimeMultipart();

	  

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO,destinatario );   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        
	        adjunto.setDataHandler(new DataHandler(new FileDataSource("/home/lubuntu/Descargas/archivo1.txt")));
	        adjunto.setFileName("mifichero.txt");
	        multiParte.addBodyPart(adjunto);
	        message.setContent(multiParte);
	        
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "xxxx");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}

}
