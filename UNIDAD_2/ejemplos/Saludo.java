package psp_hilos;
/*Crea un hilo implementando la interfaz Runnable*/

public class Saludo implements Runnable {
//clase que implementa a Runnable
    public void run() {
    //se redefine el mÃ©todo run()con el cÃ³digo asociado al hilo
        System.out.println("¡Saludo desde un hilo creado con Runnable!");
    }
    public static void main(String args[]) {
       Saludo  miRunnable=new Saludo();
       //se crea un objeto  Saludo
       Thread hilo1= new Thread(miRunnable);
       //se crea un objeto Thread (el hilo hilo1) pasando como argumento
      // al constructor un objeto Saludo
        hilo1.start();
       //se invoca al mÃ©todo start() del hilo hilo1
    }
}

