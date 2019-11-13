package ejemplos.ejemplo6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase Servidor. Espera a las conexiones clientes. Cuando un cliente conecta,
 * empezar� el intercambio de informaci� hasta que el cliente env�a la palabra FINAL.
 * Cuando esto ocurra, la conexi�n y la ejecuci�n finalizar�n.
 */
public class Server2 {

    public static final int PORT = 8080;

    public static void main(String[] args)
            throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Inicio: " + server);
        Socket socket = null;

        while (true) { // PARA PODER TENER M�S DE UN CLIENTE
            try {
                //Bloqueo hasta que la conexi�n tenga lugar
                socket = server.accept();
                //El resto de c�digo fuente.

            } catch (Exception e) {
                System.err.println("Excepci�n con cliente");
                socket.close();
            } finally {
                server.close();
            }
        }//final del while

    }
}
