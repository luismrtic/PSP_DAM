package psp_hilos;


public class Main {
    public static void main(String[] args) {
       
    System.out.println("�Hola mundo!\n");
    //imprime "�Hola mundo!" en la Salida
    Thread miHilo = Thread.currentThread();
    //obtiene el hilo donde se est� ejecutando este m�todo mediante la
    //funci�n Thread.currentThread(), y lo almacena en la variable
    //local miHilo

    //imprime el nombre del hilo en la Salida (funci�n getName())
    System.out.println("Por defecto, el hilo que ejecuta el m�todo main() "
            +"de mi programa se llama '" + miHilo.getName() + "'\n");

    
  }
}
