import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 26/10/2015.
 */
public class Trabajo implements Runnable{
    private Impresora impresora;

    public Trabajo(Impresora impresora){
        this.impresora=impresora;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        impresora.imprimir(Thread.currentThread().getName());
    }
}
