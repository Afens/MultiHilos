import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 23/11/2015.
 */
public class Tarea implements Runnable {
    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    Random rnd=new Random();
    private String nombre;

    // Constructor.
    public Tarea(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        // Muestra la fecha/hora actual
        System.out.printf("%s -> Ejecutada.\n", format.format(new Date()), nombre);
        try {
            TimeUnit.SECONDS.sleep(rnd.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s -> Acaba.\n", format.format(new Date()), nombre);
    }
}
