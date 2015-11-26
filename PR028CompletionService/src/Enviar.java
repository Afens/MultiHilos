import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 25/11/2015.
 */
public class Enviar implements Callable<String>{
    private String remitente;
    private String carta;

    public Enviar(String remitente, String carta) {
        this.remitente = remitente;
        this.carta = carta;
    }

    @Override
    public String call() throws Exception {
        SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
        try {
            Long duracion = (long) (Math.random() * 10);
            System.out.printf(
                    "%s -> %s enviado por %s recogida en %d segundos\n",
                    format.format(new Date()), this.carta, this.remitente, duracion);
            TimeUnit.SECONDS.sleep(duracion);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String informe = carta + " de " + remitente;
        return informe;

    }
}
