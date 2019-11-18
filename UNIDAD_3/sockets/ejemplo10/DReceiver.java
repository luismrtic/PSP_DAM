package ejemplos.ejemplo10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DReceiver{
  public static void main(String[] args) throws Exception {
   
	//Se crea un socket para recibir datagramas en el puerto 3000  
    DatagramSocket ds = new DatagramSocket(3000);
    //Buffer donde se almacenará lo recibido por el socket
    byte[] buf = new byte[1024];
    
    //Se crea un paquete datragrama con el buffer y la longitud del mismo
    DatagramPacket dp = new DatagramPacket(buf, 1024);
    
    //Se espera a recibir el paquete por el socket.
    ds.receive(dp);
    
    //Los datos recibidos se pasan a cadena.
    String strRecv = new String(dp.getData(), 0, dp.getLength());
    
    System.out.println(strRecv);
    
    //Se cierra el socket
    ds.close();
  }
}
