package ejemplos.ejemplo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Simple cliente que env�a unas l�neas de texto al servidor
 * y lee la l�nea que se devuelve
 */
public class Client {

    public static void main(String[] args)
            throws IOException {
// Cuando pasamos null a getByName, es generado localhost 
  
        InetAddress addr = InetAddress.getByName(null);
// En otro caso, se puede usar para el mismo prop�stito:
// InetAddress addr = InetAddress.getByName("127.0.0.1");
// InetAddress addr = InetAddress.getByName("localhost");
        System.out.println("addr = " + addr);
        Socket socket = new Socket(addr, Server.PORT);

// Poner todo dentro del try-finally para hacer m�s seguro el socket y conseguir que se cierren:
        try {
            System.out.println("socket = " + socket);
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(
                        socket.getInputStream()));
// La salida es vaciada automaticamente por el PrintWriter:
            PrintWriter output = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream())), true);
            for (int i = 0; i < 10; i++) {
                output.println("Mensaje " + i);
                String str = input.readLine();
                System.out.println(str);
            }
            output.println("END");
        } finally {
            System.out.println("Cerrando... ");
            socket.close();
        }
    }
}
