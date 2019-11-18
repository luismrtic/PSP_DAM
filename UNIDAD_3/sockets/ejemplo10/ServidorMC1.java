package ejemplos.ejemplo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServidorMC1 {

	public static void main(String[] args) {
		
		try {
		//FLUJO PARA ENTRADA ESTANDAR
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
		
		//SE CREA EL SOCKET MULTICAST
		MulticastSocket ms = new MulticastSocket();
		int puerto = 12345; // puerto multicast
		
		//DIRECCIÓN IP DEL GRUPO. Tiene que ser de clase D
		InetAddress grupo = InetAddress.getByName("225.0.0.1");
		
		String cadena="";
		
		while(!cadena.trim().equals("*")) {
			System.out.println("Datos a enviar al grupo: ");
			cadena = in.readLine();
			//ENVIANDO AL GRUPO
			DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(),grupo,puerto);
			
			ms.send(paquete);
		}
		
		ms.close(); //se cierra sockets
		System.out.println("Socket cerrado...");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
