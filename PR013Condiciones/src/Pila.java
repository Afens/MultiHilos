import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Usuario on 19/10/2015.
 */
public class Pila {
    ArrayList<Integer> pila = new ArrayList<Integer>();
    ReentrantLock cerrojo = new ReentrantLock();
    Condition hayPlatos = cerrojo.newCondition();


    public void meter(Integer elemento) throws InterruptedException {
        cerrojo.lock();

        // Agrego el elemento a la pila.
        pila.add(elemento);
        // Informo.
        System.out.println("Almacenado Plato: " + elemento);
        // Notifico por si hay algún consumidor esperando
        // que haya algún elemento.
        hayPlatos.signalAll();

        cerrojo.unlock();
    }

    public Integer sacar() throws InterruptedException {
        Integer elemento;
        cerrojo.lock();
        // Espero hasta que haya algo en la lista.
        while (pila.isEmpty()) {
            hayPlatos.await();
        }
        // Obtengo el primer elemento de la lista (cola LIFO).
        elemento = pila.remove(pila.size() - 1);
        // Informo.
        System.out.println("Extraido Plato: " + elemento);

        cerrojo.unlock();
        // Retorno el elemento extraído.
        return elemento;
    }

}
