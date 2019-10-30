package semaforos;

import java.util.concurrent.Semaphore;

/**
 * 
 */
public class HiloPrioritario extends Thread {

    /**
     * Semáforo para controlar el sincronismo.
     */
    protected Semaphore semaforoHilo;

  
    public HiloPrioritario(Semaphore semaforo) {
        this.semaforoHilo = semaforo;
    }

    @Override
    public void run() {
        try {
            sleep(500);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Hilo prioritario");
        // Abandona el semáforo, añadiendo el valor 1 a la variable permists 
        this.semaforoHilo.release();
    }
}
