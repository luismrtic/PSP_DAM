package ejemplos.ejemplo11;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Se envia unos datos (texto) a trav�s del datagrama utilizando un socket UDP
 *
 */
public class ClienteUDPEnvioObjeto {

	public static void main(String[] args) {
		
		try {
			
			
		      //CONVERTIMOS OBJETO A BYTES ****************************
			  Persona persona = new Persona("Maria",22);
		      ByteArrayOutputStream bs =  new ByteArrayOutputStream();
		      ObjectOutputStream out = new ObjectOutputStream(bs);
		      
		      out.writeObject(persona); //escribir objeto Persona en el stream

		      //Para almacenar los datos que se envian a trav�s del socket se utiliza un buffer
		      byte[] mensaje = bs.toByteArray(); //objeto en bytes
		      
		      out.close(); //cerrar el stream
		      
		      //******************************************************
			
			//Siempre que se quiera mandar un datagrama a trav�s de un socket UDP se debe de saber 
			//la direcci�n y el puerto de destino
			InetAddress destino = InetAddress.getLocalHost();
			int port = 12345; //puerto al que envio el datagrama
			
			
			//CONSTRUYO EL DATAGRAMA E ENVIAR
			//Se debe indicar:
			// - objeto en bytes
			// - longitud del array que contiene el objeto en bytes
			// - direcci�n ip de destino. Se utiliza un objeto InetAddress
			// - puerto del destino. 
			DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length,destino,port);
			
			//Para poder enviar un datagrama se debe usar un DatagramSocket asign�ndole un puerto.
			//Si no se asigna un puerto el sistema elegir� uno aleatoriamente de los disponible.
			DatagramSocket socket = new DatagramSocket(34567);
			
			//VISUALIZO INFORMACI�N
			System.out.println("Enviando datagrama de longitud: "+mensaje.length);
			System.out.println("Host de destino: "+destino.getHostName());
			System.out.println("IP destino: "+destino.getHostAddress());
			System.out.println("Puerto local del socket: "+socket.getLocalPort());
			System.out.println("Puerto al que envio: "+envio.getPort());
			
			//ENVIO DATAGRAMA usando el DatagramPacket
			socket.send(envio);
			
			//MUY IMPORTANTE!!! Hay que cerrar el socket siempre que se deja de utilizar.
			socket.close();
			
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
