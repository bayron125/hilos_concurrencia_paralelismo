package co.btrujillo.hilos.ejemplo;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) {

        Runnable viaje = new Runnable() {
            @Override
            public void run() {
                for(int i =0; i < 10; i++){
                    System.out.println(i + " - " + Thread.currentThread().getName() );
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("Finalmente me voy de viaje a " + Thread.currentThread().getName());

            }
        };

        new Thread (viaje, "villa Maria ").start();
        new Thread (viaje, "Medellin City").start();
        new Thread (viaje, "Estados unidos").start();
        new Thread (viaje, "Brasil, meu Cora").start();




    }




}
