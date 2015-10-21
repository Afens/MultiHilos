/**
 * Created by Usuario on 19/10/2015.
 */
public class Limpia implements Runnable {

    Pila limpios;
    public Limpia(Pila pila) {
        limpios=pila;
    }

    @Override
    public void run() {
        for (int i = 0; i <15; i++) {
            try {
                Thread.sleep(3000);
                guarda(new Integer(i + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void guarda(Integer elemento) throws InterruptedException {
        limpios.meter(elemento);
        System.out.printf("Plato %d ha sido puesto en la pila Limpia\n", elemento);
    }
}
