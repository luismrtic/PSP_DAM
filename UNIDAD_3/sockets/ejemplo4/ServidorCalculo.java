package ejemplos.ejemplo4;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculo {
	
	 public static void main(String[] args) throws IOException {
		 
		  ServidorCalculo servidor = new ServidorCalculo();
		  
		  servidor.escuchar();
	 }
	
	
	
    public int extraerNumero(String linea){
            /* 1. Comprobar si es un n�mero
             * 2. Ver si el n�mero es correcto (32a75)
             * 3. Ver si tiene de 1 a 8 cifras
             */
            int numero;
            try{
                    numero=Integer.parseInt(linea);
            }
            catch (NumberFormatException e){
                    numero=0;
            }
            /* Si el n�mero es mayor de 100 millones no
             * es v�lido tampoco
             */
            if (numero>=100000000){
                    numero=0;
            }
            return numero;
    }

    public int calcular(String op, String n1, String n2){
            int resultado=0;
            char simbolo=op.charAt(0);
            int num1=this.extraerNumero(n1);
            int num2=this.extraerNumero(n2);
            if (simbolo=='+'){
                    resultado=num1+num2;
            }
            return resultado;
    }

    public void escuchar() throws IOException{
            System.out.println("Arrancado el servidor");
            ServerSocket socketEscucha=null;
            try {
                    socketEscucha=new ServerSocket(9876);
            } catch (IOException e) {
                    System.out.println(
                                    "No se pudo poner un socket "+
                                    "a escuchar en TCP 9876");
                    return;
            }
            while (true){
                    Socket conexion=socketEscucha.accept();
                    System.out.println("Conexion recibida!");
                    InputStream is=conexion.getInputStream();
                    InputStreamReader isr=new InputStreamReader(is);
                    BufferedReader bf=new BufferedReader(isr);
                    String linea=bf.readLine();
                    String num1=bf.readLine();
                    String num2=bf.readLine();
                    /* Calculamos el resultado*/
                    Integer result=this.calcular(linea, num1, num2);
                    OutputStream os=conexion.getOutputStream();
                    PrintWriter pw=new PrintWriter(os);
                    pw.write(result.toString()+"\n");
                    pw.flush();
            }
    }
}