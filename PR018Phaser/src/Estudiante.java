import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 09/11/2015.
 */
public class Estudiante implements Runnable {
    Phaser secuenciador;
    Random rnd = new Random();
    SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");

    public Estudiante(Phaser secuenciador) {
        this.secuenciador = secuenciador;
    }

    @Override
    public void run() {
        sentarse();
        secuenciador.arriveAndAwaitAdvance();
        for (int i = 0; i < 5; i++) {
            hacerEjercicio(i + 1);
            secuenciador.arriveAndAwaitAdvance();
        }
        entregar();
        secuenciador.arriveAndDeregister();
    }

    private void hacerEjercicio(int i) {
        System.out.println(format.format(new Date()) + " --> "
                + Thread.currentThread().getName() + " inicia trabajo "
                + i);
        try {
            TimeUnit.SECONDS.sleep(rnd.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(format.format(new Date()) + " --> "
                + Thread.currentThread().getName() + " finaliza trabajo "
                + i);
    }

    private void entregar() {
        try {
            TimeUnit.SECONDS.sleep(rnd.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sentarse() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
