package semaforos;

import java.util.concurrent.Semaphore;

/**
 * Este hilo se debería ejecutar después del hilo prioritario.
 * 
 */
public class HinoNoPrioritario extends Thread {

    /**
     * Semáforo para controlar el sincronismo.
     */
    protected Semaphore semaforoHilo;

    public HinoNoPrioritario(Semaphore semaforo) {
        this.semaforoHilo = semaforo;
    }

    @Override
    public void run() {
        try {
            //Se ejecuta para acceder al semáforo.
            this.semaforoHilo.acquire();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            sleep(500);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Hilo NO prioritario");
        // Abandona el semádforo añadiendo un 1 a la variable permits
        this.semaforoHilo.release();
    }
}
