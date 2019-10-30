
package consumidor_productor;


public class Productor extends Thread {

  
    private Contenedor contenedor;

  
    private static final int ITERATIONS_NUMBER = 10;

   
    public Productor(Contenedor c) {
       contenedor = c;
    }

    @Override
    public void run() {
       for (int i = 0; i < Productor.ITERATIONS_NUMBER; i++) {
           contenedor.put(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
