package ejemplos.ejemplo10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DSender{
  public static void main(String[] args) throws Exception {
	  
	//Se crea un datagrama para enviar. 
	//Si no se especifida puerto en el constructor, el sistema asigna uno disponible
    DatagramSocket ds = new DatagramSocket();
    
    String str = "Hola clase de PSP!!!";
    
    //Se crea una clase para mapear la dirección IP de destino
    InetAddress ia = InetAddress.getByName("127.0.0.1");
    
    //Se crea un paquete datagrama que sirve de envoltura para enviar los datos al destino a través del socket
    DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ia, 3000);
    
    //Envío del paquete-datagrama a través del socket que se ha creado con un puerto disponible.
    ds.send(dp);
    
    //Cerramos el socket.
    ds.close();
  }
}
