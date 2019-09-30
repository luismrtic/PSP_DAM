package ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class EjemploPB4 {
    public static void main(String args[]) {
 
        Process p;
        try {
           
        	File fout= new File("/home/lubuntu/Desktop/consulta.txt");
        	File fin= new File("/home/lubuntu/Desktop/consulta.sh");
        	File ferror= new File("/home/lubuntu/Desktop/consultaError.txt");
           
            ProcessBuilder pb = new ProcessBuilder("/bin/bash");
           
            pb.redirectInput(fin);
            pb.redirectOutput(fout);
            pb.redirectError(ferror);
            
            p = pb.start();

            
           
        } catch (Exception e) {}
    }
}