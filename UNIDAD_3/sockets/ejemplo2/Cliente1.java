package ejemplos.ejemplo2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class Cliente1 {
	
	public static void main(String []args) throws Exception{
		
		
		String host="localhost";
		int puerto = 6000;
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		
		Socket cliente = new Socket(host,puerto);
		
		//CREAR FLUJO DE SALIDA AL SERVIDOR
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
		
		//ENVIAR UN SALUDO AL SERVIDOR
	    flujoSalida.writeUTF("Saludos al servidor desde el cliente");
	    
	    //CREAR FLUJO DE ENTRADA AL SERVIDOR
	    DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
	    
	    //EL SERVIDOR ENVIA UN MENSAJE
	    System.out.println("Recibiendo del servidor: \n\t"+flujoEntrada.readUTF());
	    
	    //CERRAR STREAMS Y SOCKETS
	    flujoEntrada.close();
	    flujoSalida.close();
	    cliente.close();
	
		
		
	}

}
