package ejemplos.ejemplo10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/***
 * El servidor recibe una datagrama con unos datos y se imprime por pantalla dichos datos adem�s
 * de otros datos de la conexi�n sockets.
 */
public class ServidorUDP2 {

	public static void main(String[] args) {
		
		byte[] bufer =  new byte[1024]; //buffer para recibir el datagrama
		
		
		try {
			//SE ASOCIA EL SOCKET AL PUERTO 12345
			DatagramSocket socket = new DatagramSocket(12345);
			
			//ESPERANDO DATAGRAMA
			System.out.println("Esperando Datagrama......");
			//Se crea un paquete-datagrama.
			//Como se va a usar para recibir, solo se necesita indicar el buffer donde almacenar los datos
			//de la petici�n y la longitud del mismo.
			DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
			
			//SE RECIBE EL DATAGRAMA
			socket.receive(recibo); 
			
			int bytesRec = recibo.getLength(); // obtengo n�mero de bytes
			
			String paquete = new String(recibo.getData()); //obtengo String
			
			//VISUALIZO INFORMACI�N
			System.out.println("N�mero de Bytes recibidos: "+bytesRec);
			System.out.println("Contenido del paquete: "+paquete.trim());
			System.out.println("Puerto origen del mensaje: "+recibo.getPort());
			System.out.println("IP de origen: "+recibo.getAddress().getHostAddress());
			System.out.println("Puerto destino del mensaje: "+socket.getLocalPort());
			
			socket.close(); // cierro el socket
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
