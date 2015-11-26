import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CompletionService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 25/11/2015.
 */
public class Remitente implements Runnable {

    private CompletionService<String> servicio;
    private String nombre;

    public Remitente(CompletionService<String> servicio, String nombre) {
        this.servicio = servicio;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
        Random rnd =new Random();
        String titulo = "Carta ";
        for (int i = 0; i < 5; i++) {
            Enviar envio = new Enviar(nombre, titulo+i);
            System.out.printf("%s -> %s Envia %s\n",format.format(new Date()), nombre, titulo+i);
            servicio.submit(envio);
            try {
                TimeUnit.SECONDS.sleep(rnd.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
