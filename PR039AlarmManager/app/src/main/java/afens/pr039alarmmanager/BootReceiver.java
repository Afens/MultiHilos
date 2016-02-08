package afens.pr039alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Usuario on 08/02/2016.
 */
public class BootReceiver extends BroadcastReceiver {

    // Al recibirse el broadcast.
    @Override
    public void onReceive(Context context, Intent intent) {
        // Si la alarma debe estar on, se reprograma.
        if (AvisarReceiver.isAlarmaOn(context)) {
            AvisarReceiver.reprogramarAlarma(context);
        }
    }

}