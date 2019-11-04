package notodoesthread;

public class Tarea implements Runnable {

	@Override
	public void run() {
		
		int total = 0;
		for(int i=0;i<5;i++) {
			
			total+=i;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		System.out.println(Thread.currentThread().getName());
		System.out.println(total);
		
		
	}

}