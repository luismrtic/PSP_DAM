package notodoesthread;

//Java Program to illustrate methods 
//of ConcurrentMap interface 
import java.util.concurrent.*; 
class ConcurrentMapDemoInicio { 
	
	
	public static void main(String[] args) 
	{ 
		ConcurrentHashMap m = new ConcurrentHashMap(); 
		m.put(100, "Hola"); 
		m.put(101, "Qu� "); 
		m.put(102, "Adios"); 

		//Aqu� podemos a�adir Qu� tal en la clave 101
		//Ya est� presente en el objeto ConcurrentHashMap
		m.putIfAbsent(101, "Qu� tal"); 

		// Podemos elimintar la entrada porque existe la clave 101
		m.remove(101, "For"); 

		// Ahora podemos a�adir Hola 
		m.putIfAbsent(101, "Hola"); 

		// Podemos reemplazar Hola por Qu� tal
		m.replace(101, "Hola", "Qu� tal"); 
		System.out.println(m); 
	} 
} 
