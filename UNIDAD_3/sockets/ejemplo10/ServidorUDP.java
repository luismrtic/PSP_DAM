package ejemplos.ejemplo10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


/**
 *
 * Simulación de un echo
 */
public class ServidorUDP {

	  public static void main (String args[]) {

	    try {

	     //Creamos un Socket UDP con el puerto 6789
	      DatagramSocket socketUDP = new DatagramSocket(6789);
	      //Se necesita un buffer de bytes para enviar los datos.
	      byte[] bufer = new byte[1000];

	      while (true) {
	        // Construimos el DatagramPacket para recibir peticiones
	        DatagramPacket peticion =new DatagramPacket(bufer, bufer.length);

	        // Leemos una petición del DatagramSocket
	        socketUDP.receive(peticion);

	        System.out.print("Datagrama recibido del host: " +peticion.getAddress());
	        System.out.println("Desde el puerto remoto: " + peticion.getPort());

	        // Construimos el DatagramPacket para enviar la respuesta
	        // Para ello hacemos uso de los datos que han venido con la petición.
	        // Lo datos más importantes son la dirección y el puerto
	        DatagramPacket respuesta =new DatagramPacket(peticion.getData(), peticion.getLength(),
	                             peticion.getAddress(), peticion.getPort());

	        // Enviamos la respuesta, con ello lo que hacemos es un eco
	        socketUDP.send(respuesta);
	        
	        socketUDP.close();
	      }

	    } catch (SocketException e) {
	      System.out.println("Socket: " + e.getMessage());
	    } catch (IOException e) {
	      System.out.println("IO: " + e.getMessage());
	    }
	  }

	}
