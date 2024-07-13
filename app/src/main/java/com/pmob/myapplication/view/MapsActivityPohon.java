package com.pmob.myapplication.view;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pmob.myapplication.R;
import com.pmob.myapplication.databinding.ActivityMapsBinding;

public class MapsActivityPohon extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.cvMapsPohon);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMapp = googleMap;
        mMapp.getUiSettings().setZoomControlsEnabled(true);
        mMapp.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        Switch mapTypeSwitch = findViewById(R.id.mapTypeSwitch);
        mapTypeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mMapp.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                } else {
                    mMapp.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });
        LatLng tuban = new LatLng(-7.068415356840498, 111.97901736919704);
        LatLng bojonegoro = new LatLng(-7.353958259280436, 111.98289835562957);
        LatLng kalbar = new LatLng(0.4556945093673012, 109.52671729372507);
        LatLng aceh = new LatLng(3.7845613,97.175729);
        LatLng mentawai = new LatLng(-1.3173175826635684, 98.88922686907043);
        LatLng papua = new LatLng(-4.629677744703737, 137.97267216725132);
        LatLng ntt = new LatLng(-8.59602701686806, 120.99492578079244);

        MarkerOptions markerTuban = new MarkerOptions().position(tuban).title("Sendang Lanjar Maibit Bumi Pekemahan, Tuban, Jawa Timur");
        MarkerOptions markerBojonegoro = new MarkerOptions().position(bojonegoro).title("Kedung Lantung, Bojonegoro, Jawa Timur");
        MarkerOptions markerKalbar = new MarkerOptions().position(kalbar).title("Bukit Padakng, Pakumbang, Kec. Sompak, Kabupaten Landak, Kalimantan Barat");
        MarkerOptions markerAceh = new MarkerOptions().position(aceh).title("JL. Raya Blangkejeren Tanah Merah Kutacane,Kabupaten Aceh Tenggara");
        MarkerOptions markerMentawai = new MarkerOptions().position(mentawai).title("Taman Nasional Pulau Siberut, Bojakan, Kec. Siberut Utara, Kabupaten Kepulauan Mentawai, Sumatera Barat 25394");
        MarkerOptions markerPapua = new MarkerOptions().position(papua).title("Taman Nasional Lorentz, Yakapis, Papua");
        MarkerOptions markerNtt = new MarkerOptions().position(ntt).title("Taman Nasional Flores, Kec. Wolomeze, Kabupaten Ngada, Nusa Tenggara Timur.");

        mMapp.addMarker(markerTuban);
        mMapp.addMarker(markerBojonegoro);
        mMapp.addMarker(markerKalbar);
        mMapp.addMarker(markerAceh);
        mMapp.addMarker(markerMentawai);
        mMapp.addMarker(markerPapua);
        mMapp.addMarker(markerNtt);

        mMapp.moveCamera(CameraUpdateFactory.newLatLng(tuban));

        mMapp.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                LatLng markerPosition = marker.getPosition();
                mMapp.animateCamera(CameraUpdateFactory.newLatLng(markerPosition));
                return false;
            }
        });
    }
}
