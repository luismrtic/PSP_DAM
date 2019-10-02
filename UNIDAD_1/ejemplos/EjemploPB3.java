package ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EjemploPB3 {
	
	
	
	 public static void main(String[] args) {

	      //  Crear una lista de argumentos del proceso
	      String[] list = {"featherpad", "/home/lubuntu/Desktop/test.txt"};

	      ProcessBuilder pb = new ProcessBuilder(list);
	      try {
              
	        pb.start();
	      
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
	   }
	
	
	
	

}
