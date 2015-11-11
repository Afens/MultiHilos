import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 09/11/2015.
 */
public class Corredor implements Runnable {
    CyclicBarrier barrier;

    public Corredor(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            correr();
            System.out.printf("a");
            barrier.await();
            correr();
            System.out.printf("f");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void correr() throws InterruptedException {
        Random a=new Random();
        TimeUnit.SECONDS.sleep(a.nextInt(10));
    }
}
