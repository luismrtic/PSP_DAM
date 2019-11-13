package ejemplos.ejemplo6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase Servidor. Espera a las conexiones clientes. Cuando un cliente conecta,
 * empezará el intercambio de informació hasta que el cliente envía la palabra FINAL.
 * Cuando esto ocurra, la conexión y la ejecución finalizarán.
 */
public class Server2 {

    public static final int PORT = 8080;

    public static void main(String[] args)
            throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Inicio: " + server);
        Socket socket = null;

        while (true) { // PARA PODER TENER MÁS DE UN CLIENTE
            try {
                //Bloqueo hasta que la conexión tenga lugar
                socket = server.accept();
                //El resto de código fuente.

            } catch (Exception e) {
                System.err.println("Excepción con cliente");
                socket.close();
            } finally {
                server.close();
            }
        }//final del while

    }
}
