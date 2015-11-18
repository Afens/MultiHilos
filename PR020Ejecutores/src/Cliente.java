import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 16/11/2015.
 */
public class Cliente implements Runnable {
    String nombre;
    Random aleatorio = new Random();
    SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.printf("%s -> %s Sienta al %s\n", formateador.format(new Date()), Thread.currentThread().getName(), nombre);
        try {
            int duracion = aleatorio.nextInt(10);
            TimeUnit.SECONDS.sleep(duracion);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
