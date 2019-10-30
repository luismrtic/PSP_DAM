
package consumidor_productor;


public class Contenedor {

 
    private int dato;
	
    
    private boolean hayDato = false;

    
    public synchronized int get() {
        while (!hayDato) {
            try {
                // Esperando al productor a que coloque un valor
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
            
        hayDato = false;
        
        System.out.println("Consumidor. coger: " + dato);
                
        // Notificar de que el valor ha sido extraído.
        notifyAll();
        return dato;
    }

    /**
     * Método usado por el Productor para colocar un valor en el contenedor
     * @param value
     *
     */
    public synchronized void put(int value) {
       while (hayDato) {
            try {
                // is waiting for the Consumer to extract 
                // the specific value inside.
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
            
        dato = value;
        hayDato = true;
        System.out.println("Productor. Pone: " + value);
        // Notifies that there is a value inside
        notifyAll();
    }
}

