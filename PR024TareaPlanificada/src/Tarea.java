import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by Usuario on 18/11/2015.
 */
public class Tarea implements Callable<String> {
    String nombre;

    public Tarea(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("%s -> Iniciada en: %s\n", nombre, new Date());
        return "Hola Mundo";
    }

}
