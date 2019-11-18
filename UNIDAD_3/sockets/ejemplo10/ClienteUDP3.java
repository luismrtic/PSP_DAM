package ejemplos.ejemplo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * El cliente enviar� una cadena el servidor y recibir� la misma en may�sculas
 *
 */
public class ClienteUDP3 {

public static void main(String[] args) {
		
		try {
			
			//FLUJO PARA ENTRADA EST�NDAR
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			//SOCKET CLIENTE
			DatagramSocket clientesocket = new DatagramSocket(); //EL SISTEMA LE ASIGNA UN PUERTO LIBRE
			
			//Se crean los buffer para poder almacenar los datos que se env�a y que se reciben.
			byte [] enviados=new byte[1024];
			byte [] recibidos=new byte[1024];
			
			//DATOS DEL SERVIDOR al que enviar mensaje
			InetAddress IPServidor = InetAddress.getLocalHost(); // localhost
			int puerto = 9876; //puerto por el que se escucha

			//INTRODUCIR DATOS POR TECLADO
			System.out.println("Introduce mensaje:");
			
			String cadena=in.readLine();
			enviados =  cadena.getBytes(); // se codifica Strig a bytes
			
			//ENVIANDO DATAGRAM AL SERVIDOR
			System.out.println("Enviando "+enviados.length + " bytes al servidor");
			
			DatagramPacket envio = new DatagramPacket(enviados, enviados.length,IPServidor,puerto);
			
			clientesocket.send(envio);
			
			//RECIBIENDO DATAGRAMA DEL SERVIDOR
			DatagramPacket recibo = new DatagramPacket(recibidos,recibidos.length);
			
			System.out.println("Esperando datagrama....");
			
			clientesocket.receive(recibo);
			
			String mayusculas =  new String(recibo.getData());
			
			//OBTENIENDO INFORMACI�N DEL DATAGRAMA
			InetAddress IPOrigen = recibo.getAddress();
			int puertoOrigen = recibo.getPort();
			System.out.println("\tProcedente de:"+IPOrigen+":"+puertoOrigen);
			System.out.println("\tDatos: "+mayusculas.trim());
	
			//CERRAR SOCKET 
			clientesocket.close();
			
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
