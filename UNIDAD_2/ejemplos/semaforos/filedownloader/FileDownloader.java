package semaforos.filedownloader;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Permite la descarga de recursos específicos.
 */
class FileDownloader implements Runnable {

    private Semaphore limitadorConexiones;
    private int numeroRecurso;

    public FileDownloader(Semaphore limitadorConexiones,int numeroRecurso) {
        this.limitadorConexiones = limitadorConexiones;
        this.numeroRecurso = numeroRecurso;
    }

    @Override
    public void run() {
        try {
        	limitadorConexiones.acquire();
            System.out.println("Empieza la descargar del fichero número: "+ this.numeroRecurso);
            //Simulate time needed to download a random file waiting for 
            // 0,5 to 3 seconds
            // Simulación del tiempo necesario para desargar ficheros aletorios esperando
            // de 0,5 a 3 segundos.
            Thread.sleep(new Random().nextInt(3000 - 500) + 500);
            // La línea de arriba reemplaza la lógica de negocio para 
            // conseguir ficheros como JS, CSS, o imágenes desde URL específica 
            // y usarlas en el fichero HTML que este programa podría coger como parámetro.
        
            System.out.println("Descargado fichero números: "+ this.numeroRecurso + " has finished");
            limitadorConexiones.release();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(FileDownloader.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}
