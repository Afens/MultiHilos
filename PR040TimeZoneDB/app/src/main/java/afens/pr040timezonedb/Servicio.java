package afens.pr040timezonedb;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Usuario on 09/02/2016.
 */
public class Servicio extends IntentService {
    private static final String SERVICE_NAME = "Consultar Hora";
    public static final String NAME_ZONE = "Nombre Zona";
    public static final String HORA_OBTENIDA = "afens.get.hora";
    public static final String TIME = "time";

    public Servicio() {
        // El constructor del padre recibe el nombre para el hilo.
        super(SERVICE_NAME);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String a=intent.getStringExtra(NAME_ZONE);
        Call<Zona> call = TimeZoneApi.getmInstance().getServicio().getZona(a);
        call.enqueue(new Callback<Zona>() {
            @Override
            public void onResponse(Call<Zona> call, Response<Zona> response) {
                if(response.body()!=null)
                responder(response.body().getTimestamp());
            }

            @Override
            public void onFailure(Call<Zona> call, Throwable t) {

            }
        });
    }

    private void responder(Integer timestamp) {
        Intent respuestaIntent = new Intent(HORA_OBTENIDA);
        respuestaIntent.putExtra(TIME,timestamp);
        sendOrderedBroadcast(respuestaIntent,null);
        //LocalBroadcastManager.getInstance(this).sendBroadcast(respuestaIntent);
    }
}
