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
				
				//Se crea un pool de hilos con un número fijos de hilos.
				ExecutorService hilosExServer = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
	 
				for (int j = 0; j < THREAD_POOL_SIZE; j++) {
					
					hilosExServer.execute(new Runnable() {
						@Override
						public void run() {
	 
							for (int i = 0; i < 500000; i++) {
								Integer numeroAleatorioRecurso = (int) Math.ceil(Math.random() * 550000);
								//ceil devuelve el entero mayor o igual más próximo a un número dado.
	 
								// Recuperar valor. Para este ejemplo no usamos dicho valor para ninguna operación
								Integer recursoValor = recursoHilos.get(String.valueOf(numeroAleatorioRecurso));
	 
								// Añadir valor con método put
								recursoHilos.put(String.valueOf(numeroAleatorioRecurso), numeroAleatorioRecurso);
							}
						}
					});
				}
				// Inicia un cierre ordenado en el que se ejecutan tareas enviadas previamente, pero no se aceptarán nuevas tareas. 
				// Invocación no tiene ningún efecto adicional si ya está apagado.
				// Este método no espera a que las tareas enviadas previamente completen la ejecución. Use awaitTermination para hacer eso
				hilosExServer.shutdown();
	 
				// Bloquea hasta que todas las tareas hayan completado la ejecución después de una solicitud de apagado, o se produzca el tiempo de espera, o el subproceso actual sea
				// interrumpido, lo que ocurra primero.
				hilosExServer.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
	 
				long tiempoFinal = System.nanoTime();
				long tiempoTotal = (tiempoFinal - tiempoInicio) / 1000000L;
				tiempoMedio += tiempoTotal;
				System.out.println("500K entradas añadidas/retiradas en" + tiempoTotal + " ms");
			}
			System.out.println("Para " + recursoHilos.getClass() + " el tiempo medio es " + tiempoMedio / 5 + " ms\n");
		}
	}


