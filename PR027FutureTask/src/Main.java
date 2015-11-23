import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Usuario on 23/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newCachedThreadPool();
        executor.submit(new TR(new Tarea()));
        executor.shutdown();
    }
}
