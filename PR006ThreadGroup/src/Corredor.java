import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 07/10/2015.
 */
public class Corredor implements Runnable {
    private Ganador g;
    public Corredor(Ganador g){
        this.g=g;
    }

    @Override
    public void run() {
        Random rnd=new Random();
        int segundos=rnd.nextInt(21)+10;
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            return;
        }
        g.setGanador(Thread.currentThread().getName());
        System.out.printf("%s ha terminado\n", Thread.currentThread().getName());
    }
}
