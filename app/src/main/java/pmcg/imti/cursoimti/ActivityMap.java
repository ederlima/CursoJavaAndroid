package pmcg.imti.cursoimti;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import pmcg.imti.cursoimti.Localizador;

import butterknife.ButterKnife;

/**
 * Created by aluno on 11/08/15.
 */
public class ActivityMap extends AppCompatActivity implements OnMapReadyCallback {

    Marker marker = null;
    List<LatLng> locais = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.map_activity);

        ButterKnife.bind(this);

        MapFragment map = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        map.getMapAsync(this);

        //
        Localizador localizador = new Localizador(ActivityMap.this);
        LatLng ad1 = localizador.getCoordenada("Avenida Afonso Pena, 1000, Campo Grande, Mato Grosso do Sul");
        LatLng ad2 = localizador.getCoordenada("Avenida Afonso Pena, 1300, Campo Grande, Mato Grosso do Sul");
        LatLng ad3 = localizador.getCoordenada("Avenida Afonso Pena, 1600, Campo Grande, Mato Grosso do Sul");
        LatLng ad4 = localizador.getCoordenada("Avenida Afonso Pena, 1900, Campo Grande, Mato Grosso do Sul");

        locais.add(ad1);
        locais.add(ad2);
        locais.add(ad3);
        locais.add(ad4);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        googleMap.setMyLocationEnabled(true);



        for(LatLng local : locais) {
            googleMap.addMarker( new MarkerOptions().position(local));
        }

        


        //
        googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {

                if(marker != null)
                {
                    marker.remove();
                }

                //LatLng local = new LatLng(-20.505312, -54.597478);
                LatLng local = new LatLng(location.getLatitude(), location.getLongitude());

                marker = googleMap.addMarker(new MarkerOptions().position(local));
            }


        });
    }
}
