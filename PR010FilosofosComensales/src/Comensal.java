/**
 * Created by Usuario on 21/10/2015.
 */
public class Comensal implements Runnable{
    int comen;
    Palillo prP, segP;
    public Comensal(int comen, Palillo izq, Palillo der){
        this.comen=comen;
        if(comen%2==0) {
            this.prP = izq;
            this.segP = der;
        }else{
            this.prP = der;
            this.segP = izq;
        }
    }


    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                prP.coger(comen);
                segP.coger(comen);
                comer();
                prP.soltar(comen);
                segP.soltar(comen);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void pensar() throws InterruptedException {
        Thread.sleep(3000);
    }

    private void comer() throws InterruptedException {
        Thread.sleep(3000);
    }
}
