import java.util.concurrent.Callable;

/**
 * Created by Usuario on 18/11/2015.
 */
public class Tarea implements Callable<String> {
    Alumno a;

    public Tarea(Alumno a) {
        this.a = a;
    }

    @Override
    public String call() throws Exception {
        a.ir();
        return a.nombre;
    }
}
