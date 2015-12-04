import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Usuario on 04/12/2015.
 */
public class Jefe {
    public static void main(String[] args) {
        ThreadPoolExecutor exeBaldomero = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<Future<String>> informes = new ArrayList<>();
        try {
            for (int i = 1; i <= 10; i++) {
                informes.add(exeBaldomero.submit(new Casa(i)));
            }

            TimeUnit.SECONDS.sleep(5);

            for (int i = 1; i <= 15; i++) {
                informes.add(exeBaldomero.submit(new Casa(i+10)));
            }

            exeBaldomero.shutdown();
            exeBaldomero.awaitTermination(1, TimeUnit.DAYS);


            for (int i = 0; i < informes.size(); i++) {
                System.out.println(informes.get(i).get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
