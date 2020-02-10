import java.io.IOException;
import java.io.Writer;
import java.net.SocketException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient.AUTH_METHOD;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class ClienteSMTP {

	public static void main(String[] args) {
		
		//Se crea un cliente SMTP seguro
		AuthenticatingSMTPClient cliente = new AuthenticatingSMTPClient();
		
		//datos del usuario y del servidor
		String servidor="smtp.gmail.com";
		String usuario="psp2dam@gmail.com"; // en este ejemplo usamos una cuenta gmail
		String pwd="xxxxx";
		int puerto=587;
		
		int respuesta;
		//Creación de una clave para establecer un canal serguro
		try {
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(null, null);
			KeyManager km = kmf.getKeyManagers()[0];
			cliente.connect(servidor, puerto);
			System.out.println("1 - "+cliente.getReplyString());
			//se establece la clave para la comunicaci�n segura
			cliente.setKeyManager(km);
			
			respuesta = cliente.getReplyCode();
			if(!SMTPReply.isPositiveCompletion(respuesta)) {
				cliente.disconnect();
				System.out.println("CONEXIÓN RECHAZADA");
				System.exit(1);
			}
			
			//se env�a el comando EHLO
			cliente.ehlo(servidor);//necesario
			
			System.out.println("2 - "+cliente.getReplyString());
			
			//Se ejecuta el comando STARTTLS y se comprueba si es true
			if(cliente.execTLS()) {
				System.out.println("3-"+cliente.getReplyString());
				//se realiza la autentificaci�n con el servidor
				if(cliente.auth(AUTH_METHOD.PLAIN, usuario, pwd))
				{
					System.out.println("4 -"+cliente.getReplyCode());
					String destino="XXXXXX@gmail.com"; 
					String asunto="prueba envío de email";
					String mensaje="Seguro que esto se env�a bien!!!";
					
					//Se crea la cabecera
					SimpleSMTPHeader cabecera = new SimpleSMTPHeader(usuario, destino, asunto);
					
					//el nombre de usuario y el email de origen coinciden 
					cliente.setSender(usuario);
					cliente.addRecipient(destino);
					System.out.println("5 -"+cliente.getReplyString());
					
					//Se envia DATA
					Writer escritor = cliente.sendMessageData();
					if(escritor==null) {
						System.out.println("FALLO AL ENVIAR DATA");
						System.exit(1);
					}
					escritor.write(cabecera.toString());
					escritor.write(mensaje);
					escritor.close();
					System.out.println("6 - "+cliente.getReplyCode());
					
					boolean exito = cliente.completePendingCommand();
					System.out.println("7 -"+ cliente.getReplyCode());
					
					if(!exito) { //fallo
						System.out.println("FALLO AL FINALIZAR TRANSACCI�N");
						System.exit(1);
					}
					
					
				}else // else del m�todo auth
					System.out.println("USUARIO NO AUTENTIFICADO");
			}else //else del m�todo execTLS
				System.out.println("FALLO AL EJECUTAR STARTTLS");
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			cliente.disconnect();
		}catch (IOException e) {
			// TODO: handle exception
		}
		
		System.out.println("Fin del env�o");
		System.exit(0);
		

	} // fin main

} //fin ClienteSMTP
