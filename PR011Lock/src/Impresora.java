import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Usuario on 26/10/2015.
 */
public class Impresora {
    private final Lock cerrojo=new ReentrantLock(true);

    public void imprimir(String texto){
        if (cerrojo.tryLock()) {
            //cerrojo.lock();


            System.out.printf("Impresion iniciada del documento %s\n", texto);

            Random rnd=new Random();

            try {
                TimeUnit.SECONDS.sleep(rnd.nextInt(5)+1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.printf("Impresion finalizada del documento %s\n", texto);
                cerrojo.unlock();
            }
        } else {
            System.out.printf("No se ha podido imprimir el documento %s\n", texto);
        }

    }
}
