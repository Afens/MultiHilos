package afens.pr040timezonedb;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TimeZoneApi.TimeZoneInterface servicio;
    private Call<Zona> call;
    private Spinner spinner;
    private TextView lblTime;
    private LocalBroadcastManager mGestor;
    private BroadcastReceiver mReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = spinner.getSelectedItem().toString();
                // Se inicia el servicio enviando como extra los datos.
                Intent i = new Intent(getApplicationContext(), Servicio.class);
                i.putExtra(Servicio.NAME_ZONE, a);
                startService(i);
            }
        });
    }
    private void init() {
        spinner = (Spinner) findViewById(R.id.spinner);
        lblTime = (TextView) findViewById(R.id.lblTime);
        servicio = TimeZoneApi.getmInstance().getServicio();

        // Se crea el receptor de mensajes desde el servicio.
        mReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                abortBroadcast();
                configReloj(intent.getIntExtra(Servicio.TIME,0));
            }
        };
    }


    private void configReloj(Integer timestamp) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        lblTime.setText(format.format(new Date(timestamp * 1000L)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Se registra el receptor para la acción.
        IntentFilter filtro = new IntentFilter(Servicio.HORA_OBTENIDA);
        filtro.setPriority(5);
        registerReceiver(mReceiver, filtro);
    }

    @Override
    protected void onPause() {
        // Se desregistra el receptor para dicha acción.
        unregisterReceiver(mReceiver);
        super.onPause();
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
