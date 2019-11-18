package ejemplos.ejemplo10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ClienteMC1 {

public static void main(String[] args) {
		
	try {
		//Se crea el socket muticast
		int puerto= 12345;
		MulticastSocket ms = new MulticastSocket(puerto);
		
		//DIRECCIÓN IP DEL GRUPO. Debe ser de clase D
		InetAddress grupo = InetAddress.getByName("225.0.0.1"); 
		
		//Nos unimos al grupo
		ms.joinGroup(grupo);
		
		String mensaje = "";
		//Buffer para recibir los datos a través del socket datagrama
		byte [] bufer = new byte[1000];
		
		while(!mensaje.trim().equals("*")){
			//Recibe el paquete del servidor multicast
			DatagramPacket paquete = new DatagramPacket(bufer,bufer.length);
			ms.receive(paquete);
			mensaje = new String(paquete.getData());
			System.out.println("Recibido:"+mensaje.trim());
		}
		
		ms.leaveGroup(grupo); //abandonamos el grupo
		ms.close(); 
		System.out.println("Socket cerrado...");
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
