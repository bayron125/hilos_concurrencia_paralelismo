package co.btrujillo.hilos.ejemplotimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {

        Toolkit toolkit= Toolkit.getDefaultToolkit();
        AtomicInteger contadorAtomic = new AtomicInteger(3);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();
                if(i >0) {
                    toolkit.beep();
                    System.out.println("tarea prediodica en " + i + " nombre  del Thread: "
                            + Thread.currentThread().getName());

                } else {
                    System.out.println("Finaliza el tiempo");
                    timer.cancel();
                }
            }
        },0,10000);
        System.out.println("agendamos una tarea inmediata que se repite cada 10 segundos... ");
    }


}
