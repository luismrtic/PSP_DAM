package ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class EjemploPB2 {
    public static void main(String args[]) {
        String s;
        Process p;
        try {
            
            ProcessBuilder pb = new ProcessBuilder("ls", "-aF");  //-a = todos los ficheros -F=tipo del fichero
            pb.directory(new File("/home/lubuntu/Descargas"));
            
            p = pb.start();

            BufferedReader br = new BufferedReader( new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println(s);
            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {}
    }
}