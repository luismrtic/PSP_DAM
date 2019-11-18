package ejemplos.ejemplo10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * El servidor va a recibir una cadena y devolverá al cliente la misma cadena en mayúsculas.
 *
 */
public class ServidorUDP3 {

	public static void main(String[] args) {
		
		try {
		//Se crea un Socket Datagrama para recibir peticiones.
	    //Puerto por el que escucha el servidor: 9876
		DatagramSocket serversocket = new DatagramSocket(9876);
		
		//Se crean los buffer de escritura/lectura de los datos
		byte [] enviados=new byte[1024];
		byte [] recibidos=new byte[1024];
		String cadena;
		
		
			while(true) {
				System.out.println("Esperando datagrama....");
				//RECIBO DATAGRAMA
				recibidos = new byte[1024];
				//Paquete datagrama donde se recibirán los datos. Para ello se hace uso derl buffer.
				DatagramPacket paqueteRecibido = new DatagramPacket(recibidos, recibidos.length);
				
				//SE RECIBEN LOS DATOS
				serversocket.receive(paqueteRecibido);
				 
				//Se pasan los bytes de los datos a cadena
				cadena = new String(paqueteRecibido.getData());
				
				//Recuperamos la información de Socket Cliente u origen de la petición
				//DIRECCION ORIGEN
				InetAddress IPOrigen = paqueteRecibido.getAddress();
				//PUERTO ORIGEN
				int puerto =  paqueteRecibido.getPort();
				System.out.println("\tOrigen: "+IPOrigen+":"+puerto);
				System.out.println("\tMensaje recibido: "+cadena.trim());
				
				//SERVICIO QUE SE LE DA A CLIENTE_CONVERTIR CADENA A MAYÚSCULAS
				//Aquí es donde vendrá la función que se encargue de la lógica de negocio del servicio ofrecido
				String mayuscula = cadena.trim().toUpperCase();
				
				//Hacemos uso del buffer de escritura para poder enviar los datos en un DatagramPacket
				enviados =  mayuscula.getBytes();
				
				//ENVIO DATAGRAMA AL CLIENTE
				//Se crea un DatagramPacket con:
				// -datos que se quieren enviar (buffer)
				// -longitud de los datos.
				// -Dirección IP de destino. Se hace uso de un InetAddress
				// -Puerto de destino
				DatagramPacket paqueteEnviado = new DatagramPacket(enviados,enviados.length,IPOrigen,puerto);
		
				//SE ENVÍAN LOS DATOS a través del Socket UDP que se creó
				serversocket.send(paqueteEnviado);
				
				//Para terminar. En caso de que se dectecte un * se para la ejecución (el servicio)
				if(cadena.trim().equals("*"))break;
						
						
			  } // FIN WHILE
			
			//Cerramos el socket, que no se olvide!!!!
			serversocket.close();
			
			System.out.println("Socket cerrado....");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
