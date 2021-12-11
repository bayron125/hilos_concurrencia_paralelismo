package co.btrujillo.hilos.ejemplosyn;

import co.btrujillo.hilos.ejemplosyn.runnable.Consumidor;
import co.btrujillo.hilos.ejemplosyn.runnable.Panaderia;
import co.btrujillo.hilos.ejemplosyn.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();

        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();
    }
}
