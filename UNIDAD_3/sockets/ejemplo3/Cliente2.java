package ejemplos.ejemplo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente2 {
	
	public static void main(String[] args) throws IOException{
		
	
		InetAddress direccion = InetAddress.getByName(null);
		/**
		 * �Por qu� hemos pasado null a getByName? F�cil, el m�todo getByName al recibir null,
		 * genera el valor de direcci�n local, es decir...localhost.
		 */
		
		
		// Otras formas de poder hacer una direcci�n local
		// InetAddress direccion = InetAddress.getByName("127.0.0.1");
		//InetAddress direccion = InetAddress.getByName("localhost");
		
		System.out.println("Direcci�n:"+direccion);
		
        //Vamos a crear el socket con la direcci�n y puerto establecido en el servidor
		Socket socket = new Socket(direccion,Server2.PUERTO);
		 
		try {
			
		 System.out.println("Socket:"+socket);
		 
		 BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		 PrintWriter salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			
		 for(int i=0;i<10;i++) {
			 salida.println("Mensaje "+i);
			 String cadena = entrada.readLine();
			 System.out.println(cadena);
		 }
		 
		 
		 salida.println("FINAL");
		 /*Intenta con usar salida.print("FINAL")...
		  * Ejecuta otra vez los sockets�qu� ha pasado?*/
		 
		}finally {
			System.out.println("Cerrando...");
			socket.close();
		}
		
		
		
	}

}
