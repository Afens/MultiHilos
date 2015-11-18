import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Usuario on 18/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor ejecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        ArrayList<Tarea> arrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            arrayList.add(new Tarea(new Alumno("Alumno " + i)));
        }

        try {
            System.out.printf("El primero en llegar %s\n", ejecutor.invokeAny(arrayList));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ejecutor.shutdown();

    }
}
