package co.btrujillo.hilos.ejemplo.threads;

import co.btrujillo.hilos.ejemplo.runnable.ViajeTarea;

public class  EjemploInterfaceRunnable {
    public static void main(String[] args) {
        new Thread (new ViajeTarea("Isla de galapagos")).start();
        new Thread (new ViajeTarea("Puerto Rico")).start();
        new Thread (new ViajeTarea("Estados unidos")).start();
        new Thread (new ViajeTarea("Brasil, sao Paulo")).start();




    }




}
