package notodoesthread;

public class HiloPrincipal {

	public static void main(String[] args) {
		
		
		Tarea t= new Tarea();
		Thread hilo= new Thread(t);
		hilo.start();
		

	}

}