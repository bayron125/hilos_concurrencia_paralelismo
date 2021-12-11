package co.btrujillo.hilos.ejemploexecutor;

import co.btrujillo.hilos.ejemplosyn.runnable.Consumidor;
import co.btrujillo.hilos.ejemplosyn.runnable.Panaderia;
import co.btrujillo.hilos.ejemplosyn.runnable.Panadero;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploExecutorProductorCosumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

       ;

        Panaderia panaderia = new Panaderia();

        Runnable productor = new Panadero(panaderia);
        Runnable consumidor = new Consumidor(panaderia);


       Future<?> futuro1= executor.submit(productor);
       Future<?> futuro2 = executor.submit(consumidor);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Tamaño de tareas en cola: " + executor.getQueue().size());

        executor.shutdown();


    }
}
