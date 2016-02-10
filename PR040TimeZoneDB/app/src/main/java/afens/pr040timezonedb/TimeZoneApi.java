package afens.pr040timezonedb;

import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Usuario on 09/02/2016.
 */
public class TimeZoneApi {
    private static final String BASE_URL = "http://api.timezonedb.com/";
    private static TimeZoneApi mInstance;
    private TimeZoneInterface servicio;

    private TimeZoneApi() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        servicio = retrofit.create(TimeZoneInterface.class);
        System.err.println("llega");
    }

    public static synchronized TimeZoneApi getmInstance(){
        if(mInstance==null)
            mInstance=new TimeZoneApi();

        return mInstance;
    }

    public TimeZoneInterface getServicio() {
        return servicio;
    }

    public interface TimeZoneInterface {
        @GET("?format=json&key=BPS7FVIKQ7GI")
        Call<Zona> getZona(@Query("zone") String value);
    }


}
