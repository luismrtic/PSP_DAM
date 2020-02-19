
import java.io.FileInputStream;
import java.security.KeyStore;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AlmacenarLlaves{
   public static void main(String args[]) throws Exception {
      //Crear un objeto KeyStore 
      KeyStore keyStore = KeyStore.getInstance("JCEKS"); // JEKS es el almacen de datos

      //Cargar el objeto KeyStore 
      char[] password = "changeit".toCharArray();
      String path = "/usr/lib/jvm/java-11-openjdk-amd64/lib/security/cacerts";
      java.io.FileInputStream fis = new FileInputStream(path);
      keyStore.load(fis, password);
      
      //Crear un objeto KeyStore.ProtectionParameter 
      KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);

      //Crear un objeto SecretKey 
      SecretKey mySecretKey = new SecretKeySpec("myPassword".getBytes(), "DSA");
      
      //Crear un objeto SecretKeyEntry 
      KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(mySecretKey);
      keyStore.setEntry("AliasClaveSecreta", secretKeyEntry, protectionParam);

      //Almacenar un objeto KeyStore 
      java.io.FileOutputStream fos = null;
      fos = new java.io.FileOutputStream("nombreAlmacenClave");
      keyStore.store(fos, password);
      System.out.println("Datos almacenados");
   }
}