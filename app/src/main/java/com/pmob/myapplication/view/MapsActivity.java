package com.pmob.myapplication.view;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.android.gms.maps.model.Marker;
import com.pmob.myapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pmob.myapplication.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.cvMaps);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        Switch mapTypeSwitch = findViewById(R.id.mapTypeSwitch);
        mapTypeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                } else {
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });

        LatLng gaza = new LatLng(31.5016942,34.4565448);
        LatLng panti1 = new LatLng(-7.8171882,110.3731232);
        LatLng panti2 = new LatLng(-7.8166321,110.3487826);
        LatLng panti3 = new LatLng(-7.8272895,110.3624029);
        LatLng panti4 = new LatLng(-7.8131717,110.3739876);
        LatLng panti5 = new LatLng(-7.8232871,110.3693927);
        LatLng panti6 = new LatLng(-7.80551,110.3844768);


        MarkerOptions markerPanti1 = new MarkerOptions().position(panti1).title("Panti Asuhan Yatim Putra Muhammadiyah, Yogyakarta");
        MarkerOptions markerPanti2 = new MarkerOptions().position(panti2).title("\"Panti Asuhan Yayasan Tuna Netra Netra Islam, Yogyakarta");
        MarkerOptions markerPanti3 = new MarkerOptions().position(panti3).title("Panti Asuhan NU Bintan Sa'adillah Al-Rasyid, Yogyakarta");
        MarkerOptions markerPanti4 = new MarkerOptions().position(panti4).title("Griya Yatim & Dhuafa (Jogja), Yogyakarta");
        MarkerOptions markerPanti5 = new MarkerOptions().position(panti5).title("anti Asuhan Putra Islam Giwangan, Yogyakarta");
        MarkerOptions markerPanti6 = new MarkerOptions().position(panti6).title("Panti Asuhan La Tahzan, Yogyakarta");

        mMap.addMarker(markerPanti1);
        mMap.addMarker(markerPanti2);
        mMap.addMarker(markerPanti3);
        mMap.addMarker(markerPanti4);
        mMap.addMarker(markerPanti5);
        mMap.addMarker(markerPanti6);


//        mMap.moveCamera(CameraUpdateFactory.newLatLng(panti1));

        float zoomLevel = 12.5f; // 50% of the normal zoom (default is 10)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(panti1, zoomLevel));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                LatLng markerPosition = marker.getPosition();
                mMap.animateCamera(CameraUpdateFactory.newLatLng(markerPosition));
                return false;
            }
        });

        mMap.moveCamera(CameraUpdateFactory.newLatLng(panti1));
    }
}