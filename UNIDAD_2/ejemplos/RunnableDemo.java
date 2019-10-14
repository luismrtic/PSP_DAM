package psp_hilos;

class RunnableDemo implements Runnable {
	   private Thread t;
	   private String nombreHilo;

	   RunnableDemo(String name) {
		   nombreHilo = name;
	      System.out.println("Creado " +  nombreHilo );
	   }
	   
	   public void run() {
	      System.out.println("Running " +  nombreHilo );
	      
	      try {
	      
	         for(int i = 4; i > 0; i--) {
	            System.out.println("Hilo: " + nombreHilo + ", " + i);
	            
	            // Let the thread sleep for a while.
	            Thread.sleep(50);
	         }
	      } catch (InterruptedException e) {
	         System.out.println("Hilo " +  nombreHilo + " interrumpido.");
	      }
	      System.out.println("Hilo " +  nombreHilo + " saliendo.");
	   }
	   
	   public void start () {
	      System.out.println("Empezando " +  nombreHilo );
	      
	      if (t == null) {
	         t = new Thread (this, nombreHilo);
	         t.start ();
	      }
	   }
	}

	