package co.btrujillo.hilos.ejemplosyn.runnable;

public class Panaderia {
    private String pan;
    private boolean disponible;

    public synchronized void hornear(String masa){
        this.pan = masa;
        while(disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("el panadero hornea: " + this.pan);
        disponible = true;
        notify();
    }

    public synchronized String consumir(){
        while(!disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("cliente consume: " + this.pan);
        this.disponible=false;
        notify();
        return pan;
    }
}
