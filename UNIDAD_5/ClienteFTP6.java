import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class ClienteFTP6 {
	
    private static void mostrarRespuestaServidor(FTPClient ftpClient) {
        String[] respuestas = ftpClient.getReplyStrings();
        if (respuestas != null && respuestas.length > 0) {
            for (String respuesta : respuestas) {
                System.out.println("SERVIDOR: " + respuestas);
            }
        }
    }
    public static void main(String[] args) {
        String server = "files.000webhost.com";
        int port = 21;
        String user = "pspdam";
        String pass = "psp.2020";
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            mostrarRespuestaServidor(ftpClient);
           
            int codigoRespuesta = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(codigoRespuesta)) {
                System.out.println("Fallo en la operación. Servidor envio código: " + codigoRespuesta);
                return;
            }
            boolean success = ftpClient.login(user, pass);
            mostrarRespuestaServidor(ftpClient);
            if (!success) {
                System.out.println("No se puede hacer login");
                return;
            } else {
                System.out.println("LOGEADO EN SERVIDOR");
            }
        } catch (IOException ex) {
            System.out.println("Oops! Algún error sucedió");
            ex.printStackTrace();
        }
    }
}