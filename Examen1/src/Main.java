import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 04/12/2015.
 */
public class Main {
    public static void main(String[] args) {
        //Crea Caja y clientes
        Caja caja = new Caja(4);
        Random rnd = new Random();
        try {
            for (int i = 0; i < 50; i++) {
                new Thread(new Cliente(caja, "Cliente " + (i + 1))).start();
                TimeUnit.SECONDS.sleep(rnd.nextInt(3));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
