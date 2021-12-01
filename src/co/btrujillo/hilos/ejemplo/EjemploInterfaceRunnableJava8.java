package co.btrujillo.hilos.ejemplo;

public class EjemploInterfaceRunnableJava8  {
    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();

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
                System.out.println(main.getState());
            }
        };

        Thread v1 = new Thread (viaje, "villa Maria ");
        Thread v2 = new Thread (viaje, "Medellin City");
        Thread v3 = new Thread (viaje, "Estados unidos");
        Thread v4 = new Thread (viaje, "Brasil, meu Cora");

      v1.start();
      v2.start();
      v3.start();
      v4.start();
      v1.join();
      v2.join();
      v3.join();
      v4.join();

        System.out.println("continuando con la ejecucion del metodo main: " + main.getName());


    }




}
