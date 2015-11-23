import java.util.concurrent.*;

/**
 * Created by Usuario on 23/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor= (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Future<?> result=executor.submit(new Tarea());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result.cancel(true);

        System.out.printf("Cancelada? %s\n", result.isCancelled());
        System.out.printf("Terminada? %s\n", result.isDone());

        executor.shutdown();
    }
}
