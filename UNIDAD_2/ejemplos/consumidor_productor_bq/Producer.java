package consumidor_productor_bq;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;

class Producer
implements Runnable
{
	private BlockingQueue<String> drop;
	List<String> messages = Arrays.asList(
	    "Mensaje 1",
	    "Mensaje 2",
	    "Mensaje 3",
	    "Mensaje 4");
     
public Producer(BlockingQueue<String> d) { 
	this.drop = d; 
}
 
public void run()
{
    try
    {
        for (String s : messages)
            drop.put(s);
        drop.put("FIN");
    }
    catch (InterruptedException intEx)
    {
        System.out.println("Interrupción!");
    }
}    
}