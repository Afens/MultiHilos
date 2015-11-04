import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Usuario on 04/11/2015.
 */
public class ColaImpresion {
    boolean disponible[];
    Semaphore semaforo;

    Lock lock = new ReentrantLock();
    Random aleatorio = new Random();

    public ColaImpresion(int numImpresoras) {
        semaforo = new Semaphore(numImpresoras);
        disponible = new boolean[numImpresoras];
        for (int i = 0; i < disponible.length; i++) {
            disponible[i] = true;
        }
    }

    public void imprimir(Object documento) {
        try {
            semaforo.acquire();

            int imprimiendo = selecionarImpresora();
            System.out.printf("%s Iniciado en la Impresora %d\n", Thread.currentThread().getName(), imprimiendo);
            TimeUnit.SECONDS.sleep(aleatorio.nextInt(10));
            System.out.printf("%s Finalizado en la Impresora %d\n", Thread.currentThread().getName(), imprimiendo);
            disponible[imprimiendo] = true;

            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int selecionarImpresora() {
        int i;
        lock.lock();
        for (i = 0; i < disponible.length; i++) {
            if (disponible[i]) {
                disponible[i] = false;
                break;
            }
        }

        lock.unlock();
        return i;
    }
}
