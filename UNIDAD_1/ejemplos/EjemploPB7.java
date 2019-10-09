package ejemplos;

import java.util.concurrent.CompletableFuture;

public class EjemploPB7 {

	
		  public static void main(String[] args) throws Exception {
		      ProcessBuilder processBuilder = new ProcessBuilder("featherpad");
		      Process process = processBuilder.start();

		      System.out.println("-- Manejador de procesos --");
		      ProcessHandle processHandle = process.toHandle();
		      System.out.printf("PID: %s%n", processHandle.pid());
		      System.out.printf("Vivo: %s%n", processHandle.isAlive());

		      System.out.println("-- INFORMACIÓN DEL PROCESO --");
		      ProcessHandle.Info info = processHandle.info();
		      info.command().ifPresent(str -> System.out.printf("Comando: %s%n", str));
		      info.commandLine().ifPresent(str -> System.out.printf("Linea de comando: %s%n", str));
		      //info.arguments().ifPresent(array -> System.out.printf("Arguments: %s%n", array));
		      info.startInstant().ifPresent(instant -> System.out.printf("Inicio: %s%n", instant));
		      info.totalCpuDuration().ifPresent(duration ->
		              System.out.printf("Duración en CPU: %s millis%n", duration.toMillis()));
		      info.user().ifPresent(str -> System.out.printf("User: %s%n", str));

		      System.out.println("-- Esperando a su destrucción --");
		      processHandle.destroy();
		      //La mejor opcion para saber si un proceso ha terminado es onExit
		      //ya que destroy() no podría matar el proceso inmediatamente
		      CompletableFuture<ProcessHandle> future = processHandle.onExit();
		      ProcessHandle ph = future.get();//blocks
		      System.out.printf("Vivo: %s%n", ph.isAlive());
		  }
		
}
