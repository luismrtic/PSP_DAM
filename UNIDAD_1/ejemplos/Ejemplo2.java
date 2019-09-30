package ejemplos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Ejemplo2 {
	
	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		String comando = "ls -l";
		
		Process p = null;
		
		try {
			p = r.exec(comando);
						
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String linea;
			while((linea = br.readLine())!=null) {
				System.out.println(linea);
			}
			br.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
