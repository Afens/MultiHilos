import java.util.ArrayList;
import java.util.concurrent.Exchanger;

/**
 * Created by Usuario on 11/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        Exchanger<ArrayList<String>> exchanger =new Exchanger<ArrayList<String>>();
        Thread hiloPoli = new Thread(new Poli(exchanger));
        Thread hiloLadron = new Thread(new Ladron(exchanger));
        hiloPoli.start();
        hiloLadron.start();

    }
}
