
package semaforos.filedownloader;

import java.util.concurrent.Semaphore;

/**
 * Representa una tarea que crea un número de conexiones
 */
public class ConnectionsLimiterTest {

    /**
     * Punto de entrada de la app.
     */
    public static void main(String[] args) {
    	
    	//Indicamos el número de ficheros que se pueden descargar al mismo tiempo.
        final int maximoFicherosMismoTiempo = 2;
        // Creamos un semáforo con el número de recursos igual al número de ficheros que se pueden
        // descargar simultáneamente.
        Semaphore limitadorConexiones =  new Semaphore(maximoFicherosMismoTiempo);
        
        //SIMULACIÓN DE 10 FICHEROS QUE SE NECESITAN PARA DESCARGAR UNA PÁGINA.
        for (int i = 0; i < 10; i++) {
            new Thread(new FileDownloader(limitadorConexiones, i)).start();
        }
    }
}
