import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 18/11/2015.
 */
public class Alumno {
    String nombre;

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public void ir() {
        Random aleatorio = new Random();
        int duracion = aleatorio.nextInt(5);
        try {
            TimeUnit.SECONDS.sleep(duracion);
        } catch (InterruptedException e) {

        }
        System.out.printf("%s tarda %d segundos\n", nombre, duracion);
    }
}
