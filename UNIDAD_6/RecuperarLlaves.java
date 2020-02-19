
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import java.security.KeyStore.SecretKeyEntry;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class RecuperarLlaves{
   public static void main(String args[]) throws Exception{
      //Crear un objeto KeyStore
	   KeyStore keyStore = KeyStore.getInstance("JCEKS");

      //Cargar el objeto KeyStore 
      char[] password = "changeit".toCharArray();
      java.io.FileInputStream fis = new FileInputStream(
    		  "/usr/lib/jvm/java-11-openjdk-amd64/lib/security/cacerts");
      
      keyStore.load(fis, password);
      
      //Crear el objeto KeyStore.ProtectionParameter 
      ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);

      //Crear el objeto SecretKey 
      SecretKey mySecretKey = new SecretKeySpec("myPassword".getBytes(), "DSA");
      
      //Crear el objeto SecretKeyEntry 
      SecretKeyEntry secretKeyEntry = new SecretKeyEntry(mySecretKey);
      keyStore.setEntry("AliasClaveSecreta", secretKeyEntry, protectionParam);

      //Almacenar el objeto KeyStore 
      java.io.FileOutputStream fos = null;
      fos = new java.io.FileOutputStream("newKeyStoreName");
      keyStore.store(fos, password);
      
      //Crear el objeto KeyStore.SecretKeyEntry 
      SecretKeyEntry secretKeyEnt = (SecretKeyEntry)keyStore.getEntry("AliasClaveSecreta", protectionParam);

      //Crear el objeto SecretKey 
      SecretKey mysecretKey = secretKeyEnt.getSecretKey();      
      System.out.println("Algoritmo usado para generar la clave: "+mysecretKey.getAlgorithm());   
      System.out.println("Formato usado para la clave: "+mysecretKey.getFormat());
   }
}