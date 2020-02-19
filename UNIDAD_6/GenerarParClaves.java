
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class GenerarParClaves {
   public static void main(String args[]) throws Exception{
      //Crear el objeto KeyPair generator 
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
      
      //Inicializar el KeyPairGenerator
      keyPairGen.initialize(2048);
      
      //Generar el par de claves
      KeyPair pair = keyPairGen.generateKeyPair();
      
      //Obtener la clave privada del par de claves
      PrivateKey privKey = pair.getPrivate();   
      
      //Obtener la clave publica del par de claves
      PublicKey publicKey = pair.getPublic(); 
      System.out.println("Claves generadas");
   }
}
