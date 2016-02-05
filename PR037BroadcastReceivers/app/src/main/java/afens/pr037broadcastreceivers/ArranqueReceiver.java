package afens.pr037broadcastreceivers;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Usuario on 04/02/2016.
 */
public class ArranqueReceiver extends BroadcastReceiver {
    private static final int NC_TAREA = 1;
    private NotificationManager mGestor;

    @Override
    public void onReceive(Context context, Intent intent) {
        mGestor = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder b = new NotificationCompat.Builder(context);
        b.setContentTitle("Title");
        b.setContentText("Text");
        b.setContentInfo("Info");
        b.setTicker("Ticker");
        b.setSmallIcon(R.drawable.ic_event_seat_white_18dp);
        b.setLargeIcon(((BitmapDrawable) context.getResources().getDrawable(R.mipmap.ic_launcher))
                .getBitmap());
        b.setAutoCancel(true);
        mGestor.notify(NC_TAREA, b.build());
    }
}
