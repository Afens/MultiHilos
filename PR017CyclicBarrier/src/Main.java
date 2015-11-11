import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Usuario on 09/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        int TOTAL_CORREDORES = 10;
        CyclicBarrier barrera = new CyclicBarrier(TOTAL_CORREDORES, new Runnable() {
            @Override
            public void run() {
                System.out.println("Todos los corredores han llegado a la Salida.");
            }
        });

        ArrayList<Thread> corredores = new ArrayList<Thread>();
        for (int i = 0; i < TOTAL_CORREDORES; i++) {
            corredores.add(new Thread(new Corredor(barrera)));
        }
        for (Thread corredor : corredores) {
            corredor.start();
        }

        try {
            for (Thread corredor : corredores) {
                corredor.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Todos los corredores han llegado a la Meta.");
    }
}
