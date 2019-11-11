package ejemplos.ejemplo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client 
{
    public static void main(String[] args) throws IOException 
    {
        try
        {
            Scanner scn = new Scanner(System.in);
              
            // Obtenemos la dirección de sockets
            InetAddress ip = InetAddress.getByName("localhost");
      
            // Establecemos la comunicación con el puerto 7777
            Socket s = new Socket(ip, 7777);
      
            // Obtenemos los input y out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
      
            // El siguiente bucle ejecuta el intercambio de 
            // información entre el cliente y el manejador de cliente
            while (true) 
            {
                System.out.println(dis.readUTF());
                String cadena = scn.nextLine();
                dos.writeUTF(cadena);
                  
                // Si el cliente envía exit, la conexión se cierra 
                // y después salimos del bucle con break
                if(cadena.equals("Exit"))
                {
                    System.out.println("Cerramos la conexión : " + s);
                    s.close();
                    System.out.println("Conexión cerrada");
                    break;
                }
                  
                // Imprimimos la fecha o la hora pedida por el cliente
                String respuesta = dis.readUTF();
                System.out.println(respuesta);
            }
              
            // cerramos los recursos
            scn.close();
            dis.close();
            dos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
