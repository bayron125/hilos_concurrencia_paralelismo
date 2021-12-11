package co.btrujillo.hilos.ejemploexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        AtomicInteger numeroAtomic= new AtomicInteger(1);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Tamaño de tareas en cola: " + executor.getQueue().size());

        Callable<String> tarea = () -> {
            int contador= numeroAtomic.getAndIncrement();
            System.out.println("Inicio de la tarea..." + contador );
            try {
                System.out.println("nombre del Thread" + Thread .currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea...");
            return "Algun resultado importante de la tarea...";
        };

        Callable <Integer > tarea2= () ->{
            System.out.println("inicio tarea 3");
            TimeUnit.MILLISECONDS.sleep(3000);
            return 10;
        };

       Future<?> resultado= executor.submit(tarea);
       Future<?> resultado2 = executor.submit(tarea);
       Future<Integer> resultado3 = executor.submit(tarea2);
        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Tamaño de tareas en cola: " + executor.getQueue().size());

        executor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main ");

       // System.out.println(resultado.isDone());
        while(!(resultado.isDone() && resultado2.isDone() && resultado3.isDone())){
            System.out.println(String.format("Resultado 1: %s - resultado 2: %s - resultado 3: %s",
                    resultado.isDone() ? "finalizo": "ejecutando", resultado2.isDone() ? "finalizo" : "ejecutando",
                    resultado3.isDone() ? "finalizo": "ejecutando"));
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        System.out.println("Obtenemos resultados de la tarea 1: " + resultado.get());
        System.out.println("Finaliza la tarea 1: " +resultado.isDone());

        System.out.println("Obtenemos resultados de la tarea 2: " + resultado2.get());
        System.out.println("Finaliza la tarea 2: " +resultado2.isDone());

        System.out.println("Obtenemos resultados de la tarea 3: " + resultado3.get());
        System.out.println("Finaliza la tarea 3: " +resultado3.isDone());
    }
}
