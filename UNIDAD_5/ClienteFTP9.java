
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
 

public class ClienteFTP9 {
 
    public static void main(String[] args) {
    	String server = "files.000webhost.com";
        int port = 21;
        String user = "pspdam";
        String pass = "psp.2020";
 
        FTPClient ftpClient = new FTPClient();
        try {
 
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
 
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
 
            // CASO #1: subir un primer fichrero usando un  InputStream
            File firstLocalFile = new File("/home/lubuntu/MIS_APUNTES/copias.tar");
 
            String firstRemoteFile = "copias.tar";
            InputStream inputStream = new FileInputStream(firstLocalFile);
 
            System.out.println("Empieza la subida del primer fichero");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("El primer fichero ha sido subido correctamente");
            }
 
            // CASO #2: subir un segundo fichero usando un OutputStream
            File secondLocalFile = new File("/home/lubuntu/MIS_APUNTES/apuntes_1");
            String secondRemoteFile = "apuntes_1.txt";
            inputStream = new FileInputStream(secondLocalFile);
 
            System.out.println("Empieza la subida del segundo fichero");
            OutputStream outputStream = ftpClient.storeFileStream(secondRemoteFile);
            byte[] bytesIn = new byte[4096];
            int read = 0;
 
            while ((read = inputStream.read(bytesIn)) != -1) {
                outputStream.write(bytesIn, 0, read);
            }
            inputStream.close();
            outputStream.close();
 
            boolean completed = ftpClient.completePendingCommand();
            if (completed) {
                System.out.println("El segundo fichero ha sido subido correctamente");
            }
 
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
 
}
