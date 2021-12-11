package co.btrujillo.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> tarea = () -> {
            System.out.println("Inicio de la tarea...");
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

       Future<?> resultado= executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main ");

       // System.out.println(resultado.isDone());
        while(!resultado.isDone()){
            System.out.println("Ejecutando tarea");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        System.out.println("Obtenemos resultados de la tarea: " + resultado.get());
        System.out.println("Finaliza la tarea: " +resultado.isDone());

    }
}
