
import java.security.MessageDigest;
import java.util.Scanner;

public class EjemploMensajeDigest {
   public static void main(String args[]) throws Exception{
	  
      //Leer datos del usuario
      Scanner sc = new Scanner(System.in);
      System.out.println("Introduzca un mensaje");
      String message = sc.nextLine();
	  
      //Crear un objeto MessageDigest   
      MessageDigest md = MessageDigest.getInstance("SHA-256");

      //Pasar los datos al objeto MessageDigest creado
      md.update(message.getBytes());
      
      //Tratar el mensaje
      byte[] digest = md.digest();      
      
      System.out.println(digest);  
     
      //Convertir el array de bytes en formato HexString
      StringBuffer hexString = new StringBuffer();
      for (int i = 0;i<digest.length;i++) {
         hexString.append(Integer.toHexString(0xFF & digest[i]));
      }
      System.out.println("Foramto Hexadecimal : " + hexString.toString());     
   }
}