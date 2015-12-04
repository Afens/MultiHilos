import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 04/12/2015.
 */
public class Casa implements Callable<String> {
    private int numCasa;
    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    public Casa(int numCasa) {
        this.numCasa = numCasa;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(new Random().nextInt(4)+2);
        return String.format("%s --> %s ha terminado de pintar la casa %d",
                format.format(new Date()), Thread.currentThread().getName(), numCasa);
    }
}
