package ejemplos.ejemplo11;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/***
 * El servidor recibe una datagrama con unos datos y se imprime por pantalla dichos datos además
 * de otros datos de la conexión sockets.
 */
public class ServidorUDPRecibirObjeto {

	public static void main(String[] args) {
		
	      
		byte[] bufer =  new byte[1024]; //buffer para recibir el datagrama
		
		
		try {
			
			
			//SE ASOCIA EL SOCKET AL PUERTO 12345
			DatagramSocket socket = new DatagramSocket(12345);
			
			//ESPERANDO DATAGRAMA
			System.out.println("Esperando Datagrama......");
			//Se crea un paquete-datagrama.
			//Como se va a usar para recibir, solo se necesita indicar el buffer donde almacenar los datos
			//de la petición y la longitud del mismo.
			DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
			
			//SE RECIBE EL DATAGRAMA
			socket.receive(recibo); 
			
			//CONVERTIMOS BYTES A OBJETO ****************************************
			  ByteArrayInputStream bais =  new ByteArrayInputStream(bufer);
		      ObjectInputStream in = new ObjectInputStream(bais);
		      Persona persona = (Persona) in.readObject(); //obtener el objeto
		    //********************************************************************
		      
		      
		      in.close();
			
			
			//VISUALIZO INFORMACIÓN
			System.out.println("Nombre: "+persona.getNombre());
			System.out.println("Edad: "+persona.getEdad());
		
			socket.close(); // cierro el socket
			
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
