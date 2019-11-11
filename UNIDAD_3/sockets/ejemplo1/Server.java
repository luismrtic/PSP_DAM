package ejemplos.ejemplo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
    public static void main(String[] args) throws IOException 
    {
        //Servidor escucha por el puerto 7777
        ServerSocket ss = new ServerSocket(7777);
        /* Existen más constructores de ServerSocket*/
          
        // Bucle infinito para estar recibiendo continuamente las peticiones de los clientes.
        while (true) 
        {
            Socket s = null;
              
            try 
            {
                // El objeto socket recibe las peticiones entrantes de los clientes
                s = ss.accept();
                  
                System.out.println("Un nuevo cliente se ha conectado : " + s);
                  
                //Obtenemos los in y out streams
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                  
               /**¿QUÉ HACEMOS?***/
                  
            }
            catch (Exception e){
                s.close();
                e.printStackTrace();
            }
        }
    }
}
  


