
package consumidor_productor;


public class Consumidor extends Thread {

    private Contenedor contenedor;
	
    private static final int ITERATIONS_NUMBER = 10;

    public Consumidor(Contenedor c) {
            contenedor = c;
    }

    @Override
    public void run() {
        int valor;
        for (int i = 0; i < Consumidor.ITERATIONS_NUMBER; i++) {
            valor = contenedor.get();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}

