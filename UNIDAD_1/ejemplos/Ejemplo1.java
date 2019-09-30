package ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Ejemplo1 {
	
	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		
		System.out.println("Nº de procesadores:"+r.availableProcessors());
		System.out.println("Memoria total:"+r.totalMemory());
		System.out.println("Memoria libre:"+r.freeMemory());
		System.out.println("Memoria ocupada:"+(r.totalMemory()-r.freeMemory()));
		

		String comando="lsb_release -a";
		
		
		Process p;
		
		try {
			
			p = r.exec(comando);
			
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("salida.txt")));
			
			String linea;
			while((linea=br.readLine())!=null) {
				System.out.println(linea);
				bw.write(linea);
				
			}
			br.close();
			bw.close();
			
			p.destroy();
			
			
		}catch(Exception e) {
			System.out.println("Se ha producido un error");
		}
		
		
	}

}
