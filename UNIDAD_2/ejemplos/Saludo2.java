package psp_hilos;



public class Saludo2 extends Thread {
//clase que implementa a Runnable
    public void run() {
    //se redefine el método run()con el código asociado al hilo
        System.out.println("�Saludo desde un hilo creado con Thread!");
    }
    public static void main(String args[]) {
       Saludo2  miThread=new Saludo2();
       //se crea un objeto  Saludo2
       miThread.start();

       //se invoca al método start() del hilo hilo1
    }
}

