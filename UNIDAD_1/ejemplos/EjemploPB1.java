package ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EjemploPB1 {

	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder();
		
		String directorio="/home/lubuntu/Desktop";
		
	

		try {
		
		//pb = new ProcessBuilder("ls","-l"); 
		pb = new ProcessBuilder("/bin/sh", "-c", "ls -l| grep errores"); 
		
		
		File fout= new File("/home/lubuntu/Desktop/consulta.txt");
		
		pb.redirectOutput(fout);
		
		//pb = new ProcessBuilder();
		//pb = pb.command("ls","-l");
		
		
		List l = pb.command();
		Iterator il = l.iterator();
		while(il.hasNext()) {
			System.out.println("Comando:"+il.next().toString());
		}
		
		pb.directory(new File(directorio));
	
			
			Process p = pb.start();
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String linea;
			while((linea = br.readLine())!=null) {
				System.out.println(linea);
			}
			br.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
