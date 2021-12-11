package co.btrujillo.hilos.ejemploexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploSheduleExecutorServicesPeriodo {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        //CountDownLatch lock = new CountDownLatch(5);
        AtomicInteger contador = new AtomicInteger(5);


        System.out.println("Alguna tarea en el main...");
        Future<?> future = executor.scheduleAtFixedRate(()->{
            System.out.println("Hola mundo tarea programada");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                //lock.countDown();
                contador.getAndDecrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },1000,2000, TimeUnit.MILLISECONDS);
        while(contador.get()>=0){
            if(contador.get()==0){
                future.cancel(true);
                executor.shutdown();
                break;
            }

        }
        //lock.await();

        System.out.println("Alguna otra tarea en el main...");
    }
}
