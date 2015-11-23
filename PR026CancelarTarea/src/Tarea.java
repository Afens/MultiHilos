import java.util.concurrent.Callable;

/**
 * Created by Usuario on 23/11/2015.
 */
public class Tarea implements Callable<String> {

    @Override
    public String call() throws Exception {
        while (true) {
            System.out.printf("Ejecutando tarea...\n");
            Thread.sleep(100);
        }

    }
}
