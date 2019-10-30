
package prioridades;

/**
 * Clase que implementa Runnable y que va incrementando una 
 * variable contador cada vez que se ejecuta su método run().
 */
public class Clicker implements Runnable {

    /**
     * Contador del número de ejecuciones.
     */
    int click = 0;
    /**
     * Instancia de Thread para implementar un hilo.
     */
    Thread t;
    /**
     * Variable booleana que mientras sea true se seguirá ejecutando 
     * el hilo. La palabra reservada volatile se utiliza para indicar 
     * que el valor de una variable puede ser modificada por 
     * diferentes hilos.
     */
    private volatile boolean running = true;

    /**
     * Constructor.
     *
     * @param p prioridad con la que se instancia el nuevo hilo.
     */
    public Clicker(int p) {
        t = new Thread(this);
        t.setPriority(p);
    }

    @Override
    public void run() {
        while (running) {
            click++;
        }
    }

    /**
     * Se podrá utilizar el método de Thread Thread.stop(). 
     * No obstante, en la propia documentación de la API de Java 
     * se recomienda que se detenga el hilo mediante la modificación
     * de una variable que controle la ejecución
     * del método start(). En este ejemplo se pone una booleana a false,
     * con cuyo valor el start() no se ejecuta.
     */
    public void stop() {
        running = false;
    }

    /**
     * Arranca el hilo.
     */
    public void start() {
        t.start();
    }
}
