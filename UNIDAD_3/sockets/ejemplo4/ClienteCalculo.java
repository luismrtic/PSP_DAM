package ejemplos.ejemplo4;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteCalculo {
    public static BufferedReader getFlujo(InputStream is){
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader bfr= new BufferedReader(isr);
            return bfr;
    }
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
            InetSocketAddress direccion=new InetSocketAddress("localhost", 9876);
            Socket socket=new Socket();
            socket.connect(direccion);
            BufferedReader bfr= ClienteCalculo.getFlujo(socket.getInputStream());
            PrintWriter pw=new PrintWriter(socket.getOutputStream());
            
            System.out.println("Introduzca un número:");
            
            Scanner s = new Scanner(System.in);
            String n1= s.nextLine();
            System.out.println("Introduzca otro número");
            String n2= s.nextLine();
            
            pw.print("+\n"); 
            //pw.print(n1+"\n");
            //pw.print(n2+"\n");
            pw.println(n1);
            pw.println(n2);
       
            
            pw.flush();
            String resultado=bfr.readLine();
            System.out.println
                    ("El resultado fue:"+resultado);
    }
}