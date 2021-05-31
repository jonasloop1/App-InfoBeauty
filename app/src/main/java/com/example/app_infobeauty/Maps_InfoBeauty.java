package com.example.app_infobeauty;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps_InfoBeauty extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public void onCreate( Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.fragment_location);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

//Coordenadas para a Cidade do Rio de Janeiro

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        LatLng Rio = new LatLng(-22.2752762, -42.419415);
        mMap.addMarker(new MarkerOptions().position(Rio).title("Marcado em Rio de Janeiro"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rio));
    }
}