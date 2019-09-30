package ejemplos;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class EjemploPB1B {

	public static void main(String[] args) {
		
		Path currentRelativePath = Paths.get("");
        String ss = currentRelativePath.toAbsolutePath().toString();
        System.out.println("La ruta desde donde ejecutas tu comando es: " + ss);
		
		ProcessBuilder pb = new ProcessBuilder();
		
		String directorio="/home/lubuntu/eclipse-workspace/UNIDAD_1/bin";
		
		try {
		
		pb = new ProcessBuilder("java","ejemplos.Simpatico"); 
	
		File fout=new File("/home/lubuntu/Desktop/salidaSimpatico.txt");
		pb.redirectOutput(fout);
		
		pb.redirectError(new File("/home/lubuntu/Desktop/errores.txt"));
		
		List<String> l = pb.command();
		
		Iterator<String> iter = l.iterator();
		System.out.println("Argumentos del programa");
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		pb.directory(new File(directorio));
		
		pb.start();
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
