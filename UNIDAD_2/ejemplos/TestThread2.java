package psp_hilos;

public class TestThread2 {

	   public static void main(String args[]) {
	      ThreadDemo T1 = new ThreadDemo("Hilo-1");
	      T1.start();
	      
	      ThreadDemo T2 = new ThreadDemo("Hilo-2");
	      T2.start();
	   }   
	}