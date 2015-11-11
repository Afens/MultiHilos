import java.util.concurrent.Phaser;

/**
 * Created by Usuario on 09/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        Thread[] hilos = new Thread[10];
        Phaser secuenciador = new Secuenciador(10);
        for (int i = 0; i < 10; i++) {
            hilos[i] = new Thread(new Estudiante(secuenciador), "Estudiante "
                    + (i + 1));
            hilos[i].start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

        System.out.println("¿Secuenciador terminado? "+ secuenciador.isTerminated());
    }
}
