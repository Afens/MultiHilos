/**
 * Created by Usuario on 26/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        Impresora impresora=new Impresora();
        Thread[] hilos=new Thread[10];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i]=new Thread(new Trabajo(impresora),"Trabajo "+i);
        }
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
    }
}
