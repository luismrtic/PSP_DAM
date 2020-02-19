
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

public class EjemploMAC {
   public static void main(String args[]) throws Exception{
      //Crear un objeto KeyGenerator
      KeyGenerator keyGen = KeyGenerator.getInstance("DES");

      //Crear un objeto SecureRandom 
      SecureRandom secRandom = new SecureRandom();

      //Inicializar el KeyGenerator
      keyGen.init(secRandom);

      //Crear/Generar una clave
      Key key = keyGen.generateKey();	 

      //Crear un objeto Mac 
      Mac mac = Mac.getInstance("HmacSHA256");

      //Inicializar un objeto Mac 
      mac.init(key);

      //Ejecutar el Mac
      String msg = new String("Hola, esto es un mensaje");
      byte[] bytes = msg.getBytes();      
      byte[] macResult = mac.doFinal(bytes);

      System.out.println("Resultado Mac:");
      System.out.println(new String(macResult));     
   }
}