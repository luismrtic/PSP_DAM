package notodoesthread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapVsSynchronizedMap {
	 
		public final static int THREAD_POOL_SIZE = 5;
	 
		public static Map<String, Integer> elementoHashTableObject = null;
		public static Map<String, Integer> elementoSynchronizedMapObject = null;
		public static Map<String, Integer> elementoConcurrentHashMapObject = null;
	 
		public static void main(String[] args) throws InterruptedException {
	 
			// Test con un objeto Hashtable
			elementoHashTableObject = new Hashtable<String, Integer>();
			lanzarTest(elementoHashTableObject);
	 
			// Test con un objeto synchronizedMap
			elementoSynchronizedMapObject = Collections.synchronizedMap(new HashMap<String, Integer>());
			lanzarTest(elementoSynchronizedMapObject);
	 
			// Test con un objeto ConcurrentHashMap
			elementoConcurrentHashMapObject = new ConcurrentHashMap<String, Integer>();
			lanzarTest(elementoConcurrentHashMapObject);
	 
		}
	 
		public static void lanzarTest(final Map<String, Integer> recursoHilos) throws InterruptedException {
	 
			System.out.println("Inicio del test: " + recursoHilos.getClass());
			long tiempoMedio = 0;
			for (int i = 0; i < 5; i++) {
	 
				long tiempoInicio = System.nanoTime();
				
				//Se crea un pool de hilos con un n�mero fijos de hilos.
				ExecutorService hilosExServer = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
	 
				for (int j = 0; j < THREAD_POOL_SIZE; j++) {
					
					hilosExServer.execute(new Runnable() {
						@Override
						public void run() {
	 
							for (int i = 0; i < 500000; i++) {
								Integer numeroAleatorioRecurso = (int) Math.ceil(Math.random() * 550000);
								//ceil devuelve el entero mayor o igual m�s pr�ximo a un n�mero dado.
	 
								// Recuperar valor. Para este ejemplo no usamos dicho valor para ninguna operaci�n
								Integer recursoValor = recursoHilos.get(String.valueOf(numeroAleatorioRecurso));
	 
								// A�adir valor con m�todo put
								recursoHilos.put(String.valueOf(numeroAleatorioRecurso), numeroAleatorioRecurso);
							}
						}
					});
				}
				// Inicia un cierre ordenado en el que se ejecutan tareas enviadas previamente, pero no se aceptar�n nuevas tareas. 
				// Invocaci�n no tiene ning�n efecto adicional si ya est� apagado.
				// Este m�todo no espera a que las tareas enviadas previamente completen la ejecuci�n. Use awaitTermination para hacer eso
				hilosExServer.shutdown();
	 
				// Bloquea hasta que todas las tareas hayan completado la ejecuci�n despu�s de una solicitud de apagado, o se produzca el tiempo de espera, o el subproceso actual sea
				// interrumpido, lo que ocurra primero.
				hilosExServer.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
	 
				long tiempoFinal = System.nanoTime();
				long tiempoTotal = (tiempoFinal - tiempoInicio) / 1000000L;
				tiempoMedio += tiempoTotal;
				System.out.println("500K entradas a�adidas/retiradas en" + tiempoTotal + " ms");
			}
			System.out.println("Para " + recursoHilos.getClass() + " el tiempo medio es " + tiempoMedio / 5 + " ms\n");
		}
	}


