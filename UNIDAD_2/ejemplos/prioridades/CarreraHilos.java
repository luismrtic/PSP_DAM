package prioridades;

/*
 * Clase Main que ejemplifica el uso de la clase anterior.
 */
public class CarreraHilos {

    /**
     * Punto de entrada de la aplicación.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Creación de los hilos
        Clicker max = new Clicker(Thread.MAX_PRIORITY);
        Clicker min = new Clicker(Thread.MIN_PRIORITY);

        //Se arrancan los hilos
        max.start();
        min.start();

        //Se les deja en ejecución durante 5 segundos. Se duerme
        // el proceso relativo al programa Java. Los 3 hilos creados
        // anteriormente siguen ejecutándose.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Hilo del Main interrumpido.");
        }

           //Detención de los hilos
        max.stop();
        min.stop();

        //Se imprime el valor del contador de ambos
        System.out.println("Max - prioridad hilo: " + max.click);
        System.out.println("Min - prioridad hilo: " + min.click);
    }
}
