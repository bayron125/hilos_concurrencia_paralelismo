package co.btrujillo.hilos.ejemplo.runnable;
import static co.btrujillo.hilos.ejemplo.EjemploSincronizacionThread.imprimirFrases;

public class ImprimirFrases implements Runnable{

    private String frase1, frase2;

    public ImprimirFrases (String frase1, String frase2){
        this.frase1 = frase1;
        this.frase2 = frase2;
    }

    @Override
    public void run() {
        imprimirFrases(this.frase1, this.frase2);
    }
}
