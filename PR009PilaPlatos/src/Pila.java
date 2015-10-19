import java.util.ArrayList;

/**
 * Created by Usuario on 19/10/2015.
 */
public class Pila {
    ArrayList<Integer> pila = new ArrayList<Integer>();
    Object cerrojo = new Object();

    public void meter(Integer elemento) throws InterruptedException {
        synchronized (cerrojo) {
            // Espero mientras est� lleno.

            // Agrego el elemento al almac�n.
            pila.add(elemento);
            // Informo.
            System.out.println("Almacenado Plato: " + elemento);
            // Notifico por si hay alg�n consumidor esperando
            // que haya alg�n elemento.
            cerrojo.notifyAll();
        }
    }

    public Integer sacar() throws InterruptedException {
        Integer elemento;
        synchronized (cerrojo) {
            // Espero hasta que haya algo en la lista.
            while (pila.isEmpty()) {
                cerrojo.wait();
            }
            // Obtengo el primer elemento de la lista (cola LIFO).
            elemento = pila.remove(pila.size() - 1);
            // Informo.
            System.out.println("Extraido Plato: " + elemento);

            // Retorno el elemento extra�do.
            return elemento;
        }
    }

}
