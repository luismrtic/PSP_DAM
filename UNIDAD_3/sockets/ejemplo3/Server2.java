package ejemplos.ejemplo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

	
	public static final int PUERTO=8080;
	
	public static void main(String[] args) throws IOException{
		
		//Se crear el Socket servidor para escuchar las peticiones de conexi�n de los clientes
		ServerSocket server = new ServerSocket(PUERTO);
		
		Socket socket =null;
	    /**
	     * �Por qu� creamos esta variable de tipo Socket?
	     * En esta variable se crear� el Socket que se necesitar� para comunicarse con el cliente.
	     * Una vez establecida la conexi�n con el cliente a trav�s de la aceptaci�n de la petici�n con 
	     * ServerSocket, se debe tener por cada cliente un Socket para poder realizar la comunicaci�n con �l
	     **/
		 
		System.out.println("Servidor arrancado!!!"+ server);
		
		
		try {
			//Bloqueado hasta que suceda una conexi�n
			socket=server.accept();
			System.out.println("Conexi�n aceptada:"+ socket);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//La salida se puede generar por un PrintWriter
			PrintWriter salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			
			while(true) {
				String cadena=entrada.readLine();
				if("FINAL".equals(cadena)) {
					break;
				}
				System.out.println("Imprimimos la entrada:"+cadena);
				salida.println(cadena);
			}
		}finally {
			System.out.println("Cerrando...");
			socket.close();
			server.close();
		}
		
		/**
		 * Con el bloque finally nos garantizamos que se cierran los sockets pase lo que pase.
		 * */
		
		
		
		
	}
}
