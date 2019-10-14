package psp_hilos;


public class Main {
    public static void main(String[] args) {
       
    System.out.println("¡Hola mundo!\n");
    //imprime "¡Hola mundo!" en la Salida
    Thread miHilo = Thread.currentThread();
    //obtiene el hilo donde se está ejecutando este método mediante la
    //función Thread.currentThread(), y lo almacena en la variable
    //local miHilo

    //imprime el nombre del hilo en la Salida (función getName())
    System.out.println("Por defecto, el hilo que ejecuta el método main() "
            +"de mi programa se llama '" + miHilo.getName() + "'\n");

    
  }
}
