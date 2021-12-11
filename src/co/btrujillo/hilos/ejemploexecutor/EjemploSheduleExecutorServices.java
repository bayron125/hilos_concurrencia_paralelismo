package co.btrujillo.hilos.ejemploexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploSheduleExecutorServices {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main...");
        executor.schedule(()->{
            System.out.println("Hola mundo tarea programada");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },2000, TimeUnit.MILLISECONDS);
        executor.shutdown();

        System.out.println("Alguna otra tarea en el main...");
    }
}
