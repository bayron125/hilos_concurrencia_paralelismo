package co.btrujillo.hilos.ejemplo.threads;

final public class NombreThread extends Thread{

    public NombreThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Se inicia el metodo run con el hilo " +  getName());

        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName());
        }
        System.out.println("Finaliza el metodo run con el hilo ");
    }



}
