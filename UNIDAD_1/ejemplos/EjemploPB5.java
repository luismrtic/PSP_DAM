package ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

public class EjemploPB5 {

	
	public static void main(String args[]) {
        String s;
        Process p;
        try {
           
        	
 
            ProcessBuilder pb = new ProcessBuilder("ls -s");
            //ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "ls -l"); 
           
            List l = pb.command();
            Iterator iter = l.iterator();
    		System.out.println("Argumentos del programa");
    		while(iter.hasNext()) {
    			System.out.println(iter.next());
    		}
            
            pb = new ProcessBuilder("ls","-l");
            
            p = pb.start();
            
            InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String linea;
			while((linea = br.readLine())!=null) {
				System.out.println(linea);
			}
			br.close();

            
           
        } catch (Exception e) {}
    }
}
