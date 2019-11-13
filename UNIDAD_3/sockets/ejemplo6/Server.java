package ejemplos.ejemplo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase Servidor. Espera a las conexiones clientes. Cuando un cliente conecta,
 * empezará el intercambio de informació hasta que el cliente envía la palabra FINAL.
 * Cuando esto ocurra, la conexión y la ejecución finalizarán.
 */
public class Server {

    public static final int PORT = 8080;

    public static void main(String[] args)
            throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        Socket socket = null;
        System.out.println("Inicio: " + server);
        try {
            // Bloqueado hasta que haya conexión:
             socket = server.accept();
            System.out.println("Conexión aceptada: " + socket);
            BufferedReader input
                    = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));
            // La salida es generada normalmente por un PrintWriter:
            PrintWriter output;
            output = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream())),
                    true);
            while (true) {
                String str = input.readLine();
                if (str.equals("FINAL")) {
                    break;
                }
                System.out.println("Imprimiendo entrada:" + str);
                output.println(str);
            }
        // Siempre se cerrará ambos sockets...
        } finally {
            System.out.println("Closing. . . ");
            socket.close();
            server.close();
        }

    }
}
