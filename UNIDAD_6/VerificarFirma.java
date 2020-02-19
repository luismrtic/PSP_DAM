
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;

import java.util.Scanner;

public class VerificarFirma {
   public static void main(String args[]) throws Exception{
      //Crear el objeto generador KeyPair 
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
	      
      //Inicializar el par de claves
      keyPairGen.initialize(2048);
	      
      //Generar el par de claves
      KeyPair pair = keyPairGen.generateKeyPair();
      
      //Obtener las claves privadas
      PrivateKey privKey = pair.getPrivate();

      //Crear el objeto Signature 
      Signature sign = Signature.getInstance("SHA256withDSA");

      //Inicializar la firma
      sign.initSign(privKey);
      byte[] bytes = "Hola esto es un mensaje de prueba".getBytes();
      
      //Añadir datos a la firma
      sign.update(bytes);
      
      //Calcular la firma
      byte[] signature = sign.sign();      
      
      //Inicizaliar la firma
      sign.initVerify(pair.getPublic());
      sign.update(bytes);
      
      //Verificar la firma
      boolean bool = sign.verify(signature);
      
      if(bool) {
         System.out.println("Firma verificada");   
      } else {
         System.out.println("Firma fallida");
      }
   }
}