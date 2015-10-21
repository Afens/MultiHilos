/**
 * Created by Usuario on 19/10/2015.
 */
public class Seca implements Runnable {
    Pila limpios, secos;
    Integer elemento;
    public Seca(Pila limpios, Pila secos) {
        this.limpios=limpios;
        this.secos=secos;
    }

    @Override
    public void run() {

        while(true){
            try {
                coger();
                Thread.sleep(3000);
                guarda();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void coger() throws InterruptedException {
        elemento = limpios.sacar();
        System.out.printf("Plato %d ha sido sacado de la pila Limpia\n", elemento);
    }
    private void guarda() throws InterruptedException {
        secos.meter(elemento);
        System.out.printf("Plato %d ha sido puesto en la pila Seca\n", elemento);
    }
}
