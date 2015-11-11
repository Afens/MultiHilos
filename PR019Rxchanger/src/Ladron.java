import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 11/11/2015.
 */
public class Ladron implements Runnable {
    private ArrayList<String> buffer = new ArrayList<String>();
    private final Exchanger<ArrayList<String>> intercambiador;

    public Ladron(Exchanger<ArrayList<String>> intercambiador) {
        this.intercambiador = intercambiador;
    }

    @Override
    public void run() {
        String a;
        Random rnd = new Random();
        try {
            for (int i = 0; i < 5; i++) {
                //Captura Rehenes
                for (int j = 0; j < 10; j++) {
                    a = "Rehen " + (j + 1);
                    TimeUnit.SECONDS.sleep(rnd.nextInt(5));
                    System.out.printf("\tLadron -> Captura %s\n", a);
                    buffer.add(a);
                }

                //Intercambio
                buffer = intercambiador.exchange(buffer);

                //Libero Socios
                for (int j = 0; j < 10; j++) {
                    System.out.printf("\tLadron -> Libera %s\n", buffer.remove(0));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
