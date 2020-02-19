
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import java.security.Key;
import java.security.SecureRandom;

public class GeneradorClaves {
   public static void main(String args[]) throws Exception{
      //Crear un objeto KeyGenerator 
      KeyGenerator keyGen = KeyGenerator.getInstance("DES");
      
      //Crear un objeto SecureRandom 
      SecureRandom secRandom = new SecureRandom();
      
      //Inicializar e KeyGenerator
      keyGen.init(secRandom);
      
      //Crear/Generar key
      Key key = keyGen.generateKey();
      
      System.out.println(key);      
      Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");      
      cipher.init(cipher.ENCRYPT_MODE, key);      

      String msg = new String("Hola, esto es un mensaje secreto");
      byte[] bytes = cipher.doFinal(msg.getBytes());      
      System.out.println(bytes);      
   }
}