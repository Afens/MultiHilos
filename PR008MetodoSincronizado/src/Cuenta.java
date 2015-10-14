import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 14/10/2015.
 */
public class Cuenta {
    private int saldo=0;

    public synchronized void cargo(int cantidad) {
        saldo -= cantidad;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("Cargo realizado, Su saldo actual es:" +saldo);
    }
    public  void ingreso(int cantidad) {
        synchronized (this) {
            saldo += cantidad;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                return;
            }
            System.out.println("Ingreso realizado, Su saldo actual es:" + saldo);
        }
    }
}
