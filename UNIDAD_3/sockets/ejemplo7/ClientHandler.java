
package ejemplos.ejemplo7;

// Un servidor que usa el multihilo
// para manejar cualquier nÃºmero de clientes.
import java.io.*;
import java.net.*;

/**
 * Servidor el cual usa multihilos para tratar con un número de clientes.
 */
public class ClientHandler extends Thread {

    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ClientHandler(Socket s)throws IOException {
        socket = s;
        input= new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
        output= new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream())),
                                           true);
        
// Si se lanza alguna excepción, el objeto llamador es el responsable de cerrar el socket.

        start(); // Llamada al método run()
    }

    @Override
    public void run() {
        try {
            while (true) {
                String str = input.readLine();
                if (str.equals("END")) {
                    break;
                }

                System.out.println("Recibido: " + str);
                output.println(str);
            }
            System.out.println("Cerrando...");
        } catch (IOException e) {
            System.err.println("I/O Exception");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket no cerrado");
            }
        }
    }
}
