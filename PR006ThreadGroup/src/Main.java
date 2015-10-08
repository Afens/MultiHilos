import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 07/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        ThreadGroup grupo = new ThreadGroup("Corredores");
        Ganador ganador = new Ganador();
        Corredor corredor = new Corredor(ganador);
        ArrayList<Thread> array = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            array.add(new Thread(grupo, corredor));
        }
        for (Thread hilo : array) {
            hilo.start();
        }
        while (grupo.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        grupo.interrupt();

    }
}
