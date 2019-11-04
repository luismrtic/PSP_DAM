package notodoesthread;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapDemo {

   public static void main(final String[] arguments) {
     
	   
	   Map<String,String> map = new ConcurrentHashMap<String, String>();

	   map.put("1", "Uno");
	   map.put("2", "Dos");
	   map.put("3", "Tres");
	   map.put("5", "Cinco");
	   map.put("6", "Seis");

      System.out.println("Inicializado el ConcurrentHashMap: " + map);
      Iterator<String> iterator = map.keySet().iterator();

      try { 
         
         while(iterator.hasNext()) {
            String key = iterator.next();
            
            if(key.equals("3")) {
            	map.put("4", "Cuatro");
            }
         }
      } catch(ConcurrentModificationException cme) {
         cme.printStackTrace();
      }
      System.out.println("ConcurrentHashMap después de modificación: " + map);

      map = new HashMap<String, String>();

       map.put("1", "Uno");
	   map.put("2", "Dos");
	   map.put("3", "Tres");
	   map.put("5", "Cinco");
	   map.put("6", "Seis");


      System.out.println("Inicializado el HashMap: " + map);
      iterator = map.keySet().iterator();

      try {
         
         while(iterator.hasNext()) {
            String key = iterator.next();
            
            if(key.equals("3")) {
               map.put("4", "Cuatro");
            }
         }
         System.out.println("HashMap después de la modificación: " + map);
      } catch(ConcurrentModificationException cme) {
         cme.printStackTrace();
      }
   }  
}