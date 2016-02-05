package afens.pr036notificaciones;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final int NC_TAREA = 1;
    private NotificationManager mGestor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mGestor = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NotificationCompat.Builder b = new NotificationCompat.Builder(getApplication());
                //b.setWhen(133333);
                b.setContentTitle("Title");
                b.setContentText("Text");
                b.setContentInfo("Info");
                b.setTicker("Ticker");
                b.setSmallIcon(R.drawable.ic_announcement_white_18dp);
                b.setLargeIcon(((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher))
                        .getBitmap());


                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.iessaladillo.es"));
                // Se crea un pending intent para iniciar una actividad con el intent.
                PendingIntent pendingIntent =
                        PendingIntent.getActivity(getApplication(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                // Se establece el pending intent para cuando el usuario pulse sobre
                // la notificación.
                b.setContentIntent(pendingIntent);
                b.setAutoCancel(true);
                mGestor.notify(NC_TAREA, b.build());


                NotificationCompat.Builder l = new NotificationCompat.Builder(getApplication());
                l.setSmallIcon(R.drawable.ic_announcement_white_18dp); // Icono pequeño.
                l.setLargeIcon(((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher))
                        .getBitmap()); // Icono grande.
                l.setContentTitle("Nueva tarea pendiente"); // Título (1ª línea).
                l.setContentText("Pasar ITV al coche"); // Texto (2º línea).
                l.setContentInfo("3"); // Info adicional (nº total tareas pendientes).
                l.setTicker("Nueva tarea pendiente");  // Ticker.
                // Se configuran los elementos para el modo expandido.
                NotificationCompat.BigPictureStyle estilo = new NotificationCompat.BigPictureStyle();
                estilo.setBigContentTitle("Pasar ITV al coche");
                estilo.bigPicture(BitmapFactory.decodeResource(getResources(),
                        R.drawable.ic_announcement_white_18dp));
                estilo.setSummaryText("Antes del día 15/04/2014");
                l.setStyle(estilo);
                // Se construye y muestra la notificación, asignándole un código de notificación entero.
                l.setAutoCancel(true);
                mGestor.notify(2, l.build());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
