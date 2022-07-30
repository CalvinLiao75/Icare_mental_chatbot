package com.example.icare2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ClinicMap extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(-34, 151);
            //chiayi
            LatLng chiayi = new LatLng(23.478537, 120.449950);
            LatLng chiayi_1 = new LatLng(23.468523494225046, 120.44338445488623);
            LatLng chiayi_2 = new LatLng(23.475928041272464, 120.44478339721483);
            LatLng chiayi_3 = new LatLng(23.471882865410855, 120.4448408125579);
            LatLng chiayi_4 = new LatLng(23.480855533550326, 120.45401659721485);
            LatLng chiayi_5 = new LatLng(23.481176154273374, 120.46094339721478);
            LatLng chiayi_6 = new LatLng(23.47951555458924, 120.44445175673697);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.addMarker(new MarkerOptions().position(chiayi_1).title("吳南逸診所"));
            googleMap.addMarker(new MarkerOptions().position(chiayi_2).title("真善渼診所"));
            googleMap.addMarker(new MarkerOptions().position(chiayi_3).title("太和診所"));
            googleMap.addMarker(new MarkerOptions().position(chiayi_4).title("周裕軒身心醫學診所"));
            googleMap.addMarker(new MarkerOptions().position(chiayi_5).title("蕭正誠診所"));
            googleMap.addMarker(new MarkerOptions().position(chiayi_6).title("知心連冀身心醫學科診所"));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chiayi,13));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_clinic_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}