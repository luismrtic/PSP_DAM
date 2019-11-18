package ejemplos.ejemplo10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Simulación de un echo. Lo que envía el Cliente lo recibe otra vez del Servidor
 * */

public class ClienteUDP {

	  // Los argumentos proporcionan el mensaje y el nombre del servidor
	  public static void main(String args[]) {

	    try {
	    	
	      DatagramSocket socketUDP = new DatagramSocket();
	      
	      String texto = "Esto de los sockets es una pasada!!!";
	      
	      //El esto hay que pasarlo a bytes para poderlo pasar por el socket a través del DatagramSocket
	      byte[] mensaje = texto.getBytes();
	      
	      //Creamos un envoltorio para la dirección IP. En este caso será localhost. 
	      InetAddress hostServidor = InetAddress.getLocalHost();
	      //Se elige el puerto por donde escuchar el servicio
	      int puertoServidor = 6789;

	      // Construimos un datagrama para enviar el mensaje al servidor
	      DatagramPacket peticion =new DatagramPacket(mensaje, texto.length(), hostServidor,puertoServidor);

	      // Enviamos el datagrama
	      socketUDP.send(peticion);

	      // Construimos el DatagramPacket que contendrá la respuesta
	      byte[] bufer = new byte[1000];
	      DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);
	      socketUDP.receive(respuesta);

	      // Enviamos la respuesta del servidor a la salida estandar
	      System.out.println("Respuesta: " + new String(respuesta.getData()));

	      // Cerramos el socket
	      socketUDP.close();

	    } catch (SocketException e) {
	      System.out.println("Socket: " + e.getMessage());
	    } catch (IOException e) {
	      System.out.println("IO: " + e.getMessage());
	    }
	  }
	}