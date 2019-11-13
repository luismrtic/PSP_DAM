
package ejemplos.ejemplo7;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Crear una cantidad de clientes que se conectan al servidor.
 */
public class Multiclient {

    static final int MAX_THREADS = 40;

    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress addr= InetAddress.getByName(null);
        while (true) {
            if (ClientThread.getThreadsCount() < MAX_THREADS) {
                new ClientThread(addr);
            }
            Thread.currentThread().sleep(100);
        }
    }
}
