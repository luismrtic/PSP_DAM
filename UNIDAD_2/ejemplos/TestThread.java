package psp_hilos;

public class TestThread {

	   public static void main(String args[]) {
	      RunnableDemo R1 = new RunnableDemo("Hilo-1");
	      R1.start();
	      
	      RunnableDemo R2 = new RunnableDemo("Hilo-2");
	      R2.start();
	   }   
	}