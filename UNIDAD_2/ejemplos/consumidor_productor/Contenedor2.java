
package consumidor_productor;


public class Contenedor2 {

 
    private int dato;
	
    
    private boolean hayDato = false;

    /**
     * Método usado por el Consumidor para extraer un valor del contenedor
     * @return dato
     *
     */
    public int get() {
        while (!hayDato) {
            try {
            	Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
            
        hayDato = false;
      
        System.out.println("Consumidor. coger: " + dato);
            
        return dato;
    }

    /**
     * Método usado por el Productor para colocar un valor en el contenedor
     * @param value
     */
    public void put(int value) {
       while (hayDato) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
            
        dato = value;
        hayDato = true;
        System.out.println("Productor. Pone: " + value);
        
       
    }
}

