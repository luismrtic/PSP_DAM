import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class SubirFichero {

	public static void main(String[] args) throws IOException {
		
		FTPClient cliente = new FTPClient();
		
		String servFTP = "files.000webhost.com";
		
		System.out.println("Nos conectamos a: "+servFTP);
		String usuario = "pspdam";
		String clave = "psp.2020";
		
		cliente.connect(servFTP);
		boolean login = cliente.login(usuario, clave);
		
		if(login) {
			System.out.println("Login correcto...");
		}else {
			
			System.out.println("Login incorrecto");
			cliente.disconnect();
			System.exit(1);
		}
		
		//System.out.println("Directorio actual:"+cliente.printWorkingDirectory());
	
	    /*
		FTPFile[] files = cliente.listFiles();
		if(files.length>0) {
			
			System.out.println("Ficheros en el directorio actual:"+files.length);
			
			String tipos[] = {"Fichero","Directorio","Enlace simb."};
			
			for(int i = 0; i<files.length; i++) {
				System.out.println("\t"+files[i].getName()+"=>"+tipos[files[i].getType()]);
			}
			
		}
		*/
		
		String direc="MIS_DATOS";
		
		cliente.changeWorkingDirectory(direc);
		
        cliente.setFileType(FTP.BINARY_FILE_TYPE);
		
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("/home/lubuntu/ficheros/temperaturas.txt"));
		
		cliente.storeFile("temperaturas.txt", in);
		
		in.close();
		
		
		boolean logout = cliente.logout();
		if(logout) {
			System.out.println("Logout del servidor FTP...");
		}else {
			System.out.println("Error al hacer Logout...");
		}
		
		cliente.disconnect();
		
		System.out.println("Conexi�n finalizada");
		

	}

}
