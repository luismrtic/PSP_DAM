
package consumidor_productor;


public class ProductorConsumidorMain {


    public static void main(String[] args) {
        Contenedor c = new Contenedor();
        Productor productor = new Productor(c);
        Consumidor consumidor = new Consumidor(c);

        productor.start();
        consumidor.start();
    }
}

