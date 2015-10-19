/**
 * Created by Usuario on 19/10/2015.
 */
public class Guarda implements Runnable {
    Pila pila;

    public Guarda(Pila secos) {
        pila = secos;
    }

    @Override
    public void run() {
        while (true) {
            try {
                guarda();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void guarda() throws InterruptedException {
        Integer elemento;
        elemento = pila.sacar();
        Thread.sleep(3000);
        System.out.printf("Plato %d ha sido Guardado", elemento);
    }
}
