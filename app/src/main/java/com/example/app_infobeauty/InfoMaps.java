package com.example.app_infobeauty;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.app_infobeauty.databinding.ActivityInfoMapsBinding;

public class InfoMaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityInfoMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInfoMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.getUiSettings().setZoomGesturesEnabled(true);

        LatLng rio = new LatLng(-22.908333, -43.196388);

        mMap.addMarker(new MarkerOptions().position(rio).title("Rio de janeiro"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rio, 5));
    }
}