package ejemplos.ejemplo10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Se envia unos datos (texto) a través del datagrama utilizando un socket UDP
 *
 */
public class ClienteUDP2 {

	public static void main(String[] args) {
		
		try {
			
			//Siempre que se quiera mandar un datagrama a través de un socket UDP se debe de saber 
			//la dirección y el puerto de destino
			InetAddress destino = InetAddress.getLocalHost();
			int port = 12345; //puerto al que envio el datagrama
			
			//Para almacenar los datos que se reciben a través del socket se utiliza un buffer
			byte [] mensaje=new byte[1024];
			
			String saludo="Enviando datos al Servidor!!!!";
			mensaje =  saludo.getBytes(); // se codifica Strig a bytes
			
			//CONSTRUYO EL DATAGRAMA E ENVIAR
			//Se debe indicar:
			// - mensaje en bytes
			// - longitud de ese mensaje
			// - dirección ip de destino. Se utiliza un objeto InetAddress
			// - puerto del destino. 
			DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length,destino,port);
			
			//Para poder enviar un datagrama se debe usar un DatagramSocket asignándole un puerto.
			//Si no se asigna un puerto el sistema elegirá uno aleatoriamente de los disponible.
			DatagramSocket socket = new DatagramSocket(34567);
			
			//VISUALIZO INFORMACIÓN
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
