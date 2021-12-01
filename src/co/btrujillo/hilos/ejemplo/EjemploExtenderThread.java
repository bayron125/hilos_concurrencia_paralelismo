package co.btrujillo.hilos.ejemplo;

import co.btrujillo.hilos.ejemplo.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        Thread hilo = new NombreThread("MR bean");
        hilo.start();
        //Thread.sleep(2);
        Thread hilo2 = new NombreThread("Pascualito");
        hilo2.start();
        NombreThread hilo3 =  new NombreThread("Martuchis");
        hilo3.start();
        System.out.println(hilo.getState());

    }
}
