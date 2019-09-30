package ejemplos;

import java.util.concurrent.TimeUnit;

public class Ejemplo0 {
	
	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		
		String comando="firefox";
			
		Process p;
		
		try {
			
			p = r.exec(comando);
			p.waitFor(20,TimeUnit.SECONDS);
			p.destroy();		
			
		  }catch (SecurityException ex){
	            System.out.println("Ha ocurrido un error de Seguridad."+
	                    "No se ha podido crear el proceso por falta de permisos.");
	        }catch (Exception ex){
	            System.out.println("Ha ocurrido un error, descripción: "+
	                    ex.toString());
	        }	
	}

}
