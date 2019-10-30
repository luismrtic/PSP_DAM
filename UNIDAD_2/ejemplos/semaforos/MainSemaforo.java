
package semaforos;

import java.util.concurrent.Semaphore;

public class MainSemaforo {

    public static void main(String[] args) {
        
    	Semaphore semaforo = new Semaphore(0);
        
        HinoNoPrioritario noPrioritario = new HinoNoPrioritario(semaforo);
        HiloPrioritario prioritario = new HiloPrioritario(semaforo);
        
        noPrioritario.start();
        prioritario.start();
    }
}
