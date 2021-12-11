package co.btrujillo.hilos.ejemplosyn;

import co.btrujillo.hilos.ejemplosyn.runnable.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidorJava8 {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();

        new Thread(() -> {
            for(int i = 0; i < 10; i++){
                p.hornear("Pan numero: " +i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for(int i = 0; i < 10 ; i++){
                p.consumir();
            }
        }).start();
    }
}
