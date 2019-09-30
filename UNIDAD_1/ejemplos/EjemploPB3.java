package ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EjemploPB3 {
	
	
	
	 public static void main(String[] args) {

	      // create a new list of arguments for our process
	      String[] list = {"featherpad", "/home/lubuntu/Desktop/test.txt"};

	      // create the process builder
	      ProcessBuilder pb = new ProcessBuilder(list);
	      try {

	        //pb= pb.redirectOutput(ProcessBuilder.Redirect.from(new File("/home/lubuntu/Desktop/")));
	        pb.start();
	      
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
	   }
	
	
	
	

}
