/**
 * Created by Usuario on 14/10/2015.
 */
public class Banco implements Runnable {
    Cuenta cuenta;

    public Banco(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            cuenta.cargo(5);
        }
    }
}
