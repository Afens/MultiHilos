import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 23/11/2015.
 */
public class Main {

    public static void main(String[] args) {
        ScheduledExecutorService executor= Executors.newScheduledThreadPool(2);
        ScheduledFuture<?> result=executor.scheduleAtFixedRate(new Tarea("Tarea"),1,5, TimeUnit.SECONDS);





    }
}
