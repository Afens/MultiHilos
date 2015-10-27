import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Usuario on 26/10/2015.
 */
public class Producto {
    private double precio;
    private final ReadWriteLock cES = new ReentrantReadWriteLock();
    private final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    public Producto(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        double valor;

        cES.readLock().lock();
        System.out.printf("%s -> %s - Consultando precio...\n", format.format(new Date()), Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        valor = precio;
        System.out.printf("%s -> %s - Precio: %.2f\n", format.format(new Date()), Thread.currentThread().getName(), valor);
        cES.readLock().unlock();
        return valor;
    }

    public void setPrecio(double precio) {
        cES.writeLock().lock();

        System.out.printf("%s -> %s - Cambiando precio...\n", format.format(new Date()), Thread.currentThread().getName());

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.precio = precio;

        System.out.printf("%s -> %s - Nuevo Precio: %.2f\n", format.format(new Date()), Thread.currentThread().getName(), this.precio);
        cES.writeLock().unlock();
    }
}
