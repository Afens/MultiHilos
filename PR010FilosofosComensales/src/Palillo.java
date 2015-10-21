/**
 * Created by Usuario on 21/10/2015.
 */
public class Palillo {
    int num;
    boolean disponible=true;

    public Palillo(int num){
        this.num=num;
    }

    public synchronized void coger(int comen) throws InterruptedException {
        while (!disponible) {
            wait();
        }
        disponible=false;
        System.out.printf("El comensal %d ha cogido el palillo %d\n", comen, num);
    }

    public synchronized void soltar(int comen) throws InterruptedException {
        disponible=true;
        System.out.printf("El comensal %d ha soltado el palillo %d\n", comen, num);
        notifyAll();
    }


}
