package notodoesthread;

//Java Program to illustrate methods 
//of ConcurrentMap interface 
import java.util.concurrent.*; 
class ConcurrentMapDemoInicio { 
	
	
	public static void main(String[] args) 
	{ 
		ConcurrentHashMap m = new ConcurrentHashMap(); 
		m.put(100, "Hola"); 
		m.put(101, "Qué "); 
		m.put(102, "Adios"); 

		//Aquí podemos añadir Qué tal en la clave 101
		//Ya está presente en el objeto ConcurrentHashMap
		m.putIfAbsent(101, "Qué tal"); 

		// Podemos elimintar la entrada porque existe la clave 101
		m.remove(101, "For"); 

		// Ahora podemos añadir Hola 
		m.putIfAbsent(101, "Hola"); 

		// Podemos reemplazar Hola por Qué tal
		m.replace(101, "Hola", "Qué tal"); 
		System.out.println(m); 
	} 
} 
