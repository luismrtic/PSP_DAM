
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Scanner;

public class CrearFirmaDigital {
   public static void main(String args[]) throws Exception {
      //Recoger texto del usuario
      Scanner sc = new Scanner(System.in);
      System.out.println("Introduzca texto:");
      String msg = sc.nextLine();
      
      //Generar el par de claves
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
      
      //Inicializar el generador de par de claves
      keyPairGen.initialize(2048);
      
      //Generar el par de claves
      KeyPair pair = keyPairGen.generateKeyPair();
      
      //Obtener la clave privada
      PrivateKey privKey = pair.getPrivate();
      
      //Crear un objeto Signature
      Signature sign = Signature.getInstance("SHA256withDSA");
      
      //Inicializar la firma signature
      sign.initSign(privKey);
      byte[] bytes = "msg".getBytes();
      
      //Añadir datos a la firma
      sign.update(bytes);
      
      //Calcular la firma
      byte[] signature = sign.sign();
      
      //Imprimir la firma
      System.out.println("La firma ditital del texto facilitado es: "+new String(signature, "UTF8"));
   }
}