import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
 
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
 

public class ClienteFTP8 {
 
    public static void main(String[] args) {
    	String server = "files.000webhost.com";
        int port = 21;
        String user = "pspdam";
        String pass = "psp.2020";
 
        FTPClient ftpClient = new FTPClient();
 
        try {
 
            ftpClient.connect(server, port);
            mostrarRespuestaServidor(ftpClient);
 
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Conexión fallida");
                return;
            }
 
            boolean success = ftpClient.login(user, pass);
            mostrarRespuestaServidor(ftpClient);
 
            if (!success) {
                System.out.println("No se puede hacer login en el servidor");
                return;
            }
 
            // Lists files and directories
            FTPFile[] files1 = ftpClient.listFiles("/");
            printFileDetails(files1);
 
            // uses simpler methods
            String[] files2 = ftpClient.listNames();
            printNames(files2);
 
 
        } catch (IOException ex) {
            System.out.println("Oops! Sucedió algún error");
            ex.printStackTrace();
        } finally {
            // logs out and disconnects from server
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
 
    private static void printFileDetails(FTPFile[] files) {
        DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (FTPFile file : files) {
            String details = file.getName();
            if (file.isDirectory()) {
                details = "[" + details + "]";
            }
            details += "\t\t" + file.getSize();
            details += "\t\t" + dateFormater.format(file.getTimestamp().getTime());
 
            System.out.println(details);
        }
    }
 
    private static void printNames(String files[]) {
        if (files != null && files.length > 0) {
            for (String aFile: files) {
                System.out.println(aFile);
            }
        }
    }
 
    private static void mostrarRespuestaServidor(FTPClient ftpClient) {
        String[] respuestas = ftpClient.getReplyStrings();
        if (respuestas != null && respuestas.length > 0) {
            for (String respuesta : respuestas) {
                System.out.println("SERVIDOR: " + respuestas);
            }
        }
    }
}